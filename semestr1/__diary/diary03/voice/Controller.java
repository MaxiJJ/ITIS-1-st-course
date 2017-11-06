package course1.__diary.diary03.voice;

import course1.__diary.diary03.exceptions.AudioCaptureException;
import course1.__diary.diary03.exceptions.AudioPlayException;
import course1.__diary.diary03.exceptions.RecognitionSpeechException;
import course1.__diary.diary03.exceptions.TextRecognitionException;
import course1.__diary.diary03.voice.control.AudioCapture;
import course1.__diary.diary03.voice.control.AudioPlay;

import java.util.ArrayList;

public class Controller {

    private static AudioPlay audioPlay;
    private static AudioCapture audioCapture;

    public static void record() throws AudioCaptureException {
        if (audioPlay != null && audioPlay.isAudioPlay()) {
            throw new AudioCaptureException("At the moment sound playing in");
        }

        audioCapture = new AudioCapture();
    }

    public static void play(String text) throws AudioPlayException, TextRecognitionException {
        if (text == null || text.equals("")) {
            throw new TextRecognitionException("Too few symbols in text");
        }

        //waiting for the audio bytes
        byte[] bytes = SpeechKit.sendGET(text);
        System.out.println("Send");

        audioPlay = new AudioPlay(bytes);
        System.out.println("Play");

    }

    public static ArrayList<String> recognize() throws RecognitionSpeechException {
        if (audioCapture.isCapture()) {
            throw new RecognitionSpeechException("Audio is capturing now");
        }

        if (audioCapture == null) {
            throw new RecognitionSpeechException("Audio isn't captured");
        }

        byte[] data = audioCapture.getAudioBytes();

        if (data.length > 0) {
            return SpeechKit.sendPOST(data);
        } else {
            throw new RecognitionSpeechException("Recorded audio is empty");
        }
    }

    public static void stopCapture() {
        audioCapture.setCapture(false);
    }
}
