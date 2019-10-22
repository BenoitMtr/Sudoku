package fr.miage.main;

import fr.miage.gui.GUI;
import fr.miage.io.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class Main
{
    public static boolean verifCoup(char[][] grille, int ligne, int colonne, int chiffre)
    { int rowZone,colZone;
        //boucles for pour vérifier sur ligne et colonne
        for(int col=0;col<9;col++)
        {
            if(Character.getNumericValue(grille[ligne][col])==chiffre) return false;
        }
        for(int row=0;row<9;row++)
        {
            if(Character.getNumericValue(grille[row][colonne])==chiffre) return false;
        }

       //détermination de la zone où tester la validité du coup
        if(ligne<=2) rowZone=0; //cas où on est dans la première zone
        else rowZone=ligne-(ligne-3); //cas où on est dans une des 8 autres zones

        if(colonne<=2) colZone=0;
        else colZone=colonne-(colonne-3);

        //boucles for pour vérifier sur zone 3x3
        for(int zoneR=rowZone;zoneR<(rowZone+3);zoneR++)
        {
            for(int zoneC=colZone;zoneC<(colZone+3);zoneC++)
            {
                if(Character.getNumericValue(grille[zoneR][zoneC])==chiffre) return false;
            }
        }

        return true;
    }

    public static boolean isCompleted(char[][] grille)
    {
        for(int row=0;row<9;row++)
        {
            for(int col=0;col<9;col++)
            {
                if(!Character.isDigit(grille[row][col])) return false;
            }
        }
        return true;
    }

    public static void main( String[] args )
    {
        int selecLigne,selecCol,chiffre;
        char[][] grille = null;
        String coup;

        System.out.println("Chargement de la grille. . .");
        if(args.length>0) IO.load(args[0]);
        else IO.load("");
        grille=IO.getGrille();

        while(!isCompleted(grille))
        {
            GUI.afficherGrille(grille);
            coup= GUI.getCoupJoue();
            selecLigne=Character.getNumericValue(coup.charAt(0));
            selecCol=Character.getNumericValue(coup.charAt(1));
            chiffre=Character.getNumericValue(coup.charAt(2));

            boolean valide=verifCoup(grille,selecLigne-1,selecCol-1,chiffre);

            if(valide) grille[selecLigne-1][selecCol-1]= (char)(chiffre+'0');
            else GUI.error("Le coup entré n'est pas valide, veuillez en entrer un autre.");
}

    }
}
