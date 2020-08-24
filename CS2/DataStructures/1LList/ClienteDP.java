import java.util.StringTokenizer;

public class ClienteDP
{
    // Atributos
    private String nocta, nombre, tipo;
    private int saldo;
    
    private ClienteDP next;
    
    // Constructores
    public ClienteDP()
    {
        this.nocta  = "";
        this.nombre = "";
        this.tipo   = "";
        this.saldo  = 0;
        
        this.next  = null;
    }
    
    public ClienteDP(String datos)
    {
        StringTokenizer st = new StringTokenizer(datos,"_");
        
        this.nocta  = st.nextToken();
        this.nombre = st.nextToken();
        this.tipo   = st.nextToken();
        this.saldo  = Integer.parseInt(st.nextToken());
    }
    
    // Metodos: Accesors (geters) y Mutators (seters)
    public String getNocta()
    {
        return this.nocta;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public String getTipo()
    {
        return this.tipo;
    }
    
    public int getSaldo()
    {
        return this.saldo;
    }
    
    public ClienteDP getNext()
    {
        return this.next;
    }
    
    // Mutators
    public void setNocta(String cta)
    {
        this.nocta = cta;
    }
    
    public void setNombre(String name)
    {
        this.nombre = name;
    }
    
    public void setTipo(String tcta)
    {
        this.tipo = tcta;
    }
    
    public void setSaldo(int cantidad)
    {
        this.saldo = cantidad;
    }
    
    public void setNext(ClienteDP nodo)
    {
        this.next = nodo;
    }
    
    public String toString()
    {
        return this.nocta+"_"+this.nombre+"_"+this.tipo+"_"+this.saldo;
    }
}












