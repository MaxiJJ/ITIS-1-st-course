package course1.march30.fileManager.commands;

import course1.march30.fileManager.commands.exception.CommandException;
import course1.march30.fileManager.commands.exception.CommandNotFoundException;
import course1.march30.fileManager.utils.FileManagerUtils;

public class PickPathCommand implements Command {

    private static PickPathCommand instance;

    private PickPathCommand() {}

    public static PickPathCommand getInstance() {
        if (instance == null) {
            instance = new PickPathCommand();
        }
        return instance;
    }

    @Override
    public void execute(String[] parameters) throws CommandException {
        if (parameters.length != 2) {
            throw new CommandNotFoundException();
        }
        String path = parameters[1];

        if (!FileManagerUtils.getInstance().pickPath(path)) {
            throw new CommandException("Can't change path! Directory not found!");
        }
    }
}
