package fr.miage.io;

import java.io.*;

/**
 * Hello world!
 *
 */
public class IO
{
    static char[][] grille = new char[9][9];

    /**
     * load: permet de charger une grille de sudoku, depuis un fichier txt dont le lien est précisé en paramètre
     * @param path
     * @return boolean that indicates if the load succeeded
     */
    public static boolean load(String path)
    {

        if(path=="") //quand on veut charger une grille depuis resources
        {
            InputStream is = IO.class.getResourceAsStream("/grid.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            try {
                char current = ' ';
                int value=0;
                int row = 0, col = 0;
                while ((value=reader.read())!=-1) {
                    current = (char) value;

                    while (!Character.isDigit(current) && current != '_') {
                        current = (char) reader.read();
                    }

                    if (current == '_') current = ' ';

                    grille[row][col] = current;
                    col++;

                    if (col == 9) {
                        col = 0;
                        row++;
                    }
                    if (row == 9) row = 0;

                }
            }
            catch(IOException e)
            {
                System.out.println("Chemin incorrect pour grille resources.");
                e.printStackTrace();
                return false;
            }
        }

       else if(path!="" && path.substring(path.length()-3).equals("txt"))
        {
            try {
                FileInputStream fis = new FileInputStream(new File(path));

                char current = ' ';
                int row = 0, col = 0;
                while (fis.available() > 0) {
                    current = (char) fis.read();

                    while (!Character.isDigit(current) && current != '_') {
                        current = (char) fis.read();
                    }

                    if (current == '_') current = ' ';

                    grille[row][col] = current;
                    col++;

                    if (col == 9) {
                        col = 0;
                        row++;
                    }
                    if (row == 9) row = 0;


                }
            }
            catch(IOException e)
            {
                System.out.println("Chemin incorrect.");
                e.printStackTrace();
                return false;
            }
        }
        else
        {
            System.out.println("Type de fichier incorrect, veuillez entrer un lien vers un fichier .txt");
            return false;
        }
    return true;
    }

   public static char[][] getGrille()
    {
        return grille;
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
