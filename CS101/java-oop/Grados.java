import javax.swing.JOptionPane;

import com.sun.xml.internal.org.jvnet.staxex.util.XMLStreamReaderToXMLStreamWriter.Breakpoint;

public class Grados {
    private static void convCentigrados() {
        float centigrados, farenheit;
        String strGrados;
        strGrados = JOptionPane.showInputDialog("Grados Centigrados= ");
        centigrados = Float.parseFloat(strGrados);

        farenheit = (float) 9 / 5 * centigrados + 32;

        JOptionPane.showMessageDialog(null, centigrados + " G. Centigrados = " + farenheit + " G. Farenheit");

    }
    private static void convFareinheit(){
        float centigrados, farenheit;
        String strGrados;
        strGrados = JOptionPane.showInputDialog("Grados Farenheit= ");
        farenheit = Float.parseFloat(strGrados);

        centigrados = (float) 5/9 * (farenheit - 32);

        JOptionPane.showMessageDialog(null, farenheit + " G. Farenheit = " + centigrados + " G. Centigrados");
    }
    
    public static void main(String[] args) {
        while(true){
           String opicion = JOptionPane.showInputDialog("Si Centigrados a farenheit, 1. Si no, 0. 2 Para Cancelar.");
            if (opicion == "0") {
                convCentigrados();
            } else if (opicion == "1") {
                convFareinheit();
            }else break;
        }
        
    }
}