package febrary9.utils;

import java.util.Scanner;

/**
 * Created by Максим on 12.02.2017.
 */
public class ConsoleUserInteractor implements UserInteractor {

    public ConsoleUserInteractor() throws UserInteractorException {

    }

    @Override
    public String readCommand() throws UserInteractorReadException {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        if (command.isEmpty()) return null;

        return command;
    }

    @Override
    public void print(String output) {
        System.out.println(">> " + output);
    }
}
