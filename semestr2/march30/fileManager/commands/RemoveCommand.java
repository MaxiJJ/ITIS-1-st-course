package course1.march30.fileManager.commands;

import course1.march30.fileManager.commands.exception.CommandException;
import course1.march30.fileManager.commands.exception.CommandNotFoundException;
import course1.march30.fileManager.utils.FileManagerUtils;

public class RemoveCommand implements Command {

    private static RemoveCommand instance;

    private RemoveCommand() {

    }

    public static RemoveCommand getInstance() {
        if (instance == null) {
            instance = new RemoveCommand();
        }
        return instance;
    }


    @Override
    public void execute(String[] parameters) throws CommandException {
        if (parameters.length < 2 || parameters.length > 3) {
            throw new CommandNotFoundException();
        }
        String file;
        String parameter = null;
        file = parameters[parameters.length - 1];

        if (parameters.length == 3) {
            parameter = parameters[1];
        }
        if (parameter == null) {
            if (!FileManagerUtils.getInstance().remove(file, false, false)) {
                throw new CommandException("Can't remove! File not found!");
            }
            return;
        }

        boolean result;
        switch (parameter) {
            case "-r":
                result = FileManagerUtils.getInstance().remove(file, true, false);
                break;
            case "-f":
                result = FileManagerUtils.getInstance().remove(file, false, true);
                break;
            case "-rf":
            case "-fr":
                result = FileManagerUtils.getInstance().remove(file, true, true);
                break;
            default:
                throw new CommandNotFoundException();
        }
        if (!result) {
            throw new CommandException("Can't remove! File or directory not found!");
        }

    }
}
