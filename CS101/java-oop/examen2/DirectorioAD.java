import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * DirectorioAD
 */
public class DirectorioAD {
    private BufferedReader archivoIn;
    private Vector vPersonas, vInfo;

    public Vector obtenerPersonas() {
        String str;
        try {
            //Abrir archivo
            archivoIn = new BufferedReader(new FileReader("Directorio.txt"));

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

    public Vector obtenerInfo(String persona) {
        // System.out.println("Called method");
        String str;
        //Abrir archivo
        try {
            archivoIn = new BufferedReader(new FileReader("Datos.txt"));
            vInfo = new Vector();
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                String[] parts = str.split("_");
                if (parts[0].equals(persona)) {
                    // albums += str + "\n";
                    System.out.println(parts[3]);
                    vInfo.add("Nombre: " + parts[0]);
                    vInfo.add("Telefono Casa: " +parts[1]);
                    vInfo.add("Telefono Celular: " +parts[2]);
                    vInfo.add("Direccion: " +parts[3]);
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