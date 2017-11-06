package course1.march30.fileManager.commands;

import course1.march30.fileManager.commands.exception.CommandException;

public interface Command {
    void execute(String[] parameters) throws CommandException;
}
