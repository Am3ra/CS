import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/**
 * Prueba
 */
public class Prueba {
    private BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private String titulo, autor;

    private void pedirDatos() {
        try {
            titulo = JOptionPane.showInputDialog("Titulo Del Libro");
            System.out.println("autor:");
            autor = stdIn.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    private void mostrarDatos() {
        JOptionPane.showMessageDialog(null,titulo);
        System.out.println(autor);
    }

    public static void main(String[] args) {
        Prueba pr = new Prueba();
        pr.pedirDatos();
        pr.mostrarDatos();
    }
}