import javax.swing.*;
import java.awt.*;

import java.util.Vector;

import javax.management.BadStringOperationException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.*;
import java.io.*;

import javax.swing.*;
import java.net.Socket;


import java.util.Vector;
public class Cliente
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
    

    
    public Socket socket;
    
    private BufferedReader bufferEntrada;
    private PrintWriter    bufferSalida;
    
    private AudioOS audioOS = new AudioOS();

    
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
            System.out.println("Error: "+ioe +"line 62");
        }
        
        return datos;
    }

    public void playSong(String name) {
        establecerConexion();
        enviarDatos("streamAudio");
        enviarDatos( name+ ".wav");
        try {
            InputStream in = new BufferedInputStream(socket.getInputStream());
            audioOS.play(in);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void stop() {
        audioOS.stop();
        cerrarConexion();
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
                socket = new Socket("localhost",8008);
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
    // public void actionPerformed(ActionEvent e){
        
    //     if(e.getSource() == bServerFiles)
    //     {
    //         establecerConexion();
    //         enviarDatos("consultarDirectorio");
    //         // taServerFiles.setText(printData(recibirDatos()));
    //         listaServerFiles = new JList(returnVector(recibirDatos()));
    //         listaServerFiles.addListSelectionListener(this);
    //         panelServer.setVisible(false);
    //         panelServer.removeAll();
	// 		panelServer.add(listaServerFiles);
	// 		panelServer.setVisible(true);
    //     }
        
    //     if(e.getSource() == bClientFiles){
    //         listaClientFiles = new JList(returnVector(returnDirectory()));
    //         listaClientFiles.addListSelectionListener(this);
    //         panelClient.setVisible(false);
    //         panelClient.removeAll();
	// 		panelClient.add(listaClientFiles);
	// 		panelClient.setVisible(true);
    //         // taClienteFiles.setText(printData(returnDirectory()));
    //     }
        
    //     if(e.getSource() == bGet)
    //     {
    //         System.out.println((String)listaServerFiles.getSelectedValue());
    //         recibirFile((String)listaServerFiles.getSelectedValue());
    //     }
        
    //     if(e.getSource() == bSend){
    //         System.out.println((String)listaClientFiles.getSelectedValue());   
    //         enviarFile((String)listaClientFiles.getSelectedValue());         
    //     }
        
    // }

    private void enviarFile(String filename) {
        try{
            establecerConexion();
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
            cerrarConexion();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public String RecibirlistaSongs(String filename) {
        String datos ="";
        try{
            establecerConexion();
            enviarDatos("recibirListaSongs");
            enviarDatos(filename);
            datos = recibirDatos();
            cerrarConexion();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return datos;
    }

    public byte[] recibirFileImagen(String fileName) {
        try{
        establecerConexion();
        enviarDatos("RecieveFileImagen");
        enviarDatos(fileName);
        File temp_file;
        ByteArrayOutputStream buffer;
        // byte[] buffer = new byte[40960];
        
            InputStream is = socket.getInputStream();
            
            buffer= new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[16384];

            while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
            }
        cerrarConexion();
        return buffer.toByteArray();
        }catch(Exception e){
            System.out.println(e + "Line233");
        }
        return null;
    }

    public void busquedaArtista(String artista) {
        establecerConexion();
        enviarDatos("busquedaArtista");
        enviarDatos(artista);
        cerrarConexion();
    }

    public String busquedaAlbum(String album) {
        establecerConexion();
        enviarDatos("busquedaAlbum");
        enviarDatos(album);
        String result = recibirDatos();
        cerrarConexion();
        return result;
    }

    public void reset() {
        establecerConexion();
        enviarDatos("reset");
        cerrarConexion();
    }
    
    public static void main(String args[])
    {
        Cliente client = new Cliente();
    }
}











