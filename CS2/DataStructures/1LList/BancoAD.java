import java.io.*;
import java.util.Date;

public class BancoAD {
    // Atributos
    private ClienteDP primero, ultimo, actual;

    private PrintWriter archivoOut;
    private BufferedReader archivoIn;

    // Constructor
    public BancoAD() {
        try {
            archivoIn = new BufferedReader(new FileReader("Clientes.txt"));

            while (archivoIn.ready())
                capturar(archivoIn.readLine());

            archivoIn.close();
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    // Metodos
    public String capturar(String datos) {
        String datos2[] = datos.split("_");
        System.out.println(datos2[0]);
        System.out.println(consultarNocta(datos2[0]));
        if (consultarNocta(datos2[0]).equals("NO SE ENCONTRO")) {

            if (primero == null) {
                primero = new ClienteDP(datos);
                ultimo = primero;
                ultimo.setNext(null);
            } else {
                actual = new ClienteDP(datos);
                ultimo.setNext(actual);
                ultimo = actual;
                ultimo.setNext(null);

            }
            return "Datos: " + datos;
        }
        return "DATO YA EN LISTA";
    }

    public String consultar(String archivo){
        String datos = "";
        try {
            // 1.Abrir el archivo
            archivoIn = new BufferedReader(new FileReader(archivo));
            // 2. Obtener los datos del archivo
            while (archivoIn.ready()) {
                datos += archivoIn.readLine() + "\n";
            }
            // 3. Cerrar el archivo
            archivoIn.close();
        } catch (Exception ioe) {
            System.out.println("Error:" + ioe);
        }
        // 4.Entregar los datos.
        return datos;
    }

    public String consultarNocta(String nocta) {
        actual = primero;
        String datos = "NO SE ENCONTRO";
        while (actual != null) {
            if (actual.getNocta().equals(nocta)) {
                datos = actual.toString();
                break;
            }
            actual = actual.getNext();
        }
        return datos;
    }

    private ClienteDP searchNocta(String nocta) {
        actual = primero;
        while (actual != null) {
            if (actual.getNocta().equals(nocta)) {
                return actual;
            }
            actual = actual.getNext();
        }
        return null;
    }

    public String consultarClientes() {
        String datos = "";

        if (primero == null)
            datos = "Lista vacia...";
        else {
            actual = primero;
            while (actual != null) {
                // datos = datos +
                // actual.getNocta()+"_"+actual.getNombre()+"_"+actual.getTipo()+"_"+actual.getSaldo()+"\n";

                datos = datos + actual.toString() + "\n";

                actual = actual.getNext();
            }
        }

        return datos;
    }

    public String consultarClientesArchivo() {
        String datos = "";
        try {
            // 1.Abrir el archivo
            archivoIn = new BufferedReader(new FileReader("Clientes.txt"));
            // 2. Obtener los datos del archivo
            while (archivoIn.ready()) {
                datos += archivoIn.readLine() + "\n";
            }
            // 3. Cerrar el archivo
            archivoIn.close();
        } catch (Exception ioe) {
            System.out.println("Error:" + ioe);
        }
        // 4.Entregar los datos.
        return datos;
    }

    public void datosListaArchivo() {
        if (primero == null)
            System.out.println("Lista vacia...");
        else {
            try {
                archivoOut = new PrintWriter(new FileWriter("Clientes.txt"));

                actual = primero;
                while (actual != null) {
                    // datos = datos +
                    // actual.getNocta()+"_"+actual.getNombre()+"_"+actual.getTipo()+"_"+actual.getSaldo()+"\n";

                    archivoOut.println(actual.toString());

                    actual = actual.getNext();
                }

                archivoOut.close();

                System.out.println("Datos almacenados en el archivo...");
            } catch (IOException ioe) {
                System.out.println("Error: " + ioe);
            }
        }

    }

    public String retiro(String nocta, int cantidad) {
        ClienteDP cuenta = searchNocta(nocta);

        if (cuenta == null) {
            return "Cuenta no existente";
        } else {
            if (cuenta.getTipo().equals("HIPOTECA")) {
                return "No se puede retirar de hipoteca";
            } else if (cuenta.getTipo().equals("INVERSION")) {
                registrar("retiros.txt", nocta+"_"+cuenta.getSaldo() + "_" + (cuenta.getSaldo() - cantidad));
                cuenta.setSaldo(cuenta.getSaldo() - cantidad);
            } else if (cuenta.getTipo().equals("CREDITO")) {
                registrar("retiros.txt", nocta+"_"+cuenta.getSaldo() + "_" + (cuenta.getSaldo() + cantidad));
                cuenta.setSaldo(cuenta.getSaldo() + cantidad);
            } else if (cuenta.getTipo().equals("AHORRO")) {
                registrar("retiros.txt", nocta+"_"+cuenta.getSaldo() + "_" + (cuenta.getSaldo() - cantidad));
                cuenta.setSaldo(cuenta.getSaldo() - cantidad);
            } else{
                return "ERROR EN TIPO DE CUENTA";
            }
        }
        return "Retiro hecho exitosamente";
    }

    public String deposito(String nocta, int cantidad) {
        ClienteDP cuenta = searchNocta(nocta);

        if (cuenta == null) {
            return "Cuenta no existente";
        } else {
            if (cuenta.getTipo().equals("HIPOTECA")) {
                registrar("depositos.txt", nocta+"_"+cuenta.getSaldo() + "_"  +( cuenta.getSaldo()-cantidad));
                cuenta.setSaldo(cuenta.getSaldo() - cantidad);
            } else if (cuenta.getTipo().equals("INVERSION")) {
                registrar("depositos.txt", nocta+"_"+cuenta.getSaldo() + "_" + (cuenta.getSaldo() + cantidad));
                cuenta.setSaldo(cuenta.getSaldo() + cantidad);
            } else if (cuenta.getTipo().equals("CREDITO")) {
                registrar("depositos.txt", nocta+"_"+cuenta.getSaldo() + "_" + (cuenta.getSaldo() - cantidad));                
                cuenta.setSaldo(cuenta.getSaldo() - cantidad);
            } else if (cuenta.getTipo().equals("AHORRO")) {
                registrar("depositos.txt", nocta+"_"+cuenta.getSaldo() + "_" + (cuenta.getSaldo() + cantidad));
                cuenta.setSaldo(cuenta.getSaldo() + cantidad);
            } else {
                return "ERROR EN TIPO DE CUENTA";
            }
        }
        return "Deposito hecho exitosamente";
    }
    
    private void registrar(String fileName, String datos) {
        String resultado;
        try {
            // 1. Abrir archivo.
            archivoOut = new PrintWriter(new FileWriter(fileName, true));
            // 2. Almacenar o guardar los datos en el archivo.
            archivoOut.println(datos+"_"+ new Date().toString());
            // 3. Cerrar el archivo
            archivoOut.close();
            // 4. Entregar el resultado de la transacción.
            resultado = "Captura de datos exitosa";
        } catch (Exception ioe) {
            System.out.println("Error: " + ioe);
            resultado = "Error en captura de datos: \n";
        }
    }
}
