package febrary16.audio.processing;

import febrary16.entities.Track;

/**
 * Created by Максим on 15.02.2017.
 */
public final class Flac implements Player {

    private static Track audioTrack;

    private Flac() {
    }

    private static class FlacHandler {
        private final static Flac INSTANCE = new Flac();
    }

    public static Player getInstance(Track track) {
        audioTrack = track;
        return FlacHandler.INSTANCE;
    }

    @Override
    public byte[] readAudioBytes() {
        return new byte[0];
    }
}
