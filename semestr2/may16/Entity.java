package course1.may16;

/**
 * Created by Максим on 16.05.2017.
 */
public class Entity {
    private int count = 0;

    public synchronized void inc() {
        count = count + 1;
    }

    public synchronized int getCount() {
        return count;
    }
}
