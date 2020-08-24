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

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



import java.util.Vector;
/**
 * adminBiblioteca
 */
public class ClienteAudioGUI extends JFrame implements ActionListener, ListSelectionListener {

    
        
    private JTextField tfAutor, tfTitulo,tfEditorial;
    private JButton bPlay, bJList,bConsultar, bStop;
    private JPanel panel1, panel2,panel3;
    private JTextArea taDatos;
    private Vector vData;
    private JList listaSongs;

    private Cliente cliente = new Cliente();
    private AudioOS audioOS = new AudioOS();
    

    public ClienteAudioGUI(){
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
        panel3 = new JPanel();
        taDatos = new JTextArea(10,30);
        taDatos.setEditable(false);

        //adicionar action listener a botones
        bJList.addActionListener(this);
        bPlay.addActionListener(this);
        bStop.addActionListener(this);
        bConsultar.addActionListener(this);

        //definir layout de JPanels
        panel1.setLayout(new GridLayout(3,2));
        panel3.setLayout(new GridLayout(3,2));
        panel2.setLayout(new FlowLayout());

        // Poner los objetos de atributos en el Jpanel
        panel1.add(new JLabel("Titulo : "));
        panel1.add(tfTitulo);
        panel1.add(bPlay);
        panel1.add(bStop);
        panel1.add(bConsultar);
        panel1.add(bJList);

        panel2.add(panel1);
        panel3.add(new JScrollPane(taDatos));
        panel2.add(panel3);
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
            cliente.enviarDatos(tfTitulo.getText()+".wav");
            try {
                InputStream in = new BufferedInputStream(cliente.socket.getInputStream());
                audioOS.play(in);
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (event.getSource()==bStop) {
            audioOS.stop();
            cliente.cerrarConexion();

        }
        if (event.getSource()==bConsultar){
            cliente.establecerConexion();
            cliente.enviarDatos("consultarCanciones");
            panel3.setVisible(false);
            panel3.removeAll();
            panel3.add(taDatos);
            panel3.setVisible(true);
            taDatos.setText(printData(cliente.recibirDatos()));
        }
        if (event.getSource()==bJList){
            cliente.establecerConexion();
            cliente.enviarDatos("consultarCanciones");
            // taDatos.setText(printData(cliente.recibirDatos()));
            listaSongs = new JList(returnVector(cliente.recibirDatos()));
            listaSongs.addListSelectionListener(this);
            panel3.setVisible(false);
            panel3.removeAll();
			panel3.add(listaSongs);
			panel3.setVisible(true);
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
    
    private Vector returnVector(String datos) {
        String[] intermediate = datos.split("&");
        vData = new Vector();
        for (int i = 0; i < intermediate.length; i++) {
            vData.add(intermediate[i]);
        }
        return vData;
    }
    
    public void valueChanged(ListSelectionEvent eListener) {
	
		if (eListener.getValueIsAdjusting() == true) {
            if (eListener.getSource() == listaSongs) {
                tfTitulo.setText((String)listaSongs.getSelectedValue());
            }
		}

	}

    
    public static void main(String args[]) {
        new ClienteAudioGUI();
    }
}
