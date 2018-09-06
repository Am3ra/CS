import java.io.*;

public class BancoAD
{
    // Atributos
    private ClienteDP primero, ultimo, actual;
    
    private PrintWriter    archivoOut;
    private BufferedReader archivoIn;
    
    // Constructor
    public BancoAD()
    {
        try
        {
            archivoIn = new BufferedReader(new FileReader("Clientes.txt"));
            
            while(archivoIn.ready())
                capturar(archivoIn.readLine());
            
            archivoIn.close();
        }
        catch(IOException ioe)
        {
            System.out.println("Error: "+ioe);
        }
    }
    
    // Metodos
    public String capturar(String datos)
    {
        String datos2[] = datos.split("_");
        System.out.println(datos2[0]);
        System.out.println(consultarNocta(datos2[0]));
        if (consultarNocta(datos2[0]).equals("NO SE ENCONTRO")) {
            
            if(primero == null)
            {
                primero = new ClienteDP(datos);
                ultimo = primero;
                ultimo.setNext(null);
            }
            else
            {
                actual = new ClienteDP(datos);
                ultimo.setNext(actual);
                ultimo = actual;
                ultimo.setNext(null);
                
            }
            return "Datos: "+datos;
        }
        return "DATO YA EN LISTA";
    }
    public String consultarNocta(String nocta){
        actual = primero;
        String datos="NO SE ENCONTRO";
        while (actual != null) {
            if (actual.getNocta().equals(nocta)) {
                datos = actual.toString();
                break;
            }
            actual = actual.getNext();
        }
        return datos;
    }
    
    public String consultarClientes()
    {
        String datos="";
        
        if(primero == null)
            datos = "Lista vacia...";
        else
        {
            actual = primero;
            while(actual != null)
            {
                //datos = datos + actual.getNocta()+"_"+actual.getNombre()+"_"+actual.getTipo()+"_"+actual.getSaldo()+"\n";
                
                datos = datos + actual.toString() + "\n";
                
                actual = actual.getNext();
            }
        }
        
        return datos;
    }
    
    public void datosListaArchivo()
    {
        if(primero == null)
            System.out.println("Lista vacia...");
        else
        {
            try
            {
                archivoOut = new PrintWriter(new FileWriter("Clientes.txt"));
                
                actual = primero;
                while(actual != null)
                {
                    //datos = datos + actual.getNocta()+"_"+actual.getNombre()+"_"+actual.getTipo()+"_"+actual.getSaldo()+"\n";
                    
                    archivoOut.println(actual.toString());
                    
                    actual = actual.getNext();
                }
                
                archivoOut.close();
                
                System.out.println("Datos almacenados en el archivo...");
            }
            catch(IOException ioe)
            {
                System.out.println("Error: "+ioe);
            }
        }

    }
}














