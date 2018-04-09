import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;


/**
 * BibliotecaAD
 */
public class BibliotecaAD {
    private BufferedReader archivoIn;
    private Vector vPersonas, vInfo;
    public Vector obtenerEditoriales() {
        String str;
        try {
            //Abrir archivo
            archivoIn = new BufferedReader(new FileReader("Editoriales.txt"));

            //Leer datos
            vPersonas = new Vector();
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                // artistas += str + "\n";
                vPersonas.add(str);

            }
            // Cerrar el archivo
            archivoIn.close();

        } catch (FileNotFoundException e) {
            System.out.println("error: " + e);
        } catch (IOException e) {
            System.out.println("error: " + e);
        }

        return vPersonas;
    }

    public Vector obtenerInfo(String editorial) {
        // System.out.println("Called method");
        String str;
        //Abrir archivo
        try {
            archivoIn = new BufferedReader(new FileReader("Libros.txt"));
            vInfo = new Vector();
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                String[] parts = str.split("_");
                if (parts[2].equals(editorial)) {
                    // albums += str + "\n";
                    vInfo.add("Titulo: " + parts[0]);
                    vInfo.add("Autor: " + parts[1]);
                    vInfo.add("Editorial: " + parts[2]);
                    vInfo.add("\n");

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
        return vInfo;
    }
    
}