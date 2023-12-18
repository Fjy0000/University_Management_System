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
    private SetInterface<Faculty> faculty = new Set<>();
    private SetInterface<Programme> programme = new Set<>();

    public Course(String CourseId, String CourseName) {
        this.CourseId = CourseId;
        this.CourseName = CourseName;

    }

    public Course(String CourseId, String CourseName, SetInterface<Faculty> faculty) {
        this.CourseId = CourseId;
        this.CourseName = CourseName;
        this.faculty = faculty;

    }

    public Course(String CourseId, String CourseName, String emp, SetInterface<Programme> programme) {
        this.CourseId = CourseId;
        this.CourseName = CourseName;
        this.programme = programme;

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

    public SetInterface<Programme> getProgrammeCode() {
        return programme;
    }

    public void addProgramme(Programme programme) {
        this.programme.add(programme);
    }

    public boolean removeProgramme(Programme program) {
        return programme.remove(program);
    }
    
    public boolean containsProgram(Programme program) {
        return programme.contains(program);
    }

    @Override
    public int compareTo(Course object) {
        return this.CourseId.compareTo(object.getCourseId());
    }

    @Override
    public String toString() {
        return CourseId + "\t" + CourseName;
    }

}