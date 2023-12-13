/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author User
 */
public class Course {
    
    private String CourseId;
    private String CourseName;
    private String facultyId;
    private String CourseFee;
    
     public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String CourseId) {
        this.CourseId = CourseId;
    }
    
     public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }
    
     public String getfacultyId() {
        return facultyId;
    }

    public void setfacultyId(String facultyId) {
        this.facultyId = facultyId;
    }
    
    public String getCourseFee(){
        return CourseFee;
    }
    
    public void setCourseFee(String CourseFee){
        this.CourseFee = CourseFee;
    }
    
    @Override
    public String toString() {
        return CourseId + "\t" + CourseName + "\t" + facultyId + "\t" + CourseFee;
    }
    
}
