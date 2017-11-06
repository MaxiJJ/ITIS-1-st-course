package course1.__diary.diary03.exceptions;

/**
 * Created by Максим on 01.02.2017.
 */
public class IllegalDatesSequenceException extends Exception {
    public IllegalDatesSequenceException() {
    }

    public IllegalDatesSequenceException(String message) {
        super(message);
    }
}