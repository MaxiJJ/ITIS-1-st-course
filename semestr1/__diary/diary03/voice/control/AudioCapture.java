package course1.__diary.diary03.voice.control;


import course1.__diary.diary03.exceptions.AudioCaptureException;
import course1.__diary.diary03.voice.util.Utilities;

import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;

public class AudioCapture implements Runnable {

    private boolean isCapture;

    private AudioFormat audioFormat;
    private TargetDataLine targetDataLine;

    private byte[] buffer;
    private ByteArrayOutputStream out; //Thread safe stream


    public boolean isCapture() {
        return isCapture;
    }

    public AudioCapture() throws AudioCaptureException {

        try {

            audioFormat = Utilities.getMicFormat();
            isCapture = true;
            targetDataLine = (TargetDataLine) AudioSystem.getLine(
                    new DataLine.Info(
                            TargetDataLine.class,
                            Utilities.getMicFormat()));
            
            targetDataLine.open(audioFormat);
            targetDataLine.start();

            buffer = new byte[(int) (audioFormat.getFrameSize() * audioFormat.getSampleRate())];

            out = new ByteArrayOutputStream();

            Thread t = new Thread(this);
            t.start();
        } catch (LineUnavailableException e) {
            throw new AudioCaptureException("Can't capture audio : " + e.getMessage());
        }
    }


    public byte[] getAudioBytes() {
        return out.toByteArray();
    }

    public long getLength() {

        return out.size();
    }


    public void setCapture(boolean capture) {
        isCapture = capture;
    }


    private void writeData() {
        int count = targetDataLine.read(buffer, 0, buffer.length);
        if (count > 0) {
            out.write(buffer, 0, count);
        }
    }


    @Override
    public void run() {

        while (isCapture) {

            writeData();
        }

    }


}