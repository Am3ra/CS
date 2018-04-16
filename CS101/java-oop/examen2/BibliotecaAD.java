import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;

/**
 * BibliotecaAD
 */
public class BibliotecaAD {
    private BufferedReader archivoIn;
    private Vector vPersonas, vInfo;
    private ImageIcon imageEditorial[];

    private Object[] objectBook;

    public Vector obtenerEditoriales() {
        String str;
        try {
            //Abrir archivo
            archivoIn = new BufferedReader(new FileReader("Editoriales.txt"));

            //Leer datos
            vPersonas = new Vector();
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                // artistas += str + "\n";
                vPersonas.add(str);

            }
            // Cerrar el archivo
            archivoIn.close();

        } catch (FileNotFoundException e) {
            System.out.println("error: " + e);
        } catch (IOException e) {
            System.out.println("error: " + e);
        }

        return vPersonas;
    }

    public Vector obtenerInfo(String editorial) {
        // System.out.println("Called method");
        String str;
        //Abrir archivo
        try {
            archivoIn = new BufferedReader(new FileReader("Libros.txt"));
            vInfo = new Vector();
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                String[] parts = str.split("_");
                if (parts[2].equals(editorial)) {
                    str = "";
                    str += "Titulo: " + parts[0] + "\n";
                    str += "Autor: " + parts[1] + "\n";
                    str += "Editorial: " + parts[2] + "\n";
                    str += "\n";
                    vInfo.add(str);
                }
            }
            archivoIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        //Leer archivo

        //cerrar archivo
        return vInfo;
    }

    public Object[] getBook(String name) {
        String str;
        objectBook = new Object[2];

        try {
            archivoIn = new BufferedReader(new FileReader("Libros.txt"));
            vInfo = new Vector();
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                String[] parts = str.split("_");
                if (parts[0].equals(name)) {
                    str = "";
                    str += "Titulo: " + parts[0] + "\n";
                    str += "Autor: " + parts[1] + "\n";
                    str += "Editorial: " + parts[2] + "\n";
                    str += "\n";
                    objectBook[0] = str;

                    objectBook[1] = new ImageIcon(((new ImageIcon("images/" + parts[0] + ".jpg")).getImage())
                            .getScaledInstance(218, 218, java.awt.Image.SCALE_SMOOTH));
                }
            }

            //check if vector is empty
            if (objectBook[1] == null) {
                objectBook[0] = ("Titulo no encontrado,\n Autor no encontrado,\n Editorial no existe");
                objectBook[1] = new ImageIcon(((new ImageIcon("images/NotToday.jpeg")).getImage())
                        .getScaledInstance(218, 218, java.awt.Image.SCALE_SMOOTH));
            }
            archivoIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        return objectBook;
    }

    public ImageIcon[] obtenerInfoIcons(String editorial) {
        String str;
        //Abrir archivo
        try {
            archivoIn = new BufferedReader(new FileReader("Libros.txt"));
            vInfo = new Vector();
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                String[] parts = str.split("_");
                if (parts[2].equals(editorial)) {
                    vInfo.add(parts[0]);
                }
            }
            archivoIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        imageEditorial = new ImageIcon[vInfo.size()];

        for (int i = 0; i < imageEditorial.length; i++) {
            System.out.println(vInfo.get(i).toString());
            imageEditorial[i] = new ImageIcon(((new ImageIcon("images/" + vInfo.get(i).toString() + ".jpg")).getImage()).getScaledInstance(218, 218,
                    java.awt.Image.SCALE_SMOOTH));
        }
        //cerrar archivo
        return imageEditorial;
    }

    public String getInfo(int bookSelected) {
        System.out.println(vInfo);
        return vInfo.get(bookSelected).toString();
    }

}