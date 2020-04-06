package com.andb.csa.notes.audio;

import com.andb.csa.library.audio.StdAudio;

public class StdAudioTest {
    public static void main(String[] args) throws InterruptedException {
        double baseFreq = 277.18;
        int[] steps = {2, 2, 7, 9, 10, 9, 10, 9, 7, 5};
        double[] rests = {.5, 0.1, 0.25, 0.25, 0.25, 2, 0.25, 0.25, 0.25, 0.25};
        for (int j = 0; j < 40; j++) {
            for (int i = 0; i < steps.length; i++) {
                double hz = baseFreq * Math.pow(2, steps[i] / 12.0);
                StdAudio.play(StdAudio.note(hz, 0.2, 0.3));
                Thread.sleep((int) (rests[i] * 1000));
            }
        }
    }
}
