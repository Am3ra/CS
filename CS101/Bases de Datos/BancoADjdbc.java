import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;


/**
 * BancoADjdbcjdbc
 */
public class BancoADjdbc {

    private BufferedReader archivoIn;
    private PrintWriter archivoOut;
    private Connection conexion;

    public BancoADjdbc(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysl://localhost/banco?user=root");
            System.out.println("Conexion exitosa a la BD...");
        } catch (ClassNotFoundException e) {
            System.out.println("Error 1:" + e);
        } catch(InstantiationException e){
            System.out.println("Error 2: "+e);
        } catch(IllegalAccessException e){
            System.out.println("Error 3: "+e);
        } catch(SQLDataException e){
            System.out.println("Error 4: "+e);
        } catch(SQLException e){
            System.out.println("Error 5: " + e);
        }
    }

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
                respuesta += archivoIn.readLine()+"\n";
            }
            //Capturar Datos
            archivoOut.println(respuesta);
            //Cerrar Archivo
            archivoOut.close();
            respuesta = "Datois capturados: " + respuesta;
        } catch (IOException e) {
            respuesta = "ERROR" + e;
        }

        return respuesta;
    }
}