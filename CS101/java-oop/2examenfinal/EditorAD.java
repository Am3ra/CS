import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.io.File;


/**
 * EditorAD
 */
public class EditorAD {

    private Vector vData;

    public String openFile(String name) {
        String result="";
        try {
            BufferedReader archivoIn = new BufferedReader(new FileReader(name));
            while (archivoIn.ready()) {
                result += archivoIn.readLine()+"\n";
            }
            archivoIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return result;
    }

    public String capturarDatos(String datos, String name) {

        try {
            //Abrir archivo
            BufferedWriter archivoOut = new BufferedWriter(new FileWriter(name));
            archivoOut.write(datos);
            archivoOut.close();
            return "Successfully written";
        } catch (FileNotFoundException e) {
            System.out.println("error: " + e);
        } catch (IOException e) {
            System.out.println("error: " + e);
        }
        return "Failure in capturing data";
    }
    public String archivosDisponibles() {
        String songs = "";
        File directory = new File(".");
        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            songs += file.getName()+"&";
        }
        return songs;
    }
    public Vector returnVector(String datos) {
        String[] intermediate = datos.split("&");
        vData = new Vector();
        for (int i = 0; i < intermediate.length; i++) {
            vData.add(intermediate[i]);
        }
        return vData;
    }
    
    public void deleteArchivo(String name) {
        try {
            Process p = Runtime.getRuntime().exec(new String[] { "bash", "-c", "rm ./"+name });
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}