package com.paratussoftware.apollo;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchProcessor;

import javax.sound.sampled.LineUnavailableException;
import java.util.LinkedList;

public class NoteFinder {

    public static void main(final String[] args) {
        System.out.println("Start Playing");
        final LinkedList pitchList = new LinkedList();
        final PitchDetectionHandler pitchDetectionHandler =
                (pitchDetectionResult, audioEvent) -> {
                    final float pitch = pitchDetectionResult.getPitch();
                    if (pitch >= 0) {
                        pitchList.add(pitch);
                    }
                };
        try {

            final AudioDispatcher audioDispatcher = AudioDispatcherFactory.fromDefaultMicrophone(2048, 0);
            audioDispatcher.addAudioProcessor(new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.YIN,
                    44100, 2048, pitchDetectionHandler));

            final Thread audioThread = new Thread(audioDispatcher);
            audioThread.start();
            Thread.sleep(5000);
            audioDispatcher.stop();

            pitchList.sort((o1, o2) -> Float.compare((float) o1, (float) o2));
            System.out.println("Hightst: " + pitchList.getLast());
            System.out.println("Lowest: " + pitchList.getFirst());
        } catch (InterruptedException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
