import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



import java.util.Vector;
/**
 * adminBiblioteca
 */
public class AdminBiblioteca extends JFrame implements ActionListener {

    
        
    private JTextField tfAutor, tfTitulo,tfEditorial;
    private JButton bCapturar, bSalir,bConsultar;
    private JPanel panel1, panel2;
    private JTextArea taDatos;
    BibliotecaAD bibliotecaAD = new BibliotecaAD();

    public AdminBiblioteca(){
        super("Administracion de Biblioteca");

        // Crear objetos de atributos/variables de clase
        tfAutor = new JTextField();
        tfTitulo = new JTextField();
        tfEditorial = new JTextField();
        bCapturar = new JButton("Capturar");
        bConsultar = new JButton("Consultar");
        bSalir = new JButton("Exit");
        panel1 = new JPanel();
        panel2 = new JPanel();
        taDatos = new JTextArea(10,30);
        taDatos.setEditable(false);

        //adicionar action listener a botones
        bSalir.addActionListener(this);
        bCapturar.addActionListener(this);
        bConsultar.addActionListener(this);

        //definir layout de JPanels
        panel1.setLayout(new GridLayout(6,2));
        panel2.setLayout(new FlowLayout());

        // Poner los objetos de atributos en el Jpanel
        panel1.add(new JLabel("Titulo : "));
        panel1.add(tfTitulo);
        panel1.add(new JLabel("Autor :  "));
        panel1.add(tfAutor);
        panel1.add(new JLabel("Editorial :  "));
        panel1.add(tfEditorial);
        panel1.add(bCapturar);
        panel1.add(bConsultar);
        panel1.add(bSalir);

        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        // Hacer visible el JFrame
        add(panel2);
        setSize(500,500);
        // setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        taDatos.setEditable(false);
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void actionPerformed(ActionEvent event){
        if (event.getSource()==bCapturar){
            if (tfAutor.getText().isEmpty()|| tfEditorial.getText().isEmpty()|| tfTitulo.getText().isEmpty()) {
                taDatos.setText("Algun Campo esta vacio");
            } else{
                String datos = tfTitulo.getText() +"_"+ tfAutor.getText() + "_" + tfEditorial.getText();
                datos = bibliotecaAD.capturarDatos(datos);
                taDatos.setText(datos);
            } 
        }
        if (event.getSource()==bConsultar){
            taDatos.setText(bibliotecaAD.returnAll());
        }
        if (event.getSource()==bSalir){
            System.exit(0);
        }
    }
    
    public static void main(String args[]) {
        new AdminBiblioteca();
    }
}
