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
 */
public class BancoADjdbc {

    private BufferedReader archivoIn;
    private PrintWriter archivoOut;
    private Connection conexion;
    private Statement statement;

    private ClienteDP clientedp = new ClienteDP();

    public BancoADjdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysl://localhost/banco?user=root");
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

    public String capturar(String datos) {
        String respuesta = "";

        StringTokenizer st = new StringTokenizer(datos, "_");

        String cta = st.nextToken();
        String nombre = st.nextToken();
        String tipo = st.nextToken();
        String saldo = st.nextToken();

        clientedp = new ClienteDP(datos);

        String insertCliente = "INSERT INTO Cliente VALUES('" + clientedp.toStringSql() + "')";
        //Abrir archivo Datos


        try {
            // archivoOut = new PrintWriter(new FileWriter("Cliente.txt", true));

            // //Capturar Datos
            // archivoOut.println(datos);
            // //Cerrar Archivo
            // archivoOut.close();

            statement = conexion.createStatement();
            statement.executeUpdate(insertCliente);
            statement.close();

            respuesta = "Datos capturados: " + datos;
            System.out.println(insertCliente);
        } catch (SQLException e) {
            respuesta = "ERROR" + e;
        }

        return respuesta;
    }
    public String consultarClientes() {
        String respuesta = "";
        ResultSet tr;
        String cta, nombre, tipo;
        int saldo;
        //Abrir archivo Datos
        String query = "SELECT * FROM Cliente";
        try {
            // archivoIn = new BufferedReader(new FileReader("Cliente.txt"));
            // while(archivoIn.ready()){
            //     respuesta += archivoIn.readLine()+"\n";
            // }
            // //Capturar Datos
            // archivoOut.println(respuesta);
            // //Cerrar Archivo
            // archivoOut.close();
            // respuesta = "Datois capturados: " + respuesta;

            statement = conexion.createStatement();
            tr = statement.executeQuery(query);
            clientedp = new ClienteDP();
            while (tr.next()) {
                // cta = tr.getString("nocta");
                // nombre = tr.getString("nombre");
                // tipo = tr.getString("tipo");
                // saldo = tr.getInt("saldo");

                // respuesta = respuesta + cta + "_" + nombre + "_" + tipo + "_" + saldo;

                clientedp.setNocta(tr.getString("nocta"));
                clientedp.setNombre(tr.getString("nombre"));
                clientedp.setTipo(tr.getString("tipo"));
                clientedp.setSaldo(tr.getInt("saldo"));

                respuesta += clientedp.toString()+"\n";
            }
            statement.close();
            System.out.println(query);
        } catch (SQLException e) {
            respuesta = "ERROR" + e;
        }

        return respuesta;
    }
}