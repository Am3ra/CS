import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

}