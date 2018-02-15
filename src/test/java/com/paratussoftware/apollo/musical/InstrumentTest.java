package com.paratussoftware.apollo.musical;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class InstrumentTest {

    @Test
    public void testConstruction() throws Exception {
        final LinkedList<Note> notes = new LinkedList<>();

        final Instrument instrument = new Instrument("Ocarina", notes);

        assertEquals("Ocarina", instrument.getName());
        assertSame(notes, instrument.getNotes());
    }

    @Test
    public void testCanPlay() throws Exception {
        final LinkedList<Note> notes = new LinkedList<>();
        final Note expectedNote = new Note("C", 5, 10);
        notes.add(expectedNote);

        final Instrument instrument = new Instrument("Ocarina", notes);

        assertEquals(expectedNote, instrument.findNote(7));
        assertEquals(expectedNote, instrument.findNote(5));
        assertEquals(expectedNote, instrument.findNote(10));

        assertEquals(Note.NULL, instrument.findNote(11));
        assertEquals(Note.NULL, instrument.findNote(4));
    }


}