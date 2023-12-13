package entity;

/**
 *
 * @author User
 */
public class Programme extends Faculty {

    private String programmeId;
    private String programmeName;

    public String getprogrammeId() {
        return programmeId;
    }

    public void setprogrammeId(String programmeId) {
        this.programmeId = programmeId;
    }

    public String getprogrammeName() {
        return programmeName;
    }

    public void setprogrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    @Override
    public String toString() {
        return programmeId + "\t" + programmeName;
    }

}
