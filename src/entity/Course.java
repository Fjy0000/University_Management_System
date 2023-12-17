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
    private SetInterface<Faculty> faculty = new Set<>();

    public Course(String CourseId, String CourseName) {
        this.CourseId = CourseId;
        this.CourseName = CourseName;

    }

    public Course(String CourseId, String CourseName, SetInterface<Faculty> faculty) {
        this.CourseId = CourseId;
        this.CourseName = CourseName;
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

    public SetInterface<Faculty> getFacultyId() {
        return faculty;
    }

    public void addFaculty(Faculty faculty) {
        this.faculty.add(faculty);
    }

    public void removedFaculty(Faculty faculty) {
        this.faculty.remove(faculty);
    }

    @Override
    public int compareTo(Course object) {
        return this.CourseId.compareTo(object.getCourseId());
    }

    @Override
    public String toString() {
        return CourseId + "\t" + CourseName + "\t" + facultyId;
    }

    public void addProgram(Programme program) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean removeProgram(String programId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}