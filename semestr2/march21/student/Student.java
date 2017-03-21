package march21.student;

import march21.Group;
import march21.courses.Course;

import java.util.List;

/**
 * Created by Максим on 21.03.2017.
 */
public class Student {
    private String firstName;
    private String lastName;
    private List<Course> courses;
    private Integer sumScore;
    private boolean sessionPassed;
    private Group group;

    public Student() {
    }

    public Student(String firstName, String lastName, List<Course> courses, Group group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
        this.sessionPassed = true;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Integer getSumScore() {
        int averageScore = 0;
        for (Course subject : courses) {
            averageScore += subject.getPoints();
        }
        return averageScore;
    }

    public boolean isSessionPassed() {
        for (Course subject : courses) {
            if (subject.getPoints() < 28) {
                this.sessionPassed = false;
                return sessionPassed;
            }
        }

        return sessionPassed;
    }

    public void setSessionPassed(boolean sessionPassed) {
        this.sessionPassed = sessionPassed;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
