import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GradosGUI extends JFrame{
    private JTextField tfGrados;
    private JButton bCalcular, bSalir;

    public GradosGUI(){
        super("Conversion de grados");

        // Crear objetos de atributos/variables de clase
        tfGrados = new JTextField();
        bCalcular = new JButton("G. Centigrados a G. Fahrenheit");
        bSalir = new JButton("Exit");

        //definir layout de Jframe
        setLayout(new GridLayout(2,2));

        // Poner los objetos de atributos en el JFrame
        add(new JLabel("Grados a convertir = "));
        add(tfGrados);
        add(bCalcular);
        add(bSalir);

        // Hacer visible el JFrame
        setSize(400,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        GradosGUI grados = new GradosGUI();
    }
}