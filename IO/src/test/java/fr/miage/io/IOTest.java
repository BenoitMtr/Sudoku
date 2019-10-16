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
        boolTest=IO.load("src/test/java/fr/miage/io/grid_test.txt");
        assertEquals(true, boolTest);
    }
}
