package course1.febrary9.utils;

import course1.febrary16.ui.UserInteractorReadException;

/**
 * Created by Максим on 09.02.2017.
 */
public interface UserInteractor {
    public String readCommand() throws UserInteractorReadException;
    public void print(String output) throws UserInteractorWriteException ;
}