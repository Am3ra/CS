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

public class Server {
    private JTextArea taDatos;
    private JPanel panel;

    private ServerSocket server;
    private Socket socket;

    private BufferedReader bufferEntrada;
    private PrintWriter bufferSalida;

    private MinitestADLL minitest = new MinitestADLL();


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
            server = new ServerSocket(8008, 5);

            while (true) {
                System.out.println("\nMessage Server: estado listen()\n Esperando peticiones de conexion...\n");

                // 2. Al escuchar una peticion de conexion hacer el accept()
                socket = server.accept();

                System.out.println("Message Server: Se recibio peticion de conexxion\n se hizo el accept()...\n");

                // 3. Preparar canales o buffers de comunicacion
                bufferEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferSalida = new PrintWriter(socket.getOutputStream());
                bufferSalida.flush();

                // 4. Recibir datos o mensaje del cliente
                transaccion = recibirDatos();

                if (transaccion.equals("consultarMax")) {
                    enviarDatos(""+minitest.listOfFiles.length);
                }  else if(transaccion.equals("RecieveFileImagen")) {
                    String filename = recibirDatos();
                    try {
                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                        FileInputStream fis = new FileInputStream(minitest.listOfFiles[Integer.parseInt(filename)]);
                        byte[] buffer = new byte[409600];
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
                System.out.println("Transaccion realizada: " + transaccion);
            }

        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    public static void main(String args[]) {
        Server serverApp = new Server();
        serverApp.iniciarServer();
    }
}
