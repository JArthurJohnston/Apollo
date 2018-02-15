package com.paratussoftware.apollo.musical.serialization;

import com.paratussoftware.apollo.musical.Melody;

import java.io.*;

public class SongWriter {


    public void write(final Melody melody, final String fileName) {
        try {
            final FileWriter fileWriter = new FileWriter(new File(fileName));
            fileWriter.write(melody.toString());
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public Melody read(final String songFileName) {
        try {
            final FileReader fileReader = new FileReader(new File(songFileName));
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
            final String melodyName = bufferedReader.readLine();
            final String tabsLine = bufferedReader.readLine();
            return new Melody(melodyName, new Melody.Tab[0]);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
