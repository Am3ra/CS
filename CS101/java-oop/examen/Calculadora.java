import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.Panel;

public class Calculadora extends JFrame implements ActionListener
{
    private JTextField tfNumero = new JTextField(8);
    private CalculosDP calculosdp = new CalculosDP();
    
    private JButton bSuma, bResta, bMultiplica, bDivide, bIgual, bClear, bPunto;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private JButton bFactorial, bExpo, bRaiz, bCuadrado;
    private Panel panel1, panel2;
    
    private float n1, n2;
    private String operacion = "";
    private String strNumero = "";
    private int base, x;
    
    public Calculadora()
    {
        super("Calculadora");
        
        panel1 = new Panel();
        panel2 = new Panel();
        panel1.setLayout(new GridLayout(1,2));
        panel2.setLayout(new GridLayout(5,4));
        
        
        panel1.add(tfNumero);
        
        bClear = new JButton("clear");
        bClear.addActionListener(this);
        panel1.add(bClear);
        
        
        b7 = new JButton("7");
        b7.addActionListener(this);
        panel2.add(b7);
        
        b8 = new JButton("8");
        b8.addActionListener(this);
        panel2.add(b8);
        
        b9 = new JButton("9");
        b9.addActionListener(this);
        panel2.add(b9);
        
        bSuma = new JButton("+");
        bSuma.addActionListener(this);
        panel2.add(bSuma);
        
        b4 = new JButton("4");
        b4.addActionListener(this);
        panel2.add(b4);
        
        b5 = new JButton("5");
        b5.addActionListener(this);
        panel2.add(b5);
        
        b6 = new JButton("6");
        b6.addActionListener(this);
        panel2.add(b6);
        
        bResta = new JButton("-");
        bResta.addActionListener(this);
        panel2.add(bResta);
        
        b1 = new JButton("1");
        b1.addActionListener(this);
        panel2.add(b1);
        
        b2 = new JButton("2");
        b2.addActionListener(this);
        panel2.add(b2);
        
        b3 = new JButton("3");
        b3.addActionListener(this);
        panel2.add(b3);
        
        bMultiplica = new JButton("x");
        bMultiplica.addActionListener(this);
        panel2.add(bMultiplica);
        
        b0 = new JButton("0");
        b0.addActionListener(this);
        panel2.add(b0);
        
        bPunto = new JButton(".");
        bPunto.addActionListener(this);
        panel2.add(bPunto);
        
        bIgual = new JButton("=");
        bIgual.addActionListener(this);
        panel2.add(bIgual);
        
        bDivide = new JButton("/");
        bDivide.addActionListener(this);
        panel2.add(bDivide);
        
        bFactorial = new JButton("x!");
        bFactorial.addActionListener(this);
        panel2.add(bFactorial);
        
        bRaiz = new JButton("sqrt(x)");
        bRaiz.addActionListener(this);
        panel2.add(bRaiz);
        
        bCuadrado = new JButton("x^2");
        bCuadrado.addActionListener(this);
        panel2.add(bCuadrado);
        
        bExpo = new JButton("y^x");
        bExpo.addActionListener(this);
        panel2.add(bExpo);
        
        
        setLayout(new FlowLayout());
        add(panel1);
        add(panel2);
        setSize(350,220);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == bFactorial) {
            tfNumero.setText(""+(calculosdp.factorial(Integer.parseInt(tfNumero.getText()))));
        }
        if (event.getSource() == bCuadrado) {
            tfNumero.setText("" + (calculosdp.cuadrado(Float.parseFloat(tfNumero.getText()))));
        }
        if (event.getSource() == bDivide) {
            calculosdp.setNum(Float.parseFloat(tfNumero.getText()));
            calculosdp.setOP("divide");
            tfNumero.setText("");
        }
        if (event.getSource() == bClear) {
            tfNumero.setText("");
        }
        if (event.getSource() == bRaiz) {
            tfNumero.setText(""+calculosdp.raiz(Float.parseFloat(tfNumero.getText())));
        }
        if (event.getSource() == bExpo) {
            calculosdp.setNum(Float.parseFloat(tfNumero.getText()));
            calculosdp.setOP("exponencial");
            tfNumero.setText("");
        }
        if (event.getSource() == bSuma) {
            calculosdp.setNum(Float.parseFloat(tfNumero.getText()));
            calculosdp.setOP("suma");
            tfNumero.setText("");
        }
        if (event.getSource() == bResta) {
            calculosdp.setNum(Float.parseFloat(tfNumero.getText()));
            calculosdp.setOP("resta");
            tfNumero.setText("");
        }
        if (event.getSource() == bMultiplica) {
            calculosdp.setNum(Float.parseFloat(tfNumero.getText()));
            calculosdp.setOP("multiplica");
            tfNumero.setText("");
        }
        if (event.getSource() == bIgual) {
            tfNumero.setText(calculosdp.result(Float.parseFloat(tfNumero.getText())));
        }
        if (event.getSource() == bPunto) {
            tfNumero.setText(tfNumero.getText()+".");
        }
        if (event.getSource() == b0) {
            tfNumero.setText(tfNumero.getText() + "0");
        }
        if (event.getSource() == b1) {
            tfNumero.setText(tfNumero.getText() + "1");
        }
        if (event.getSource() == b2) {
            tfNumero.setText(tfNumero.getText() + "2");
        }
        if (event.getSource() == b3) {
            tfNumero.setText(tfNumero.getText() + "3");
        }
        if (event.getSource() == b4) {
            tfNumero.setText(tfNumero.getText() + "4");
        }
        if (event.getSource() == b5) {
            tfNumero.setText(tfNumero.getText() + "5");
        }
        if (event.getSource() == b6) {
            tfNumero.setText(tfNumero.getText() + "6");
        }
        if (event.getSource() == b7) {
            tfNumero.setText(tfNumero.getText() + "7");
        }
        if (event.getSource() == b8) {
            tfNumero.setText(tfNumero.getText() + "8");
        }
        if (event.getSource() == b9) {
            tfNumero.setText(tfNumero.getText() + "9");
        }
    }
    
    
    public static void main(String args[])
    {
        Calculadora calculadora = new Calculadora();
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
