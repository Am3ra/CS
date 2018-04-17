/***********************************************************/
/*** Programa de Intercambio de Mensajes con BSD Sockets ***/
/***              Class: Cliente                       ***/
/***********************************************************/

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;

import java.io.IOException;

import java.net.Socket;


public class Cliente extends JFrame implements ActionListener
{
    private JTextField tfDatos;
    private JButton bEnviar;
    private JTextArea taDatos;
    private JPanel panel1;
    private JPanel panel2;
    
    private Socket socket;
    
    private BufferedReader bufferEntrada;
    private PrintWriter    bufferSalida;
    
    
    // Constructor
    public Cliente()
    {
        super("Cliente");
        
        // 1. Crear los objetos de los atributos
        tfDatos = new JTextField();
        taDatos = new JTextArea();
        bEnviar = new JButton("Enviar datos");
        panel1  = new JPanel();
        panel2  = new JPanel();
        
        // 2. Definir el Layout de los panels
        panel1.setLayout(new GridLayout(1,2));
        panel2.setLayout(new BorderLayout());
        
        // 3. Adicionar addActionListener al boton bEnviar
        bEnviar.addActionListener(this);
        
        // 4. Adicionar los objetos a los panels
        panel1.add(tfDatos);
        panel1.add(bEnviar);
        
        panel2.add(panel1, BorderLayout.NORTH);
        panel2.add(new JScrollPane(taDatos), BorderLayout.CENTER);
        
        // 5. Adicionar panel2 al JFrame y hacerlo visible
        add(panel2);
        setSize(400,400);
        setVisible(true);
    }
    
    private void enviarDatos(String datos)
    {
        bufferSalida.println(datos);
        bufferSalida.flush();
    }
    
    private String recibirDatos()
    {
        String datos="";
        
        try
        {
            datos = bufferEntrada.readLine();
            bufferSalida.flush();
        }
        catch(IOException ioe)
        {
            System.out.println("Error: "+ioe);
        }
        
        return datos;
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
    
    public void actionPerformed(ActionEvent e)
    {
        String mensaje="";
        
        try
        {
            if (e.getSource() == bEnviar)
            {
                // 1. Obtener del tfDatos el mensaje a eviar al server
                mensaje = tfDatos.getText();
                
                // 2. Establecer conexion con el server en el puerto 5005
                //socket = new Socket("localhost",5005);
                socket = new Socket("localhost",7000);
                //socket = new Socket("10.25.194.147",5005);
                
                taDatos.append("\nSe hizo la Conexion con el Server...\n");
                
                // 3. Preparar canales o buffers de comunicacion
                bufferEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferSalida  = new PrintWriter(socket.getOutputStream());
                bufferSalida.flush();
                
                // 4. Enviar mensaje al server
                enviarDatos(mensaje);
                
                // 5. Recibir datos del server
                mensaje = recibirDatos();
                
                // 6. Cerrar conexion y desplegamos el mensaje del server
                cerrarConexion();
                
                taDatos.append("Mensaje del Server: "+mensaje);
                
                
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Error: "+ioe);
        }
    }
    
    
    public static void main(String args[])
    {
        new Cliente();  	
    }
    
} 
