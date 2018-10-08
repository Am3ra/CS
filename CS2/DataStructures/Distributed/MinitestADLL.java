import javax.swing.ImageIcon;
import java.io.*;
import java.util.LinkedList;


/**
 * MinitestAD
 */
public class MinitestADLL{

    private File folder = new File("images");
    private File[] listOfFiles = folder.listFiles();
    public ImagesDP firstDP,currentDP,lastDP;
    public LinkedList listaCool = new LinkedList();;

    public MinitestADLL() {
        for(int i = 0;i<listOfFiles.length;i++){
            appendDP(new ImageIcon("images/" + listOfFiles[i].getName()));
            System.out.println(listOfFiles[i].getName());
        }
    }

    private void appendDP(ImageIcon image) {
        listaCool.add(new ImagesDP(image));
    }
}