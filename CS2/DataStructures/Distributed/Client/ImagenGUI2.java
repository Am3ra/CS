import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.File;

import java.net.Socket;


public class ImagenGUI2 extends JFrame implements ActionListener
{
	// Atributos, variables de clase o variables de instancia
    // Atributos originales
    private JButton bNext, bPrev;
    
    private int contadorImagen=-1;
    private int numeroImagenes;
    
    private InputStream inputStream;
    private FileOutputStream fileOut;
    private byte streamImagen[];
    
    //private Conexion conexion = new Conexion();
    private Socket socket;
  
    //private JPanel panel1, panel2, panel3;
    
    // Nuevos atributos de JPanels y JButtons para el JFrame
    private JPanel panelOpcionArtista, panelPrevNext, panelAlbums, panelSongs, panelPlayStop, panelPrincipal;
	private JButton bArtista, bPlay, bStop;
    private JTextField tfArtista;
    private Cliente cliente = new Cliente();

    private int i =0,max;
    private JList listaSongs;
    
    // Constructor y Metodos o servicios
    public ImagenGUI2()
    {
        super("Albums Images LList");
        
        cliente.establecerConexion();
        cliente.enviarDatos("consultarMax");
        max = Integer.parseInt(cliente.recibirDatos());
        System.out.println("MAX: " + max);
        cliente.cerrarConexion();

        // 1. Crear objetos de las variables de instancia o de clase
        bPrev  = new JButton("<");
        bNext  = new JButton(">");
        
        panelOpcionArtista  = new JPanel();
        panelPrevNext  = new JPanel();
        panelAlbums    = new JPanel();
        panelSongs     = new JPanel();
        panelPlayStop  = new JPanel();
        panelPrincipal = new JPanel();
        
        tfArtista = new JTextField();
        bArtista  = new JButton("Search");
        bPlay     = new JButton("Play");
        bStop     = new JButton("Stop");
        
        // 2. Definir Layouts de los panels
        panelOpcionArtista.setLayout(new GridLayout(1,3));
        panelPrevNext.setLayout(new FlowLayout());
        //panelPrevNext.setLayout(new GridLayout(1,1));
        panelAlbums.setLayout(new GridLayout(1,1));
        panelSongs.setLayout(new GridLayout(1,1));
        panelPlayStop.setLayout(new FlowLayout());
        panelPrincipal.setLayout(new BorderLayout(4,4));
        
        // 3. Adicionar addActionListener a los botones y poner boton bPrev no activo
        bPrev.addActionListener(this);
        bNext.addActionListener(this);
        bPrev.setEnabled(false);
        
        bArtista.addActionListener(this);
        bPlay.addActionListener(this);
        bStop.addActionListener(this);
        
        // 5. Adicionar a los panels los objetos correspondientes
        panelOpcionArtista.add(new JLabel("Artista: "));
        panelOpcionArtista.add(tfArtista);
        panelOpcionArtista.add(bArtista);
        
        panelPrevNext.add(bPrev);
        panelPrevNext.add(bNext);

        panelAlbums.add(new JLabel(new ImageIcon(cliente.recibirFileImagen("0"))));

        listaSongs = new JList(cliente.RecibirlistaSongs("0").split("&"));
        panelSongs.add(listaSongs);

        // panelSongs.add(new JList(cliente.recibirDatos().split("&")));
        
        panelPlayStop.add(new JLabel("Now Playing: NO SONG"));
        panelPlayStop.add(bPlay);
        panelPlayStop.add(bStop);
        
        panelPrincipal.add(panelOpcionArtista, BorderLayout.NORTH);
        panelPrincipal.add(panelPrevNext, BorderLayout.WEST);
        panelPrincipal.add(panelAlbums, BorderLayout.CENTER);
        panelPrincipal.add(panelSongs, BorderLayout.EAST);
        panelPrincipal.add(panelPlayStop, BorderLayout.SOUTH);
        
        // 6. Adicionar panel3 al JFrame y hacerlo visible
        add(panelPrincipal);
        setSize(500,300);
        setVisible( true );
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (i == max - 1) {
            bNext.setEnabled(false);
        }
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == bNext) {
            bPrev.setEnabled(true);
            i++;
            panelAlbums.setVisible(false);
            panelAlbums.removeAll();

            panelAlbums.add(new JLabel(new ImageIcon(cliente.recibirFileImagen("" + i))));
            panelAlbums.setVisible(true);


            panelSongs.setVisible(false);
            panelSongs.removeAll();

            listaSongs = new JList(cliente.RecibirlistaSongs(""+i).split("&"));
            panelSongs.add(listaSongs);
            panelSongs.setVisible(true);


            if (i == max - 1) {
                bNext.setEnabled(false);
            }

        } else if (e.getSource() == bPrev) {
            bNext.setEnabled(true);
            i--;
            panelAlbums.setVisible(false);
            panelAlbums.removeAll();
            panelAlbums.add(new JLabel(new ImageIcon(cliente.recibirFileImagen("" + i))));
            panelAlbums.setVisible(true);

            panelSongs.setVisible(false);
            panelSongs.removeAll();

            listaSongs = new JList(cliente.RecibirlistaSongs("" + i).split("&"));
            panelSongs.add(listaSongs);
            panelSongs.setVisible(true);
            if (i == 0) {
                bPrev.setEnabled(false);
            }
        } else if (e.getSource() == bArtista){
            System.out.println(tfArtista.getText());
            if(tfArtista.getText().equals("")){
                System.out.println("RESET");
                cliente.reset();
            }else{
                String artista = tfArtista.getText();
                cliente.busquedaArtista(artista);
            }
            
            cliente.establecerConexion();
            cliente.enviarDatos("consultarMax");
            max = Integer.parseInt(cliente.recibirDatos());
            System.out.println("MAX: " + max);
            cliente.cerrarConexion();
            i=0;

            panelAlbums.setVisible(false);
            panelAlbums.removeAll();

            panelAlbums.add(new JLabel(new ImageIcon(cliente.recibirFileImagen("0"))));
            panelAlbums.setVisible(true);

            panelSongs.setVisible(false);
            panelSongs.removeAll();

            listaSongs = new JList(cliente.RecibirlistaSongs("" + i).split("&"));
            panelSongs.add(listaSongs);
            panelSongs.setVisible(true);
            bPrev.setEnabled(false);
            if (i == max - 1) {
                bNext.setEnabled(false);
            } else {
                bNext.setEnabled(true);
            }

        }
        else if (e.getSource() == bPlay) {
            cliente.playSong( listaSongs.getSelectedValue().toString());
        }
        else if (e.getSource() == bStop) {
            cliente.stop();
        }
    }

	
	//// Metodo principal main()
	public static void main(String args[])
	{
		new ImagenGUI2();
	}
}
