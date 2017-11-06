package course1.may16;

/**
 * Created by Максим on 16.05.2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Entity entity = new Entity();
        Thread thread1 = new Thread(new Incrementer(entity, 10));
        Thread thread2 = new Thread(new Incrementer(entity, 10));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(entity.getCount());
    }
}
