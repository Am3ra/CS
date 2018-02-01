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
public class exponencial extends JFrame implements ActionListener{
    private JTextField tfexponencial, tfbase;
    private JButton bCalcular, bSalir;
    private JPanel panel1, panel2;
    private JTextArea taDatos;
    private CalculosDP calculos = new CalculosDP();

    public exponencial(){
        super("Conversion de grados");

        // Crear objetos de atributos/variables de clase
        tfexponencial = new JTextField();
        tfbase = new JTextField();
        bCalcular = new JButton("Calcular exponencial");
        bSalir = new JButton("Exit");
        panel1 = new JPanel();
        panel2 = new JPanel();
        taDatos = new JTextArea(10,30);
        taDatos.setEditable(false);

        //adicionar action listener a botones
        bSalir.addActionListener(this);
        bCalcular.addActionListener(this);

        //definir layout de JPanels
        panel1.setLayout(new GridLayout(3,2));
        panel2.setLayout(new FlowLayout());

        // Poner los objetos de atributos en el Jpanel
        panel1.add(new JLabel("Base = "));
        panel1.add(tfbase);
        panel1.add(new JLabel("Exponencial=  "));
        panel1.add(tfexponencial);
        panel1.add(bCalcular);
        panel1.add(bSalir);

        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        // Hacer visible el JFrame
        add(panel2);
        setSize(500,300);
        //setVisible(true);
    }
    
    public JPanel getPanel2() {
        return panel2;
    }
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == bCalcular) {
            //Obtener Datos
            String strexponencial = tfexponencial.getText();
            String strbase = tfbase.getText();
            //Hacer la conversion 
            
            int exp = Integer.parseInt(strexponencial);
            int base = Integer.parseInt(strbase);
            if(exp < 0 ){
                int cool = calculos.exponencial(base, exp*(-1));

                //Desplegar resultado
                taDatos.setText("1/"+cool + " Es el resultado");

            }
            if(exp == 0 ){

                //Desplegar resultado
                taDatos.setText(1 + " Es el resultado");

            } 

            if (exp >0){
                int cool = calculos.exponencial(base, exp);

                //Desplegar resultado
                taDatos.setText(cool + " Es el resultado");

            }
            
        }
        if(event.getSource()==bSalir){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        exponencial exponencial = new exponencial();
    }
}