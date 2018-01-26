import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class GradosGUI2 extends JFrame implements ActionListener{
    private JTextField tfGrados;
    private JButton bCalcular, bSalir;
    private JPanel panel1, panel2;
    private JTextArea taDatos;

    public GradosGUI2(){
        super("Conversion de grados");

        // Crear objetos de atributos/variables de clase
        tfGrados = new JTextField();
        bCalcular = new JButton("G. Centigrados a G. Fahrenheit");
        bSalir = new JButton("Exit");
        panel1 = new JPanel();
        panel2 = new JPanel();
        taDatos = new JTextArea(10,30);
        taDatos.setEditable(false);

        //adicionar action listener a botones
        bSalir.addActionListener(this);
        bCalcular.addActionListener(this);

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
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == bCalcular) {
            //Obtener Datos
            String strGrados = tfGrados.getText();
            //Hacer la conversion 
            float gc = Float.parseFloat(strGrados);
            float gf = (float) 9/5 * gc +32; 
            //Desplegar resultado
            taDatos.setText( gc+"Grados Centigrados = " + gf +" Grados Fahrenheit" );

        }
        if(event.getSource()==bSalir){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        GradosGUI2 grados = new GradosGUI2();
    }
}