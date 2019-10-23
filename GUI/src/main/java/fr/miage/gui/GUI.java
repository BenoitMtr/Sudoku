package fr.miage.gui;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Label;
import com.indvd00m.ascii.render.elements.Table;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class GUI
{
    public GUI()
    {

    }

    public void afficherGrille(char[][] grille)
    {
        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(50).height(30);
        Table table = new Table(9, 9);

        for(int row=0;row<9;row++)
        {
            for(int col=0;col<9;col++)
            {
                table.setElement(col+1,row+1,new Label(Character.toString(grille[row][col])));
            }
        }
        builder.element(table);
        ICanvas canvas = render.render(builder.build());
        String s = canvas.getText();
        System.out.println(s);
    }

    public String[] getCoupJoue()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Entrez votre coup, dans l'ordre 'ligne, colonne, chiffre':");
        String[] coup=scanner.nextLine().split(" ");

        try
        {
            if(Integer.parseInt(coup[0])!=0 && coup[0].length()!=3) coup[0]="";

        }
        catch(NumberFormatException e)
        {
        }

        return coup;
    }

    public void error(String message)
    {
        System.out.println(message);
    }

}
