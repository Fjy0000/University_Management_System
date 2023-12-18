package entity;

import adt.Set;
import utility.SortedIterator;
import java.util.Objects;

/**
 *
 * @author Geng Seng
 */
public class Programme implements Comparable<Programme> {

    private String programmeCode;
    private String levelofstudy;
    private String programmeName;
    private String faculty;
    private String yearIntake;
    private int duration;
    private Set<TutorialGroup> tutorialGroups; // Added set to store tutorial groups

    public Programme() {
        this.tutorialGroups = new Set<>();
    }

    // Constructor without tutorial groups
    public Programme(String programmeCode, String levelofstudy, String programmeName, String faculty, String yearIntake, int duration) {
        this.programmeCode = programmeCode;
        this.levelofstudy = levelofstudy;
        this.programmeName = programmeName;
        this.faculty = faculty;
        this.yearIntake = yearIntake;
        this.duration = duration;
        this.tutorialGroups = new Set<>();
    }

    // Constructor with tutorial groups
    public Programme(String programmeCode, String levelofstudy, String programmeName, String faculty, String yearIntake, int duration, Set<TutorialGroup> tutorialGroups) {
        this.programmeCode = programmeCode;
        this.levelofstudy = levelofstudy;
        this.programmeName = programmeName;
        this.faculty = faculty;
        this.yearIntake = yearIntake;
        this.duration = duration;
        this.tutorialGroups = tutorialGroups;
    }

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

    public Set<TutorialGroup> getTutorialGroups() {
        return tutorialGroups;
    }

    public void addTutorialGroup(TutorialGroup tutorialGroup) {
        tutorialGroups.add(tutorialGroup);
    }

    public void removeTutorialGroup(TutorialGroup tutorialGroup) {
        tutorialGroups.remove(tutorialGroup);
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
        return String.format("%-10s\t %-10s\t %-80s\t %-10s\t %-10s\t %-10d", programmeCode, levelofstudy, programmeName, faculty, yearIntake, duration);
    }

    public String toListGroup() {
        StringBuilder outputStr = new StringBuilder();

        // Check if the program has associated tutorial groups
        if (!tutorialGroups.isEmpty()) {
            SortedIterator<TutorialGroup> iterator = tutorialGroups.getIterator();
            while (iterator.hasNext()) {
                TutorialGroup tutorialGroup = iterator.next();
                outputStr.append(String.format("%-10s\t %-15s\t %-80s", tutorialGroup.getGroupName(), programmeCode, programmeName)).append("\n");
            }
        }

        return outputStr.toString();
    }
}
