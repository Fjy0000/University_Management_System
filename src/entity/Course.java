package entity;

import adt.Set;
import adt.SetInterface;

/**
 *
 * @author User
 */

 public class Course implements Comparable<Course> {
    
    private String CourseId;
    private String CourseName;
    private String facultyId;
    private int CourseFee;
    private SetInterface<Faculty> faculty = new Set<>();
    
    public Course(String CourseId, String CourseName, int CourseFee) {
    this.CourseId = CourseId;
    this.CourseName = CourseName;
    this.CourseFee = CourseFee;
  }
    
    public Course(String CourseId, String CourseName, int CourseFee, SetInterface<Faculty> faculty) {
    this.CourseId = CourseId;
    this.CourseName = CourseName;
    this.CourseFee = CourseFee;
    this.faculty = faculty;
    
  }

    
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
    
    
    public int getCourseFee(){
        return CourseFee;
    }
    
    public void setCourseFee(int CourseFee){
        this.CourseFee = CourseFee;
    }
    
    public SetInterface<Faculty> getFacultyId(){
        return faculty;
    }
    
    public void addFaculty(Faculty faculty){
        this.faculty.add(faculty);
    }
    
    public void removedFaculty(Faculty faculty){
        this.faculty.remove(faculty);
    }
    
    @Override
    public int compareTo(Course object){
        return this.CourseId.compareTo(object.getCourseId());
    }
    
    @Override
    public String toString() {
        return CourseId + "\t" + CourseName + "\t" + facultyId + "\t" + CourseFee;
    }

    public void addProgram(Programme program) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean removeProgram(String programId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
