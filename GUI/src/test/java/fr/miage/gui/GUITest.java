package fr.miage.gui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * Unit test for simple App.
 */
public class GUITest
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void getCoupJoueTest()
    {
        ByteArrayInputStream in = new ByteArrayInputStream("129".getBytes());
        System.setIn(in);

        assertEquals("129",GUI.getCoupJoue());
    }

}
