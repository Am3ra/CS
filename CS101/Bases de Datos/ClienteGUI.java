import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * ClienteGUI
 */
public class ClienteGUI extends JFrame implements ActionListener{
    private JTextField tfCuenta, tfNombre, tfTipo, tfSaldo;
    private JButton bCapturar, bConsultar, bSalir;
    private JPanel panel1, panel2;
    private JTextArea taDatos;
    
    private BancoAD bancoad = new BancoAD();

    public ClienteGUI(){
        super("ADMON de Clientes");

        tfCuenta = new JTextField();
        tfNombre = new JTextField();
        tfTipo = new JTextField();
        tfSaldo = new JTextField();
        bCapturar = new JButton("Capturar Datos");
        bConsultar = new JButton("consultar Clientes");
        bSalir =new JButton("Salir");
        panel1 = new JPanel();
        panel2 = new JPanel();
        taDatos = new JTextArea(10,30);

        bSalir.addActionListener(this);
        bConsultar.addActionListener(this);
        bCapturar.addActionListener(this);

        panel1.setLayout(new GridLayout(6,2));
        panel2.setLayout(new FlowLayout());

        panel1.add(new JLabel("No de cuenta"));
        panel1.add(tfCuenta);
        panel1.add(new JLabel("Nombre"));
        panel1.add(tfNombre);
        panel1.add(new JLabel("Tipo de cuenta"));
        panel1.add(tfTipo);
        panel1.add(new JLabel("Saldo"));
        panel1.add(tfSaldo);
        panel1.add(bCapturar);
        panel1.add(bConsultar);
        panel1.add(bSalir);

        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        add(panel2);
        setSize(400,400);
        setVisible(true);

    }
    private String obtenerDatos(){
        String nocta = tfCuenta.getText(), nombre = tfCuenta.getText(),tipo = tfCuenta.getText(), saldo = tfCuenta.getText(),datos;

        if (nocta.equals("")|| nombre.isEmpty()||tipo.equals("")||saldo.isEmpty()){
            datos =  "VACIO";
        } else{
            try {
                int n  = Integer.parseInt(saldo);
                datos = nocta+"_"+nombre+"_"+tipo+"_"+saldo;
            } catch(Exception e){
                datos = "Error en captura"+e;
                System.out.println("ERROR"+e);
            }
        }
        return datos;
    }   

    public void actionPerformed(ActionEvent event){
        String datos, respuesta;
        if(event.getSource()==bCapturar){
            datos = obtenerDatos();
            if (datos.equals("VACIO")){
                respuesta =  "Algun campo esta vacio";
            } else if (datos.equals("NO_NUMERICO")){
                respuesta= "Saldo no numerico";
            }else {
                respuesta = bancoad.capturar(datos);
            }
            taDatos.setText(respuesta);
        }
        if (event.getSource() == bConsultar) {

        }
        if (event.getSource() == bSalir) {

        }
    }
    public static void main(String[] args) {
        new ClienteGUI();
    }
}