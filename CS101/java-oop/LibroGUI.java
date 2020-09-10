import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibroGUI extends JFrame implements ActionListener {
    private JTextField tfTitulo = new JTextField();
    private JTextField tfAutor = new JTextField();
    private JTextField tfEditorial = new JTextField();

    private JButton bCapturar, bConsultar, bSalir;

    private JTextArea taDatos = new JTextArea(10, 23);
    private JPanel panel1, panel2;

    private BibliotecaAD bad = new BibliotecaAD();

    public LibroGUI() {
        super("Administracion de Libros");

        panel1 = new JPanel();
        panel2 = new JPanel();

        panel1.setLayout(new GridLayout(5, 2));
        panel2.setLayout(new FlowLayout());

        panel1.add(new JLabel("TITULO"));
        panel1.add(tfTitulo);

        panel1.add(new JLabel("AUTOR"));
        panel1.add(tfAutor);

        panel1.add(new JLabel("EDITORIAL"));
        panel1.add(tfEditorial);

        bCapturar = new JButton("Capturar");
        bCapturar.addActionListener(this);
        panel1.add(bCapturar);

        bConsultar = new JButton("Consultar");
        bConsultar.addActionListener(this);
        panel1.add(bConsultar);

        bSalir = new JButton("Salir");
        bSalir.addActionListener(this);
        panel1.add(bSalir);

        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));

        add(panel2);
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public String obtenerDatos() {
        if (tfTitulo.getText().equals("") || tfAutor.getText().equals("") || tfEditorial.getText().equals("")) {
            return "VACIO";
        } else {
            return tfTitulo.getText() + "_" + tfAutor.getText() + "_" + tfEditorial.getText();

        }
    }

    public void actionPerformed(ActionEvent e) {
        String respuesta = "";
        String datos = "";

        if (e.getSource() == bCapturar) {
            //Obtener Datos
            datos = obtenerDatos();
            //Capturar datos
            if (datos == "VACIO") {
                taDatos.setText("algun campo esta vacio");
            } else {
                datos = bad.capturarDatos(datos);
                //mostrar resultados
                taDatos.setText(datos);
            }

        }
        if (e.getSource() == bConsultar) {
            //obtener datos
            datos = bad.obtenerLibros();
            //mostrar datos
            taDatos.setText(datos);
        }

        if (e.getSource() == bSalir)
            System.exit(0);
    }

    public static void main(String args[]) {
        new LibroGUI();
    }
}