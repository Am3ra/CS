import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.sound.sampled.Clip;

public class AudioTunesGUI2 extends JFrame implements ActionListener, ListSelectionListener {
	//Atributos de la aplicacion
	private JPanel panelUsuario, panelArtistas, panelAlbums, panelSongs, panelPrincipal, panelAudio;
	private JButton bCatalogo, bAlbums, bSongs;
	private JButton bPlay, bStop;
	private JTextField tfArtista, tfAlbum, tfSong;
	private JTextArea taArtistas, taAlbums, taSongs;


	private AudioOS audio = new AudioOS();
	private AudioTunesAD atad = new AudioTunesAD();

	private Vector vArtistas, vAlbums, vSongs;
	private JList listaArtistas, listaAlbums, listaSongs;

	private ImageIcon iconAlbum[];

	public AudioTunesGUI2() {
		super("Audio Tunes Super");

		//1Crear objetos de los atributos
		tfArtista = new JTextField(10);
		tfAlbum = new JTextField(10);
		tfSong = new JTextField(10);
		bCatalogo = new JButton("Catalogo");
		bArtista = new JButton("Artistas");
		bAlbums = new JButton("Albums");
		bSongs = new JButton("Canciones");
		bPlay = new JButton("Play");
		bStop = new JButton("Stop");
		taArtistas = new JTextArea("Artistas", 20, 20);
		taAlbums = new JTextArea("Albums", 20, 20);
		taSongs = new JTextArea("Song");
		panelUsuario = new JPanel();
		panelArtistas = new JPanel();
		panelAlbums = new JPanel();
		panelSongs = new JPanel();
		panelAudio = new JPanel();
		panelPrincipal = new JPanel();

		bPlay.addActionListener(this);
		bStop.addActionListener(this);
		bCatalogo.addActionListener(this);
		bAlbums.addActionListener(this);
		bSongs.addActionListener(this);

		//Definir Layouts de los JPaneles
		panelUsuario.setLayout(new FlowLayout());
		panelArtistas.setLayout(new GridLayout(1, 1));
		panelAlbums.setLayout(new GridLayout(1, 1));
		panelSongs.setLayout(new GridLayout(1, 1));
		panelAudio.setLayout(new FlowLayout());
		panelPrincipal.setLayout(new BorderLayout(5, 5));

		// Colocar los objetos de los atributos
		panelUsuario.add(bCatalogo);
		panelUsuario.add(new JLabel("Artista :"));
		panelUsuario.add(tfArtista);
		panelUsuario.add(bAlbums);
		panelUsuario.add(new JLabel("    Albums :"));
		panelUsuario.add(tfAlbum);
		panelUsuario.add(bSongs);

		panelArtistas.add(new JScrollPane(taArtistas));
		panelAlbums.add(new JScrollPane(taAlbums));
		panelSongs.add(new JScrollPane(taSongs));

		panelAudio.add(new JLabel("Song: "));
		panelAudio.add(tfSong);
		panelAudio.add(bPlay);
		panelAudio.add(bStop);

		panelPrincipal.add(panelUsuario, BorderLayout.NORTH);
		panelPrincipal.add(panelArtistas, BorderLayout.WEST);
		panelPrincipal.add(panelAlbums, BorderLayout.CENTER);
		panelPrincipal.add(panelSongs, BorderLayout.EAST);
		panelPrincipal.add(panelAudio, BorderLayout.SOUTH);

		//Adicionar panel principalal JFramey hacelo visible

		add(panelPrincipal);
		setSize(700, 400);
		// setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JPanel getPanel2() {
		return panelPrincipal;
	}

	public void actionPerformed(ActionEvent evento) {
		String song, artista;
		if (evento.getSource() == bCatalogo) {

			// artistas = atad.obtenerArtistas();
			vArtistas = atad.obtenerArtistas();

			// taArtistas.setText(artistas);
			listaArtistas = new JList(vArtistas);
			listaArtistas.addListSelectionListener(this);
			panelArtistas.setVisible(false);
			panelArtistas.removeAll();
			panelArtistas.add(listaArtistas);
			panelArtistas.setVisible(true);

		}
		if (evento.getSource() == bAlbums) {
			//obtener artista
			artista = tfArtista.getText();
			//obtener albums
			vAlbums = atad.obtenerAlbums(artista);
			//desplegar resultados
			listaAlbums = new JList(vAlbums);
			listaAlbums.addListSelectionListener(this);
			panelAlbums.setVisible(false);
			panelAlbums.removeAll();
			panelAlbums.add(listaAlbums);
			panelAlbums.setVisible(true);
		}
		if (evento.getSource() == bPlay) {
			song = tfSong.getText();
			try {
				audio.reproducir(song);
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}

		}
		if (evento.getSource() == bStop) {
			audio.stop();
		}
	}

	public void valueChanged(ListSelectionEvent eListener) {
		String artistaElegido, albumElegido, songElegido;
		if (eListener.getValueIsAdjusting() == true) {
			if (eListener.getSource() == listaArtistas) {
				artistaElegido = (String) listaArtistas.getSelectedValue();
				tfArtista.setText(artistaElegido);
				System.out.println(artistaElegido);


				// vAlbums = atad.obtenerAlbums(artistaElegido);
				iconAlbum = atad.obtenerAlbumsIcon(artistaElegido);
				//desplegar resultados
				listaAlbums = new JList(iconAlbum);
				listaAlbums.addListSelectionListener(this);

				panelAlbums.setVisible(false);
				panelAlbums.removeAll();
				panelAlbums.add(new JScrollPane(listaAlbums));
				panelAlbums.setVisible(true);
			}
			if (eListener.getSource() == listaAlbums) {
				int albumSelected = listaAlbums.getSelectedIndex();
				System.out.println(albumSelected);
				albumElegido = atad.getAlbum(albumSelected);
				vSongs = atad.obtenerCancion(albumElegido);
				//desplegar resultados
				listaSongs = new JList(vSongs);
				listaSongs.addListSelectionListener(this);
				panelSongs.setVisible(false);
				panelSongs.removeAll();
				panelSongs.add(new JScrollPane(listaSongs));
				panelSongs.setVisible(true);
			}
			if (eListener.getSource() == listaSongs) {
				songElegido = (String) listaSongs.getSelectedValue();
				tfSong.setText(songElegido);
				System.out.println(songElegido);
			}

		}

	}

	public static void main(String args[]) {
		new AudioTunesGUI2();
	}
}