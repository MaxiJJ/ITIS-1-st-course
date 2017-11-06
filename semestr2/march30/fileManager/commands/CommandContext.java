package course1.march30.fileManager.commands;

import course1.march30.fileManager.commands.exception.CommandException;
import course1.march30.fileManager.commands.exception.CommandNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CommandContext {

    private Map<String, Command> commands;
    private static CommandContext instance;

    private CommandContext() {
        commands = new HashMap<>();
        commands.put("ls", GetFilesCommand.getInstance());
        commands.put("cd", PickPathCommand.getInstance());
        commands.put("rm", RemoveCommand.getInstance());
        commands.put("mv", MoveCommand.getInstance());
        commands.put("cp", CopyCommand.getInstance());
    }

    public static CommandContext getInstance() {
        if (instance == null) {
            instance = new CommandContext();
        }
        return instance;
    }

    public void executeCommand(String command) throws CommandException {
        String[] commandParts = command.split(" ");
        Command cmd = commands.get(commandParts[0]);
        if (cmd == null) {
            throw new CommandNotFoundException();
//            ConsoleUserPrinter.printErrorCommand();
//            return;
        }
        cmd.execute(commandParts);
    }
}
