import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;

public class ImagesAD1
{
    private BufferedReader archivoIn;
    
    private ImageIcon imagenesAlbums[];
    private String albums;
    private String albumsImages[];

    public void consultarClientes() {
        String datos = "";
        lnNumber = 0;
        try {
            // 1.Abrir el archivo
            archivoIn = new BufferedReader(new FileReader("Clientes.txt"));
            // 2. Obtener los datos del archivo
            while (archivoIn.ready()) {
                datos += archivoIn.readLine() + "\n";
            }
            // 3. Cerrar el archivo
            archivoIn.close();
        } catch (Exception ioe) {
            System.out.println("Error:" + ioe);
        }
        // 4.Entregar los datos.
        albums = datos; 
    }
    
    // public String consultar(String grupo) {
    //     String str = "";
    //     String datos = "";
    //     String nocta = "";
    //     boolean encontrado = false;
    //     StringTokenizer st;
    //     int i = 0;

    //     if (arrayClientes == null) {
    //         return "Arreglo no inicializado / null";
    //     }

    //     while (i < arrayClientes.length && !encontrado) {
    //         str = arrayClientes[i];
    //         st = new StringTokenizer(str, "_");
    //         nocta = st.nextToken();
    //         if (ncta.equals(nocta)) {
    //             posicion = i;
    //             System.err.println("posicion : " + posicion);
    //             encontrado = true;
    //         }
    //         i++;
    //         datos = str;
    //     }
    //     if (!encontrado) {
    //         return "NO_LOCALIZADO";
    //     }
    //     return datos;
    // }
    public ImageIcon[] obtenerImagenesAlbums(String artista)
    {
        String albumFinal[],temp="";
        StringTokenizer st;
        int numeroAlbums=0;
        int i=0;
        
        String albumsArray[] = albums.split("\n");
        
        for (String j : albumsArray) {
            if(j.split("_")[0].equals(artista)){
                temp += j.split("_")[1]+"_";
            }
        }
        ImageIcon imagenesAlbums = new ImageIcon[temp.split("_").length-1];

        for (i = 0 ; i<temp.split("_").length-1;i++) {
            try {
                imagenesAlbums[i] = new ImageIcon("images/"+temp.split("_")[i]);
            } catch (Exception e) {
                System.out.println(e.toString);
            }
        }
        

        return imagenesAlbums;
    }
    
}















