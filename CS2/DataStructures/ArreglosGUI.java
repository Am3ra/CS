import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.*;
import java.io.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArreglosGUI extends JFrame implements ActionListener
{
    private JMenuBar  menuBarOpciones;
    private JMenu     menu;
    private JMenuItem miNumero, miString, miSalir;
    
    private JPanel    panel, panel1, panel2, panel3;
    private JButton   bIntercambiar, bOrdenar, bBuscar;
    
    private JTextField tfArreglo1[];
    private JTextField tfArreglo2[];
    
    private String arreglo1[];
    private String arreglo2[];
    
    public ArreglosGUI()
    {
        super("ARREGLOS UNIDIMENSIONALES");
        
        // 1. Crear objetos
        menuBarOpciones = new JMenuBar();
        menu            = new JMenu("ARREGLOS:");
        miString        = new JMenuItem("Strings");
        miNumero        = new JMenuItem("Numeros");
        miSalir         = new JMenuItem("Exit");
        bIntercambiar   = new JButton("Intercambiar Datos");
        bOrdenar        = new JButton("Ordenar Arreglo 2");
        bBuscar         = new JButton("Buscar en Arreglo 1");
        
        // Adicionar ActionLisener a los botones
        bIntercambiar.addActionListener(this);
        bOrdenar.addActionListener(this);
        
        // Adicionar listener a los menu items
        miString.addActionListener(this);
        miNumero.addActionListener(this);
        miSalir.addActionListener(this);
        
        // 2. Adicionar JMenuItems a JMenu
        menu.add(miNumero);
        menu.add(miString);
        menu.add(miSalir);
        
        // 3. Adicionar JMenu a JMenuBar
        menuBarOpciones.add(menu);
        
        // 4. Adicionar JMenuBar al JFrame
        setJMenuBar(menuBarOpciones);
        
        setSize(400,300);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == miNumero)
        {
            JOptionPane.showMessageDialog(null,"Trabajar con Arreglo de Numeros...");
            
        }
        
        if(e.getSource() == miString)
        {
            JOptionPane.showMessageDialog(null,"Trabajar con Arreglo de Strings...");
        }
        
        if(e.getSource() == miSalir)
            System.exit(0);
    }
    
    public static void main(String args[])
    {
        ArreglosGUI arreglo = new ArreglosGUI();
    }
}
