package march21.courses;

/**
 * Created by Максим on 21.03.2017.
 */
public class ExtendedScoreCourse extends AbstractCourse {

    @Override
    public void setPoints(int score) {
        this.points = score / 2;
    }
}
