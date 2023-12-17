package entity;

import adt.Set;
import adt.SetInterface;
import adt.SortedIterator;

/**
 *
 * @author 60111
 */
public class TutorialGroup implements Comparable<TutorialGroup> {

    private String groupName;
    private static int groupNum = 1;
    private boolean assigned;
    private SetInterface<Student> students = new Set<>();

    public TutorialGroup() {
        this.groupName = "G" + groupNum;
        assigned = false;
        groupNum++;
    }

    public TutorialGroup(String name) {
        this.groupName = name;
        assigned = false;
        groupNum++;
    }

    public void addStudent(Student student) {
        // Check if the student is not null before adding to the group
        if (student != null) {
            students.add(student);
        }
    }

    public void removeStudent(Student student) {
        if (student != null) {
            students.remove(student);
        }
    }

    public boolean containsStudent(Student student) {
        return students.contains(student);
    }

    // Getter method to retrieve the set of students in the tutorial group
    public SetInterface<Student> getStudentsSet() {
        return students;
    }

    // Method to list students in the tutorial group
    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in this group.");
        } else {
            // Use an iterator to traverse the set of students
            SortedIterator<Student> iterator = students.getIterator();
            while (iterator.hasNext()) {
                // Print each student's information
                System.out.println(iterator.next());
            }
        }
    }

    public int getSize() {
        return students.getSize();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public static int getGroupNum() {
        return groupNum;
    }

    public static void setGroupNum(int groupNum) {
        TutorialGroup.groupNum = groupNum;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    @Override
    public String toString() {
        return "Tutorial Group\n"
                + "Group Name: " + groupName
                + "\nIs Assigned: " + assigned;
    }

    // Override compareTo method for sorting tutorial groups based on group names
    @Override
    public int compareTo(TutorialGroup object) {
        return this.groupName.compareTo(object.getGroupName());
    }
}