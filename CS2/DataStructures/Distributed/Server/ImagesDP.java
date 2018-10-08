import javax.swing.ImageIcon;

/**
 * imagesDP
 */
public class ImagesDP {

    private ImagesDP previous, next;
    private ImageIcon image;

    public ImagesDP(ImageIcon imageIcon) {
        this.image = imageIcon;
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

    public ImageIcon getImage(){
        return this.image;
    }
}