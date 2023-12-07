/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author fongj
 */
public class Student extends StudentCourse {

    private String studentId;
    private String studentPassword;
    private String studentName;
    private String studentIc;
    private String studentProgremme;
    private StudentCourse studentCourse;

    public Student() {
    }

    public Student(String id, String name, String password, String ic, String progremme) {
        this.studentId = id;
        this.studentName = name;
        this.studentPassword = password;
        this.studentIc = ic;
        this.studentProgremme = progremme;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentIc() {
        return studentIc;
    }

    public void setStudentIc(String studentIc) {
        this.studentIc = studentIc;
    }

    public String getStudentProgremme() {
        return studentProgremme;
    }

    public void setStudentProgremme(String studentProgremme) {
        this.studentProgremme = studentProgremme;
    }

    public StudentCourse getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(StudentCourse studentCourse) {
        this.studentCourse = studentCourse;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", studentPassword=" + studentPassword + ", studentName=" + studentName + ", studentIc=" + studentIc + ", studentProgremme=" + studentProgremme + ", studentCourse=" + studentCourse + '}';
    }

}
