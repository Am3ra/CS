import java.util.Arrays;

import javax.swing.JOptionPane;


public class Arreglo7
{
    String numbers[];
    private void obtenerDatos(String nums[])
    {
        System.out.println(Arrays.toString(nums));
        numbers = nums;
    }
    
    private void desplegarDatos(String numbers[])
    {
        JOptionPane.showMessageDialog(null,"El arreglo es:\n " + Arrays.toString(numbers));
    }
    private void buscar(String args[]) {
        String i=JOptionPane.showInputDialog(null, "Ingrese el elemento a buscar");
        String message = "El elemento "+i+" se encontro ";
        int COUNTER = 0;
        String addon = "";
        for (int j = 0; j < args.length; j++) {
            if (args[j].equals(i)){
                    addon += "\nEn la posicion "+j;
                    COUNTER ++;
                }
            }
            JOptionPane.showMessageDialog(null, message+COUNTER+" vezes " + addon);
    }
    
    
    private void principal(String args[])
    {
        obtenerDatos(args);
        desplegarDatos(args);
        buscar(args);
    }
    
    public static void main(String args[])
    {
        Arreglo7 objeto = new Arreglo7();
        //int numeros[] = new int[3];
        
        objeto.principal(args);
    }
}
