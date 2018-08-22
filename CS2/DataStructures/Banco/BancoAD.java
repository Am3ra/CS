import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BancoAD{
    private PrintWriter archivoOut;
    private BufferedReader archivoIn;
    private String arrayClientes[],arrayTemp[];
    private int lnNumber,posicion;

    public String datosArregloArchivo(){
        if (arrayClientes == null) {
            return "Array is null";
        } else {
            try {
                // 1. Abrir archivo.
                archivoOut = new PrintWriter(new FileWriter("Clientes.txt", false));
                // 2. Almacenar o guardar los datos en el archivo.
                for (String i : arrayClientes) {
                    archivoOut.println(i);
                }
                // 3. Cerrar el archivo
                archivoOut.close();
                // 4. Entregar el resultado de la transacción.
                return "Captura de datos exitosa";
            } catch (Exception ioe) {
                System.out.println("Error: " + ioe);
                return "Error en captura de datos: \n";
            }
        }
    }

    public String capturar (String datos){
        String resultado;
        System.out.println(Arrays.toString(datos.split("_")));
        
        if (consultar(datos.split("_")[0]).equals("NO_LOCALIZADO")) {
    
            try {
            //1. Abrir archivo.
            archivoOut = new PrintWriter(new FileWriter("Clientes.txt",true));
            //2. Almacenar o guardar los datos en el archivo.
            archivoOut.println(datos);
            //3. Cerrar el archivo
            archivoOut.close();
            //4. Entregar el resultado de la transacción.
            resultado = "Captura de datos exitosa";
            } catch (Exception ioe) {
                System.out.println("Error: "+ ioe);
                resultado = "Error en captura de datos: \n";
            }
            return resultado;
        } else return "Cuenta existente";
    }
    public String consultarClientes() {
        String datos="";
        lnNumber = 0;
        try {
            //1.Abrir el archivo
            archivoIn = new BufferedReader(new FileReader("Clientes.txt"));
            //2. Obtener los datos del archivo
            while (archivoIn.ready()) {
                datos+=archivoIn.readLine()+"\n";  
            }
            //3. Cerrar el archivo
            archivoIn.close();
        } catch (Exception ioe) {
            System.out.println("Error:"+ioe);
        }
        //4.Entregar los datos.
        return datos;
    }
    public void setStringLength(){
        System.out.println("HIT");
        lnNumber=0;
        try {
            //1.Abrir el archivo
            archivoIn = new BufferedReader(new FileReader("Clientes.txt"));
            //2. Obtener los datos del archivo
            while (archivoIn.ready()) {
                archivoIn.readLine();
                System.out.println("HIT");
                lnNumber++;
            }
            //3. Cerrar el archivo
            archivoIn.close();
        } catch (Exception ioe) {
            System.out.println("Error"+ioe);
        }
        System.out.println("HIT OUT");
    }
    public String datosArchivoArreglo(){
        String str="";
        String resultado="";
        int i= 0;
        setStringLength();
        arrayClientes = new String[lnNumber];

        try {
            archivoIn = new BufferedReader(new FileReader("Clientes.txt"));
            while(archivoIn.ready()){
                str=archivoIn.readLine();
                arrayClientes[i]=str;
                i++;
            }
            archivoIn.close();
        } catch (Exception ioe) {
            System.out.println("Error:"+ioe);
        }
        resultado = "Datos en arrayClientes"+i;
        return resultado;
    }
    public String displayStringArray(){
       String datos="";
       for (int i = 0; i < arrayClientes.length; i++) {
           datos+=arrayClientes[i]+"\n";
       }
        return datos;
    }
    public String consultar(String ncta){
        String str="";
        String datos="";
        String nocta="";
        boolean encontrado = false;
        StringTokenizer st;
        int i=0;
        
        if (arrayClientes == null){
            return "Arreglo no inicializado / null";
        }

        while (i<arrayClientes.length && !encontrado) {
            str= arrayClientes[i];
            st = new StringTokenizer(str,"_");
            nocta = st.nextToken();
            if (ncta.equals(nocta)) {
                posicion = i;
                encontrado = true;
            }
            i++;
            datos = str;
        }
        if (!encontrado) {
            return "NO_LOCALIZADO";
        }
        return datos;
    }
}