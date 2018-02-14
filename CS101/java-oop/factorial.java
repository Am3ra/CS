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
public class factorial extends JFrame implements ActionListener{
    private JTextField tffactorial;
    private JButton bCalcular, bSalir;
    private JPanel panel1, panel2;
    private JTextArea taDatos;
    private CalculosDP calculos = new CalculosDP();

    public factorial(){
        super("Caculo de Factorial");

        // Crear objetos de atributos/variables de clase
        tffactorial = new JTextField();
        bCalcular = new JButton("Calcular factorial");
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
        panel1.add(new JLabel("Factorial de N= "));
        panel1.add(tffactorial);
        panel1.add(bCalcular);
        panel1.add(bSalir);

        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        // Hacer visible el JFrame
        add(panel2);
        setSize(500,300);
        // setVisible(true);
    }
    public JPanel getPanel2(){
        return panel2;
    }
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == bCalcular) {
            //Obtener Datos
            String strfactorial = tffactorial.getText();
            //Hacer la conversion 
            
            Integer num = Integer.parseInt(strfactorial);
            Integer cool =calculos.factorial(num);
            
            //Desplegar resultado
            taDatos.setText(cool + " Es el resultado");

        }
        if(event.getSource()==bSalir){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        factorial factorial = new factorial();
    }
}