import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.util.Vector;

public class BibliotecaGUI extends JFrame implements ActionListener, ListSelectionListener {
    // Atributos de la aplicacion
    private JPanel panelUsuario, panelEditoriales, panelLibros, panelPrincipal, panelInfo;

    private JTextField tfLibroSearch,tfEditorial;

    private JButton bEditorial, bBuscar,bCapturar;
    private JTextArea taEditorial, taLibros, taInfo;
    private BibliotecaAD bibliotecaad = new BibliotecaAD();

    private Vector vectorEditoriales;
    private JList listaEditoriales, listaInformacion;

    private ImageIcon iconAlbum[];

    private Object objectBook[];

    public BibliotecaGUI() {
        super("BIBLIOTECA TEC");

        // 1. Crear objetos de los atributos

        bEditorial = new JButton("Editoriales");
        bBuscar = new JButton("Buscar Titulo");
        bCapturar = new JButton("Capturar");

        tfLibroSearch = new JTextField("", 10);
        tfEditorial = new JTextField("", 10);

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
        bBuscar.addActionListener(this);
        bCapturar.addActionListener(this);

        // 2. Definir Layouts de los JPanels
        
        panelUsuario.setLayout(new FlowLayout());
        panelEditoriales.setLayout(new GridLayout(1, 1));
        panelInfo.setLayout(new GridLayout(1, 1));
        panelLibros.setLayout(new GridLayout(1, 3));
        panelPrincipal.setLayout(new BorderLayout(5, 5));

        // 3. Colocar los objetos de los atributos en los panels correspondientes
        panelUsuario.add(bEditorial);
        panelUsuario.add(tfLibroSearch);
        panelUsuario.add(bBuscar);
        panelUsuario.add(tfEditorial);
        panelUsuario.add(bCapturar);

        panelEditoriales.add(new JScrollPane(taEditorial));
        panelLibros.add(new JScrollPane(taLibros));
        panelInfo.add(new JScrollPane(taInfo));

        panelPrincipal.add(panelUsuario, BorderLayout.NORTH);
        panelPrincipal.add(panelEditoriales, BorderLayout.WEST);
        panelPrincipal.add(panelLibros, BorderLayout.CENTER);
        panelPrincipal.add(panelInfo, BorderLayout.EAST);

        // 4. Adicionar el panelPrincipal al JFrame
        add(panelPrincipal);
        setSize(700, 400);
        // setVisible(true);
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
        } else if (e.getSource() == bBuscar) {
            objectBook = bibliotecaad.getBook(tfLibroSearch.getText());
            System.out.println(objectBook[1]);
            
            panelLibros.setVisible(false);
            panelLibros.removeAll();
            panelLibros.add(new JLabel((ImageIcon)objectBook[1]));
            panelLibros.setVisible(true);

            panelInfo.setVisible(false);
            panelInfo.removeAll();
            panelInfo.add(new JTextArea(objectBook[0].toString()));
            panelInfo.setVisible(true);
        } else if (e.getSource() == bCapturar) {
            
        }
    }

    public JPanel getPanel2() {
        return panelPrincipal;
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
                panelLibros.add(new JScrollPane(listaInformacion));
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
