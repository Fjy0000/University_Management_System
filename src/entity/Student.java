/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.Set;
import adt.SetInterface;

/**
 *
 * @author fongj
 */
public class Student extends StudentCourse {

    private String studentId;
    private String contactNo;
    private String studentName;
    private String studentIc;
    private String studentProgremme;
    private SetInterface<StudentCourse> studentCourse = new Set<>();

    // Student ------------------------------------------------------------------------------
    public Student() {
    }

    public Student(String id, String name, String contactNo, String ic, String progremme) {
        this.studentId = id;
        this.studentName = name;
        this.contactNo = contactNo;
        this.studentIc = ic;
        this.studentProgremme = progremme;
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

    // Student Course ------------------------------------------------------------------------------
    public SetInterface<StudentCourse> getStudentCourse() {
        return studentCourse;
    }

    public int getStudentCourseSize() {
        return this.studentCourse.getSize();
    }

    public void addStudentCourse(StudentCourse courses) {
        this.studentCourse.add(courses);
    }

    public void removeStudentCourse(StudentCourse courses) {
        this.studentCourse.remove(courses);
    }

    // ToString -----------------------------------------------------------------------------------
    @Override
    public String toString() {
        return studentId + "\t" + contactNo + "\t" + studentName + "\t" + studentIc + "\t" + studentProgremme;
    }

}
