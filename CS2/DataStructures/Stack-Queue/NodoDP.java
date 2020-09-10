public class NodoDP
{
    // Atributos
    private String nombre;
    private NodoDP next;
    
    // Constructores
    public NodoDP()
    {
        this.nombre = "";
        this.next   = null;
    }
    
    public NodoDP(String name)
    {
        this.nombre = name;
        this.next   = null;
    }
    
    // Metodos: Accesors (geters)
    public String getNombre()
    {
        return this.nombre;
    }
    
    public NodoDP getNext()
    {
        return this.next;
    }
    
    // Metodos: Mutators (seters)
    public void setNombre(String name)
    {
        this.nombre = name;
    }
    
    public void setNext(NodoDP objeto)
    {
        this.next = objeto;
    }
}
