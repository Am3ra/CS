import javax.swing.JOptionPane;

public class Arreglo2 {
    private int number;
    private int numbers[] = new int[3];

    public void principle() {
        number = 89;

        JOptionPane.showMessageDialog(null, number);

        numbers[0]= 58;

        for (int i : numbers) {//For Each loop (for int i in numbers)
            JOptionPane.showMessageDialog(null, i);
        }
        
    }
    public static void main(String[] args) {
        Arreglo2 foo = new Arreglo2();
        foo.principle();
    }
}