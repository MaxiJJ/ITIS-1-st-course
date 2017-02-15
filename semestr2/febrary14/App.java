package febrary14;

import febrary14.audioHandler.MP3;
import febrary14.audioHandler.Player;
import febrary14.data.MusicStorage;
import febrary14.ui.ConsoleUserInteractor;
import febrary14.ui.UserInteractor;
import febrary14.ui.UserInteractorReadException;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by Максим on 14.02.2017.
 */
public class App extends Application {
    MusicStorage musicStorage;
    UserInteractor userInteractor;
    Player player;

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
        player = new MP3(musicStorage);
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
                        if (!player.isTrackPicked()) {
                            player.pickTrack(userInteractor.readTrackNumber());
                        }
                        player.play();
                        break;
                    case ("pause"):
                        player.pause();
                        break;
                    case ("stop"):
                        player.stop();
                        break;
                    case ("sort"):
                        musicStorage.sort();
                        break;
                    case ("search"):
                        userInteractor.print("Enter the keyword: ");
                        String keyword = userInteractor.readCommand();
                        userInteractor.print(musicStorage.search(keyword).getTitle());
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
        }
    }

    private void changeDirectory() throws UserInteractorReadException, URISyntaxException {
        userInteractor.print("Enter the path to music directory: ");
        File path = new File(userInteractor.readCommand());
        musicStorage.changeStoragePath(path.toURI());
    }


}
