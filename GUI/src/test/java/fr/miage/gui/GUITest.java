package fr.miage.gui;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class GUITest
{
    GUI guiTest=new GUI();

    String[] coupTest=new String[2];

    @Test
    public void getCoupJoueTest()
    {
        ByteArrayInputStream in = new ByteArrayInputStream("129".getBytes());
        System.setIn(in);
        coupTest=guiTest.getCoupJoue();

        assertEquals("122",coupTest[0]);

        in = new ByteArrayInputStream("12".getBytes());
        System.setIn(in);
        coupTest=guiTest.getCoupJoue();

        assertEquals("",coupTest[0]);
    }

}
