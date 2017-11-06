package course1.__diary.diary03.exceptions;

/**
 * Created by Максим on 01.02.2017.
 */
public class IllegalDateFormatException extends Exception {
    public IllegalDateFormatException() {
    }

    public IllegalDateFormatException(String message) {
        super(message);
    }
}