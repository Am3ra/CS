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

    
    public CancionesADjdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/canciones?user=root&password=hhooppee&useSSL=false");
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

    
    public String consultarCanciones() {
        String respuesta = "";
        ResultSet tr;
        //Abrir archivo Datos
        String query = "SELECT * FROM canciones";
        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(query);
            while (tr.next()) {
                respuesta +=  tr.getString("titulo")+"&";
            }
            statement.close();
            System.out.println(query);
        } catch (SQLException e) {
            respuesta = "ERROR" + e;
        }
        System.out.println(respuesta);
        return respuesta;
    }
}