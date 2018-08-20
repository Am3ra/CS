import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArreglosGUI extends JFrame implements ActionListener {
    private JMenuBar menuBarOpciones;
    private JMenu menu;
    private JMenuItem miNumero, miString, miSalir;

    private JPanel panel, panel1, panel2, panel3;
    private JButton bIntercambiar, bOrdenar, bBuscar;

    private JTextField tfArreglo1[];
    private JTextField tfArreglo2[];

    private String arreglo1[];
    private String arreglo2[];
    ArrayList<JTextField> list = new ArrayList<JTextField>();
    String args2[];
    public ArreglosGUI(String args[]) {
        super("ARREGLOS UNIDIMENSIONALES");
        args2 = args;
        // 1. Crear objetos
        menuBarOpciones = new JMenuBar();
        menu = new JMenu("ARREGLOS:");
        miString = new JMenuItem("Strings");
        miNumero = new JMenuItem("Numeros");
        miSalir = new JMenuItem("Exit");
        bIntercambiar = new JButton("Intercambiar Datos");
        bOrdenar = new JButton("Ordenar Arreglo 2");
        bBuscar = new JButton("Buscar en Arreglo 1");
        panel= new JPanel(); 

        // Adicionar ActionLisener a los botones
        bIntercambiar.addActionListener(this);
        bOrdenar.addActionListener(this);
        bBuscar.addActionListener(this);

        // Adicionar listener a los menu items
        // miString.addActionListener(this);
        // miNumero.addActionListener(this);
        miSalir.addActionListener(this);

        // 2. Adicionar JMenuItems a JMenu
        // menu.add(miNumero);
        // menu.add(miString);
        menu.add(miSalir);

        // 3. Adicionar JMenu a JMenuBar
        menuBarOpciones.add(menu);

        panel.setLayout(new FlowLayout());
        // 4. Adicionar JMenuBar al JFrame
        panel.add(new JLabel("Arreglo 1 :"));
        for (String i : args) {
            JTextField textField = new JTextField(i);
            panel.add(textField);
            list.add(textField);
        }
        panel.add(new JLabel("Arreglo 2 :"));
        for (int j = 0; j < args.length; j++) {
            JTextField textField = new JTextField(1);
            panel.add(textField);
            list.add(textField);
        }

        panel.add(bIntercambiar);
        panel.add(bBuscar);
        panel.add(bOrdenar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // desplegar(args);
        setJMenuBar(menuBarOpciones);
        add(panel);        
        setSize(400, 300);
        setVisible(true);
    }

    private void ordenar() {
        int length1 = args2.length;
        String temp;
        for (int i = 0; i < args2.length; i++) {
            // System.out.println(list.get(i+args2.length).getText());
            for (int j = 0; j < length1; j++) {
                if (j != args2.length-1) {
                    System.out.println(list.get(j + args2.length).getText());
                    if (list.get(j+args2.length).getText().compareTo(list.get(j+args2.length+1).getText())>0) {
                        temp = list.get(j+args2.length).getText();
                        list.get(j+args2.length).setText(list.get(j + args2.length + 1).getText());
                        list.get(j+args2.length + 1).setText(temp);
                    }
                }
            }
            length1--;
        }
    }
    private void intercambiar(String args[]) {
        for (int i = 0; i < args.length; i++){
            list.get(args.length*2 - 1 - i).setText(list.get(i).getText());
        }
            // nums2[i] = nums1[nums1.length - 1 - i];
    }

    private void buscar(String args[]) {
        String i = JOptionPane.showInputDialog(null, "Ingrese el elemento a buscar");
        String message = "El elemento " + i + " se encontro ";
        String addon = "";
        int COUNTER = 0;
        for (int j = 0; j < args.length; j++) {
            if (args[j].equals(i)) {
                addon += "\nEn la posicion " + j;
            }
            COUNTER++;
        }
        JOptionPane.showMessageDialog(null, message + COUNTER + " vezes" + addon);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miSalir)
            System.exit(0);
        else if (e.getSource() == bIntercambiar) {
            intercambiar(args2);
        } else if (e.getSource() == bOrdenar) {
            ordenar();
        } else if (e.getSource() == bBuscar) {
            System.out.println("Search");
            buscar(args2);
        }
    }

    public static void main(String args[]) {
        ArreglosGUI arreglo = new ArreglosGUI(args);
    }
}
