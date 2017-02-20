package febrary16.audio.processing;

import febrary16.entities.Track;

/**
 * Created by Максим on 15.02.2017.
 */
public final class MP3 implements Player {

    private static Track audioTrack;

    private MP3() {
    }

    private static class MP3Handler {
        private final static MP3 INSTANCE = new MP3();
    }

    public static Player getInstance(Track track) {
        audioTrack = track;
        return MP3Handler.INSTANCE;
    }

    @Override
    public byte[] readAudioBytes() {
        return new byte[0];
    }
}
