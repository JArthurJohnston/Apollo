package com.paratussoftware.apollo.musical.serialization;

import com.paratussoftware.apollo.musical.Instrument;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

public class Luthier {

    public static final Instrument NULL_INSTRUMENT = new Instrument("NONE", new LinkedList<>());
    private static final String INSTRUMENT_FILE_NAME = "./res/instrument.apollo";

    public void writeInstrument(final Instrument instrument, final String fileName) {
        try {
            final JAXBContext noteContext = JAXBContext.newInstance(Instrument.class);
            final Marshaller marshaller = noteContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(instrument, new File(fileName));
        } catch (final JAXBException e) {
            e.printStackTrace();
        }
    }

    public Instrument readInstrument() {
        return readInstrument(INSTRUMENT_FILE_NAME);
    }

    public Instrument readInstrument(final String filename) {
        try {
            final JAXBContext noteContext = JAXBContext.newInstance(Instrument.class);
            final Unmarshaller unmarshaller = noteContext.createUnmarshaller();
            return (Instrument) unmarshaller.unmarshal(new FileReader(filename));
        } catch (final JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return NULL_INSTRUMENT;
    }
}
