import javax.swing.JOptionPane;

/**
 * Arreglo3
 */
public class Arreglo3 {

    private void obtainData(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            nums[i]= Integer.parseInt(JOptionPane.showInputDialog("Numeros["+i+"] ="));
        }
    }
    private void displayData(int nums[]) {
        String str = "[";
        for (int i = 0; i < nums.length-1; i++) {
            str += nums[i]+",";
        }
        str += nums[nums.length-1]+"]";
        JOptionPane.showMessageDialog(null, str);
    }


    public static void main(String[] args) {
        Arreglo3 foo = new Arreglo3();
        int numeros[] = new int[3];

        foo.obtainData(numeros);
        foo.displayData(numeros);

    }
}