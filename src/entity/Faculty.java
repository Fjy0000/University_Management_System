package entity;

/**
 *
 * @author User
 */
public class Faculty implements Comparable<Faculty> {

    private String facultyId;
    private String facultyName;

    public Faculty(String facultyId, String facultyName) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;

    }

    public String getfacultyId() {
        return facultyId;
    }

    public void setfacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getfacultyName() {
        return facultyName;
    }

    public void setfacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public int compareTo(Faculty object) {
        return this.facultyId.compareTo(object.getfacultyId());
    }

    @Override
    public String toString() {
        return facultyId + "\t" + facultyName;
    }
}
