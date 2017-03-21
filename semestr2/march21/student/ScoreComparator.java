package march21.student;

import java.util.Comparator;

/**
 * Created by Максим on 21.03.2017.
 */
public class ScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getSumScore().compareTo(o2.getSumScore());
    }
}
