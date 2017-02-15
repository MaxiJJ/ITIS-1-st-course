package febrary14.audio.processing;

/**
 * Created by Максим on 15.02.2017.
 */
public interface Player {
    void play();
    void pause();
    void stop();
    void pickTrack(int numberOfTrack);
    boolean isTrackPicked();
}
