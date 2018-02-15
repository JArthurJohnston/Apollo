package com.paratussoftware.apollo.musical;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Note {

    public static Note NULL = new Note("", 0, 0);

    @XmlElement
    private String name;
    @XmlElement
    private int lowerRange;
    @XmlElement
    private int upperRange;

    private Note() {
    }

    public Note(final String name, final int lowerRange, final int upperRange) {
        this.name = name;
        this.lowerRange = lowerRange;
        this.upperRange = upperRange;
    }

    public String getName() {
        return this.name;
    }

    public int getLowerRange() {
        return this.lowerRange;
    }

    public int getUpperRange() {
        return this.upperRange;
    }
}
