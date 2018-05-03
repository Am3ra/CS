import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Editor extends JFrame implements ActionListener
{
    private JMenuBar  menuBar;
    private JMenu     menu;
    private JMenuItem menuItemNew, menuItemAbrir, menuItemGuardar, menuItemGuardarAs, menuItemSalir;
    
    private JTextArea taEditor= new JTextArea(20,40);
    private JPanel	  panel;
    private String    nombreArchivo="";
    
    
    public Editor()
    {
        super("Editor Basico");
        
        menuBar = new JMenuBar();
        menu    = new JMenu("File");
        panel   = new JPanel();
        panel.setLayout(new FlowLayout());
        
        menuItemNew = new JMenuItem("New");
        menuItemNew.addActionListener(this);
        menu.add(menuItemNew);
        
        menuItemAbrir = new JMenuItem("Open");
        menuItemAbrir.addActionListener(this);
        menu.add(menuItemAbrir);
        
        menuItemGuardar = new JMenuItem("Save");
        menuItemGuardar.addActionListener(this);
        menu.add(menuItemGuardar);
        
        menuItemGuardarAs = new JMenuItem("Save As");
        menuItemGuardarAs.addActionListener(this);
        menu.add(menuItemGuardarAs);
        
        menuItemSalir    = new JMenuItem("Exit");
        menuItemSalir.addActionListener(this);
        menu.add(menuItemSalir);
        
        menuBar.add(menu);
        
        panel.add(new JScrollPane(taEditor));
        panel.setVisible(false);
        
        setJMenuBar(menuBar);
        
        add(panel);
        setSize(500,400);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource() == menuItemNew)
        {
            JOptionPane.showMessageDialog(null,"Abrir un Nuevo Archivo...");
        }
        
        if(e.getSource() == menuItemAbrir)
        {
            JOptionPane.showMessageDialog(null,"Abrir un Archivo ya existente...");
        }
        
        if(e.getSource() == menuItemGuardar)
        {
            JOptionPane.showMessageDialog(null,"Guardar un Archivo...");
        }
        
        if(e.getSource() == menuItemGuardarAs)
        {
            JOptionPane.showMessageDialog(null,"Abrir un Archivo con nuevo nombre...");
        }
        
        if(e.getSource() == menuItemSalir)
            System.exit(0);
    }
    
    public static void main(String args[])
    {
        new Editor();
    }
}
