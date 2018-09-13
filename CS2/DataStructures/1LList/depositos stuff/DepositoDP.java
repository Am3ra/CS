import java.util.Date;
import java.util.StringTokenizer;

/**
 * DepositoDP
 */
public class DepositoDP {

    private int saldoPrevio, SaldoNuevo;
    private String nocta;
    private Date dateCreated;

    private DepositoDP next;

    // Constructores
    public DepositoDP()
    {
        this.nocta  = "";
        this.saldoPrevio  = 0;
        this.SaldoNuevo  = 0;
        
        this.next  = null;
    }

    public DepositoDP(String datos)
    {
        StringTokenizer st = new StringTokenizer(datos,"_");
        this.dateCreated = new Date();        
        this.nocta  = st.nextToken();
        this.saldoPrevio  = Integer.parseInt(st.nextToken());
        this.SaldoNuevo  = Integer.parseInt(st.nextToken());
    }

    // Metodos: Accesors (getters) y Mutators (setters)
    public String getNocta() {
        return this.nocta;
    }

    public int getSaldoNuevo() {
        return this.SaldoNuevo;
    }

    public int getSaldoPrevio() {
        return this.saldoPrevio;
    }

    public DepositoDP getNext() {
        return this.next;
    }


    public void setNext(DepositoDP nodo) {
        this.next = nodo;
    }

    public String toString() {
        return this.nocta + "_" + Integer.toString(this.saldoPrevio) + "_" + Integer.toString(this.SaldoNuevo) + "_" + this.dateCreated.toString();
    }
}