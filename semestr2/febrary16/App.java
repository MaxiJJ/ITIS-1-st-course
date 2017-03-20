package febrary16;

import febrary16.audio.processing.PlayerManager;
import febrary16.data.MusicStorage;
import febrary16.ui.ConsoleUserInteractor;
import febrary16.ui.UserInteractor;
import febrary16.ui.UserInteractorReadException;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by Максим on 14.02.2017.
 */
public class App extends Application {
    private MusicStorage musicStorage;
    private UserInteractor userInteractor;
    private PlayerManager playerManager;

    public App(String[] args) {
        super(args);
    }

    public static void main(String[] args) {
        new App(args);
    }

    @Override
    public void init() {
        userInteractor = new ConsoleUserInteractor();
        musicStorage = new MusicStorage();
        playerManager = new PlayerManager();
    }

    @Override
    public void start() {
        try {
            changeDirectory();

            String command;
            while (true) {
                userInteractor.print("Enter the command: ");
                command = userInteractor.readCommand();
                switch (command) {
                    case ("exit"):
                        System.out.print("Close the program");
                        System.exit(0);
                        break;
                    case ("play"):
                        if (!playerManager.isTrackPicked()) {
                            int trackNum = userInteractor.readTrackNumber();
                            playerManager.pickTrack(musicStorage.get(trackNum));
                        }
                        playerManager.play();
                        break;
                    case ("pause"):
                        playerManager.pause();
                        break;
                    case ("stop"):
                        playerManager.stop();
                        break;
                    case ("add"):
                        userInteractor.print("Enter the path to track: ");
                        File path = new File(userInteractor.readCommand());
                        musicStorage.add(path.toURI());
                        break;
                    case ("delete"):
                        int trackNum = userInteractor.readTrackNumber();
                        musicStorage.delete(musicStorage.get(trackNum));
                        break;
                    case ("sortByTitle"):
                        musicStorage.sortByTitle();
                        break;
                    case ("sortByDuration"):
                        musicStorage.sortByDuration();
                        break;
                    case ("sortByComposer"):
                        musicStorage.sortByComposer();
                        break;
                    case ("searchByName"):
                        userInteractor.print("Enter the keyword: ");
                        String keyword = userInteractor.readCommand();
                        userInteractor.print(musicStorage.searchByName(keyword).getTitle());
                        break;
                    case ("searchByComposer"):
                        userInteractor.print("Enter the keyword: ");
                        String composerName = userInteractor.readCommand();
                        userInteractor.print(musicStorage.searchByComposer(composerName).getTitle());
                        break;
                    case ("create playlist"):
                        musicStorage.createPlaylist();
                        break;
                    case ("change music directory"):
                        changeDirectory();
                        break;
                    default:
                        System.out.println("Unknown command");
                        break;
                }
            }
        } catch (UserInteractorReadException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("Incorrect path: " + e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Such type of music is unavailable: " + e.getMessage());
        }
    }

    private void changeDirectory() throws UserInteractorReadException, URISyntaxException {
        userInteractor.print("Enter the path to music directory: ");
        File path = new File(userInteractor.readCommand());
        musicStorage.clear();
        musicStorage.add(path.toURI());
    }


}
