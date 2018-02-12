import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private JButton bConsultarNocta, bRetiro, bDeposito, bCancelar;
    private JPanel panel1, panel2;
    private JTextArea taDatos;
    private JComboBox cbtiposcuenta;
    

    // private BancoAD bancoad = new BancoAD();
    private BancoADjdbc bancoad = new BancoADjdbc();

    public ClienteGUI(){
        super("ADMON de Clientes");
        String[] tiposCuentas = { "HIPOTECA", "INVERSION", "AHORRO", "CREDITO"};

        tfCuenta = new JTextField();
        tfNombre = new JTextField();
        // tfTipo = new JTextField();
        tfSaldo = new JTextField();
        bCapturar = new JButton("Capturar Datos");
        bConsultar = new JButton("Consultar Clientes");
        bCancelar =new JButton("Cancelar Transacción");
        panel1 = new JPanel();
        panel2 = new JPanel();
        taDatos = new JTextArea(10,30);
        cbtiposcuenta = new JComboBox(tiposCuentas);
        taDatos.setEditable(false);

        bConsultarNocta =new JButton("Consultar no. Cuenta");
        bRetiro = new JButton("Retiro de cuenta");
        bDeposito =new JButton("Depositar");
        bSalir=new JButton("Salir");

        bSalir.addActionListener(this);
        bConsultar.addActionListener(this);
        bCapturar.addActionListener(this);
        bConsultarNocta.addActionListener(this);
        bRetiro.addActionListener(this);
        bRetiro.setEnabled(false);
        bDeposito.addActionListener(this);
        bDeposito.setEnabled(false);
        bCancelar.addActionListener(this);

        panel1.setLayout(new GridLayout(9,2));
        panel2.setLayout(new FlowLayout());

        panel1.add(new JLabel("No de cuenta"));
        panel1.add(tfCuenta);
        panel1.add(new JLabel("Nombre"));
        panel1.add(tfNombre);
        panel1.add(new JLabel("Tipo de cuenta"));
        panel1.add(cbtiposcuenta);
        panel1.add(new JLabel("Saldo"));
        panel1.add(tfSaldo);
        panel1.add(bCapturar);
        panel1.add(bConsultar);
        panel1.add(bConsultarNocta);
        panel1.add(bRetiro);
        panel1.add(bDeposito);
        panel1.add(bCancelar);
        panel1.add(bSalir);
       
        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        add(panel2);
        setSize(400,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private String obtenerDatos(){
        String nocta = tfCuenta.getText(), nombre = tfNombre.getText(),tipo =(String) cbtiposcuenta.getSelectedItem(), saldo = tfSaldo.getText(),datos;

        if (nocta.equals("")|| nombre.isEmpty()||tipo.equals("")||saldo.isEmpty()){
            datos =  "VACIO";
        } else{
            try {
                int n  = Integer.parseInt(saldo);
                datos = nocta+"_"+nombre+"_"+tipo+"_"+saldo;
            } catch(Exception e){
                datos = "NO_NUMERICO";
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
            taDatos.setText(bancoad.consultarClientes());
        }
        if (event.getSource() == bSalir) {
            System.exit(0);
        } if (event.getSource()== bDeposito){
            //OBtener numero de cuenta
            String ncta = tfCuenta.getText();
            //obtener numero de deposito
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a depositar = " ));
            respuesta = bancoad.depositar(ncta, cantidad);
            //Desplegar el resultado
            taDatos.setText(respuesta);
            // activarBotones();
        }if (event.getSource()== bRetiro){

        }
        if (event.getSource()== bConsultarNocta){
            String ncta = tfCuenta.getText();
            // respuesta = bancoad.buscar(ncta, cantidad);

            //respuesta = BancoADjdbc.consultarncta(ncta);
        }
    }
    public static void main(String[] args) {
        new ClienteGUI();
    }
}