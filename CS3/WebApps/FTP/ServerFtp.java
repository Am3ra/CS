import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

import java.io.InputStreamReader;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerFtp extends JFrame
{
    private JTextArea taDatos;
    private JPanel panel;
    
    private ServerSocket server;
    private Socket		 socket;
    
    private BufferedReader bufferEntrada;
    private PrintWriter    bufferSalida;
    
    private BufferedReader archivoIn;
    private PrintWriter    archivoOut;
    
    public ServerFtp()
    {
        super("Server FTP");
        
        // 1. Crear objetos de los atributos
        taDatos = new JTextArea();
        panel   = new JPanel();
        
        // 2. Sefinir Layout para el panel
        panel.setLayout(new GridLayout(1,1));
        
        // 3. Poner los objetos en el panel
        panel.add(new JScrollPane(taDatos));
        
        // 4. Adicionar el apnel al JFrame y lo hacemos visible
        add(panel);
        setSize(400,300);
        setVisible(true);
    }
    
    private String recibirDatos()
    {
        String datos="";
        
        try
        {
            datos = bufferEntrada.readLine();
        }
        catch(IOException ioe)
        {
            System.out.println("Error: "+ioe);
        }
        
        return datos;
    }
    
    private void enviarDatos(String datos)
    {
        bufferSalida.println(datos);
        bufferSalida.flush();
    }
    
    private void cerrarConexion()
    {
        try
        {
            bufferEntrada.close();
            bufferSalida.close();
            socket.close();
        }
        catch(IOException ioe)
        {
            System.out.println("Error: "+ioe);
        }
    }
    
    private void iniciarServer()
    {
        String archivos="", archivo="", linea="";
        String transaccion="";
        
        try
        {
            // 1. Inicializar el Serve y ponerlo en estado liste()
            server = new ServerSocket(5005,5);
            
            while(true)
            {
                taDatos.append("\nServer FTP: estado listen()\n Esperando peticiones de conexion...\n");
                
                // 2. Al escuchar una peticion de conexion hacer el accept()
                socket = server.accept();
                
                taDatos.append("Server FTP: Se recibio peticion de conexion\n se hizo el accept()...\n");
                
                // 3. Preparar canales o buffers de comunicacion
                bufferEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferSalida  = new PrintWriter(socket.getOutputStream());
                bufferSalida.flush();
                
                // 4. Recibir transaccion a realizar
                transaccion = recibirDatos();
                
                // 5. Checar transaccion
                if(transaccion.equals("obtenerArchivosServer"))
                {
                    // Obtener los archivos del directorio default
                    
                    // Enviar los archivos en formato String
                    enviarDatos(transaccion);
                    
                    taDatos.append("\nTransaccion: "+transaccion);
                }
                
                if(transaccion.equals("transferirArchivoServerCliente"))
                {
                    
                    // 1. Recibir el archivo a transferir
                    archivo = recibirDatos();
                    
                    // 2. Abrir el archivo para leer
                    
                    // 3. Procesar el archivo con un ciclo y enviar cada linea del archivo al Cliente
                    enviarDatos(transaccion+"   "+archivo);
                    
                    // 4. Cerrar archivo
                    taDatos.append("Archivo enviado al Cliente: \n"+archivo);
                }
                
                if(transaccion.equals("transferirArchivoClienteServer"))
                {
                    // 1. Recibir el archivo a recibir
                    archivo = recibirDatos();
                    
                    // 2. Abrir el archivo para guardar
                    
                    // 3. Con un ciclo, recibir cada linea del archivo y guardarla en el archivo en el Server
                    
                    // 4. Cerrar archivo
                    
                    taDatos.append("Archivo recibido del Cliente: "+archivo);
                }
            }
            
        }
        catch(IOException ioe)
        {
            System.out.println("Error: "+ioe);
        }
    }
    
     public String obtenerArchivosServer()
     {
         String archivos="";
         
         // Abrir el path del directorio default
         
         // Obtener el path.list() en un arreglo de Strings
         
         // Concatenar el contenido del arreglo en un solo String con un elimitador "*" o "&"
     
         return archivos;
     }
    
    public static void main(String args[])
    {
        ServerFtp serverFtp = new ServerFtp();
        
        serverFtp.iniciarServer();
    }
}
