package march21;

import march21.courses.Course;
import march21.student.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 21.03.2017.
 */
public class Group {
    private String name;
    private List<Student> students;

    public List<Student> getStudents() {
        List<Student> passedSessionStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.isSessionPassed()) {
                passedSessionStudents.add(student);
            }
        }

        return students;
    }

    public void expelStudent(Student student) {
        student.setSessionPassed(false);
    }

    public void addPointsToStudent(Student student, Course course, int points) {
        List<Course> courses = student.getCourses();

        for (Course studentCourse : courses) {
            if (studentCourse.equals(course)) {
                int coursePoint = studentCourse.getPoints();
                studentCourse.setPoints(coursePoint + points);
            }
        }
    }

    public boolean addStudent(Student student) {
        return students.add(student);
    }

    public boolean removeStudent(Student student) {
        return students.remove(student);
    }
}
