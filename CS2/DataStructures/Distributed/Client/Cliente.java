import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Cliente extends JFrame implements ActionListener
{
	private JTextField tfMensaje;
	private JButton    bEnviar;
	private JTextArea  taDatos;
	private JPanel     panel1, panel2;
	
	private Socket       socket;
	
	private BufferedReader bufferEntrada;
	private PrintWriter    bufferSalida;
	
	public Cliente()
	{
		super("Cliente");
		
		tfMensaje = new JTextField(10);
		bEnviar   = new JButton("Enviar mensaje");
		taDatos   = new JTextArea(12,20);
		panel1    = new JPanel();
		panel2    = new JPanel();
		
		bEnviar.addActionListener(this);
		panel1.setLayout(new GridLayout(1,2));
		panel2.setLayout(new FlowLayout());
		
		panel1.add(tfMensaje);
		panel1.add(bEnviar);
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
		
		add(panel2);
		setSize(300,300);
		setVisible(true);
	}
	
	private void establecerConexion()
	{
		try
		{
			socket = new Socket(InetAddress.getByName("localhost"),7000);
			//socket = new Socket(InetAddress.getByName("10.0.2.15"),7000);
		}
		catch(IOException ioe)
		{
			System.out.println("Error: "+ioe);
		}	
	}
	
	private void iniciarBuffers()
	{
		try
		{
			bufferEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufferSalida  = new PrintWriter(socket.getOutputStream(),true);
			bufferSalida.flush();
		}
		catch(IOException ioe)
		{
			System.out.println("Error: "+ioe);
		}
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
			datos = "Error: "+ioe;
		}
		
		return datos;
	}
	
	private void enviarDatos(String mensaje)
	{
		bufferSalida.println(mensaje);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String mensaje="";
		
		if(e.getSource() == bEnviar)
		{
			// 1. Establecer conexion con el server
			establecerConexion();
			
			// 2. Preparar buffers de entrada y salida para el socket
			iniciarBuffers();
			
			// Dialogo entre el cliente y el server
			// 3. Enviar mensaje al server
			mensaje = tfMensaje.getText();
			enviarDatos(mensaje);
			
			// 4. Recibir mensaje del server
			mensaje = recibirDatos();
			
			// 5. Cerrar conexion
			cerrarConexion();
			
			// Desplegar mensaje del server
			taDatos.append("\nMensaje de Server: "+mensaje);
		}
	}
	
	public static void main(String args[])
	{
		Cliente clienteApp = new Cliente();
	}
}