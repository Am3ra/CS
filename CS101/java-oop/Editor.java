import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.*;

public class Editor extends JFrame implements ActionListener
{
    private JMenuBar  menuBar;
    private JMenu     menu;
    private JMenuItem menuItemNew, menuItemAbrir, menuItemGuardar, menuItemGuardarAs, menuItemSalir;
    
    private JTextArea taEditor= new JTextArea(20,40),tAreaDatos = new JTextArea();
    private JPanel	  panel, panelBuscar;
    private String    nombreArchivo="";
    private EditorAD editorAD = new EditorAD();
    
    
    public Editor()
    {
        super("Editor Basico");
        
        menuBar = new JMenuBar();
        menu    = new JMenu("File");
        panel   = new JPanel();
        panelBuscar   = new JPanel();
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
        
        panelBuscar.add(tAreaDatos);
        tAreaDatos.setText("cool");
        panelBuscar.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource() == menuItemNew)
        {
            nombreArchivo = JOptionPane.showInputDialog(null, "Write name of file:");            
            panel.setVisible(true);
        }
        
        if(e.getSource() == menuItemAbrir)
        {
            nombreArchivo = JOptionPane.showInputDialog("Abrir un Archivo:");
            System.out.println(nombreArchivo);
            taEditor.setText(editorAD.openFile(nombreArchivo));
            // taEditor.setText("Good");
            panel.setVisible(true);
            
        }
        
        if(e.getSource() == menuItemGuardar)
        {
            JOptionPane.showMessageDialog(null,"Guardar un Archivo...");
            if (nombreArchivo.isEmpty()) {
                nombreArchivo = JOptionPane.showInputDialog("Write name of file");
                editorAD.capturarDatos(taEditor.getText(), nombreArchivo);
            } else {
                editorAD.capturarDatos(taEditor.getText(), nombreArchivo);
            }
            JOptionPane.showMessageDialog(null, "Guardado con exito");
            taEditor.setText("");
            panel.setVisible(false);
            nombreArchivo = "";
        }
        
        if(e.getSource() == menuItemGuardarAs){
            nombreArchivo = JOptionPane.showInputDialog("Write name of file");
            editorAD.capturarDatos(taEditor.getText(), nombreArchivo);     
            panel.setVisible(false);
            nombreArchivo = "";
            taEditor.setText("");
        }
        
        if(e.getSource() == menuItemSalir)
            System.exit(0);
    }
    
    public static void main(String args[])
    {
        new Editor();
    }
}
