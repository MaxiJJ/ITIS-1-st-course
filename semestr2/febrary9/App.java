package febrary9;

import febrary9.data.Db;
import febrary9.data.DbException;
import febrary9.data.FileDb;
import febrary9.data.MemoryStorage;
import febrary9.utils.*;

import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by Максим on 09.02.2017.
 */
public class App extends Application {

    protected UserInteractor terminal;
    protected Db db;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new App(args);
    }

    public App(String[] args) {
        super(args);
    }

    @Override
    public void init() {
        try {
            this.terminal = new ConsoleUserInteractor();
            this.db = new MemoryStorage();
        } catch (UserInteractorException ex) {
            System.out.println("Couldn't start application due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void start() {
        try {
            String command;
            while ((command = this.terminal.readCommand()) != null) {
                switch (command) {
                    case "readAll":
                        this.terminal.print(Arrays.toString(this.db.findAll()));
                        break;
                    case "save":
                        if ((command = this.terminal.readCommand()) != null) {
                            this.db.save(command);
                        }
                        break;
                    default:
                        this.terminal.print("Unkown command");
                }
//        this.terminal.print(command);
            }
        } catch (UserInteractorReadException ex) {
            System.out.println("Can't read user input due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        } catch (UserInteractorWriteException ex) {
            System.out.println("Can't print data to user due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        } catch (DbException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }

}
