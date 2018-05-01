import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.StringTokenizer;



/**
 * BancoADjdbcjdbc
 * 
 * 
 */

public class CancionesADjdbc {

    private Connection conexion;
    private Statement statement;
    private BufferedReader archivoIn;
    private PrintWriter archivoOut;

    
    public CancionesADjdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/banco?user=root&password=hhooppee&useSSL=false");
            System.out.println("Conexion exitosa a la BD...");
        } catch (ClassNotFoundException e) {
            System.out.println("Error 1:" + e);
        } catch (InstantiationException e) {
            System.out.println("Error 2: " + e);
        } catch (IllegalAccessException e) {
            System.out.println("Error 3: " + e);
        } catch (SQLDataException e) {
            System.out.println("Error 4: " + e);
        } catch (SQLException e) {
            System.out.println("Error 5: " + e);
        }
    }

    
    // public String consultarClientesR() {
    //     String respuesta = "";
    //     ResultSet tr;
    //     //Abrir archivo Datos
    //     String query = "SELECT * FROM Clientes";
    //     try {
    //         statement = conexion.createStatement();
    //         tr = statement.executeQuery(query);
    //         clientedp = new ClienteDP();
    //         while (tr.next()) {
                
    //             clientedp.setNocta(tr.getString("cuenta"));
    //             clientedp.setNombre(tr.getString("nombre"));
    //             clientedp.setTipo(tr.getString("tipo"));
    //             clientedp.setSaldo(tr.getInt("saldo"));
    //             clientedp.setFecha(tr.getString("fecha"));
    //             clientedp.setHora(tr.getString("hora"));

    //             respuesta += clientedp.toString()+"&";
    //         }
    //         statement.close();
    //         System.out.println(query);
    //     } catch (SQLException e) {
    //         respuesta = "ERROR" + e;
    //     }

    //     return respuesta;
    // }
    
    // public String consultarCuenta(String cuenta) {
    //     String respuesta = "";
    //     ResultSet tr;
    //     //Abrir archivo Datos
    //     String query = "SELECT * FROM Clientes where cuenta = "+cuenta+";" ;
    //     System.out.println(query);
    //     if (cuenta.equals("")){
    //         return "No se introdujo cuenta";
    //     }
    //     try {

    //         statement = conexion.createStatement();
    //         tr = statement.executeQuery(query);
    //         clientedp = new ClienteDP();
    //         while (tr.next()) {

    //             clientedp.setNocta(tr.getString("cuenta"));
    //             clientedp.setNombre(tr.getString("nombre"));
    //             clientedp.setTipo(tr.getString("tipo"));
    //             clientedp.setSaldo(tr.getInt("saldo"));
    //             clientedp.setFecha(tr.getString("fecha"));
    //             clientedp.setHora(tr.getString("hora"));

    //             respuesta += clientedp.toString();
    //         }
    //         statement.close();
    //         System.out.println(query);
    //     } catch (SQLException e) {
    //         respuesta = "ERROR" + e;
    //     }
    //     if (respuesta.equals("")){
    //         return "No se encontro cuenta.";
    //     };
    //     return respuesta;
    // }
}