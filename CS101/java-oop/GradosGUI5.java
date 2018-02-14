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
public class GradosGUI5 extends JFrame implements ActionListener{
    private JTextField tfGrados;
    private JButton bCalcular1, bCalcular2, bSalir;
    private JPanel panel1, panel2;
    private JTextArea taDatos;
    private CalculosDP calculos = new CalculosDP();

    public GradosGUI5(){
        super("Conversion de grados");

        // Crear objetos de atributos/variables de clase
        tfGrados = new JTextField();
        bCalcular1 = new JButton("G. Centigrados a G. Fahrenheit");
        bCalcular2 = new JButton("G. Fahrenheit a G. Celcius");
        bSalir = new JButton("Exit");
        panel1 = new JPanel();
        panel2 = new JPanel();
        taDatos = new JTextArea(10,30);
        taDatos.setEditable(false);

        //adicionar action listener a botones
        bSalir.addActionListener(this);
        bCalcular1.addActionListener(this);
        bCalcular2.addActionListener(this);

        //definir layout de JPanels
        panel1.setLayout(new GridLayout(2,2));
        panel2.setLayout(new GridLayout(1,1));

        // Poner los objetos de atributos en el Jpanel
        panel1.add(new JLabel("Grados a convertir = "));
        panel1.add(tfGrados);
        panel1.add(bCalcular1);
        panel1.add(bCalcular2);
        

        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        panel2.add(bSalir);
        // Hacer visible el JFrame
        add(panel2);
        setSize(500,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JPanel getPanel2() {
        return panel2;
    }
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == bCalcular1) {
            //Obtener Datos
            String strGrados = tfGrados.getText();
            //Hacer la conversion 
            float gc = Float.parseFloat(strGrados);
            float gf = calculos.gradosCF(gc);
            //Desplegar resultado
            tfGrados.setText(""+gf);
            taDatos.setText( gc+"Grados Centigrados = " + gf +" Grados Fahrenheit" );

        }
        if (event.getSource() == bCalcular2) {
            //Obtener Datos
            String strGrados = tfGrados.getText();
            //Hacer la conversion 
            float gf = Float.parseFloat(strGrados);
            float gc = calculos.gradosFC(gf);
            //Desplegar resultado
            tfGrados.setText("" + gf);
            taDatos.setText(gf + "Grados Fahrenheit = " + gc + " Grados Celcius");

        }
        if(event.getSource()==bSalir){
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        GradosGUI5 grados = new GradosGUI5();
    }
}