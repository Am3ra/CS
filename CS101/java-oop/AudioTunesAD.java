import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * AudioTunesAD
 */
public class AudioTunesAD {
    private BufferedReader archivoIn;
    private Vector vArtistas, vAlbums, vSongs;

    public Vector obtenerArtistas() {
        String str;
        try {
            //Abrir archivo
            archivoIn = new BufferedReader(new FileReader("Artistas.txt"));

            //Leer datos
            vArtistas = new Vector();
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                // artistas += str + "\n";
                vArtistas.add(str);

            }
            // Cerrar el archivo
            archivoIn.close();

        } catch (FileNotFoundException e) {
            System.out.println("error: " + e);
        } catch (IOException e) {
            System.out.println("error: " + e);
        }

        return vArtistas;
    }

    public Vector obtenerAlbums(String artista) {
        // System.out.println("Called method");
        String str;
        //Abrir archivo
        try {
            archivoIn = new BufferedReader(new FileReader("Albums.txt"));
            vAlbums=new Vector();
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                String[] parts = str.split("_");
                if (parts[0].equals(artista)) {
                    // albums += str + "\n";
                    System.out.println(str);
                    vAlbums.add(parts[1]);
                }
            }
            archivoIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        //Leer archivo

        //cerrar archivo
        return vAlbums;
    }
    public Vector obtenerCancion(String album) {
        // System.out.println("Called method");
        String str;
        //Abrir archivo
        try {
            archivoIn = new BufferedReader(new FileReader("Songs.txt"));
            vSongs=new Vector();
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                String[] parts = str.split("_");
                if (parts[0].equals(album)) {
                    // albums += str + "\n";
                    System.out.println(str);
                    vSongs.add(parts[1]);
                }
            }
            archivoIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        //Leer archivo

        //cerrar archivo
        return vSongs;
    }
}