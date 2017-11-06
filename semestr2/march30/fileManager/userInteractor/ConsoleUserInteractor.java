package course1.march30.fileManager.userInteractor;

import java.util.Scanner;

public class ConsoleUserInteractor implements Console {

    private Scanner scanner;

    public ConsoleUserInteractor() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String getCommand() {
        String command = scanner.nextLine();
        if (command.equals("Exit")) return null;

        return command;
    }

}
