import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * AudioTunesAD
 */
public class AudioTunesAD {
    private BufferedReader archivoIn;

    public String obtenerArtistas() {
        String artistas = "", str;
        try {
            //Abrir archivo
            archivoIn = new BufferedReader(new FileReader("Artistas.txt"));

            //Leer datos
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                artistas += str + "\n";
            }
            // Cerrar el archivo
            archivoIn.close();

        } catch (FileNotFoundException e) {
            System.out.println("error: " + e);
        } catch (IOException e) {
            System.out.println("error: " + e);
        }

        return artistas;
    }

    public String obtenerAlbums(String artista) {
        System.out.println("Called method");
        String str, albums = "";
        //Abrir archivo
        try {
            archivoIn = new BufferedReader(new FileReader("Albums.txt"));
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                String[] parts = str.split("_");
                if (parts[0].equals(artista)) {
                    albums += str + "\n";
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
        return albums;
    }
}