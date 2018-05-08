import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.util.Vector;

public class FtpClient extends JFrame implements ActionListener, ListSelectionListener
{
    // Atributos de la aplicacion
    private JPanel panelUsuario, panelServer, panelClient, panelPrincipal;
    
    private JButton bServerFiles, bClientFiles, bGet, bSend;
    private JTextArea  taServerFiles, taClienteFiles;
    
    private Vector vectorServerFiles, vectorClientFiles;
    private JList  listaServerFiles, listaClientFiles;
    
    public FtpClient()
    {
        super("FTP: File Transfer Protocol");
        
        // 1. Crear objetos d elos atributos
        bServerFiles = new JButton("Mostrar Directorio Server");
        bClientFiles  = new JButton("Mostrar Directorio Cliente");
        bGet   = new JButton("GET (->)");
        bSend    = new JButton("SEND (<-)");
        taServerFiles= new JTextArea("Directorio Server",12,15);
        taClienteFiles  = new JTextArea("Directorio Cliente",12,15);
        panelUsuario  = new JPanel();
        panelServer = new JPanel();
        panelClient   = new JPanel();
        panelPrincipal= new JPanel();
        
        // Adionar actionListener a los JButtons
        bServerFiles.addActionListener(this);
        bClientFiles.addActionListener(this);
        bGet.addActionListener(this);
        bSend.addActionListener(this);
        
        // 2. Definir Layouts de los JPanels
        panelUsuario.setLayout(new GridLayout(4,1));
        panelServer.setLayout(new GridLayout(1,1));
        panelClient.setLayout(new GridLayout(1,1));
        panelPrincipal.setLayout(new FlowLayout());
        //panelPrincipal.setLayout(new BorderLayout(5,5));
        
        // 3. Colocar los objetos de los atributos en los panels correspondientes
        panelUsuario.add(bServerFiles);
        panelUsuario.add(bGet);
        panelUsuario.add(bClientFiles);
        panelUsuario.add(bSend);
        
        panelServer.add(new JScrollPane(taServerFiles));
        panelClient.add(new JScrollPane(taClienteFiles));

        panelPrincipal.add(panelServer);
        panelPrincipal.add(panelUsuario);
        panelPrincipal.add(panelClient);
        
        // 4. Adicionar el panelPrincipal al JFrame
        add(panelPrincipal);
        setSize(600,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource() == bServerFiles)
        {
            taServerFiles.setText("Lista de Archivos del Server...");
        }
        
        if(e.getSource() == bClientFiles)
        {
            taClienteFiles.setText("Lista de Archivos del Cliente...");
        }
        
        if(e.getSource() == bGet)
        {
            JOptionPane.showMessageDialog(null,"Archivo Transferido del Server al Cliente...");
        }
        
        if(e.getSource() == bSend)
        {
            JOptionPane.showMessageDialog(null,"Archivo Transferido del Cliente al Server...");
            
        }
        
    }
    
    public void valueChanged(ListSelectionEvent lse)
    {
        
        if(lse.getValueIsAdjusting() == true)
        {
            if(lse.getSource() == listaServerFiles)
            {
                
            }
            
            if(lse.getSource() == listaServerFiles)
            {
                
            }
        }
    }
    
    public static void main(String args[])
    {
        new FtpClient();
    }
}











