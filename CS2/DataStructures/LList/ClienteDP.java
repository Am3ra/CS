public class ClienteDP {
    private String nocta, nombre,tipo;
    private int saldo;
    private ClienteDP next;

    public ClienteDP(){
        this.nocta  = "";
        this.nombre = "";
        this.tipo   = "";
        this.saldo  = 0;
        this.next   = null;
    }

    public CLineteDP(String datos){
        String[] st = datos.split("_");
        this.nocta  = st[0];
        this.nombre = st[1];
        this.tipo   = st[2];
        this.saldo  = Integer.parseInt(st[3]);
    }
    
    public String getNocta() {
        return this.nocta;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getTipo() {
        return this.tipo;
    }
    public int getSaldo() {
        return this.saldo;
    }
    public ClienteDP getNext() {
        return this.next;
    }
    public void setNocta(String nocta) {
        this.nocta = nocta;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public void setNext(ClienteDP next) {
        this.next = next;
    }
}