import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class BancoAD {
    // Atributos
    private LinkedList cLinkedList,rLinkedList,dLinkedList;
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
            cLinkedList.addLast(new ClienteDP(datos));
            return "Datos: " + datos;
        }
        return "DATO YA EN LISTA";
    }

    public String deleteNode(String nocta) {
        ClienteDP cursor = primero;
        String attempt = consultarNocta(nocta);
        if (attempt.equals("NO SE ENCONTRO")) {
            return "Cuenta no existente";
        } else {
            for (int i = 0; i < cLinkedList.size(); i++){
                if (cLinkedList.get(i).getNocta().equals(nocta)) {
                    cLinkedList.remove(i);
                    return "Cuenta borrada exitosamente";
                } 
                return "cuenta borrada exitosamente";
            }
        }
        return "Algun error en el proceso ocurrio";
    }

    public String consultar(String archivo) {
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
        for (int i = 0; i < cLinkedList.size(); i++) {
            if(cLinkedList.get(i).getNocta().equals(nocta)){
                return cLinkedList.get(i).toString();
            }
        }
        return datos;
    }

    private void appendRetiro(RetiroDP node) {
        rLinkedList.add(node);
    }

    private void appendDeposito(DepositoDP node) {
        dLinkedList.add(node);
    }

    private ClienteDP searchNocta(String nocta) {
        for (int i = 0; i < cLinkedList.size(); i++) {
            if(cLinkedList.get(i).getNocta().equals(nocta)){
               return cLinkedList.get(i).toString();
            }
        }
        return null;
    }

    public String consultarClientes() {
        String datos = "";

        if (cLinkedList.isEmpty())
            datos = "Lista vacia...";
        else {
            actual = primero;
            for (int i = 0; i < cLinkedList.size()  ; i++)  {
                // datos = datos +
                // actual.getNocta()+"_"+actual.getNombre()+"_"+actual.getTipo()+"_"+actual.getSaldo()+"\n";
                
                datos = datos + cLinkedList.get(i).toString() + "\n";

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

    public void datosLLRetirosArchRetiros() {
        RetiroDP cursor = retiroHead;
        if (retiroHead == null) {
            System.out.println("LISTA VACIA");
        } else {
            while (cursor != null) {
                registrar("retiros.txt", cursor.toString());
                cursor = cursor.getNext();
            }
        }
    }

    public void datosLLDepositosArchDepositos() {
        if (cLinkedList.isEmpty()) {
            System.out.println("LISTA VACIA");
        } else {
            for (int i = 0; i < cLinkedList.size(); i++) {
                registrar("depositos.txt", cLinkedList.get(i).toString());
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
                appendRetiro(new RetiroDP(nocta + "_" + cuenta.getSaldo() + "_" + (cuenta.getSaldo() - cantidad)));
                cuenta.setSaldo(cuenta.getSaldo() - cantidad);
            } else if (cuenta.getTipo().equals("CREDITO")) {
                appendRetiro(new RetiroDP(nocta + "_" + cuenta.getSaldo() + "_" + (cuenta.getSaldo() + cantidad)));
                cuenta.setSaldo(cuenta.getSaldo() + cantidad);
            } else if (cuenta.getTipo().equals("AHORRO")) {
                appendRetiro(new RetiroDP(nocta + "_" + cuenta.getSaldo() + "_" + (cuenta.getSaldo() - cantidad)));
                cuenta.setSaldo(cuenta.getSaldo() - cantidad);
            } else {
                return "ERROR EN TIPO DE CUENTA";
            }
        }
        return "Retiro hecho exitosamente";
    }

    public String deposito(String nocta, int cantidad) {
        ClienteDP cuenta = searchNocta(nocta);
        System.out.println("DEPOSITO\n\n");
        // printListDepositos();
        if (cuenta == null) {
            return "Cuenta no existente";
        } else {
            if (cuenta.getTipo().equals("HIPOTECA")) {
                appendDeposito(new DepositoDP(nocta + "_" + cuenta.getSaldo() + "_" + (cuenta.getSaldo() - cantidad)));
                cuenta.setSaldo(cuenta.getSaldo() - cantidad);
            } else if (cuenta.getTipo().equals("INVERSION")) {
                appendDeposito(new DepositoDP(nocta + "_" + cuenta.getSaldo() + "_" + (cuenta.getSaldo() + cantidad)));
                cuenta.setSaldo(cuenta.getSaldo() + cantidad);
            } else if (cuenta.getTipo().equals("CREDITO")) {
                appendDeposito(new DepositoDP(nocta + "_" + cuenta.getSaldo() + "_" + (cuenta.getSaldo() - cantidad)));
                cuenta.setSaldo(cuenta.getSaldo() - cantidad);
            } else if (cuenta.getTipo().equals("AHORRO")) {
                appendDeposito(new DepositoDP(nocta + "_" + cuenta.getSaldo() + "_" + (cuenta.getSaldo() + cantidad)));
                cuenta.setSaldo(cuenta.getSaldo() + cantidad);
            } else {
                return "ERROR EN TIPO DE CUENTA";
            }
        }
        return "Deposito hecho exitosamente";
    }

    public String consultarRetiros() {
        RetiroDP cursor = retiroHead;
        String datos = "";
        System.out.println("CONSULTANDO RETIROS");
        for (int i = 0; i < rLinkedList.size(); i++) {
            datos += rLinkedList.get(i).toString() + "\n";
        }
        return datos;
    }

    public String consultarDepositos() {
        DepositoDP cursor = depositoHead;
        String datos = "";
        System.out.println("CONSULTANDO DEPOSITOS");
        for (int i = 0; i < dLinkedList.size(); i++) {
            datos += dLinkedList.get(i).toString() + "\n";
        }
        return datos;
    }

    private void registrar(String fileName, String datos) {
        String resultado;
        try {
            // 1. Abrir archivo.
            archivoOut = new PrintWriter(new FileWriter(fileName, true));
            // 2. Almacenar o guardar los datos en el archivo.
            archivoOut.println(datos);
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
