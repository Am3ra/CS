import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class CalculosGUI2 extends JFrame implements ActionListener{
    private JMenuBar mbPrincipal;
    private JMenu menuCalculos, menuGrados;
    private JMenuItem miFactorial, miGradosCF, miGradosFC, miExponencial,miEcuacion,miAudio, miSalir;
    private JPanel panel;

    private factorial factor = new factorial();
    private exponencial expo = new exponencial();
    private GradosGUI5 grados = new GradosGUI5();
    private Raizes raiz = new Raizes();
    private Audio2 audio2 = new Audio2();

    public CalculosGUI2(){
        super("Java APP: Calculos varios");
        //Crear objeto de los atributos
        mbPrincipal = new JMenuBar();
        menuCalculos = new JMenu("Calculos Varios");
        menuGrados = new JMenu("Conversion de Grados");
        miFactorial = new JMenuItem("Factorial de N");
        miEcuacion = new JMenuItem("Ecuación Cuadrática");
        miAudio = new JMenuItem("Reproducción de Audio");
        miExponencial = new JMenuItem("Exponencial");
        miGradosCF = new JMenuItem("C a F");
        miGradosFC = new JMenuItem("F a C");
        miSalir = new JMenuItem("Exit");
        panel =  new JPanel();

        //Colocar action listeners
        miSalir.addActionListener(this);
        miFactorial.addActionListener(this);
        miExponencial.addActionListener(this);
        miGradosCF.addActionListener(this);
        miGradosFC.addActionListener(this);
        miEcuacion.addActionListener(this);
        miAudio.addActionListener(this);

        //Colocar los JMENUITEMS
        menuGrados.add(miGradosCF);
        menuGrados.add(miGradosFC);
        menuCalculos.add(miFactorial);
        menuCalculos.add(miExponencial);
        menuCalculos.add(menuGrados);
        menuCalculos.add(miEcuacion);
        menuCalculos.add(miAudio);
        menuCalculos.add(miSalir);

        //Colocar JMenuBar
        mbPrincipal.add(menuCalculos);

        //Colocar el JMenuBAr en el Jframe
        setJMenuBar(mbPrincipal);
        setSize(500,400);
        setVisible(true);
        

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent a){
        if(a.getSource()==miSalir){
            System.exit(0);
        } if (a.getSource()==miExponencial) {
            panel.setVisible(false);
            panel = expo.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        } if (a.getSource()==miFactorial) {
            panel.setVisible(false);
            panel = factor.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        } if (a.getSource()==miGradosFC||a.getSource()==miGradosCF) {
            panel.setVisible(false);
            panel = grados.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        }

    }
    public static void main(String[] args) {
        new CalculosGUI2();
    }
}