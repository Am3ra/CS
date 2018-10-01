import javax.swing.ImageIcon;
import java.io.*;


/**
 * MinitestAD
 */
public class MinitestAD{

    private File folder = new File("images");
    private File[] listOfFiles = folder.listFiles();
    public ImagesDP firstDP,currentDP,lastDP;

    public MinitestAD() {
        for(int i = 0;i<listOfFiles.length;i++){
            appendDP(new ImageIcon("images/" + listOfFiles[i].getName()));
            System.out.println(listOfFiles[i].getName());
        }
    }

    private void appendDP(ImageIcon image) {
        
        if (firstDP == null){
            firstDP = new ImagesDP(image);
            firstDP.setPrevious(null);
            firstDP.setNext(null);
            lastDP = firstDP;
        }else{
            lastDP.setNext(new ImagesDP(image));
            lastDP.getNext().setPrevious(lastDP);
            lastDP.getNext().setNext(null);
            lastDP = lastDP.getNext();
        }

    }
}