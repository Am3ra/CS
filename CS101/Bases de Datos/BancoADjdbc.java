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

public class BancoADjdbc {

    private Connection conexion;
    private Statement statement;
    private BufferedReader archivoIn;
    private PrintWriter archivoOut;

    private ClienteDP clientedp = new ClienteDP();
    private RetiroDP retirodp = new RetiroDP();
    private DepositoDP depositodp = new DepositoDP();
    private TransferenciaDP transferenciadp = new TransferenciaDP();
    
    public BancoADjdbc() {
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

    public String capturar(String datos) {
        String respuesta = "";

        StringTokenizer st = new StringTokenizer(datos, "_");

        String cta = st.nextToken();
        String nombre = st.nextToken();
        String tipo = st.nextToken();
        String saldo = st.nextToken();

        clientedp = new ClienteDP(datos);

        String insertCliente = "INSERT INTO Clientes VALUES(" + clientedp.toStringSql() + ")";
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
        //Abrir archivo Datos
        String query = "SELECT * FROM Clientes";
        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(query);
            clientedp = new ClienteDP();
            while (tr.next()) {
                
                clientedp.setNocta(tr.getString("cuenta"));
                clientedp.setNombre(tr.getString("nombre"));
                clientedp.setTipo(tr.getString("tipo"));
                clientedp.setSaldo(tr.getInt("saldo"));
                clientedp.setFecha(tr.getString("fecha"));
                clientedp.setHora(tr.getString("hora"));

                respuesta += clientedp.toString()+"\n";
            }
            statement.close();
            System.out.println(query);
        } catch (SQLException e) {
            respuesta = "ERROR" + e;
        }

        return respuesta;
    }
    public String depositar(String ncta, int cantidad) {
        //Abrir BD
        String transaccion = "";
        String query;
        ResultSet tr;
        String update;
        try {
            statement = conexion.createStatement();
            //Preparar Query de consulta con cuentaa
            query = "SELECT * from clientes where cuenta = "+ncta+";";
            tr = statement.executeQuery(query);
            //Realizar deposito
            if(tr.next()){
                depositodp.setCambio(cantidad);
                depositodp.setCuenta(tr.getString("cuenta"));
                depositodp.setMP(tr.getInt("saldo"));
                clientedp.setNocta(tr.getString("cuenta"));
                clientedp.setNombre(tr.getString("nombre"));
                clientedp.setSaldo(tr.getInt("saldo"));
                clientedp.setTipo(tr.getString("tipo"));
                clientedp.setFecha(tr.getString("fecha"));
                clientedp.setHora(tr.getString("hora"));
                if (clientedp.getTipo() == "INVERSION"|| clientedp.getTipo() == "AHORRO") {
                    clientedp.setSaldo(clientedp.getSaldo()+cantidad);
                    depositodp.setMA(depositodp.getMP()+cantidad);
                }
                
                else {
                    clientedp.setSaldo(clientedp.getSaldo() - cantidad);
                    depositodp.setMA(depositodp.getMP() - cantidad);
                }
                // 
                update ="update clientes set saldo="+clientedp.getSaldo()+" where cuenta = "+ncta+";";
                System.out.println(update);
                statement.executeUpdate(update);
                
                update = "INSERT INTO deposito VALUES(" + depositodp.toStringSql() + ")";
                System.out.println(update);
                statement.executeUpdate(update);
                
                transaccion = "Deposito exitoso, nuevo saldo = "+clientedp.getSaldo();
            }else{
                transaccion = "Numero de cta. No encontrado";
            }
            // Cerrar BD
            statement.close();

        } catch (SQLException e) {
            transaccion = "Error en el update: "+e;
        }
       
        return transaccion;
    }
    public String retirar(String ncta, int cantidad) {
        //Abrir BD
        String transaccion = "";
        String query;
        ResultSet tr;
        String update;
        try {
            statement = conexion.createStatement();
            //Preparar Query de consulta con cuentaa
            query = "SELECT * from clientes where cuenta = "+ncta+";";
            tr = statement.executeQuery(query);
            //Realizar deposito
            if(tr.next()){
                retirodp.setCambio(cantidad);
                retirodp.setCuenta(tr.getString("cuenta"));
                retirodp.setMontoPrevio(tr.getInt("saldo"));
                clientedp.setNocta(tr.getString("cuenta"));
                clientedp.setNombre(tr.getString("nombre"));
                clientedp.setSaldo(tr.getInt("saldo"));
                clientedp.setTipo(tr.getString("tipo"));
                clientedp.setFecha(tr.getString("fecha"));
                clientedp.setHora(tr.getString("hora"));

                if (clientedp.getTipo().equals("HIPOTECA")) {
                    return "No se puede retirar de cuenta de ahorros";
                } else if (clientedp.getTipo() == "INVERSION"|| clientedp.getTipo() == "AHORRO") {
                    clientedp.setSaldo(clientedp.getSaldo()-cantidad);
                    retirodp.setMontoActual(retirodp.getMontoPrevio()-cantidad);

                } else {
                    clientedp.setSaldo(clientedp.getSaldo() + cantidad);
                    retirodp.setMontoActual(retirodp.getMontoPrevio()+cantidad);

                }
                // 
                update ="update clientes set saldo="+clientedp.getSaldo()+" where cuenta = "+ncta+";";
                System.out.println(update);
                statement.executeUpdate(update);
                transaccion = "Retiro exitoso, nuevo saldo = "+clientedp.getSaldo();

                update = "INSERT INTO retiro VALUES(" + retirodp.toStringSql() + ")";
                System.out.println(update);
                statement.executeUpdate(update);
                

            }else{
                transaccion = "Numero de cta. No encontrado";
            }
            // Cerrar BD
            statement.close();

        } catch (SQLException e) {
            transaccion = "Error on update: "+e;
        }
       
        return transaccion;
    }
    
