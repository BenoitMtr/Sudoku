package fr.miage.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MainTest
{

    char[][] testGrille={
            {'8',' ',' ','5',' ','6','3',' ',' ' },
            {' ',' ','3','2','4',' ',' ',' ','8' },
            {'1','6','7',' ',' ','3',' ','4',' ' },
            {'8',' ',' ','5',' ','6','3',' ',' ' },
            {' ',' ','3','2','4',' ',' ',' ','8' },
            {'1','6','7',' ',' ','3',' ','4',' ' },
            {'8',' ',' ','5',' ','6','3',' ',' ' },
            {' ',' ','3','2','4',' ',' ',' ','8' },
            {'1','6','7',' ',' ','3',' ','4',' ' }
    };

    @Test
    public void verifCoupTest()
    {
        boolean testVerif=Main.verifCoup(testGrille,1,2,9);
        assertEquals(true,testVerif);
    }

    @Test
    public void isCompletedTest()
    {
        assertEquals(false,Main.isCompleted(testGrille));
    }
}
