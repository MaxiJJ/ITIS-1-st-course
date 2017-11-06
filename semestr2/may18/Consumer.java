package course1.may18;

/**
 * Created by Максим on 18.05.2017.
 */
public class Consumer implements Runnable {
    private Entity entity;

    public Consumer(Entity entity) {
        this.entity = entity;
    }

    @Override
    public void run() {
        synchronized (entity) {
            while (entity.isStatus()) {
                try {
                    entity.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            entity.use();
            entity.notify();
        }
    }
}
