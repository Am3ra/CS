import java.io.*;
import java.util.StringTokenizer;

public class BancoAD
{
    private PrintWriter archivoOut;
    private BufferedReader archivoIn;
    private String arregloClientes[];
    
    private int numeroRegistros;
    private int posicion;
    
    /*public BancoAD()
    {
        consultarClientes();
        arregloClientes = new String[numeroRegistros];
        
    }*/
    
    public String capturar(String datos)
    {
        String resultado="";
        
        try
        {
            // 1. Abrir el archivo
            archivoOut = new PrintWriter(new FileWriter("Clientes.txt",true));
            
            // 2. Almacenar o guardar los datos en el archivo
            archivoOut.println(datos);
            
            // 3. Cerrar el archivo
            archivoOut.close();
            
            // 4. Entregar resultadod e la transaccion
            resultado = "Captura de datos exitosa...";
            
            numeroRegistros++;
        }
        catch(IOException ioe)
        {
            System.out.println("Error: "+ioe);
            resultado = "Error en captura de datos: \n"+ioe;
        }
        
        return resultado;
    }
    
    public String consultarClientes()
    {
        String datos="";
        
        numeroRegistros=0;
        
        try
        {
            // 1. Abrir el archivo
            archivoIn = new BufferedReader(new FileReader("Clientes.txt"));
            
            // 2. Obtener lod datos del archivo
            while(archivoIn.ready())
            {
                datos = datos + archivoIn.readLine() + "\n";
                numeroRegistros++;
            }
            
            // 3. Cerrar el archivo
            archivoIn.close();
        }
        catch(IOException ioe)
        {
            System.out.println("Error: "+ioe);
            datos = "Error en consultar datos: \n"+ioe;
        }
        
        // 4. Entregar los datos
        return datos;
    }
    
    public String datosArchivoArreglo()
    {
        String str="";
        String resultado="";
        
        int i=0;
        
        consultarClientes();
        arregloClientes = new String[numeroRegistros];
        
        try
        {
            // 1. Abrir el archivo
            archivoIn = new BufferedReader(new FileReader("Clientes.txt"));
            
            // 2. Obtener lod datos del archivo
            while(archivoIn.ready())
            {
                str = archivoIn.readLine();
                arregloClientes[i] = str;
                
                i++;
            }
            
            // 3. Cerrar el archivo
            archivoIn.close();
            
            resultado = "Datos en el arregloClientes: "+i;
        }
        catch(IOException ioe)
        {
            System.out.println("Error: "+ioe);
            resultado = "Error en pasar datos al arrgloClientes: \n"+ioe;
        }
        
        // 4. Entregar los datos
        return resultado;
    }
    
    public String consultarArreglo()
    {
        String datos="";
        int i=0;
        
        while(i<arregloClientes.length)
        {
            datos = datos + arregloClientes[i] + "\n";
            i++;
        }
        
        return datos;
    }
    
    public String consultar(String ncta)
    {
        String str="",datos="";
        int i=0;
        StringTokenizer st=null;
        String nocta="";
        boolean encontrado=false;
        
        while(i<arregloClientes.length && !encontrado)
        {
            str = arregloClientes[i];
            
            st = new StringTokenizer(str,"_");
            nocta = st.nextToken();
            
            if(ncta.equals(nocta))
            {
                posicion = i;
                encontrado = true;
            }
            
            i++;
            
            datos = str;
        }
        
        if(!encontrado)
            datos = "NO_LOCALIZADO";
        
        return datos;
    }
}
















