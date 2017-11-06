package course1.march21.student;

import java.util.Comparator;

/**
 * Created by Максим on 21.03.2017.
 */
public class LastNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
