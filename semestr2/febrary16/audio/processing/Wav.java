package febrary16.audio.processing;

import febrary16.entities.Track;

/**
 * Created by Максим on 15.02.2017.
 */
public final class Wav implements Player {

    private static Track audioTrack;

    private Wav() {
    }

    private static class WavHandler {
        private final static Wav INSTANCE = new Wav();
    }

    public static Player getInstance(Track track) {
        audioTrack = track;
        return WavHandler.INSTANCE;
    }

    @Override
    public byte[] readAudioBytes() {
        return new byte[0];
    }

}
