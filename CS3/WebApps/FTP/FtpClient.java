import javax.swing.*;
import java.awt.*;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.util.Vector;
import java.util.StringTokenizer;
import java.net.Socket;

public class FtpClient extends JFrame implements ActionListener, ListSelectionListener
{
    /**
     *
     */
    private static final long serialVersionUID = -395776797649844637L;

    // Atributos de la aplicacion
    private JPanel panelUsuario, panelServer, panelClient, panelPrincipal;
    
    private JButton bServerFiles, bClientFiles, bGet, bSend;
    private JTextArea  taServerFiles, taClienteFiles;
    
    private Vector vectorServerFiles, vectorClientFiles;
    private JList  listaServerFiles, listaClientFiles;
    
    private Socket socket;
    
    private Conexion conexion = new Conexion();
    
    private BufferedReader archivoIn;
    private PrintWriter    archivoOut;
    
    private String archivoElegidoServer, archivoElegidoCliente;
    
    public FtpClient()
    {
        super("FTP: File Transfer Protocol");
        
        // 1. Crear objetos d elos atributos
        bServerFiles = new JButton("Mostrar Directorio Server");
        bClientFiles  = new JButton("Mostrar Directorio Cliente");
        bGet   = new JButton("GET (->)");
        bSend    = new JButton("SEND (<-)");
        taServerFiles= new JTextArea("Directorio Server",12,12);
        taClienteFiles  = new JTextArea("Directorio Cliente",12,12);
        panelUsuario  = new JPanel();
        panelServer = new JPanel();
        panelClient   = new JPanel();
        panelPrincipal= new JPanel();
        
        // Adionar actionListener a los JButtons
        bServerFiles.addActionListener(this);
        bClientFiles.addActionListener(this);
        bGet.addActionListener(this);
        bSend.addActionListener(this);
        
        // 2. Definir Layouts de los JPanels
        panelUsuario.setLayout(new GridLayout(4,1));
        panelServer.setLayout(new GridLayout(1,1));
        panelClient.setLayout(new GridLayout(1,1));
        panelPrincipal.setLayout(new FlowLayout());
        //panelPrincipal.setLayout(new BorderLayout(5,5));
        
        // 3. Colocar los objetos de los atributos en los panels correspondientes
        panelUsuario.add(bServerFiles);
        panelUsuario.add(bGet);
        panelUsuario.add(bClientFiles);
        panelUsuario.add(bSend);
        
        panelServer.add(new JScrollPane(taServerFiles));
        panelClient.add(new JScrollPane(taClienteFiles));

        panelPrincipal.add(panelServer);
        panelPrincipal.add(panelUsuario);
        panelPrincipal.add(panelClient);
        
        // 4. Adicionar el panelPrincipal al JFrame
        add(panelPrincipal);
        setSize(550,250);
        setVisible(true);
    }
    
    public String obtenerArchivosCliente()
    {
        String archivos="";
        
        // Abrir el path del directorio default
        
        // Obtener el path.list() en un arreglo de Strings
        
        // Concatenar el contenido del arreglo en un solo String con un elimitador "*" o "&"
        
        return archivos;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String archivosServer, archivosCliente;
        StringTokenizer st;
        
        if(e.getSource() == bServerFiles)
        {
            // 1. Establecer conexion con el server en el puerto 5005
            socket = conexion.establecerConexion();
            
            // 2. Enviar transaccion a realizar
            conexion.enviarDatos("obtenerArchivosServer");
            
            // 3. Recibir el String con la lista de archivos
            archivosServer = conexion.recibirDatos();
            
            // 4. Cerrar conexion y desplegamos el mensaje del server
            conexion.cerrarConexion();
            
            // 5. Preparar el Vector y el JList de archivos
            
            // 6. Mostrar el JList de songs en el panelSongs
            System.out.println(archivosServer);

        }
        
       if(e.getSource() == bClientFiles)
        {
            // 1. Obtener los archivos del cliente
            archivosCliente = obtenerArchivosCliente();
            
            // 5. Preparar el Vector y el JList de archivos
            
            // 6. Mostrar el JList de songs en el panelSongs
            System.out.println(archivosCliente);
        }
        
        if(e.getSource() == bGet)
        {
            String linea="";
            
            // 1. Establecer conexion con el server en el puerto 5005
            socket = conexion.establecerConexion();
            
            // 2. Enviar transaccion a realizar y el archivo a transferir del Server
            conexion.enviarDatos("transferirArchivoServerCliente");
            conexion.enviarDatos("Archivo XXX...");
            
            //try
            //{
                // 3. Abrir el archivo para guardar
                linea = conexion.recibirDatos();
                
                // 4. Recibir el String de canciones del Server
            /*}
            catch(IOException ioe)
            {
                System.out.println("Error: "+ioe);
            }*/
            
            // 5. Cerrar conexion y desplegamos el mensaje del server
            conexion.cerrarConexion();
            
            System.out.println("Archivo recibido del Server:\nLinea: "+linea);
        }
        
       if(e.getSource() == bSend)
        {
            String linea="";
            
            // 1. Establecer conexion con el server en el puerto 5005
            socket = conexion.establecerConexion();
            
            // 2. Enviar transaccion a realizar y el archivo a transferir al Server
            conexion.enviarDatos("transferirArchivoClienteServer");
            conexion.enviarDatos(archivoElegidoCliente);
            
            //try
            //{
                // 3. Abrir el archivo para leer
                
                // 4. Procesar el archivo y enviar cada linea
                
                // 5. Cerrar archivo
                
            /*}
            catch(IOException ioe)
            {
                System.out.println("Error: "+ioe);
            }
             */
            // 5. Cerrar conexion
            conexion.cerrarConexion();
            
            //taDatos.append("Archivo enviado al cliente: "+archivoElegidoCliente);
        }
    }
    
    public void valueChanged(ListSelectionEvent lse)
    {
        if(lse.getValueIsAdjusting() == true)
        {
            if(lse.getSource() == listaServerFiles)
            {
                // 1. Obtener al archivo a transferir del Server
                archivoElegidoServer = (String)listaServerFiles.getSelectedValue();
                System.out.println(archivoElegidoServer);
            }
            
            if(lse.getSource() == listaClientFiles)
            {
                // 1. Obtener al archivo a transferir del Server
                archivoElegidoCliente = (String)listaClientFiles.getSelectedValue();
                System.out.println(archivoElegidoCliente);
            }
        }
    }
    
    public static void main(String args[])
    {
        new FtpClient();
    }
}











