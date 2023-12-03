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
    private String studentName;
    private String studentPassword;
    private String studentProgremme;
    private StudentCourse studentCourse;

    public Student() {
    }

    public Student(String id, String name, String password, String progremme, StudentCourse course) {
        this.studentId = id;
        this.studentName = name;
        this.studentPassword = password;
        this.studentProgremme = progremme;
        this.studentCourse = course;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
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
        return studentId + "\t" + studentName + "\t" + studentPassword + "\t" + studentProgremme + "\t" + studentCourse;
    }

}
