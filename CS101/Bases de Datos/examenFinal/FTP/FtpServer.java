/***********************************************************/
/*** Programa de Intercambio de Mensajes con BSD Sockets ***/
/***              Class: FtpServer                      ***/
/***********************************************************/

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FtpServer extends JFrame {
    private JTextArea taDatos;
    private JPanel panel;

    private ServerSocket server;
    private Socket socket;

    private BufferedReader bufferEntrada;
    private PrintWriter bufferSalida;

    public FtpServer() {
        super("Message Server");

        // 1. Crear objetos de los atributos
        taDatos = new JTextArea();
        panel = new JPanel();

        // 2. Definir Layout para el panel
        panel.setLayout(new GridLayout(1, 1));

        // 3. Poner los objetos en el panel
        panel.add(new JScrollPane(taDatos));

        // 4. Adicionar el panel al JFrame y lo hacemos visible
        add(panel);
        setSize(400, 300);
        setVisible(true);
    }

    private String recibirDatos() {
        String datos = "";

        try {
            datos = bufferEntrada.readLine();
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }

        return datos;
    }

    private void enviarDatos(String datos) {
        bufferSalida.println(datos);
        bufferSalida.flush();
    }

    private String returnDirectory(){
        String songs = "";
        String lscmd = "ls";
        try {
            Process p = Runtime.getRuntime().exec(new String[] { "bash", "-c", lscmd });
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = reader.readLine();
            System.out.println(line);
            while (line != null) {
                System.out.println(line);
                songs += line+"&";
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return songs;
    }

    private void cerrarConexion() {
        try {
            bufferEntrada.close();
            bufferSalida.close();
            socket.close();
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    private void iniciarServer() {
        String transaccion = "";
        String respuesta = "";

        try {
            // 1. Inicializar el Serve y ponerlo en estado listen()
            server = new ServerSocket(5005, 5);

            while (true) {
                taDatos.append("\nMessage Server: estado listen()\n Esperando peticiones de conexion...\n");

                // 2. Al escuchar una peticion de conexion hacer el accept()
                socket = server.accept();

                taDatos.append("Message Server: Se recibio peticion de conexxion\n se hizo el accept()...\n");

                // 3. Preparar canales o buffers de comunicacion
                bufferEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferSalida = new PrintWriter(socket.getOutputStream());
                bufferSalida.flush();

                // 4. Recibir datos o mensaje del cliente
                transaccion = recibirDatos();

                if (transaccion.equals("consultarDirectorio")) {
                    enviarDatos(returnDirectory());
                } else if(transaccion.equals("SendFile")){
                    enviarDatos("RecieveFile");
                    String fileName = recibirDatos();
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    FileOutputStream fos = new FileOutputStream(fileName);
                    byte[] buffer = new byte[4096];

                    int filesize = 15123; // Send file size in separate msg
                    int read = 0;
                    int totalRead = 0;
                    int remaining = filesize;
                    while ((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
                        totalRead += read;
                        remaining -= read;
                        System.out.println("read " + totalRead + " bytes.");
                        fos.write(buffer, 0, read);
                    }
                    fos.close();
                    dis.close();
                } else if(transaccion.equals("RecieveFile")) {
                    String filename = recibirDatos();
                    try {
                        enviarDatos("SendFile");
                        enviarDatos(filename);
                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                        FileInputStream fis = new FileInputStream(filename);
                        byte[] buffer = new byte[4096];
                        while (fis.read(buffer) > 0) {
                            dos.write(buffer);
                        }
                        fis.close();
                        dos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                // 6. Cerrar conexion
                cerrarConexion();

                // 7 desplegar transaccion
                taDatos.append("Transaccion realizada: " + transaccion);
                System.out.println("Datos Enviados:" + respuesta);
            }

        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    public static void main(String args[]) {
        FtpServer serverApp = new FtpServer();
        serverApp.iniciarServer();
    }
}
