package fr.miage.main;

import org.junit.jupiter.api.Test;

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

    Plateau plateauTest=new Plateau(testGrille);
    String coupTest="129";

    @Test
    public void verifCoupTest()
    {
        boolean testVerif=plateauTest.verifCoup(testGrille,1,2,9);
        assertEquals(true,testVerif);
    }

    @Test
    public void isCompletedTest()
    {
        assertEquals(false,plateauTest.isCompleted(testGrille));
    }

    @Test
    public void jouerCoupTest()
    {
        plateauTest.jouerCoup(plateauTest.getGrille(),coupTest);
        assertEquals('9',testGrille[0][1]);
    }
}
