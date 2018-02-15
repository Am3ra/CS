import java.util.StringTokenizer;

public class ClienteDPret {
    private String fecha, cuenta;
    private int mp, cambio, ma;

    public ClienteDPret() {
        this.mp = 0;
        this.cambio = 0;
        this.ma = 0;
        this.cuenta = "";
        this.fecha = "";
    }

    public String getNocta() {
        return this.cuenta;
    }

    public int getMA() {
        return this.ma;
    }

    public int getMP() {
        return this.mp;
    }

    public int getCambio() {
        return this.cambio;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setNocta(String ncta) {
        this.cuenta = ncta;
    }

    public void setMP(int cantidad) {
        this.mp = cantidad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setMA(int hora) {
        this.ma = hora;
    }

    public void setCambio(int hora) {
        this.cambio = hora;
    }

    public String toString() {
        return this.mp + "_" + this.cambio + "_" + this.ma + "_" + this.cuenta + "_" + this.fecha;
    }

    public String toStringSql() {
        return "'" + this.mp + "','" + this.cambio + "','" + this.ma + "','" + this.cuenta + "',now()";
    }
}