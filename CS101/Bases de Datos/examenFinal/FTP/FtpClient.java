import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.util.Vector;

import javax.management.BadStringOperationException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.net.Socket;


import java.util.Vector;
public class FtpClient extends JFrame implements ActionListener, ListSelectionListener
{
    // Atributos de la aplicacion
    private JPanel panelUsuario, panelServer, panelClient, panelPrincipal;
    
    private JButton bServerFiles, bClientFiles, bGet, bSend;
    private JTextArea  taServerFiles, taClienteFiles;
    
    private Vector vectorServerFiles, vectorClientFiles, vData;
    private JList  listaServerFiles, listaClientFiles;

    private FileInputStream in;
    private BufferedInputStream bufferedInputStream;
    private OutputStream outputStream;
    
    public FtpClient(){
        super("FTP: File Transfer Protocol");
        
        // 1. Crear objetos d elos atributos
        bServerFiles = new JButton("Mostrar Directorio Server");
        bClientFiles  = new JButton("Mostrar Directorio Cliente");
        bGet   = new JButton("GET (->)");
        bSend    = new JButton("SEND (<-)");
        taServerFiles= new JTextArea("Directorio Server",12,15);
        taClienteFiles  = new JTextArea("Directorio Cliente",12,15);
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
        setSize(600,250);
        setVisible(true);
    }
    
    public Socket socket;
    
    private BufferedReader bufferEntrada;
    private PrintWriter    bufferSalida;
    
    
    // Constructor
    
    public void enviarDatos(String datos)
    {
        bufferSalida.println(datos);
        bufferSalida.flush();
    }
    
    public String recibirDatos()
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
    
    public void cerrarConexion(){
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
    
    public void establecerConexion(){
        try
        {
                // 1. Obtener del tfDatos el mensaje a eviar al server
                // 2. Establecer conexion con el server en el puerto 5005
                socket = new Socket("localhost",5005);
                // socket = new Socket("localhost",7000);
                //socket = new Socket("10.25.194.147",5005);
                
                // 3. Preparar canales o buffers de comunicacion
                bufferEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferSalida  = new PrintWriter(socket.getOutputStream());
                bufferSalida.flush();
               
        }

        catch(IOException ioe)
        {
            System.out.println("Error: "+ioe);
        }
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

    private String printData(String datos) {
        String[] intermediate = datos.split("&");
        datos = "";
        for (int i = 0; i < intermediate.length; i++) {
            datos += intermediate[i] + "\n";
        }
        return datos;
    }
    private Vector returnVector(String datos) {
        String[] intermediate = datos.split("&");
        vData = new Vector();
        for (int i = 0; i < intermediate.length; i++) {
            vData.add(intermediate[i]);
        }
        return vData;
    }
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == bServerFiles)
        {
            establecerConexion();
            enviarDatos("consultarDirectorio");
            // taServerFiles.setText(printData(recibirDatos()));
            listaServerFiles = new JList(returnVector(recibirDatos()));
            listaServerFiles.addListSelectionListener(this);
            panelServer.setVisible(false);
            panelServer.removeAll();
			panelServer.add(listaServerFiles);
			panelServer.setVisible(true);
        }
        
        if(e.getSource() == bClientFiles){
            listaClientFiles = new JList(returnVector(returnDirectory()));
            listaClientFiles.addListSelectionListener(this);
            panelClient.setVisible(false);
            panelClient.removeAll();
			panelClient.add(listaClientFiles);
			panelClient.setVisible(true);
            // taClienteFiles.setText(printData(returnDirectory()));
        }
        
        if(e.getSource() == bGet)
        {
            System.out.println((String)listaClientFiles.getSelectedValue());            
        }
        
        if(e.getSource() == bSend)
        {
        System.out.println((String)listaServerFiles.getSelectedValue());
        }
        
    }

    private void enviarFile(String filename) {
        establecerConexion();
        enviarDatos("SendFile")
        File myFile = new File (FILE_TO_SEND);
        byte [] mybytearray  = new byte [(int)myFile.length()];
        in = new FileInputStream(myFile);
        bufferedInputStream = new BufferedInputStream(in);
        bufferedInputStream.read(mybytearray,0,mybytearray.length);
        outputStream = sock.getOutputStream();
        System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
        outputStream.write(mybytearray,0,mybytearray.length);
        outputStream.flush();
        System.out.println("Done.");
        cerrarConexion();
    }
    
    public void valueChanged(ListSelectionEvent lse){
        
        if(lse.getValueIsAdjusting() == true)
        {
            if(lse.getSource() == listaServerFiles)
            {
                
            }
            
            if(lse.getSource() == listaServerFiles)
            {
                
            }
        }
    }
    
    public static void main(String args[])
    {
        FtpClient client = new FtpClient();
    }
}











