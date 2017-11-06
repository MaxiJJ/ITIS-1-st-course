package course1.march21.student;

import java.util.Comparator;

/**
 * Created by Максим on 21.03.2017.
 */
public class ComparatorFactory {
    public static Comparator<Student> getComparator(String comparatorType) throws ComparatorTypeMismatchException {
        switch (comparatorType) {
            case "first name":
                return new FirstNameComparator();
            case "last name":
                return new LastNameComparator();
            case "points":
                return new ScoreComparator();
            default:
                throw new ComparatorTypeMismatchException();
        }
    }
}
