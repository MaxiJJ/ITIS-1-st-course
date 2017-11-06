package course1.may18;

/**
 * Created by Максим on 18.05.2017.
 */
public class Producer implements Runnable {
    private Entity entity;

    public Producer(Entity entity) {
        this.entity = entity;
    }

    @Override
    public void run() {
        synchronized (entity) {
            while (!entity.isStatus()) {
                try {
                    entity.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            entity.prepare();
            entity.notify();
        }
    }
}
