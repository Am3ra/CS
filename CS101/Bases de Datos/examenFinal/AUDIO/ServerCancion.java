/***********************************************************/
/*** Programa de Intercambio de Mensajes con BSD Sockets ***/
/***              Class: Server                       ***/
/***********************************************************/

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCancion extends JFrame {
    private JTextArea taDatos;
    private JPanel panel;

    private ServerSocket server;
    private Socket socket;

    private BufferedReader bufferEntrada;
    private PrintWriter bufferSalida;

    CancionesADjdbc cADjdbc = new CancionesADjdbc();

    public ServerCancion() {
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

                if (transaccion.equals("streamAudio")){
                    String cancion = recibirDatos();
                    File soundFile = new File(cancion);
                    FileInputStream in = new FileInputStream(soundFile);
                    OutputStream out = socket.getOutputStream();
                    byte buffer[] = new byte[2048];
                    int count;
                    while ((count = in.read(buffer)) != -1){
                        out.write(buffer, 0, count);
                    }
                } else if (transaccion.equals("consultarCanciones")){
                    enviarDatos(cADjdbc.consultarCanciones());
                } 

                // 6. Cerrar conexion
                cerrarConexion();

                //7 desplegar transaccion
                taDatos.append("Transaccion realizada: " + transaccion);
                System.out.println("Datos Enviados:" + respuesta);
            }

        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    public static void main(String args[]) {
        ServerCancion serverApp = new ServerCancion();

        serverApp.iniciarServer();
    }
}
