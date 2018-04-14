import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.util.Vector;

public class BibliotecaGUI extends JFrame implements ActionListener, ListSelectionListener {
    // Atributos de la aplicacion
    private JPanel panelUsuario, panelEditoriales, panelLibros, panelPrincipal,panelInfo;

    private JButton bEditorial, bBuscar;
    private JTextArea taEditorial, taLibros,taInfo;
    private BibliotecaAD bibliotecaad = new BibliotecaAD();

    private Vector vectorEditoriales, vectorInformacion;
    private JList listaEditoriales, listaInformacion;

    private ImageIcon iconAlbum[];

    public BibliotecaGUI() {
        super("BIBLIOTECA TEC");

        // 1. Crear objetos de los atributos

        bEditorial = new JButton("Editoriales");
        bBuscar = new JButton("Buscar Titulo");

        taEditorial = new JTextArea("EDITORIALES", 20, 20);
        taLibros = new JTextArea("LIBROS DE UNA EDITORIAL");
        taInfo = new JTextArea("INFORMACION SOBRE ");

        panelUsuario = new JPanel();
        panelEditoriales = new JPanel();
        panelLibros = new JPanel();
        panelPrincipal = new JPanel();
        panelInfo = new JPanel();

        // Adionar actionListener a los JButtons
        bEditorial.addActionListener(this);

        // 2. Definir Layouts de los JPanels
        panelUsuario.setLayout(new FlowLayout());
        panelEditoriales.setLayout(new GridLayout(1, 1));
        panelInfo.setLayout(new GridLayout(1, 1));
        panelLibros.setLayout(new GridLayout(1, 1));
        panelPrincipal.setLayout(new BorderLayout(5,5));

        // 3. Colocar los objetos de los atributos en los panels correspondientes
        panelUsuario.add(bEditorial);

        panelEditoriales.add(new JScrollPane(taEditorial));
        panelLibros.add(new JScrollPane(taLibros));
        panelInfo.add(new JScrollPane(taInfo));


        panelPrincipal.add(panelUsuario, BorderLayout.NORTH);
        panelPrincipal.add(panelEditoriales,BorderLayout.WEST);
        panelPrincipal.add(panelLibros, BorderLayout.CENTER);
        panelPrincipal.add(panelInfo, BorderLayout.EAST);

        // 4. Adicionar el panelPrincipal al JFrame
        add(panelPrincipal);
        setSize(700, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bEditorial) {
            vectorEditoriales = bibliotecaad.obtenerEditoriales();
            listaEditoriales = new JList(vectorEditoriales);
            listaEditoriales.addListSelectionListener(this);

            panelEditoriales.setVisible(false);
            panelEditoriales.removeAll();
            panelEditoriales.add(listaEditoriales);
            panelEditoriales.setVisible(true);
        }
    }

    public void valueChanged(ListSelectionEvent lse) {
        String editorialElegido;
        if (lse.getValueIsAdjusting() == true) {
            if (lse.getSource() == listaEditoriales) {
                editorialElegido = (String) listaEditoriales.getSelectedValue();
                System.out.println(editorialElegido);
                iconAlbum = bibliotecaad.obtenerInfoIcons(editorialElegido);

                listaInformacion = new JList(iconAlbum);
                listaInformacion.addListSelectionListener(this);
                panelLibros.setVisible(false);
                panelLibros.removeAll();
                panelLibros.setSize(100, 400);
                panelLibros.add(new  JScrollPane(listaInformacion));
                panelLibros.setVisible(true);
                bibliotecaad.obtenerInfo(editorialElegido);
            }
            if (lse.getSource() == listaInformacion) {
    
                taInfo.setText(bibliotecaad.getInfo(listaInformacion.getSelectedIndex()));
            }

        }
    }

    public static void main(String args[]) {
        new BibliotecaGUI();
    }
}
