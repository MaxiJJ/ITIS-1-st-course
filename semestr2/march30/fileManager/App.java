package course1.march30.fileManager;

import course1.march30.fileManager.commands.CommandContext;
import course1.march30.fileManager.commands.exception.CommandException;
import course1.march30.fileManager.commands.exception.CommandNotFoundException;
import course1.march30.fileManager.userInteractor.Console;
import course1.march30.fileManager.userInteractor.ConsoleUserInteractor;
import course1.march30.fileManager.userInteractor.ConsoleUserPrinter;

public class App {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Console console = new ConsoleUserInteractor();

        while (true) {
            ConsoleUserPrinter.enterCommand();
            String command = console.getCommand();
            if (command == null) break;

            try {
                CommandContext.getInstance().executeCommand(command);
            } catch (CommandNotFoundException e) {
                ConsoleUserPrinter.printErrorCommand();
            } catch (CommandException e) {
                ConsoleUserPrinter.printError(e.getMessage());
            }
        }
    }
}
