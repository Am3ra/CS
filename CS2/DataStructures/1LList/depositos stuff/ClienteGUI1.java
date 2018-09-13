import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteGUI1 extends JFrame implements ActionListener
{
    private JTextField tfNocta, tfNombre, tfTipo, tfSaldo;
    private JButton    bCapturar, bConsultar, bSalir,
                         bConsultarClientes, bConsultarNocta, 
                         bConsultarRetirosA, bConsultarDepositosA, 
                         bConsultarRetirosLL, bConsultarDepositosLL,
                         bDeleteAccount, bAddFirst;
    private JButton    bRetiro, bDeposito, bCancelar;
    private JPanel     panel1, panel2;
    private JTextArea  taDatos;
    private JComboBox comboCuentas;
    private String opcionesCuenta[] = {"INVERSION","CREDITO","AHORRO","HIPOTECA"};
    
    private BancoAD bancoad = new BancoAD();
    
    public ClienteGUI1()
    {
        super("BANCO VB CITY LL");
        
        // 1. Crear los objetos de los atributos
        tfNocta = new JTextField();
        tfNombre = new JTextField();
        tfTipo   = new JTextField();
        tfSaldo  = new JTextField();
        bCapturar = new JButton("Capturar datos (LList)");
        bConsultar = new JButton("Consultar Clientes (LList)");
        bConsultarNocta = new JButton("Consultar No. Cuenta");
        bConsultarClientes = new JButton("Consultar Clientes (Clientes.txt)");
        bRetiro = new JButton("Retiro de Cuenta (LList)");
        bDeposito = new JButton("Deposito a Cuenta (LList)");
        bCancelar = new JButton("Cancelar Transaccion");
        bAddFirst = new JButton("AddFirst LList");
        bDeleteAccount = new JButton("Delete account");
        
        bConsultarRetirosLL = new JButton("Consultar Retiros (LList)");
        bConsultarDepositosLL = new JButton("Consultar Depositos (LList)");
        bConsultarRetirosA = new JButton("Consultar Retiros (Retiros.txt)");
        bConsultarDepositosA = new JButton("Consultar Retiros (Depositos.txt)");
        
        bSalir = new JButton("Exit");
        panel1 = new JPanel();
        panel2 = new JPanel();
        taDatos = new JTextArea(10,30);
        comboCuentas = new JComboBox(opcionesCuenta);
        
        // Adicionar addActionListener a lo JButtons
        bCapturar.addActionListener(this);
        bConsultar.addActionListener(this);
        bConsultarNocta.addActionListener(this);
        bConsultarClientes.addActionListener(this);
        bDeposito.addActionListener(this);
        bRetiro.addActionListener(this);
        bCancelar.addActionListener(this);
        
        bConsultarRetirosLL.addActionListener(this);
        bConsultarDepositosLL.addActionListener(this);
        bConsultarRetirosA.addActionListener(this);
        bConsultarDepositosA.addActionListener(this);
        bAddFirst.addActionListener(this);
        bDeleteAccount.addActionListener(this);
        
        bSalir.addActionListener(this);
        
        bRetiro.setEnabled(false);
        bDeposito.setEnabled(false);
        bCancelar.setEnabled(false);
        bDeleteAccount.setEnabled(false);
        
        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(11,2));
        panel2.setLayout(new FlowLayout());
        
        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel1.add(new JLabel("No. DE CUENTA"));
        panel1.add(tfNocta);
        panel1.add(new JLabel("NOMBRE: "));
        panel1.add(tfNombre);
        panel1.add(new JLabel("TIPO DE CUENTA"));
        //panel1.add(tfTipo);
        panel1.add(comboCuentas);
        panel1.add(new JLabel("SALDO"));
        panel1.add(tfSaldo);
        panel1.add(bCapturar);
        panel1.add(bAddFirst);
        panel1.add(bConsultar);
        panel1.add(bConsultarNocta);
        panel1.add(bConsultarClientes);
        panel1.add(bRetiro);
        panel1.add(bDeposito);
        panel1.add(bDeleteAccount);
        
        panel1.add(bConsultarRetirosLL);
        panel1.add(bConsultarDepositosLL);
        panel1.add(bConsultarRetirosA);
        panel1.add(bConsultarDepositosA);
        
        panel1.add(bCancelar);
        panel1.add(bSalir);
        
        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        
        // 4. Adicionar el panel2 al JFrame y hacerlo visible
        add(panel2);
        setSize(550,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void inactivarBotones()
    {
        bCapturar.setEnabled(false);
        bConsultar.setEnabled(false);
        bConsultarNocta.setEnabled(false);
        bConsultarClientes.setEnabled(false);
        
        bRetiro.setEnabled(true);
        bDeposito.setEnabled(true);
        bCancelar.setEnabled(true);
        bAddFirst.setEnabled(false);
        bDeleteAccount.setEnabled(true);
        
        bConsultarRetirosA.setEnabled(false);
        bConsultarDepositosA.setEnabled(false);
        bConsultarRetirosLL.setEnabled(false);
        bConsultarDepositosLL.setEnabled(false);
    }
    
    private void activarBotones()
    {
        bCapturar.setEnabled(true);
        bConsultar.setEnabled(true);
        bConsultarNocta.setEnabled(true);
        bConsultarClientes.setEnabled(true);
        
        bRetiro.setEnabled(false);
        bDeposito.setEnabled(false);
        bCancelar.setEnabled(false);
        bAddFirst.setEnabled(true);
        bDeleteAccount.setEnabled(false);
        
        bConsultarRetirosA.setEnabled(true);
        bConsultarDepositosA.setEnabled(true);
        bConsultarRetirosLL.setEnabled(true);
        bConsultarDepositosLL.setEnabled(true);
    }

    private String obtenerDatos()
    {
        String datos;
        
        String nocta  = tfNocta.getText();
        String nombre = tfNombre.getText();
        //String tipo   = tfTipo.getText();
        String tipo   = (String)comboCuentas.getSelectedItem();
        String saldo  = tfSaldo.getText();
        
        if(nocta.equals("") || nombre.isEmpty() || tipo.equals("") || saldo.isEmpty())
            datos = "VACIO";
        else
        {
            try
            {
                int n = Integer.parseInt(saldo);
                datos = nocta+"_"+nombre+"_"+tipo+"_"+saldo;
            }
            catch(NumberFormatException nfe)
            {
                datos = "NO_NUMERICO";
            }
        }
        
        return datos;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String datos, respuesta;
        System.out.println("ACTIONS");
        if(e.getSource() == bCapturar)
        {
            // 1. Obtener datos
            datos = obtenerDatos();
            
            // 2. Checar datos: datos no vacios y saldo numerico, y realizar la captura de datos
            if(datos.equals("VACIO"))
                respuesta = "Algun campo esta vacio...";
            else
                if(datos.equals("NO_NUMERICO"))
                    respuesta = "Saldo debe ser numerico...";
                else
                    respuesta = bancoad.capturar(datos);
                    //respuesta = datos;
            
            // 3. Desplegar esultado de transaccion
            taDatos.setText(respuesta);
        }
        
        if(e.getSource() == bConsultar)
        {
            // 1. Realizar consulta de clientes
            datos = bancoad.consultarClientes();
            
            // 2. Desplegar datos
            taDatos.setText(datos);
            //taDatos.setText("Consultar Clientes ...");
        }
        
        if(e.getSource() == bConsultarClientes)
        {
            // 1. Realizar consulta de clientes en el archivo
            datos = bancoad.consultarClientesArchivo();
            
            // 2. Desplegar datos
            taDatos.setText(datos);
        }
        if (e.getSource() == bAddFirst) {
            // 1. Obtener datos
            datos = obtenerDatos();

            // 2. Checar datos: datos no vacios y saldo numerico, y realizar la captura de
            // datos
            if (datos.equals("VACIO"))
                respuesta = "Algun campo esta vacio...";
            else if (datos.equals("NO_NUMERICO"))
                respuesta = "Saldo debe ser numerico...";
            else
                respuesta = bancoad.addFirst(datos);
            // respuesta = datos;

            // 3. Desplegar esultado de transaccion
            taDatos.setText(respuesta);
        }

        if (e.getSource() == bDeleteAccount) {
            // 1. Obtener datos
            String nocta = tfNocta.getText();
            respuesta = bancoad.deleteNode(nocta);
            
            taDatos.setText(respuesta);
            activarBotones();
        }
        
        if(e.getSource() == bConsultarNocta)
        {
            // 1. Obtener el no. de cuenta a buscar
            String ncta = tfNocta.getText();
            
            // 2. Realizar transaccion de consultar no. de cuenta
            respuesta = bancoad.consultarNocta(ncta);
            if(respuesta.equals("NOT_FOUND"))
                respuesta = "No. de Cuenta no localizado: "+ncta;
            else
                if(respuesta.equals("EMPTY"))
                    respuesta = "LISTA VACIA...";
                else
                    inactivarBotones();
            
            // 3. Desplegar resultado de la transaccion
            taDatos.setText(respuesta);
        }
        
        if(e.getSource() == bDeposito)
        {
            // 1. Obtener el No. de Cuenta a donde se hará el deposito
            String ncta = tfNocta.getText();
            
            // 2. Obtener la cantidad a depositar
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a depositar ="));
            
            // 3. Realizar transaccion deposito
            respuesta = bancoad.deposito(ncta,cantidad);
            
            // 4. Desplegar resultado de la transaccion
            taDatos.setText(respuesta);
            
            activarBotones();
        }
        
        if(e.getSource() == bRetiro)
        {
            // 1. Obtener el No. de Cuenta a donde se hará el retiro
            String ncta = tfNocta.getText();
            
            // 2. Obtener la cantidad a retirar
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a retirar ="));
            
            // 3. Realizar transaccion retirar
            respuesta = bancoad.retiro(ncta,cantidad);
            
            // 4. Desplegar resultado de la transaccion
            taDatos.setText(respuesta);
            
            activarBotones();
        }
        
        if(e.getSource() == bCancelar)
        {
            activarBotones();
        }
        
        if(e.getSource() == bConsultarRetirosA)
        {
            taDatos.setText(bancoad.consultar("retiros.txt"));
        }
        
        if(e.getSource() == bConsultarDepositosA)
        {
            taDatos.setText(bancoad.consultar("depositos.txt"));
        }
        
        if(e.getSource() == bConsultarRetirosLL)
        {
            // Consultar Lista de Retiros
            taDatos.setText(bancoad.consultarRetiros());
        }
        
        if(e.getSource() == bConsultarDepositosLL)
        {
            // Consultar Lista de Depositos
            taDatos.setText(bancoad.consultarDepositos());
        }
        
        if(e.getSource() == bSalir)
        {
            bancoad.datosListaArchivo();
            bancoad.datosLLRetirosArchRetiros();
            bancoad.datosLLDepositosArchDepositos();
            System.exit(0);
        }
    }
    
    public static void main(String args[])
    {
        new ClienteGUI1();
    }
}



