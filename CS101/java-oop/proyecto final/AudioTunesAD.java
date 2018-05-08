import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;

/**
 * AudioTunesAD
 */
public class AudioTunesAD {
    private BufferedReader archivoIn;
    private Vector vArtistas, vAlbums, vSongs;
    private ImageIcon imageAlbums[];
    private Cliente cliente = new Cliente();

    public Vector obtenerArtistas() {
        String str;
        //Abrir archivo
        cliente.establecerConexion();

        System.out.println("obtener Artistas");
        vArtistas = new Vector();
        cliente.enviarDatos("consultarArtistas");
        //Leer datos
        String[] artistas = cliente.recibirDatos().split("&");
        for (int i = 0; i < artistas.length; i++) {
            vArtistas.add(artistas[i]);
        }
        cliente.cerrarConexion();
        return vArtistas;
    }

    public Vector obtenerAlbums(String artista) {
        String str;
        //Abrir archivo
        cliente.establecerConexion();

        System.out.println("obtener Albums");
        vAlbums = new Vector();
        cliente.enviarDatos("consultarAlbums");
        cliente.enviarDatos(artista);
        //Leer datos
        String[] artistas = cliente.recibirDatos().split("&");
        for (int i = 0; i < artistas.length; i++) {
            vAlbums.add(artistas[i]);
        }
        cliente.cerrarConexion();
        return vAlbums;
    }

    public ImageIcon[] obtenerAlbumsIcon(String artista) {

        //Abrir archivo
        vAlbums = obtenerAlbums(artista);
        imageAlbums = new ImageIcon[vAlbums.size()];

        for (int i = 0; i < imageAlbums.length; i++) {
            System.out.println(vAlbums.get(i).toString()+"1");
            imageAlbums[i] = new ImageIcon(getClass().getResource("image/" + vAlbums.get(i).toString() + ".jpg"));
        }
        //cerrar archivo
        return imageAlbums;
    }

    public String getAlbum(int albumSelected) {
        return vAlbums.get(albumSelected).toString();
    }

    public Vector obtenerCancion(String album) {
         String str;
        //Abrir archivo
        cliente.establecerConexion();

        System.out.println("obtener Canciones");
        vSongs = new Vector();
        cliente.enviarDatos("consultarCanciones");
        cliente.enviarDatos(album);
        //Leer datos
        String[] artistas = cliente.recibirDatos().split("&");
        for (int i = 0; i < artistas.length; i++) {
            vSongs.add(artistas[i]);
        }
        cliente.cerrarConexion();
        return vSongs;
    }
}