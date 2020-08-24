import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QueueStackGUI extends JFrame implements ActionListener
{
    private JTextField tfNombre;
    private JButton    bPush, bPop, bDesplegar, bSalir;
    private JPanel     panel1, panel2;
    private JTextArea  taDatos;
    private QueueAD queAD = new QueueAD();
    
    
    public QueueStackGUI()
    {
        super("Queue - Stack GUI");
        
        // 1. Crear o inicializar atributos
        tfNombre = new JTextField();
        bPush    = new JButton("Push");
        bPop     = new JButton("Pop");
        bDesplegar = new JButton("Desplegar");
        bSalir   = new JButton("Salir");
        panel1   = new JPanel();
        panel2   = new JPanel();
        taDatos  = new JTextArea(8,20);
        
        // Adicionar addActionListener a los botones
        bPush.addActionListener(this);
        bPop.addActionListener(this);
        bDesplegar.addActionListener(this);
        bSalir.addActionListener(this);
        
        // 2. Establecer Layout a panels y Adicionar objetos a los panels
        panel1.setLayout(new GridLayout(3,2));
        panel2.setLayout(new FlowLayout());
        
        panel1.add(new JLabel("Nombre: "));
        panel1.add(tfNombre);
        panel1.add(bPush);
        panel1.add(bPop);
        panel1.add(bDesplegar);
        panel1.add(bSalir);
        
        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        
        // 3. Adicionar panels al JFrame
        add(panel2);
        setSize(300,300);
        setVisible(true);
    }
    
    public JPanel getPanel2()
    {
        return panel2;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String respuesta = "", nombre;
        if(e.getSource() == bPush)
        {
            nombre = tfNombre.getText();
            respuesta = queAD.push(nombre);
            taDatos.setText(respuesta);
        }
        
        if(e.getSource() == bPop)
        {
            respuesta = queAD.pop();
            taDatos.setText(respuesta);
        }
        
        if(e.getSource() == bDesplegar)
        {
            respuesta = queAD.desplegar();
            taDatos.setText(respuesta);
        }
        
        if(e.getSource() == bSalir)
            System.exit(0);
    }
    
    public static void main(String args[])
    {
        QueueStackGUI objeto = new QueueStackGUI();
    }
}
