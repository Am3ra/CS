import java.util.Date;
import java.util.StringTokenizer;

/**
 * RetiroDP
 */
public class RetiroDP {

    private int saldoPrevio, SaldoNuevo;
    private String nocta;
    private Date dateCreated;

    private RetiroDP next;

    // Constructores
    public RetiroDP()
    {
        this.nocta  = "";
        this.saldoPrevio  = 0;
        this.SaldoNuevo  = 0;
        
        this.next  = null;
    }

    public RetiroDP(String datos)
    {
        this.dateCreated = new Date();

        StringTokenizer st = new StringTokenizer(datos,"_");
        
        this.nocta  = st.nextToken();
        this.saldoPrevio  = Integer.parseInt(st.nextToken());
        this.SaldoNuevo  = Integer.parseInt(st.nextToken());
    }

    // Metodos: Accesors (geters) y Mutators (seters)
    public String getNocta() {
        return this.nocta;
    }

    public int getSaldoNuevo() {
        return this.SaldoNuevo;
    }

    public int getSaldoPrevio() {
        return this.saldoPrevio;
    }

    public RetiroDP getNext() {
        return this.next;
    }

    public void setNext(RetiroDP nodo) {
        this.next = nodo;
    }

    public String toString() {
        return this.nocta + "_" + Integer.toString(this.saldoPrevio) + "_" + Integer.toString(this.SaldoNuevo) + "_" + this.dateCreated.toString();
    }
}