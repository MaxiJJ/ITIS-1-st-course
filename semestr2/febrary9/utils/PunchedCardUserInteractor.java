package course1.febrary9.utils;

import course1.febrary16.ui.UserInteractorReadException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by Максим on 09.02.2017.
 */
public class PunchedCardUserInteractor implements UserInteractor {

    protected final String[] lines;
    protected int currentLine = 0;

    public PunchedCardUserInteractor(Path path) throws UserInteractorException {
        try {
            List<String> lines = Files.readAllLines(path);
            this.lines = lines.toArray(new String[lines.size()]);
            this.currentLine = 0;
        } catch (IOException ex) {
            throw new UserInteractorException("Can't load punched card.");
        }
    }

    @Override
    public String readCommand() throws UserInteractorReadException {
        String command = null;
        if(this.currentLine < this.lines.length){
            command = this.lines[this.currentLine];
            this.currentLine++;
            System.out.println("<< " + command);
        }
        return command;
    }

    @Override
    public void print(String output) throws UserInteractorWriteException {
        System.out.println(">> " + output);
    }

}
