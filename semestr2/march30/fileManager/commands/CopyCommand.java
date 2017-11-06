package course1.march30.fileManager.commands;

import course1.march30.fileManager.commands.exception.CommandException;
import course1.march30.fileManager.commands.exception.CommandNotFoundException;
import course1.march30.fileManager.utils.FileManagerUtils;

public class CopyCommand implements Command {

    private static CopyCommand instance;

    private CopyCommand() {}

    public static CopyCommand getInstance() {
        if (instance == null) {
            instance = new CopyCommand();
        }
        return instance;
    }

    @Override
    public void execute(String[] parameters) throws CommandException {
        if (parameters.length != 3) throw new CommandNotFoundException();

        if (!FileManagerUtils.getInstance().copy(parameters[1], parameters[2])) {
            throw new CommandException("Can't copy file! File or directory not found");
        }
    }
}
