import java.util.StringTokenizer;

public class ClienteDP{
    private String nocta, nombre, tipo;
    private int saldo;

    public ClienteDP(){
        this.nocta ="";
        this.nombre = "";
        this.tipo = "";
        this.saldo = 0; 
    }
    public ClienteDP(String datos){
        String[] st = datos.split("_");
        this.nocta= st[0];
        this.nombre= st[1];
        this.tipo= st[2];
        this.saldo= Integer.parseInt(st[3]);
    }
    public String getNocta(){
        return this.nocta;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getTipo(){
        return this.tipo;
    }
    public int getSaldo(){
        return this.saldo;
    }
    public void setNocta(String ncta){
        this.nocta = ncta;
    }
    public void setNombre(String nom){
        this.nombre = nom;
    }
    public void setTipo(String  tcta){
        this.tipo = tcta;
    }
    public void setSaldo(int cantidad){
        this.saldo=cantidad;
    }
    public String toString(){
        return this.nocta+"_"+this.nombre+"_"+this.tipo+"_"+this.saldo;
    }
    public String toStringSql(){
        return ""+this.nocta + "','" + this.nombre + "','" + this.tipo + "','" + this.saldo;
    }
}