import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class CalculosGUI extends JFrame implements ActionListener{
    private JMenuBar mbPrincipal;
    private JMenu menuCalculos, menuGrados;
    private JMenuItem miFactorial, miGradosCF, miGradosFC, miExponencial, miSalir;

    public CalculosGUI(){
        super("Java APP: Calculos varios");
        //Crear objeto de los atributos
        mbPrincipal = new JMenuBar();
        menuCalculos = new JMenu("Calculos Varios");
        menuGrados = new JMenu("Conversion de Grados");
        miFactorial = new JMenuItem("Factorial de N");
        miExponencial = new JMenuItem("Y = B^X");
        miGradosCF = new JMenuItem("C a F");
        miGradosFC = new JMenuItem("F a C");
        miSalir = new JMenuItem("Exit");

        //Colocar action listeners
        miSalir.addActionListener(this);
        miFactorial.addActionListener(this);
        miExponencial.addActionListener(this);
        miGradosCF.addActionListener(this);
        miGradosFC.addActionListener(this);

        //Colocar los JMENUITEMS
        menuGrados.add(miGradosCF);
        menuGrados.add(miGradosFC);
        menuCalculos.add(miFactorial);
        menuCalculos.add(miExponencial);
        menuCalculos.add(menuGrados);
        menuCalculos.add(miSalir);

        //Colocar JMenuBar
        mbPrincipal.add(menuCalculos);

        //Colocar el JMenuBAr en el Jframe
        setJMenuBar(mbPrincipal);
        setSize(400,300);
        setVisible(true);
        

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent a){
        if(a.getSource()==miSalir){
            System.exit(0);
        } if (a.getSource()==miExponencial) {
            new exponencial();
        } if (a.getSource()==miFactorial) {
            new Factorial();
        } if (a.getSource()==miGradosFC||a.getSource()==miGradosCF) {
            new GradosGUI5();
        }

    }
    public static void main(String[] args) {
        new CalculosGUI();
    }
}