package com.paratussoftware.apollo.musical;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;

@XmlRootElement
public class Instrument {
    @XmlElement
    private String name;
    @XmlElement
    private LinkedList<Note> notes;

    private Instrument() {
    }

    public Instrument(final String name, final LinkedList<Note> notes) {
        this.name = name;
        this.notes = notes;
    }

    public String getName() {
        return this.name;
    }

    public LinkedList<Note> getNotes() {
        return this.notes;
    }

    public Note findNote(final float pitch) {
        for (final Note note : this.notes) {
            if (note.getLowerRange() <= pitch && note.getUpperRange() >= pitch) {
                return note;
            }
        }
        return Note.NULL;
    }
}
