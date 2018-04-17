import java.util.StringTokenizer;

public class RetiroDP {
    private String fecha, cuenta;
    private int monto_previo, cambio, monto_actual;

    public RetiroDP() {
        this.monto_previo = 0;
        this.cambio = 0;
        this.monto_actual = 0;
        this.cuenta = "";
        this.fecha = "";
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public int getMontoActual() {
        return this.monto_actual;
    }

    public int getMontoPrevio() {
        return this.monto_previo;
    }

    public int getCambio() {
        return this.cambio;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setCuenta(String ncta) {
        this.cuenta = ncta;
    }

    public void setMontoPrevio(int cantidad) {
        this.monto_previo = cantidad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setMontoActual(int hora) {
        this.monto_actual = hora;
    }

    public void setCambio(int hora) {
        this.cambio = hora;
    }

    public String toString() {
        return this.monto_previo + "_" + this.cambio + "_" + this.monto_actual + "_" + this.cuenta + "_" + this.fecha;
    }

    public String toStringSql() {
        return "'" + this.monto_previo + "','" + this.cambio + "','" + this.monto_actual + "','" + this.cuenta + "',now()";
    }
}