    public String consultarCuenta(String cuenta) {
        String respuesta = "";
        ResultSet tr;
        //Abrir archivo Datos
        String query = "SELECT * FROM Clientes where cuenta = "+cuenta+";" ;
        System.out.println(query);
        if (cuenta.equals("")){
            return "No se introdujo cuenta";
        }
        try {

            statement = conexion.createStatement();
            tr = statement.executeQuery(query);
            clientedp = new ClienteDP();
            while (tr.next()) {

                clientedp.setNocta(tr.getString("cuenta"));
                clientedp.setNombre(tr.getString("nombre"));
                clientedp.setTipo(tr.getString("tipo"));
                clientedp.setSaldo(tr.getInt("saldo"));
                clientedp.setFecha(tr.getString("fecha"));
                clientedp.setHora(tr.getString("hora"));

                respuesta += clientedp.toString();
            }
            statement.close();
            System.out.println(query);
        } catch (SQLException e) {
            respuesta = "ERROR" + e;
        }
        if (respuesta.equals("")){
            return "No se encontro cuenta.";
        };
        return respuesta;
    }
    
    public String consultarDepositos(String cuenta) {
        String respuesta = "";
        ResultSet tr;
        //Abrir archivo Datos
        String query = "SELECT * FROM deposito where cuenta = "+ cuenta;
        if(cuenta.equals("")){
            query ="SELECT * FROM deposito";
        }
        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(query);
            while (tr.next()) {

                depositodp.setCuenta(tr.getString("cuenta"));
                depositodp.setFecha(tr.getString("fecha"));
                depositodp.setMP(Integer.parseInt(tr.getString("monto_previo")));
                depositodp.setMA(Integer.parseInt(tr.getString("monto_actual")));
                depositodp.setCambio(Integer.parseInt(tr.getString("cambio")));

                respuesta += depositodp.toString() + "\n";
            }
            statement.close();
            System.out.println(query);
        } catch (SQLException e) {
            respuesta = "ERROR" + e;
        }

