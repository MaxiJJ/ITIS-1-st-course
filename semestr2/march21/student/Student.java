package course1.march21.student;

import course1.march21.Group;
import course1.march21.courses.Course;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (sessionPassed != student.sessionPassed) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        if (courses != null ? !courses.equals(student.courses) : student.courses != null) return false;
        if (sumScore != null ? !sumScore.equals(student.sumScore) : student.sumScore != null) return false;
        return group != null ? group.equals(student.group) : student.group == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (courses != null ? courses.hashCode() : 0);
        result = 31 * result + (sumScore != null ? sumScore.hashCode() : 0);
        result = 31 * result + (sessionPassed ? 1 : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }
}
