import java.util.StringTokenizer;

public class DepositoDP{
    private String fecha, cuenta;
    private int monto_previo,cambio,monto_actual;

    public DepositoDP(){
        this.monto_previo = 0;
        this.cambio = 0;
        this.monto_actual = 0;
        this.cuenta ="";
        this.fecha= "";
    }

    public String getCuenta(){
        return this.cuenta;
    }

    public String getFecha() {
        return this.fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMA(){
        return this.monto_actual;
    }
    public int getMP(){
        return this.monto_previo;
    }
    public int getCambio(){
        return this.cambio;
    }

    public void setCuenta(String ncta){
        this.cuenta = ncta;
    }

    public void setMP(int cantidad){
        this.monto_previo=cantidad;
    }
    
    public void setMA(int hora) {
        this.monto_actual = hora;
    }
    public void setCambio(int hora) {
        this.cambio = hora;
    }


    public String toString(){
        return this.monto_previo+"_"+this.cambio+"_"+this.monto_actual+"_"+this.cuenta+"_"+this.fecha;
    }
    public String toStringSql(){
        return "'"+this.monto_previo + "','" + this.cambio + "','" + this.monto_actual + "','" + this.cuenta+"',now()";
    }
}