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
    private MinitestAD minitestAD = new MinitestAD();

    public Minitest() {

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

        panelFotos.add(new JLabel(minitestAD.firstDP.getImage()));
        minitestAD.currentDP = minitestAD.firstDP;

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
            minitestAD.currentDP=minitestAD.currentDP.getNext();
            panelFotos.setVisible(false);
            panelFotos.removeAll();
            panelFotos.add(new JLabel(minitestAD.currentDP.getImage()));
            panelFotos.setVisible(true);
            if (minitestAD.currentDP.getNext() == null) {
                bNext.setEnabled(false);
            }
            
        } else if (e.getSource() == bBefore) {
            bNext.setEnabled(true);
            panelFotos.setVisible(false);
            minitestAD.currentDP = minitestAD.currentDP.getPrevious();
            panelFotos.removeAll();
            panelFotos.add(new JLabel(minitestAD.currentDP.getImage()));
            panelFotos.setVisible(true);
            if (minitestAD.currentDP.getPrevious() == null) {
                bBefore.setEnabled(false);
            }
        }
            
        
    }

    public static void main(String[] args) {
        Minitest foo = new Minitest();
    }
    
}