import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class CalculosGUI2 extends JFrame implements ActionListener{
    private JMenuBar mbPrincipal;
    private JMenu menuCalculos, menuGrados,menuAudio;
    private JMenuItem miFactorial, miGradosCF, miGradosFC, miExponencial,miEcuacion,miAudio,miAudioMP3, miSalir;
    private JPanel panel;

    private Factorial factor = new Factorial();
    private exponencial expo = new exponencial();
    private GradosGUI5 grados = new GradosGUI5();
    private Raizes raiz = new Raizes();
    private AudioGUI audio2 = new AudioGUI();
    private AudioGUIMP3 audioGUIMP3= new AudioGUIMP3();

    public CalculosGUI2(){
        super("Java APP: Calculos varios");
        //Crear objeto de los atributos
        mbPrincipal = new JMenuBar();
        menuCalculos = new JMenu("Calculos Varios");
        menuAudio = new JMenu("Reproduccion Audio");
        menuGrados = new JMenu("Conversion de Grados");
        miFactorial = new JMenuItem("Factorial de N");
        miEcuacion = new JMenuItem("Ecuación Cuadrática");
        miAudio = new JMenuItem("Audio WAV");
        miAudioMP3 = new JMenuItem("Audio MP3");
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
        miAudioMP3.addActionListener(this);

        //Colocar los JMENUITEMS
        menuGrados.add(miGradosCF);
        menuGrados.add(miGradosFC);
        menuCalculos.add(miFactorial);
        menuCalculos.add(miExponencial);
        menuCalculos.add(menuGrados);
        menuCalculos.add(miEcuacion);
        menuCalculos.add(miSalir);

        menuAudio.add(miAudio);
        menuAudio.add(miAudioMP3);

        //Colocar JMenuBar
        mbPrincipal.add(menuCalculos);
        mbPrincipal.add(menuAudio);

        //Colocar el JMenuBAr en el Jframe
        setJMenuBar(mbPrincipal);
        setSize(500,400);
        setVisible(true);
        

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent a){
        System.out.println(""+a);
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
        } 
        if (a.getSource()==miGradosFC||a.getSource()==miGradosCF) {
            panel.setVisible(false);
            panel = grados.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        }
        if (a.getSource()==miEcuacion) {
            panel.setVisible(false);
            panel = raiz.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        }
        if (a.getSource()==miAudio) {
            panel.setVisible(false);
            panel = audio2.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        }
        if (a.getSource()==miAudioMP3){
            panel.setVisible(false);
            panel = audioGUIMP3.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        }

    }
    public static void main(String[] args) {
        new CalculosGUI2();
    }
}