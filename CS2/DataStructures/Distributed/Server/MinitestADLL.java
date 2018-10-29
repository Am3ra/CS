import java.io.*;
import java.util.*;

/**
 * MinitestAD
 */
public class MinitestADLL {
    private File folder;
    public File[] listOfFiles;
    public LinkedList listaCool;
    private ArrayList tempList;

    public MinitestADLL() {
        folder = new File("images");
        listOfFiles = folder.listFiles();
        listaCool = new LinkedList(Arrays.asList(listOfFiles));

        try {
            BufferedReader brAlbums = new BufferedReader(new FileReader(new File("Albums.txt")));
            BufferedReader brSongs = new BufferedReader(new FileReader(new File("Songs.txt")));
            String st;
            while ((st = brAlbums.readLine()) != null) {
                System.out.println(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void busquedaArtista(String artista) {
        try {
            BufferedReader brAlbums = new BufferedReader(new FileReader(new File("Albums.txt")));
            String st;
            tempList = new ArrayList();
            System.out.println("NEW ALNBUMS\n\n");
            while ((st = brAlbums.readLine()) != null) {
                if (st.split("_")[0].equals(artista)) {
                    System.out.println(st.split("_")[1] + ".jpg");
                    tempList.add(new File("images/" + st.split("_")[1] + ".jpg"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        listaCool = new LinkedList(tempList);
    }

    public String busquedaAlbum(String album) {
        System.out.println("ENTERED SEARCH: "+album);
        album = album.split("/")[1];
        album = album.split(".jpg")[0];
        System.out.println("NEW album"+album);
        String temp = "";
        try {
            BufferedReader brAlbums = new BufferedReader(new FileReader(new File("Songs.txt")));
            String st;
            System.out.println("NEW SONGS\n\n");
            while ((st = brAlbums.readLine()) != null) {
                if (st.split("_")[0].equals(album)) {
                    System.out.println(st.split("_")[1]);
                    if(temp.equals(""))
                        temp +=  st.split("_")[1];
                    else temp += "&"+st.split("_")[1];
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return temp;
    }

    public void reset() {
        listaCool = new LinkedList(Arrays.asList(listOfFiles));
    }

}