public class BancoAD1 {
    private ClienteDP primero,ultimo,actual;
    
    public String capturar(String datos) {
        if (primero== null){
            primero = new ClienteDP(datos);
        }
    }
}