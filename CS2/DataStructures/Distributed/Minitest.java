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
    private MinitestADLL minitestAD = new MinitestADLL();
    private int i = 0;
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

        panelFotos.add(new JLabel(((ImagesDP)minitestAD.listaCool.get(i)).getImage()));

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
            panelFotos.add(new JLabel(((ImagesDP)minitestAD.listaCool.get(i)).getImage()));
            panelFotos.setVisible(true);
            if (i == minitestAD.listaCool.size()) {
                bNext.setEnabled(false);
            }
            
        } else if (e.getSource() == bBefore) {
            bNext.setEnabled(true);
            i--;
            panelFotos.setVisible(false);
            panelFotos.removeAll();
            panelFotos.add(new JLabel(((ImagesDP) minitestAD.listaCool.get(i)).getImage()));
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