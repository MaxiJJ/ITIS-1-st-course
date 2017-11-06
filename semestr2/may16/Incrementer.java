package course1.may16;

/**
 * Created by Максим on 16.05.2017.
 */
public class Incrementer implements Runnable {
    private final Entity entity;
    private int loopCount;

    public Incrementer(Entity entity, int loopCount) {
        this.entity = entity;
        this.loopCount = loopCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < loopCount; i++) {
                entity.inc();
        }
    }
}
