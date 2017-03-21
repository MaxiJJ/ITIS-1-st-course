package march21.student;

import java.util.Comparator;

/**
 * Created by Максим on 21.03.2017.
 */
public class FirstNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
