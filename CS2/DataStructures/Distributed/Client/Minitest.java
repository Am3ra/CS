import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

/**
 * minitest
 */
public class Minitest extends JFrame implements ActionListener{
    private JPanel panelPrincipal, panelFlechitas,panelFotos;
    private JButton bBefore, bNext;
    private Cliente cliente = new Cliente();
    private int i = 0, max;
    public Minitest() {
        cliente.establecerConexion();
        cliente.enviarDatos("consultarMax");
        max = Integer.parseInt(cliente.recibirDatos());
        System.out.println("MAX: " + max);
        cliente.cerrarConexion();

        bBefore = new JButton("<");
        bNext = new JButton(">");
        panelPrincipal = new JPanel();
        panelFlechitas = new JPanel();
        panelFotos = new JPanel();

        bBefore.setEnabled(false);

        bBefore.addActionListener(this);
        bNext.addActionListener(this);

        panelPrincipal.setLayout(new FlowLayout());
        panelFlechitas.setLayout(new GridLayout(1,2));
        panelFotos.setLayout(new FlowLayout());
        // panelFotos.setSize(200,200);

        panelFlechitas.add(bBefore);
        panelFlechitas.add(bNext);

        panelFotos.add(new JLabel(new ImageIcon(cliente.recibirFileImagen("0"))));

        panelPrincipal.add(panelFlechitas);
        panelPrincipal.add(panelFotos);

        add(panelPrincipal);
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bNext) {
            bBefore.setEnabled(true);
            i++;
            panelFotos.setVisible(false);
            panelFotos.removeAll();

            cliente.establecerConexion();
            cliente.enviarDatos("datos");
            cliente.cerrarConexion();

            panelFotos.add(new JLabel(new ImageIcon(cliente.recibirFileImagen(""+i))));
            panelFotos.setVisible(true);
            if (i == max-1) {
                bNext.setEnabled(false);
            }
            
        } else if (e.getSource() == bBefore) {
            bNext.setEnabled(true);
            i--;
            panelFotos.setVisible(false);
            panelFotos.removeAll();
            panelFotos.add(new JLabel(new ImageIcon(cliente.recibirFileImagen("" + i))));
            panelFotos.setVisible(true);
            if (i==0) {
                bBefore.setEnabled(false);
            }
        }
            
        
    }

    public static void main(String[] args) {
        Minitest foo = new Minitest();
    }
    
}