package febrary16.ui;

/**
 * Created by Максим on 14.02.2017.
 */
public interface UserInteractor {
    String readCommand() throws UserInteractorReadException;
    int readTrackNumber();
    void print(String output);
}
