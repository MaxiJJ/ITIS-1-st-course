package febrary16.audio.processing;

import febrary16.entities.Track;

import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Created by Максим on 16.02.2017.
 */
public class PlayerFactory {

    public Player getPlayer(Track track) throws UnsupportedAudioFileException {
        final String format = track.getFormat();

        switch (format) {
            case "mp3":
                return MP3.getInstance(track);
            case "wav":
                return Wav.getInstance(track);
            case "flac":
                return Flac.getInstance(track);
        }

        throw new UnsupportedAudioFileException();
    }
}
