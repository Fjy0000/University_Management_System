/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Fong Jun Yi
 */
public class StudentCourse {

    private String courseId;
    private String course;
    private String status;

    public StudentCourse() {
    }

    public StudentCourse(String id, String course) {
        this.courseId = id;
        this.course = course;
    }

    public StudentCourse(String id, String course, String status) {
        this.courseId = id;
        this.course = course;
        this.status = status;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return courseId + "\t" + course + "\t" + status;
    }

}
