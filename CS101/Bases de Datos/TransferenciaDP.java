import java.util.StringTokenizer;

public class TransferenciaDP {
    private String tipoRetiro,tipoDeposito,fechaTransferencia,horaTransferencia;
    private int noctaRetiro,saldoAnteriorRetiro,cantidadRetiro,saldoNuevoRetiro,noctaDeposito,saldoAnteriorDeposito,cantidadDeposito,saldoNuevoDeposito;
    public TransferenciaDP() {
        this.tipoRetiro = "";
        this.tipoDeposito = "";
        this.fechaTransferencia = "";
        this.horaTransferencia = "";
        this.noctaRetiro = 0;
        this.saldoAnteriorDeposito = 0;
        this.saldoAnteriorRetiro = 0;
        this.cantidadRetiro = 0;
        this.saldoNuevoRetiro = 0;
        this.noctaDeposito = 0;
        this.cantidadDeposito = 0;
        this.saldoNuevoDeposito = 0;
    }
    public TransferenciaDP(String datos){
        String[] st = datos.split("_");
        this.tipoRetiro = st[2];
        this.tipoDeposito = st[8];
        this.saldoNuevoRetiro = 0;
        this.saldoNuevoDeposito = 0;
        this.noctaRetiro = Integer.parseInt(st[0]);
        this.saldoAnteriorDeposito = Integer.parseInt(st[9]);
        this.saldoAnteriorRetiro = Integer.parseInt(st[3]);
        this.cantidadRetiro = Integer.parseInt(st[12]);
        this.noctaDeposito = Integer.parseInt(st[6]);
        this.cantidadDeposito = Integer.parseInt(st[12]);
    }
    public String getTipoRetiro(){
        return this.tipoRetiro;
    }
    public String getTipoDeposito(){
        return this.tipoDeposito;
    }
    public String getFechaTransferencia(){
        return this.fechaTransferencia;
    }
    public String getHoraTransferencia(){
        return this.horaTransferencia;
    }
    public int getNoctaRetiro(){
        return this.noctaRetiro;
    }
    public int getSaldoAnteriorDeposito(){
        return this.saldoAnteriorDeposito;
    }
    public int getSaldoAnteriorRetiro(){
        return this.saldoAnteriorRetiro;
    }
    public int getCantidadRetiro(){
        return this.saldoAnteriorRetiro;
    }
    public int getSaldoNuevoRetiro(){
        return this.saldoNuevoRetiro;
    }
    public int getSaldoNuevoDeposito(){
        return this.saldoAnteriorDeposito;
    }
    public int getNoctaDeposito(){
        return this.saldoAnteriorDeposito;
    }
    public int getCantidadDeposito(){
        return this.saldoAnteriorDeposito;
    }
    public void setTipoRetiro(String a){
        this.tipoRetiro=a;
    }
    public void setTipoDeposito(String a){
        this.tipoDeposito=a;
    }
    public void setFechaTransferencia(String a){
        this.fechaTransferencia=a;
    }
    public void setHoraTransferencia(String a){
        this.horaTransferencia=a;
    }
    public void setNoctaRetiro(int a){
        this.noctaRetiro=a;
    }
    public void setSaldoAnteriorDeposito(int a){
        this.saldoAnteriorDeposito=a;
    }
    public void setSaldoAnteriorRetiro(int a){
        this.saldoAnteriorRetiro=a;
    }
    public void setCantidadRetiro(int a){
        this.saldoAnteriorRetiro=a;
    }
    public void setSaldoNuevoRetiro(int a){
        this.saldoNuevoRetiro=a;
    }
    public void setSaldoNuevoDeposito(int a){
        this.saldoAnteriorDeposito=a;
    }
    public void setNoctaDeposito(int a){
        this.saldoAnteriorDeposito=a;
    }
    public void setCantidadDeposito(int a){
        this.saldoAnteriorDeposito=a;
    }

    public String toString() {
        return this.noctaRetiro + "_" + this.tipoRetiro + "_" + this.saldoAnteriorRetiro + "_" + this.cantidadRetiro + "_" + this.saldoNuevoRetiro+"_"+this.noctaDeposito + "_" + this.tipoDeposito + "_" + this.saldoAnteriorDeposito + "_" + this.cantidadDeposito + "_" + this.saldoNuevoDeposito+"_"+this.fechaTransferencia+"_"+this.horaTransferencia;
    }

    public String toStringSql() {
        return "'" +this.noctaRetiro + "','"  + this.tipoRetiro + "','"  + this.saldoAnteriorRetiro + "','"  + this.cantidadRetiro + "','"  + this.saldoNuevoRetiro+"','" +this.noctaDeposito + "','"  + this.tipoDeposito + "','"  + this.saldoAnteriorDeposito + "','"  + this.cantidadDeposito + "','"  + this.saldoNuevoDeposito+ "',now(),now";
    }
}