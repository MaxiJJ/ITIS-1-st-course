package course1.march30.fileManager.commands.exception;

public class CommandNotFoundException extends CommandException {
    public CommandNotFoundException() {
    }

    public CommandNotFoundException(String message) {
        super(message);
    }
}
