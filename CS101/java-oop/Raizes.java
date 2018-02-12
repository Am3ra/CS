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
public class Raizes extends JFrame implements ActionListener{
    private JTextField tfRaiz1, tfRaiz2,tfRaiz3;
    private JButton bCalcular, bSalir;
    private JPanel panel1, panel2;
    private JTextArea taDatos;
    private CalculosDP calculos = new CalculosDP();

    public Raizes(){
        super("Caculo de Raiz");

        // Crear objetos de atributos/variables de clase
        tfRaiz1= new JTextField();
        tfRaiz2 = new JTextField();
        tfRaiz3 = new JTextField();
        bCalcular = new JButton("Calcular Raizes");
        bSalir = new JButton("Exit");
        panel1 = new JPanel();
        panel2 = new JPanel();
        taDatos = new JTextArea(10,30);
        taDatos.setEditable(false);

        //adicionar action listener a botones
        bSalir.addActionListener(this);
        bCalcular.addActionListener(this);

        //definir layout de JPanels
        panel1.setLayout(new GridLayout(4,2));
        panel2.setLayout(new FlowLayout());

        // Poner los objetos de atributos en el Jpanel
        panel1.add(new JLabel("Coeficiente A: "));
        panel1.add(tfRaiz1);
        panel1.add(new JLabel("Coeficiente B: "));
        panel1.add(tfRaiz2);
        panel1.add(new JLabel("Coeficiente C: "));
        panel1.add(tfRaiz3);
        panel1.add(bCalcular);
        panel1.add(bSalir);

        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        // Hacer visible el JFrame
        add(panel2);
        setSize(500,500);
        setVisible(true);
    }
    public JPanel getPanel2(){
        return panel2;
    }
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == bCalcular) {
            //Obtener Datos
            float intA = Integer.parseInt(tfRaiz1.getText());
            float intB = Integer.parseInt(tfRaiz3.getText());
            float intC = Integer.parseInt(tfRaiz3.getText());
            //Hacer la conversion 
            
            
            String resultado = calculos.raizes(intA, intB, intC);
            
            //Desplegar resultado
            taDatos.setText(resultado);

        }
        if(event.getSource()==bSalir){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        Raizes Raizes = new Raizes();
    }
}