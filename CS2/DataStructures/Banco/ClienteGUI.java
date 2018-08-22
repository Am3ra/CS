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

public class ClienteGUI extends JFrame implements ActionListener
{
    private JTextField tfNocta, tfNombre, tfTipo, tfSaldo;
    private JButton    bCapturar, bConsultar, bSalir;
    private JButton    bConsultarNocta, bRetiro, bDeposito, bCancelar;
    private JButton    bDatosArchivoArreglo, bConsultarArreglo, bDatosArregloArchivo;
    private JPanel     panel1, panel2;
    private JTextArea  taDatos;
    private JComboBox  comboCuentas;
    private String     opcionesCuenta[] = {"INVERSION","CREDITO","AHORRO","HIPOTECA"};
    
    private BancoAD bancoad = new BancoAD();
    
    public ClienteGUI()
    {
        super("BANCO VB CITY");
        
        // 1. Crear los objetos de los atributos
        tfNocta = new JTextField();
        tfNombre = new JTextField();
        tfTipo   = new JTextField();
        tfSaldo  = new JTextField();
        bCapturar = new JButton("Capturar datos (Archivo)");
        bConsultar = new JButton("Consultar Clientes (Archivo)");
        bSalir = new JButton("Exit");
        panel1 = new JPanel();
        panel2 = new JPanel();
        taDatos = new JTextArea(10,30);
        
        bConsultarNocta = new JButton("Consultar No. Cuenta (Arreglo)");
        bRetiro = new JButton("Retiro de Cuenta (Arreglo)");
        bDeposito = new JButton("Deposito a Cuenta (Arreglo)");
        bCancelar = new JButton("Cancelar Transaccion");
        bDatosArchivoArreglo = new JButton("Datos Archivo->Arreglo");
        bConsultarArreglo    = new JButton("Consultar Arreglo");
        bDatosArregloArchivo = new JButton("Datos Arreglo->Archivo");
        
        comboCuentas = new JComboBox(opcionesCuenta);
        
        // Adicionar addActionListener a lo JButtons
        bCapturar.addActionListener(this);
        bConsultar.addActionListener(this);
        bSalir.addActionListener(this);
        bConsultarNocta.addActionListener(this);
        bDeposito.addActionListener(this);
        bRetiro.addActionListener(this);
        bCancelar.addActionListener(this);
        comboCuentas.addActionListener(this);
        bDatosArchivoArreglo.addActionListener(this);
        bConsultarArreglo.addActionListener(this);
        bDatosArregloArchivo.addActionListener(this);
        
        bRetiro.setEnabled(false);
        bDeposito.setEnabled(false);
        bCancelar.setEnabled(false);
        
        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(9,2));
        panel2.setLayout(new FlowLayout());
        
        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel1.add(new JLabel("No. DE CUENTA"));
        panel1.add(tfNocta);
        panel1.add(new JLabel("NOMBRE: "));
        panel1.add(tfNombre);
        panel1.add(new JLabel("TIPO DE CUENTA"));
        panel1.add(comboCuentas);
        panel1.add(new JLabel("SALDO"));
        panel1.add(tfSaldo);
        panel1.add(bCapturar);
        panel1.add(bConsultar);
        panel1.add(bConsultarNocta);
        panel1.add(bRetiro);
        panel1.add(bDeposito);
        panel1.add(bCancelar);
        panel1.add(bDatosArchivoArreglo);
        panel1.add(bConsultarArreglo);
        panel1.add(bDatosArregloArchivo);
        panel1.add(bSalir);
        
        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        
        // 4. Adicionar el panel2 al JFrame y hacerlo visible
        add(panel2);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void inactivarBotones()
    {
        bCapturar.setEnabled(false);
        bConsultar.setEnabled(false);
        bConsultarNocta.setEnabled(false);
        bRetiro.setEnabled(true);
        bDeposito.setEnabled(true);
        bCancelar.setEnabled(true);
    }
    
    private void activarBotones()
    {
        bCapturar.setEnabled(true);
        bConsultar.setEnabled(true);
        bConsultarNocta.setEnabled(true);
        bRetiro.setEnabled(false);
        bDeposito.setEnabled(false);
        bCancelar.setEnabled(false);
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
        
        if(e.getSource() == bCapturar){
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
        else if(e.getSource() == bConsultar){
            //1. Realizar consulta de clientes
            datos = bancoad.consultarClientes();
            
            // 2. Desplegar datos
            taDatos.setText(datos);
        }
        
        if(e.getSource() == bConsultarNocta){
            // 1. Obtener le No de Cuenta de tfNocta
            String ncta = tfNocta.getText();
            
            // 2. Realizar transaccion de consultar no. de cuenta
            respuesta = bancoad.consultar(ncta);
            if(respuesta.equals("NO_LOCALIZADO"))
              respuesta = "No. de Cuenta no localizado: "+ncta;
            else if (respuesta.equals("Arreglo no inicializado / null"))
              respuesta = "Arreglo no inicializado";
            else
                inactivarBotones();
            
            // 3. Desplegar resultado de la transaccion
            taDatos.setText(respuesta);
        }
        
        if(e.getSource() == bRetiro){
            // 1. Obtener el No. de Cuenta de donde se hará el retiro
            String ncta = tfNocta.getText();
            //Verificar existencia:
            respuesta = bancoad.consultar(ncta);
            if(respuesta.equals("NO_LOCALIZADO"))
              respuesta = "No. de Cuenta no localizado: "+ncta;
            else if (respuesta.equals("Arreglo no inicializado / null"))
              respuesta = "Arreglo no inicializado";
            else{
                
                // 2. Obtener la cantidad a retirar
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a retirar ="));
                
                // 3. Realizar transaccion deposito
                respuesta = bancoad.retirar(ncta,cantidad);
                
                // 4. Desplegar resultado de la transaccion
                taDatos.setText(respuesta);
                activarBotones();
            }
        }
        
        if(e.getSource() == bDeposito)
        {
            // 1. Obtener el No. de Cuenta de donde se hará el retiro
            String ncta = tfNocta.getText();
            //Verificar existencia:
            respuesta = bancoad.consultar(ncta);
            if(respuesta.equals("NO_LOCALIZADO"))
              respuesta = "No. de Cuenta no localizado: "+ncta;
            else if (respuesta.equals("Arreglo no inicializado / null"))
              respuesta = "Arreglo no inicializado";
            else{
                
                // 2. Obtener la cantidad a retirar
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a retirar ="));
                
                // 3. Realizar transaccion deposito
                respuesta = bancoad.depositar(ncta,cantidad);
                
                // 4. Desplegar resultado de la transaccion
                taDatos.setText(respuesta);
                activarBotones();
            }
        }
        
        if(e.getSource() == bCancelar)
        {
            taDatos.setText("");
            activarBotones();
        }

        if(e.getSource() == bDatosArchivoArreglo)
        {
            datos = bancoad.datosArchivoArreglo();
            taDatos.setText(datos);
        }
        
        if(e.getSource() == bConsultarArreglo)
        {   
            datos = bancoad.displayStringArray();
            taDatos.setText(datos);
        }
        
        if(e.getSource() == bDatosArregloArchivo)
        {
            datos = bancoad.datosArregloArchivo();
            taDatos.setText(datos);
        }
        
        if(e.getSource() == bSalir)
        {
            System.exit(0);
        }
    }
    
    public static void main(String args[])
    {
        new ClienteGUI();
    }
}