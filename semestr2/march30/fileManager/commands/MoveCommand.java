package course1.march30.fileManager.commands;

import course1.march30.fileManager.commands.exception.CommandException;
import course1.march30.fileManager.commands.exception.CommandNotFoundException;
import course1.march30.fileManager.utils.FileManagerUtils;

public class MoveCommand implements Command {

    private static MoveCommand instance;

    private MoveCommand() {

    }

    public static MoveCommand getInstance() {
        if (instance == null) {
            instance = new MoveCommand();
        }
        return instance;
    }

    @Override
    public void execute(String[] parameters) throws CommandException {
        if (parameters.length != 3) {
            throw new CommandNotFoundException();
        }
        if (!FileManagerUtils.getInstance().move(parameters[1], parameters[2])) {
            throw new CommandException("Can't move file! File or directory not found");
        }
    }
}
