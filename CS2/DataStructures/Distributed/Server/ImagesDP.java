import java.io.File;

import javax.swing.ImageIcon;

/**
 * imagesDP
 */
public class ImagesDP {

    private ImagesDP previous, next;
    private File imageName;

    public ImagesDP(File imageName) {
        this.imageName = imageName;
    }

    public void setNext(ImagesDP imagesDP) {
        this.next = imagesDP;
    }

    public void setPrevious(ImagesDP imagesDP) {
        this.previous = imagesDP;
    }

    public ImagesDP getNext() {
        return this.next;
    }

    public ImagesDP getPrevious() {
        return this.previous;
    }

    public File getImage(){
        return this.imageName;
    }
}