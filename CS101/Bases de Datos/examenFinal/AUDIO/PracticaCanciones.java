import javax.management.BadStringOperationException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.awt.event.ActionEvent;



import java.util.Vector;
/**
 * adminBiblioteca
 */
public class PracticaCanciones extends JFrame implements ActionListener {

    
        
    private JTextField tfAutor, tfTitulo,tfEditorial;
    private JButton bPlay, bJList,bConsultar, bStop;
    private JPanel panel1, panel2;
    private JTextArea taDatos;

    private Cliente cliente = new Cliente();
    private AudioOS audioOS = new AudioOS();
    

    public PracticaCanciones(){
        super("Administracion de Biblioteca");

        // Crear objetos de atributos/variables de clase
        tfAutor = new JTextField();
        tfTitulo = new JTextField();
        tfEditorial = new JTextField();
        bPlay = new JButton("Play");
        bStop = new JButton("Stop");
        bConsultar = new JButton("Catalog Strings");
        bJList = new JButton("catalog Jlist");
        panel1 = new JPanel();
        panel2 = new JPanel();
        taDatos = new JTextArea(10,30);
        taDatos.setEditable(false);

        //adicionar action listener a botones
        bJList.addActionListener(this);
        bPlay.addActionListener(this);
        bStop.addActionListener(this);
        bConsultar.addActionListener(this);

        //definir layout de JPanels
        panel1.setLayout(new GridLayout(3,2));
        panel2.setLayout(new FlowLayout());

        // Poner los objetos de atributos en el Jpanel
        panel1.add(new JLabel("Titulo : "));
        panel1.add(tfTitulo);
        panel1.add(bPlay);
        panel1.add(bStop);
        panel1.add(bConsultar);
        panel1.add(bJList);

        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        // Hacer visible el JFrame
        add(panel2);
        setSize(400,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        taDatos.setEditable(false);
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void actionPerformed(ActionEvent event){
        if (event.getSource()==bPlay){
            cliente.establecerConexion();
            cliente.enviarDatos("streamAudio");
            cliente.enviarDatos(tfTitulo.getText());
            try {
                InputStream in = new BufferedInputStream(cliente.socket.getInputStream());
                audioOS.play(in);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            cliente.cerrarConexion();
        }
        if (event.getSource()==bConsultar){
            cliente.establecerConexion();
            cliente.enviarDatos("consultarCanciones");
            taDatos.setText(printData(cliente.recibirDatos()));
        }
        if (event.getSource()==bJList){
            System.exit(0);
        }
    }

    private String printData(String datos) {
        String[] intermediate = datos.split("&");
        datos = "";
        for (int i = 0; i < intermediate.length; i++) {
            datos += intermediate[i] + "\n";
        }
        return datos;
    }
    
    
    public static void main(String args[]) {
        new PracticaCanciones();
    }
}
