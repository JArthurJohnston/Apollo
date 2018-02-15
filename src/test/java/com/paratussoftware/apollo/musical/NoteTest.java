package com.paratussoftware.apollo.musical;

import org.junit.Test;

import static org.junit.Assert.*;

public class NoteTest {

    @Test
    public void testConstruction() {
        final Note note = new Note("C", 750, 775);

        assertEquals("C", note.getName());
        assertEquals(750, note.getLowerRange());
        assertEquals(775, note.getUpperRange());
    }

    @Test
    public void testNullNote() {
        assertEquals("", Note.NULL.getName());
        assertEquals(0, Note.NULL.getLowerRange());
        assertEquals(0, Note.NULL.getUpperRange());
    }


}