package fr.miage.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.indvd00m.ascii.render.elements.Table;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class IOTest
{

    boolean boolTest=false;

    @Test
    public void loadTest()
    {
        //test avec la grille en ressources
        boolTest=IO.load("");
        assertEquals(true, boolTest);

        //test avec le chemin absolu vers un fichier
        boolTest=IO.load("src/test/resources/grid_test.txt");
        assertEquals(true,boolTest );
    }
}
