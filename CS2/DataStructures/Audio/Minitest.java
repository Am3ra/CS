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
    int counter = 0;
    private ImageIcon imagenesAlbums[];
    

    public Minitest() {

        File folder = new File("images");
        File[] listOfFiles = folder.listFiles();
        imagenesAlbums = new ImageIcon[listOfFiles.length];

        for (int i = 0; i < listOfFiles.length; i++) {
            imagenesAlbums[i] = new ImageIcon("images/"+listOfFiles[i].getName());
            System.out.println(listOfFiles[i].getName());
        }

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

        panelFotos.add(new JLabel(imagenesAlbums[0]));

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
            counter ++;
            panelFotos.setVisible(false);
            panelFotos.removeAll();
            panelFotos.add(new JLabel(imagenesAlbums[counter]));
            panelFotos.setVisible(true);
            if (counter == imagenesAlbums.length -1) {
                bNext.setEnabled(false);
            }
            
        } else if (e.getSource() == bBefore) {
            bNext.setEnabled(true);
            counter--;
            panelFotos.setVisible(false);
            panelFotos.removeAll();
            panelFotos.add(new JLabel(imagenesAlbums[counter]));
            panelFotos.setVisible(true);
            if (counter == 0) {
                bBefore.setEnabled(false);
            }
        }
            
        
    }

    public static void main(String[] args) {
        Minitest foo = new Minitest();
    }
    
}