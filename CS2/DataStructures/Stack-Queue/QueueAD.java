/**
 * QueueAD
 */
public class QueueAD {

    private NodoDP primero, ultimo, actual;

    public String push(String nombre) {
        actual = new NodoDP(nombre);
        if (primero == null) {
            primero = actual;
            primero .setNext(null);
        }else{
            actual.setNext(primero);
            primero = actual;
        }
        return "Nodo Creado y agregado: " + nombre;
    }

    public String desplegar() {
        String datos = "";
        if (primero == null) {
            return "Queue Vacio";
        }else{
            actual = primero;
            while (actual!=null) {
                datos += actual.getNombre()+"\n";
                actual = actual.getNext();
            }
            return datos;
        }
    }
    public String pop() {
        String respuesta = "";
        if (primero=null) {
            return "VACIO";
        } else {
            respuesta = "Primer nodo:" + primero.getNombre();
            primero = primero.getNext();
        }
        return respuesta;
    }
}