package com.paratussoftware.apollo.musical.serialization;

import com.paratussoftware.apollo.musical.Melody;
import org.junit.Test;

import static com.paratussoftware.apollo.musical.Melody.Tab.*;
import static org.junit.Assert.*;

public class SongWriterTest {

    @Test
    public void testReadAndWriteMelody() {
        final SongWriter songWriter = new SongWriter();
        final String expectedMelodyName = "Go Go Power Rangers";
        final Melody powerRangersJingle = new Melody(expectedMelodyName, E, E, D, E, G, E);

        final String songFileName = "./resources/ranger.melody";
        songWriter.write(powerRangersJingle, songFileName);

        final Melody songFromFile = songWriter.read(songFileName);

        assertEquals(expectedMelodyName, songFromFile.getName());
    }
}
