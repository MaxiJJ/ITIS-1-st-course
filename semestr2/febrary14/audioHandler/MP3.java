package febrary14.audioHandler;

import febrary14.data.MusicStorage;

/**
 * Created by Максим on 15.02.2017.
 */
public class MP3 implements Player {
    private boolean isPlay = false;
    private boolean isPause = false;
    private boolean isTrackPicked = false;
    private MusicStorage musicStorage;
    private String currentSong;

    public MP3(MusicStorage musicStorage) {
        this.musicStorage = musicStorage;
    }

    @Override
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

    @Override
    public void pause() {
        if (isPlay) {
            System.out.println("Music has been paused");
            isPlay = false;
            isPause = true;
        } else {
            System.out.println("Music not playing");
        }
    }

    @Override
    public void stop() {
        if (isPlay || isPause) {
            System.out.println("Music stopped");
            isPlay = false;
            isTrackPicked = false;
        } else {
            System.out.println("Music is not playing");
        }
    }

    @Override
    public void pickTrack(int numberOfTrack) {
        currentSong = musicStorage.scan().get(numberOfTrack - 1).getTitle();
        isTrackPicked = true;
    }

    @Override
    public boolean isTrackPicked() {
        return isTrackPicked;
    }
}
