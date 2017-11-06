package course1.may18;

/**
 * Created by Максим on 18.05.2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Entity entity = new Entity();

        Consumer consumer = new Consumer(entity);
        Producer producer = new Producer(entity);

        Thread thread1 = new Thread(consumer);
        Thread thread2 = new Thread(producer);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
