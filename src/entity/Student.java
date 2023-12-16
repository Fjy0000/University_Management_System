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
        return "Student ID: " + studentId
                + "\nContactNo: " + contactNo
                + "\nName: " + studentName
                + "\nGender: " + gender
                + "\nProgremme: " + studentProgrammeCode + "\n";
    }

    // add by hongli  -----------------------------------------------------------------------------------   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}
