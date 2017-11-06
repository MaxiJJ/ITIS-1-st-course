package course1.april25;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class Player {
    public static void playSound(Integer[] sound) {
        try {
            Synthesizer synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            MidiChannel[] channels = synthesizer.getChannels();

            channels[0].programChange(sound[3]);
            channels[0].noteOn(sound[1], sound[2]);
            Thread.sleep(sound[0]);
            channels[0].noteOff(sound[1]);

            synthesizer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
