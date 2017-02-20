package febrary16.audio.processing;

import febrary16.entities.Track;

import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Created by Максим on 16.02.2017.
 */
public class PlayerManager implements Runnable{
    private boolean isPlay;
    private boolean isPause;
    private boolean isTrackPicked;
    private Track currentSong;
    private PlayerFactory playerFactory;
    private byte[] bytes;

    public PlayerManager() {
        isPlay = false;
        isPause = false;
        isTrackPicked = false;
        playerFactory = new PlayerFactory();
    }

    public void pickTrack(Track track) throws UnsupportedAudioFileException {
        currentSong = track;
        bytes = playerFactory.getPlayer(track).readAudioBytes();
        isTrackPicked = true;
    }

    public void play() {
        if (isPause) {
            System.out.println("Continue playing: " + currentSong);
            isPlay = true;
            isPause = false;
        } else {
            if (!isPlay) {
                System.out.println("Now playing: " + currentSong);
                isPlay = true;
            } else {
                System.out.println("Music already playing");
            }
        }
    }

    public void pause() {
        if (isPlay) {
            System.out.println("Music has been paused");
            isPlay = false;
            isPause = true;
        } else {
            System.out.println("Music not playing");
        }
    }

    public void stop() {
        if (isPlay || isPause) {
            System.out.println("Music stopped");
            isPlay = false;
            isPause = false;
            isTrackPicked = false;
        } else {
            System.out.println("Music is not playing");
        }
    }

    public boolean isTrackPicked() {
        return isTrackPicked;
    }

    @Override
    public void run() {

    }
}
