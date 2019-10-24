package fr.miage.main;

import fr.miage.gui.GUI;
import fr.miage.io.IO;

import java.util.Arrays;

/**
 * Main: classe contenant l'application en elle même
 */
public class Main
{
    public static void main( String[] args )
    {
        Plateau sudoku;
        IO io=new IO();
        GUI gui=new GUI();
        char[][] grille = null;
        String[] idCoup; //pour récupérer ce qui a été entré sur la console
        String coupNombre; //si le coup entré sur la console est une série de chiffres, on les stocke dans cette variable

        if(args.length>0) grille=io.load(args[0]); //un chemin vers un fichier est précisé en paramètre
        else grille=io.load(""); //on va charger une grille depuis resources

        sudoku=new Plateau(grille);

        while(!sudoku.isCompleted(sudoku.getGrille()))
        {
            gui.afficherGrille(sudoku.getGrille());
            idCoup= new Coup(gui.getCoupJoue()).getId();

            if(idCoup.length==0)
            {
                gui.error("Le coup joué n'est pas valide.");
            }
            else
            {
                switch(idCoup[0])
                {
                    case "save": io.save(sudoku.getGrille(),idCoup[1]); break;
                    case "load": sudoku.setGrille(io.load(idCoup[1])); break;
                    case "exit": System.exit(0); break;
                    default:  coupNombre=Arrays.toString(idCoup);
                        coupNombre=coupNombre.substring(1,coupNombre.length()-1);
                        sudoku.jouerCoup(sudoku.getGrille(), coupNombre); break;
                }

            }

        }

    }
}
