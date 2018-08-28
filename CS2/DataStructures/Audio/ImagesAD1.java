import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;

public class ImagesAD1
{
    private BufferedReader archivoIn;
    private ImageIcon imageAlbums[];
    private String results[];

    
    
    
    public ImageIcon[] obtenerImagenesAlbums(String artista) {
        String temp="",datos="";
        try {
            // 1.Abrir el archivo
            archivoIn = new BufferedReader(new FileReader("Albums.txt"));
            // 2. Obtener los datos del archivo
            while (archivoIn.ready()) {
                temp = archivoIn.readLine();
                if(temp.split("_")[0].equals(artista)){
                    datos+=temp.split("_")[1]+"\n";
                    System.out.println(datos);
                }
            }
            // 3. Cerrar el archivo
            archivoIn.close();
        } catch (Exception ioe) {
            System.out.println("Error:" + ioe);
        }
        results = datos.split("\n");
        System.out.println(Arrays.toString(results));
        //Abrir archivo
        imageAlbums = new ImageIcon[results.length];

        for (int i = 0; i < imageAlbums.length; i++) {
            // System.out.println(vAlbums.get(i).toString()+"1");
            imageAlbums[i] = new ImageIcon(getClass().getResource("images/" + results[i] + ".jpg"));
        }
        return imageAlbums;
    }
    
}