        return respuesta;
    }
    public String consultarRetiros(String cuenta) {
        String respuesta = "";
        ResultSet tr;
        //Abrir archivo Datos
        String query = "SELECT * FROM retiro where cuenta = "+ cuenta;
        if(cuenta.equals("")){
            query ="SELECT * FROM retiro";
        }
        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(query);
            while (tr.next()) {

                retirodp.setCuenta(tr.getString("cuenta"));
                retirodp.setFecha(tr.getString("fecha"));
                retirodp.setMontoPrevio(Integer.parseInt(tr.getString("monto_previo")));
                retirodp.setMontoActual(Integer.parseInt(tr.getString("monto_actual")));
                retirodp.setCambio(Integer.parseInt(tr.getString("cambio")));

                respuesta += retirodp.toString() + "\n";
            }
            statement.close();
            System.out.println(query);
        } catch (SQLException e) {
            respuesta = "ERROR: " + e;
        }

        return respuesta;
    }
    public String consultarTipo(String tipo) {
        String respuesta = "";
        ResultSet tr;
        //Abrir archivo Datos
        String query = "SELECT * FROM Clientes where tipo = '" + tipo+"'";
        if (tipo.equals("")){
            return "No se introdujo tipo";
        }
        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(query);
            clientedp = new ClienteDP();
            while (tr.next()) {
                
                clientedp.setNocta(tr.getString("cuenta"));
                clientedp.setNombre(tr.getString("nombre"));
                clientedp.setTipo(tr.getString("tipo"));
                clientedp.setSaldo(tr.getInt("saldo"));
                clientedp.setFecha(tr.getString("fecha"));
                clientedp.setHora(tr.getString("hora"));

                respuesta += clientedp.toString()+"\n";
            }
            statement.close();
            System.out.println(query);
        } catch (SQLException e) {
            respuesta = "ERROR" + e;
        }

        return respuesta;
    }
    public String transferencia(int ncta, int cantidad,int ncta2){
        String respuesta = "";
        System.out.println(ncta);
        String datos=""+ consultarCuenta(""+ncta)+"_"+consultarCuenta(""+ncta2)+"_"+cantidad;
        System.out.println("These are the initializers"+datos);
        if (consultarCuenta("" + ncta2).equals("No se encontro cuenta.")) {
            return "Segunda cuenta no existe.";
        } 
        transferenciadp = new TransferenciaDP(datos);
        String transaccion = "";
        String update;

        try {
            //verificar existencia de segunda cuenta
            
            //hacer Retiro de ncta1
            transferenciadp.setSaldoAnteriorRetiro(Integer.parseInt(consultarCuenta(""+ncta).split("_")[3]));
            transferenciadp.setSaldoAnteriorDeposito(Integer.parseInt(consultarCuenta(""+ncta2).split("_")[3]));
            respuesta = retirar(""+ncta, cantidad);
            System.out.println(respuesta);
            System.out.println(respuesta.split("Retiro exitoso, nuevo saldo = ")[0]);
            if (respuesta.equals("No se puede retirar de cuenta de ahorros")) {
                return "No se puede retirar de cuenta de ahorros";
            } else{
                transferenciadp.setSaldoNuevoRetiro(Integer.parseInt(respuesta.split("Retiro exitoso, nuevo saldo = ")[1]));
            }
            //verificar que se puede


            //hacer deposito
            respuesta = depositar(""+ncta2, cantidad);
            transferenciadp.setSaldoNuevoDeposito(Integer.parseInt(respuesta.split("Deposito exitoso, nuevo saldo = ")[1]));
            statement = conexion.createStatement();
            
            transferenciadp.setCantidadRetiro(cantidad);
            transferenciadp.setCantidadDeposito(cantidad);
            update = "INSERT INTO transferencia VALUES(" + transferenciadp.toStringSql() + ")";
            System.out.println(update);
            statement.executeUpdate(update);

            transaccion = "Transferencia Exitosa!";
            statement.close();
        } catch (SQLException e) {
            transaccion = "Error en el update: " + e;
        }

        return transaccion;
    }
    public String consultarTransferencia(String cuenta) {
        String respuesta = "";
        ResultSet tr;
        //Abrir archivo Datos
        String query;
        if(cuenta.equals("")||cuenta.isEmpty()){
            query ="SELECT * FROM transferencia";
        }else{
             query = "SELECT * FROM transferencia where noctaRetiro = "+ Integer.parseInt(cuenta);
        }
        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(query);
            while (tr.next()) {

                transferenciadp.setNoctaRetiro(Integer.parseInt(tr.getString("noctaRetiro")));
                transferenciadp.setNoctaDeposito(Integer.parseInt(tr.getString("noctaDeposito")));
                transferenciadp.setTipoRetiro(tr.getString("tipoRetiro"));
                transferenciadp.setTipoDeposito(tr.getString("tipoDeposito"));
                transferenciadp.setSaldoAnteriorRetiro(Integer.parseInt(tr.getString("saldoAnteriorRetiro")));
                transferenciadp.setSaldoAnteriorDeposito(Integer.parseInt(tr.getString("saldoAnteriorDeposito")));
                transferenciadp.setCantidadRetiro(Integer.parseInt(tr.getString("cantidadRetiro")));
                transferenciadp.setCantidadDeposito(Integer.parseInt(tr.getString("cantidadDeposito")));
                transferenciadp.setFechaTransferencia(tr.getString("fechaTransferencia"));
                transferenciadp.setHoraTransferencia(tr.getString("horaTransferencia"));

                respuesta += transferenciadp.toString() + "\n";
            }
            statement.close();

        } catch (SQLException e) {
            respuesta = "ERROR" + e;
        }
        if (respuesta.equals("")){
            return "No hay transferencias";
        }
        return respuesta;
    }
}