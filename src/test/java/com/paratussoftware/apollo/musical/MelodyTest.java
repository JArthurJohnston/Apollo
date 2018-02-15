package com.paratussoftware.apollo.musical;

import org.junit.Test;

import static com.paratussoftware.apollo.musical.Melody.Tab.*;
import static org.junit.Assert.*;

public class MelodyTest {

    @Test
    public void testConstruction() throws Exception {
        final String expectedName = "Summon the Dragon Zord!!";
        final Melody melody = new Melody(expectedName, G, D, F, G, A, G);

        assertEquals(expectedName, melody.getName());
        assertEquals(6, melody.getTabs().length);

        assertEquals(G, melody.getTabs()[0]);
        assertEquals(D, melody.getTabs()[1]);
        assertEquals(F, melody.getTabs()[2]);
        assertEquals(G, melody.getTabs()[3]);
        assertEquals(A, melody.getTabs()[4]);
        assertEquals(G, melody.getTabs()[5]);
    }

    @Test
    public void testToString() throws Exception {
        final String expectedName = "Summon the Dragon Zord!!";
        final Melody dragonZordSummonJingle = new Melody(expectedName, G, D, F, G, A, G);
        final String expectedMelodyTabs = expectedName + "\nG D F G A G";

        assertEquals(expectedMelodyTabs, dragonZordSummonJingle.toString());
    }


}