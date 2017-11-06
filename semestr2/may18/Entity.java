package course1.may18;

/**
 * Created by Максим on 18.05.2017.
 */
public class Entity {
    private boolean status;

    public void use() {
        System.out.println("I use");
        status = false;
    }

    public void prepare() {
        status = true;
        System.out.println("I prepare.");
    }

    public boolean isStatus() {
        return status;
    }
}
