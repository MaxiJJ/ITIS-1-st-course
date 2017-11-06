package course1.march30.fileManager.commands;

import course1.march30.fileManager.commands.exception.CommandException;
import course1.march30.fileManager.commands.exception.CommandNotFoundException;
import course1.march30.fileManager.userInteractor.ConsoleUserPrinter;
import course1.march30.fileManager.utils.FileManagerUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class GetFilesCommand implements Command {

    private static GetFilesCommand instance;
    private static FileManagerUtils fileManagerUtils;

    public static GetFilesCommand getInstance() {
        if (instance == null) {
            instance = new GetFilesCommand();
        }
        fileManagerUtils = FileManagerUtils.getInstance();
        return instance;
    }

    private GetFilesCommand() {
    }

    @Override
    public void execute(String[] parameters) throws CommandException {
        List<File> files = null;
        boolean optionalInfo = false;

        try {
            if (parameters.length == 1) {
                files = fileManagerUtils.getFiles(false, false);
                return;
            }

            switch (parameters[1]) {
                case "-a":
                    files = fileManagerUtils.getFiles(true, false);
                    break;
                case "-l":
                    optionalInfo = true;
                    files = fileManagerUtils.getFiles(false, true);
                    break;
                case "-la":
                    optionalInfo = true;
                    files = fileManagerUtils.getFiles(true, true);
                    break;
                default:
                    throw new CommandNotFoundException();
            }
        } catch (FileNotFoundException e) {
            throw new CommandException("Can't get files! File or directory not found");
        } finally {
            if (files == null) return;

            for (File file : files) {
                if (optionalInfo) ConsoleUserPrinter.printFullInfo(file);
                else ConsoleUserPrinter.printInfo(file.getName());
            }
        }
    }
}
