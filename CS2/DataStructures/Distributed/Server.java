import javax.swing.*;
import java.awt.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Server extends JFrame {
	private JTextArea taDatos;
	private JPanel panel;

	private ServerSocket server;
	private Socket socket;

	private BufferedReader bufferEntrada;
	private PrintWriter bufferSalida;

	public Server() {
		super("Server");

		taDatos = new JTextArea(15, 20);
		panel = new JPanel();

		panel.setLayout(new GridLayout(1, 1));
		panel.add(new JScrollPane(taDatos));

		setLayout(new GridLayout(1, 1));
		add(panel);
		setSize(300, 300);
		setVisible(true);
	}

	private void iniciarBuffers() {
		try {
			bufferEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufferSalida = new PrintWriter(socket.getOutputStream(), true);
			bufferSalida.flush();
		} catch (IOException ioe) {
			System.out.println("Error: " + ioe);
		}
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

	private String recibirDatos() {
		String datos = "";

		try {
			datos = bufferEntrada.readLine();
		} catch (IOException ioe) {
			System.out.println("Error: " + ioe);
			datos = "Error: " + ioe;
		}

		return datos;
	}

	private void enviarDatos(String mensaje) {
		bufferSalida.println(mensaje);
	}

	private void inicializarServer() {
		String mensajeCliente = "";
		String mensajeServer = "Hola Cliente...buenas tardes...";

		try {
			// 1. Iniciar Server
			server = new ServerSocket(7000, 5);

			while (true) {
				taDatos.append("\nEsperando peticion de conexion de un cliente...\n");

				// 2. Aceptar peticion de conexion por parte de un Cliente
				socket = server.accept();

				// Preparar buffers de entrada y salida para el socket
				iniciarBuffers();

				// Dialogo entre el server y el cliente
				// 3. Recibir mensaje del cliente
				mensajeCliente = recibirDatos();

				// 4. Enviar mensaje al cliente
				enviarDatos(mensajeServer);

				// 5. Cerrar conexion
				cerrarConexion();

				// Desplegar Mensajes
				taDatos.append("\nMensaje Cliente: " + mensajeCliente);
				taDatos.append("\nMensaje Enviado: " + mensajeServer);
			}
		} catch (IOException ioe) {
			System.out.println("Error: " + ioe);
		}
	}

	public static void main(String args[]) {
		Server serverApp = new Server();
		serverApp.inicializarServer();
	}
}