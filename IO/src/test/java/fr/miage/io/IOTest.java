package fr.miage.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IOTest
{
    //TODO test de save
    char[][] testGrille={
            {'8',' ',' ','5',' ','6','3',' ',' ' },
            {'1','6','7',' ',' ','3',' ','4',' ' },
            {'8',' ',' ','5',' ','6','3',' ',' ' },
            {'1','6','7',' ',' ','3',' ','4',' ' },
            {'8',' ',' ','5',' ','6','3',' ',' ' },
            {'1','6','7',' ',' ','3',' ','4',' ' },
            {'8',' ',' ','5',' ','6','3',' ',' ' },
            {'1','6','7',' ',' ','3',' ','4',' ' },
            {'8',' ',' ','5',' ','6','3',' ',' ' }
    };

    char[][] testGrilleLoad;

    boolean boolTest=false;
    IO ioTest=new IO();

    @Test
    public void loadTest()
    {
        //test avec la grille en ressources
        testGrilleLoad=ioTest.load("");
        assertArrayEquals(testGrille[0], testGrilleLoad[0]);

        //test avec le chemin absolu vers un fichier
        testGrilleLoad=ioTest.load("src/test/resources/grid_test.txt");
        assertArrayEquals(testGrille[0], testGrilleLoad[1]);
    }

    @Test
    public void saveTest()
    {
        ioTest.save(testGrille,"src/test/resources/saveTest.txt");
        testGrilleLoad=ioTest.load("src/test/resources/savetest.txt");

        assertArrayEquals(testGrilleLoad,testGrille);
    }
}
