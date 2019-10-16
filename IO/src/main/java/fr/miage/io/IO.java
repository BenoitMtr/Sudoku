package fr.miage.io;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Label;
import com.indvd00m.ascii.render.elements.Table;
import fr.miage.gui.GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class IO
{
    /**
     * load: permet de charger une grille de sudoku, depuis un fichier txt dont le lien est précisé en paramètre
     * @param path
     * @return boolean that indicates if the load succeeded
     */
    public static boolean load(String path)
    {
        if(path.substring(path.length()-3).equals("txt"))
        {
            IRender render = new Render();
            IContextBuilder builder = render.newBuilder();
            builder.width(50).height(30);
            Table table = new Table(9, 9);
            try
            {
                FileInputStream fis = new FileInputStream(new File(path));

                char current=' ';
                int row=1, col=1;
                while (fis.available() > 0) {
                    current = (char) fis.read();

                    while(!Character.isDigit(current) && current!='_')
                    {
                        current=(char) fis.read();
                    }

                    if(current=='_') current=' ';
                    if(row>table.getRows()) row=1;
                    if(col>table.getColumns())
                    {
                        col-=table.getColumns();
                        row++;
                    }

                    table.setElement(col,row,new Label(Character.toString(current)));
                    col++;
                }
                builder.element(table);
                ICanvas canvas = render.render(builder.build());
                String s = canvas.getText();
                GUI.afficherGrille(s);
            }
            catch(IOException e)
            {
                System.out.println("Chemin incorrect.");
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

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
