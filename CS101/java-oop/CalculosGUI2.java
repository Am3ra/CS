import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class CalculosGUI2 extends JFrame implements ActionListener {
    private JMenuBar mbPrincipal;
    private JMenu menuCalculos, menuGrados, menuAudio, menuTunes,menuBiblioteca;
    private JMenuItem miFactorial, miGradosCF, miGradosFC, miExponencial, miEcuacion, miAudio, miAudioMP3, miSalir, miAudioTunesWAV, miAudioTunesMP3, miBibliotecaGUI, miBibliotecaAdmon;
    private JPanel panel;

    private Factorial factor = new Factorial();
    private exponencial expo = new exponencial();
    private GradosGUI5 grados = new GradosGUI5();
    private Raizes raiz = new Raizes();
    private AudioGUI audio2 = new AudioGUI();
    private AudioGUIMP3 audioGUIMP3 = new AudioGUIMP3();
    private AudioTunesGUI2 audioTunesGUI2 = new AudioTunesGUI2();
    private AdminBiblioteca adminBiblioteca = new AdminBiblioteca();    
    private BibliotecaGUI bibliotecaGUI = new BibliotecaGUI();

    public CalculosGUI2() {
        super("Java APP: Calculos varios");
        //Crear objeto de los atributos
        mbPrincipal = new JMenuBar();
        menuCalculos = new JMenu("Calculos Varios");
        menuGrados = new JMenu("Conversion de Grados");
        menuAudio = new JMenu("audioPlayer");
        menuTunes = new JMenu("MENU AUDIOTUNES");
        menuBiblioteca = new JMenu("MENU BIBLIOTECA");
        miFactorial = new JMenuItem("Factorial de N");
        miEcuacion = new JMenuItem("Ecuación Cuadrática");
        miAudio = new JMenuItem("Audio WAV");
        miAudioMP3 = new JMenuItem("Audio MP3");
        miExponencial = new JMenuItem("Exponencial");
        miGradosCF = new JMenuItem("C a F");
        miGradosFC = new JMenuItem("F a C");
        miSalir = new JMenuItem("Exit");
        miAudioTunesMP3 = new JMenuItem("MP3");
        miAudioTunesWAV = new JMenuItem("WAV");
        miBibliotecaGUI = new JMenuItem("GUI");
        miBibliotecaAdmon = new JMenuItem("ADMON");
        panel = new JPanel();

        //Colocar action listeners
        miSalir.addActionListener(this);
        miFactorial.addActionListener(this);
        miExponencial.addActionListener(this);
        miGradosCF.addActionListener(this);
        miGradosFC.addActionListener(this);
        miEcuacion.addActionListener(this);
        miAudio.addActionListener(this);
        miAudioMP3.addActionListener(this);
        miAudioTunesMP3.addActionListener(this);
        miAudioTunesWAV.addActionListener(this);
        miBibliotecaAdmon.addActionListener(this);
        miBibliotecaGUI.addActionListener(this);

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

        menuTunes.add(miAudioTunesMP3);
        menuTunes.add(miAudioTunesWAV);
        
        menuBiblioteca.add(miBibliotecaGUI);
        menuBiblioteca.add(miBibliotecaAdmon);

        //Colocar JMenuBar
        mbPrincipal.add(menuCalculos);
        mbPrincipal.add(menuAudio);
        mbPrincipal.add(menuTunes);
        mbPrincipal.add(menuBiblioteca);

        //Colocar el JMenuBAr en el Jframe
        setJMenuBar(mbPrincipal);
        setSize(600, 400);
        setVisible(true);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent a) {
        System.out.println("" + a);
        if (a.getSource() == miSalir) {
            System.exit(0);
        } else if (a.getSource() == miExponencial) {
            panel.setVisible(false);
            panel = expo.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        } else if (a.getSource() == miFactorial) {
            panel.setVisible(false);
            panel = factor.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        } else if (a.getSource() == miGradosFC || a.getSource() == miGradosCF) {
            panel.setVisible(false);
            panel = grados.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        } else if (a.getSource() == miEcuacion) {
            panel.setVisible(false);
            panel = raiz.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        } else if (a.getSource() == miAudio) {
            panel.setVisible(false);
            panel = audio2.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        } else if (a.getSource() == miAudioMP3) {
            panel.setVisible(false);
            panel = audioGUIMP3.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        } else if (a.getSource() == miAudioTunesMP3) {
            panel.setVisible(false);
            panel = audioTunesGUI2.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        } else if (a.getSource() == miBibliotecaAdmon) {
            panel.setVisible(false);
            panel = adminBiblioteca.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        } else if (a.getSource() == miBibliotecaGUI) {
            panel.setVisible(false);
            panel = bibliotecaGUI.getPanel2();
            panel.setVisible(true);
            add(panel);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new CalculosGUI2();
    }
}