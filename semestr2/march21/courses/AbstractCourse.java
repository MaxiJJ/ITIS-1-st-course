package march21.courses;

/**
 * Created by Максим on 21.03.2017.
 */
public abstract class AbstractCourse implements Course {
    protected final static int MAX_SCORE = 50;

    protected String name;
    protected int points;

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
