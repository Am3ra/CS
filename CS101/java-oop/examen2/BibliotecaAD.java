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
                    str+="Titulo: " + parts[0]+"\n";
                    str+="Autor: " + parts[1] + "\n";
                    str+="Editorial: " + parts[2]+"\n";
                    str+="\n";
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
            imageEditorial[i] = new ImageIcon(getClass().getResource("images/" + vInfo.get(i).toString() + ".jpg"));
        }
        //cerrar archivo
        return imageEditorial;
    }
    
    public String getInfo(int bookSelected) {
        System.out.println(vInfo);
        return vInfo.get(bookSelected).toString();
    }
    
}