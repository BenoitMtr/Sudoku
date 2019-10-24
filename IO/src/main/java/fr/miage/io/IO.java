package fr.miage.io;

import fr.miage.gui.GUI;

import java.io.*;

/**
 * IO: Classe chargée des entrées sorties sur le disque
 */
public class IO
{

    public IO()
    {

    }
    /**
     * load: permet de charger une grille de sudoku, depuis un fichier txt dont le lien est précisé en paramètre, ou depuis les ressources du projet
     * @param path
     * @return la grille chargée depuis le fichier/ressource
     */
    public char[][] load(String path)
    {
        char[][] tmpGrille = new char[9][9];

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

                    //on skip les caractères invisibles
                    while (!Character.isDigit(current) && current != '_') {
                        current = (char) reader.read();
                    }

                    if (current == '_') current = ' ';

                    tmpGrille[row][col] = current;
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
                return new char[9][9];
            }
        }

       else if(path!="" && path.substring(path.length()-3).equals("txt")) //si on veut charger une grille au format txt depuis un fichier
        {
            System.out.println("Chargement de "+path);
            try {
                FileInputStream fis = new FileInputStream(new File(path));

                char current = ' ';
                int row = 0, col = 0;

                while (fis.available() != 0) {
                    current = (char) fis.read();

                    //on skip les caractères invisibles
                    while (!Character.isDigit(current) && current != '_') {
                        current = (char) fis.read();
                    }

                    if (current == '_') current = ' ';

                    tmpGrille[row][col] = current;
                    col++;

                    if (col == 9) {
                        col = 0;
                        row++;
                    }
                    if (row == 9) row = 0;

                }
                fis.close();
            }
            catch(IOException e)
            {
                System.out.println("Chemin incorrect.");
                e.printStackTrace();
                return new char[9][9];
            }
        }
        else
        {
            System.out.println("Type de fichier incorrect, veuillez entrer un lien vers un fichier .txt");
            return new char[9][9];
        }
    return tmpGrille;
    }

    /**
     * save: permet de sauvegarder la grille de sudoku sur laquelle on joue, dans un fichier texte
     * @param grille: la grille sur laquelle on est en train de jouer
     * @param path: le chemin vers le fichier dans lequel on veut sauvegarder notre partie
     */
    public void save(char[][] grille, String path)
    {
        if(!path.substring(path.length()-3).equals("txt"))
        {
            new GUI().error("Le format de fichier choisi n'est pas correct. Veuillez entrer un nom de fichier au format txt.");
        }
        else
        {
            File sauvegarde = new File(path);
            boolean exists = sauvegarde.exists();

            if(exists) //si le fichier indiqué par le chemin existe déjà, on l'ouvre et on le réécrit
            {
                try
                {
                    FileOutputStream fos = new FileOutputStream(new File(path));

                    char current = ' ';

                    for(int row=0;row<9;row++)
                    {
                        for(int col=0;col<9;col++)
                        {
                            current=grille[row][col];
                            if(current==' ') current='_';
                            fos.write(current);
                        }
                        if(row==8)  fos.close();
                        else fos.write('\n');
                    }
                    }
                 catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else //sinon on le crée
            {
                try {
                    sauvegarde.createNewFile();
                    FileOutputStream fos = new FileOutputStream(new File(path));

                    char current = ' ';

                    for(int row=0;row<9;row++)
                    {
                        for(int col=0;col<9;col++)
                        {
                            current=grille[row][col];
                            if(current==' ') current='_';
                            fos.write(current);
                        }
                        if(row==8)  fos.close();
                        else fos.write('\n');
                    }



                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
