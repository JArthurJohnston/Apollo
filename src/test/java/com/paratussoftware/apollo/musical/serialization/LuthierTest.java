package com.paratussoftware.apollo.musical.serialization;

import com.paratussoftware.apollo.musical.Instrument;
import com.paratussoftware.apollo.musical.Note;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class LuthierTest {

    @Test
    public void testReadAndWriteInstrument() {
        final Luthier beethoven = new Luthier();

        final Instrument mockInstrument = createMockInstrument();

        beethoven.writeInstrument(mockInstrument, "./testRes/instrument.apollo");

        final Instrument instrumentFromFile = beethoven.readInstrument("./testRes/instrument.apollo");

        assertEquals("Boromir's Horn", instrumentFromFile.getName());
        final List<Note> notes = instrumentFromFile.getNotes();
        assertEquals(3, notes.size());

        final Note cNote = notes.get(0);
        assertEquals("C", cNote.getName());
        assertEquals(444, cNote.getLowerRange());
        assertEquals(555, cNote.getUpperRange());

        final Note dNote = notes.get(1);
        assertEquals("D", dNote.getName());
        assertEquals(666, dNote.getLowerRange());
        assertEquals(777, dNote.getUpperRange());

        final Note eNote = notes.get(2);
        assertEquals("E#", eNote.getName());
        assertEquals(888, eNote.getLowerRange());
        assertEquals(999, eNote.getUpperRange());
    }

    @Test
    public void testReadDefaultInstrument() {
        final Luthier beethoven = new Luthier();

        final Instrument instrumentFromFile = beethoven.readInstrument();

        assertEquals("Dragon Dagger Ocarina", instrumentFromFile.getName());
        final List<Note> notes = instrumentFromFile.getNotes();
        assertEquals(7, notes.size());

        final Note cNote = notes.get(0);
        assertEquals("C", cNote.getName());
        assertEquals(527, cNote.getLowerRange());
        assertEquals(555, cNote.getUpperRange());

        final Note dNote = notes.get(1);
        assertEquals("D", dNote.getName());
        assertEquals(584, dNote.getLowerRange());
        assertEquals(596, dNote.getUpperRange());

        final Note eNote = notes.get(2);
        assertEquals("E", eNote.getName());
        assertEquals(647, eNote.getLowerRange());
        assertEquals(669, eNote.getUpperRange());

        final Note fNote = notes.get(3);
        assertEquals("F", fNote.getName());
        assertEquals(691, fNote.getLowerRange());
        assertEquals(715, fNote.getUpperRange());

        final Note gNote = notes.get(4);
        assertEquals("G", gNote.getName());
        assertEquals(759, gNote.getLowerRange());
        assertEquals(777, gNote.getUpperRange());

        final Note gSharpNote = notes.get(5);
        assertEquals("G#", gSharpNote.getName());
        assertEquals(825, gSharpNote.getLowerRange());
        assertEquals(845, gSharpNote.getUpperRange());

        final Note aNote = notes.get(6);
        assertEquals("A", aNote.getName());
        assertEquals(855, aNote.getLowerRange());
        assertEquals(868, aNote.getUpperRange());
    }

    @Test
    public void testNullInstrument() {
        assertEquals("NONE", Luthier.NULL_INSTRUMENT.getName());
        assertTrue(Luthier.NULL_INSTRUMENT.getNotes().isEmpty());
    }

    private Instrument createMockInstrument() {
        final LinkedList<Note> notes = new LinkedList<>();
        notes.add(new Note("C", 444, 555));
        notes.add(new Note("D", 666, 777));
        notes.add(new Note("E#", 888, 999));
        return new Instrument("Boromir's Horn", notes);
    }


}