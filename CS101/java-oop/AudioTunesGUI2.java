import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.Clip;

public class AudioTunesGUI2 extends JFrame implements ActionListener {
	//Atributos de la aplicacion
	private JPanel panelUsuario, panelArtistas, panelAlbums, panelSongs, panelPrincipal, panelAudio;
	private JButton bCatalogo, bArtista, bAlbums, bSongs;
	private JButton bPlay, bStop;
	private JTextField tfArtista, tfAlbum, tfSong;
	private JTextArea taArtistas, taAlbums, taSongs;
	private Clip clip;

	private AudioOS audio = new AudioOS();
	private AudioTunesAD atad = new AudioTunesAD();

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
		setVisible(true);
	}

	public void actionPerformed(ActionEvent evento) {
		String song, respuesta, artistas, artista, albums;
		if (evento.getSource() == bCatalogo) {

			artistas = atad.obtenerArtistas();

			taArtistas.setText(artistas);
		}
		if (evento.getSource()== bAlbums) {
			//obtener artista
			artista = tfArtista.getText();
			//obtener albums
			albums = atad.obtenerAlbums(artista);
			//desplegar resultados
			taAlbums.setText(albums);
		}
		if (evento.getSource() == bPlay) {
			song = tfSong.getText();

			audio.reproducir(song);
		}
		if (evento.getSource() == bStop) {
			audio.stop();
		}
	}

	public static void main(String args[]) {
		new AudioTunesGUI2();
	}
}