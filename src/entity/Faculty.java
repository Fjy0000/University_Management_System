package entity;

/**
 *
 * @author User
 */
public class Faculty extends Course {

    private String facultyId;
    private String facultyName;
    private String programmeId;

    public String getprogrammeId() {
        return programmeId;
    }

    public void setprogrammeId(String programmeId) {
        this.programmeId = programmeId;
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
    public String toString() {
        return facultyId + "\t" + facultyName + "\t" + programmeId;
    }

}
