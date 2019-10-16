package fr.miage.main;

import fr.miage.io.IO;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        System.out.println("Chargement de la grille. . .");
        if(args.length>0) IO.load(args[0]);
    else IO.load("src/main/resources/grid.txt");


    }
}
