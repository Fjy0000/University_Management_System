package entity;

import java.util.Objects;

/**
 *
 * @author User
 */
public class Programme implements Comparable<Programme> {

    private String programmeCode;
    private String levelofstudy;
    private String programmeName;
    private String faculty;
    private String yearIntake;
    private int duration;
//    private TutorialGroup tutorialgroup;

    public Programme() {

    }

    public Programme(String programmeCode, String levelofstudy, String programmeName, String faculty, String yearIntake, int duration) {
        this.programmeCode = programmeCode;
        this.levelofstudy = levelofstudy;
        this.programmeName = programmeName;
        this.faculty = faculty;
        this.yearIntake = yearIntake;
        this.duration = duration;
    }

//    public Programme(String programmeCode, String levelofstudy, String programmeName, String faculty, int yearIntake, int duration, TutorialGroup tutorialgroup) {
//        this.programmeCode = programmeCode;
//        this.levelofstudy = levelofstudy;
//        this.programmeName = programmeName;
//        this.faculty = faculty;
//        this.yearIntake = yearIntake;
//        this.duration = duration;
//        this.tutorialgroup = tutorialgroup;
//    }
    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    public String getLevelofstudy() {
        return levelofstudy;
    }

    public void setLevelofstudy(String levelofstudy) {
        this.levelofstudy = levelofstudy;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getYearIntake() {
        return yearIntake;
    }

    public void setYearIntake(String yearIntake) {
        this.yearIntake = yearIntake;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Programme other = (Programme) obj;
        if (this.duration != other.duration) {
            return false;
        }
        if (!Objects.equals(this.programmeCode, other.programmeCode)) {
            return false;
        }
        if (!Objects.equals(this.levelofstudy, other.levelofstudy)) {
            return false;
        }
        if (!Objects.equals(this.programmeName, other.programmeName)) {
            return false;
        }
        if (!Objects.equals(this.faculty, other.faculty)) {
            return false;
        }
        return Objects.equals(this.yearIntake, other.yearIntake);
    }

    @Override
    public int compareTo(Programme o) {
        return programmeCode.compareTo(o.programmeCode);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-40s %-10s %-25s %-10d", programmeCode, levelofstudy, programmeName, faculty, yearIntake, duration);

    }
}
