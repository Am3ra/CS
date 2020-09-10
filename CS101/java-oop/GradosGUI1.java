import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GradosGUI1 extends JFrame{
    private JTextField tfGrados;
    private JButton bCalcular, bSalir;
    private JPanel panel1, panel2;
    private JTextArea taDatos;

    public GradosGUI1(){
        super("Conversion de grados");

        // Crear objetos de atributos/variables de clase
        tfGrados = new JTextField();
        bCalcular = new JButton("G. Centigrados a G. Fahrenheit");
        bSalir = new JButton("Exit");
        panel1 = new JPanel();
        panel2 = new JPanel();
        taDatos = new JTextArea(10,30);

        //definir layout de JPanels
        panel1.setLayout(new GridLayout(2,2));
        panel2.setLayout(new FlowLayout());

        // Poner los objetos de atributos en el Jpanel
        panel1.add(new JLabel("Grados a convertir = "));
        panel1.add(tfGrados);
        panel1.add(bCalcular);
        panel1.add(bSalir);

        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        // Hacer visible el JFrame
        add(panel2);
        setSize(500,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        GradosGUI1 grados = new GradosGUI1();
    }
}