package entity;

import adt.Set;
import adt.SetInterface;
import java.util.Objects;

/**
 *
 * @author Fong Jun Yi
 */
public class Student implements Comparable<Student> {

    private String studentId;
    private String contactNo;
    private String studentName;
    private String gender;
    private String studentProgramme;
    private String studentProgrammeCode;
    private SetInterface<StudentCourse> studentCourse = new Set<>();

    // Student ------------------------------------------------------------------------------
    public Student() {
    }

    // For Registration Use
    public Student(String id, String name, String contactNo, String gender, String programme, String programmeCode) {
        this.studentId = id;
        this.studentName = name;
        this.contactNo = contactNo;
        this.gender = gender;
        this.studentProgramme = programme;
        this.studentProgrammeCode = programmeCode;
    }

    // For Update student use
    public Student(String id, String name, String contactNo, String gender, String programme, String programmeCode, SetInterface<StudentCourse> courses) {
        this.studentId = id;
        this.studentName = name;
        this.contactNo = contactNo;
        this.gender = gender;
        this.studentProgramme = programme;
        this.studentProgrammeCode = programmeCode;
        this.studentCourse = courses;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudentProgramme() {
        return studentProgramme;
    }

    public void setStudentProgramme(String studentProgramme) {
        this.studentProgramme = studentProgramme;
    }

    public String getStudentProgrammeCode() {
        return studentProgrammeCode;
    }

    public void setStudentProgrammeCode(String studentProgrammeCode) {
        this.studentProgrammeCode = studentProgrammeCode;
    }

    // Student Course ------------------------------------------------------------------------------
    public SetInterface<StudentCourse> getStudentCourse() {
        return studentCourse;
    }

    public int getStudentCourseSize() {
        return this.studentCourse.getSize();
    }

    public boolean addStudentCourse(StudentCourse courses) {
        return this.studentCourse.add(courses);
    }

    public void removeStudentCourse(StudentCourse courses) {
        this.studentCourse.remove(courses);
    }

    @Override
    public int compareTo(Student object) {
        return this.studentId.compareTo(object.getStudentId());
    }

    @Override
    public String toString() {
        return String.format("%-15s \t %-15s \t %-15s", studentId, studentName, studentProgrammeCode);
    }

    // add by hongli  -----------------------------------------------------------------------------------   
    @Override
    public boolean equals(Object obj) {
        // Check if the objects are the same reference
        if (this == obj) {
            return true;
        }
        // Check if the object is null or of a different class
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // Cast the object to the specific class Student
        Student student = (Student) obj;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    ////Consistency with equals:  ensures consistency in behavior when using these objects in hash-based collections.
    public int hashCode() {
        return Objects.hash(studentId);
    }
}
