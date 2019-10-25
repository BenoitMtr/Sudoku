package fr.miage.main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateauTest {

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

    char[][] testGrilleFull={
            {'8','1','1','5','1','6','3','1','1' },
            {'1','1','3','2','4','1','1','1','8' },
            {'1','6','7','1','1','3','1','4','1' },
            {'8','1','1','5','1','6','3','1','1' },
            {'1','1','3','2','4','1','1','1','8' },
            {'1','6','7','1','1','3','1','4','1' },
            {'8','1','1','5','1','6','3','1','1' },
            {'1','1','3','2','4','1','1','1','8' },
            {'1','6','7','1','1','3','1','4','1' },
    };


    Plateau plateauTest=new Plateau(testGrille);
    String coupTest="129";

    @Test
    public void verifCoupTest()
    {
        boolean testVerif=plateauTest.verifCoup(plateauTest.getGrille(),1,2,9);
        assertEquals(true,testVerif);

        testVerif=plateauTest.verifCoup(plateauTest.getGrille(),1,2,8);
        assertEquals(true, testVerif);
    }

    @Test
    public void isCompletedTest()
    {
        assertEquals(false,plateauTest.isCompleted(plateauTest.getGrille()));
        plateauTest.setGrille(testGrilleFull);
        assertEquals(false,plateauTest.isCompleted(plateauTest.getGrille()));
    }

    @Test
    public void jouerCoupTest()
    {
        plateauTest.setGrille(testGrille);
        plateauTest.jouerCoup(plateauTest.getGrille(),coupTest);
        assertEquals('5',testGrille[0][1]);
    }
}
