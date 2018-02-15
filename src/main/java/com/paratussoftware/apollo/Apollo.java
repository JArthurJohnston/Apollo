package com.paratussoftware.apollo;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchProcessor;
import com.paratussoftware.apollo.musical.Instrument;
import com.paratussoftware.apollo.musical.serialization.Luthier;
import com.paratussoftware.apollo.views.ApolloMainView;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.util.LinkedList;

public class Apollo {

    public static void main(final String[] args) {
        final Instrument instrument = new Luthier().readInstrument();
        System.out.println(instrument.getName());

        final ApolloMainView apolloMainView = new ApolloMainView();
        apolloMainView.setVisible(true);

        System.out.println("lets start ocarina-ing!!!");
        final PitchDetectionHandler pitchDetectionHandler =
                (pitchDetectionResult, audioEvent) -> {
                    final float pitch = pitchDetectionResult.getPitch();
                    if (pitch >= 0) {
                        SwingUtilities.invokeLater(() -> apolloMainView.drawPitch((int) pitch));
                    }
                };
        try {
            final AudioDispatcher audioDispatcher = AudioDispatcherFactory.fromDefaultMicrophone(2048, 0);
            audioDispatcher.addAudioProcessor(new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.YIN,
                    44100, 2048, pitchDetectionHandler));

            final Thread audioThread = new Thread(audioDispatcher);
            audioThread.start();
//            Thread.sleep(5000);
//            audioDispatcher.stop();
        } catch (final LineUnavailableException e) {
            e.printStackTrace();
//        } catch (final InterruptedException e) {
//            e.printStackTrace();
        }
    }
}
