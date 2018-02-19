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
    private JTextField tfCuenta, tfNombre, tfSaldo;
    private JButton bCapturar, bConsultar, bSalir;
    private JButton bConsultarNocta, bRetiro, bDeposito, bCancelar, bConRet,bConDep,bTrans,bConTrans,bConTipo;
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
        bConRet =new JButton("Consultar Retiro");
        bConDep =new JButton("Consultar Deposito");
        bConTipo =new JButton("Consultar Tipo");
        bConTrans =new JButton("Consultar Transferencias");
        bTrans =new JButton("Hacer Transferencia");
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
        bDeposito.addActionListener(this);
        bCancelar.addActionListener(this);
        bConDep.addActionListener(this);
        bConRet.addActionListener(this);
        bTrans.addActionListener(this);
        bConTrans.addActionListener(this);
        bConTipo.addActionListener(this);

        panel1.setLayout(new GridLayout(10,2));
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
        panel1.add(bConTipo);
        panel1.add(bRetiro);
        panel1.add(bConRet);
        panel1.add(bDeposito);
        panel1.add(bConDep);
        panel1.add(bTrans);
        panel1.add(bConTrans);
        panel1.add(bCancelar);
        panel1.add(bSalir);
       
        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        add(panel2);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        apagar();
    }
    public void apagar(){
        bCancelar.setEnabled(false);
        bDeposito.setEnabled(false);
        bRetiro.setEnabled(false);
        bTrans.setEnabled(false);

        bCapturar.setEnabled(true);
        bConsultar.setEnabled(true);
        bConsultarNocta.setEnabled(true);
        bConTipo.setEnabled(true);
        
    }
    public void prender(){
        bCancelar.setEnabled(true);
        bDeposito.setEnabled(true);
        bRetiro.setEnabled(true);
        bTrans.setEnabled(true);
    
        bCapturar.setEnabled(false);
        bConsultar.setEnabled(false);
        bConsultarNocta.setEnabled(false);
        bConTipo.setEnabled(false);
    }
    private String obtenerDatos(){
        String nocta = tfCuenta.getText(), nombre = tfNombre.getText(),tipo =(String) cbtiposcuenta.getSelectedItem(), saldo = tfSaldo.getText(),datos;

        if (nocta.equals("")|| nombre.isEmpty()||tipo.equals("")||saldo.isEmpty()){
            datos =  "VACIO";
        } else{
            try {
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
        } 
        if (event.getSource()== bDeposito){
            //OBtener numero de cuenta
            String ncta = tfCuenta.getText();
            //obtener numero de deposito
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a depositar = " ));
            respuesta = bancoad.depositar(ncta, cantidad);
            //Desplegar el resultado
            taDatos.setText(respuesta);

        }
        if (event.getSource()== bRetiro){
            //OBtener numero de cuenta
            String ncta = tfCuenta.getText();
            //obtener numero de deposito
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a retirar = "));
            respuesta = bancoad.retirar(ncta, cantidad);
            //Desplegar el resultado
            taDatos.setText(respuesta);
        }
        if (event.getSource()== bConsultarNocta){
            String ncta = tfCuenta.getText();
            // respuesta = bancoad.buscar(ncta, cantidad);
            respuesta = bancoad.consultarCuenta(ncta);
            //Desplegar el resultado
            taDatos.setText(respuesta);
            //respuesta = BancoADjdbc.consultarncta(ncta);
            prender();
        }
        if (event.getSource() == bConDep){
            taDatos.setText(bancoad.consultarDepositos(tfCuenta.getText()));
        }
        if (event.getSource() == bConRet){
            taDatos.setText(bancoad.consultarRetiros(tfCuenta.getText()));
        }
        if (event.getSource() == bCancelar){
            apagar();
            taDatos.setText("");
        }
        if(event.getSource()==bConTipo){
            taDatos.setText(bancoad.consultarTipo((String)cbtiposcuenta.getSelectedItem()));
        }
        if(event.getSource()==bConTrans){
            taDatos.setText(bancoad.consultarTransferencia(tfCuenta.getText()));
        }
        if(event.getSource()==bTrans){
            int ncta = Integer.parseInt(tfCuenta.getText());
            System.out.println(ncta);
            //obtener numero de deposito
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a retirar = "));
            int nocta2 = Integer.parseInt(JOptionPane.showInputDialog("Cuenta A depositar= "));
            respuesta = bancoad.transferencia(ncta, cantidad, nocta2);
            //Desplegar el resultado
            taDatos.setText(respuesta);
        }
    }
    public static void main(String[] args) {
        new ClienteGUI();
    }
}