import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * EditorAD
 */
public class EditorAD {

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
    
    private Vector returnVector(String datos) {
        String[] intermediate = datos.split("&");
        vData = new Vector();
        for (int i = 0; i < intermediate.length; i++) {
            vData.add(intermediate[i]);
        }
        return vData;
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
        String lscmd = "ls $PWD/*";
        String songs = "";
        try {
            Process p = Runtime.getRuntime().exec(new String[] { "bash", "-c", lscmd });
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = reader.readLine();
            while (line != null) {
                songs += line.split("/")[7]+"\n";
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return songs;
    }
}