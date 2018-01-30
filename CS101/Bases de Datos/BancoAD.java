import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * BancoAD
 */
public class BancoAD {
    private BufferedReader archivoIn;
    private PrintWriter archivoOut;
    public String capturar(String datos){
        String respuesta = "";
        //Abrir archivo Datos
        try {
            archivoOut = new PrintWriter(new FileWriter("Cliente.txt", true));

            //Capturar Datos
            archivoOut.println(datos);
            //Cerrar Archivo
            archivoOut.close();
            respuesta = "Datois capturados: "+datos;
        } catch (IOException e) {
            respuesta = "ERROR"+e;
        }
        
        return respuesta;
    }
    public String consultarClientes(){
        String respuesta = "";
        //Abrir archivo Datos
        try {
            archivoIn = new BufferedReader(new FileReader("Cliente.txt"));
            while(archivoIn.ready()){
                datos += archivoIn.readLine()+"\n";
            }
            //Capturar Datos
            archivoOut.println(datos);
            //Cerrar Archivo
            archivoOut.close();
            respuesta = "Datois capturados: " + datos;
        } catch (IOException e) {
            respuesta = "ERROR" + e;
        }

        return respuesta;
    }
}