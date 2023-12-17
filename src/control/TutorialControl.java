package control;

import adt.SetInterface;
import adt.SortedIterator;
import boundary.TutorialGroupUI;
import static control.Main.assignedStudents;
import static control.Main.homepage;
import static control.Main.student;
import static control.Main.tutorialGroups;
import entity.Student;
import entity.TutorialGroup;

/**
 *
 * @author Hong Li
 */
public class TutorialControl {

    private TutorialGroupUI tutorialUI = new TutorialGroupUI();

    public void tutorialtManagement() {
        //initialize TutorialGroups set
        tutorialGroups.add(new TutorialGroup("G1"));
        tutorialGroups.add(new TutorialGroup("G2"));
        tutorialGroups.add(new TutorialGroup("G3"));
        int choice;
        do {
            choice = tutorialUI.getMenuChoice();
            switch (choice) {
                case 1:
                    addStudentToGroup();
                    break;
                case 2:
                    listStudentsInGroup();
                    break;
                case 3:
                    searchStudentInGroup();
                    break;
                case 4:
                    removeStudentFromGroup();
                    break;
                case 5:
                    changeStudentGroup();
                    break;
                case 6:
                    filterGroupsByNumberOfStudents();
                    break;
                case 7:
                    mergeGroups();
                    break;
                case 8:
                    generateSummaryReport();
                    break;
                case 9:
                    homepage();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void addStudentToGroup() {
        // Call inputstudentId method to get student ID from the user
        String studentId = tutorialUI.inputstudentId();
        // Call inputgroupName method to get assigned group from the user
        String groupName = tutorialUI.inputgroupName();
        System.out.print("\n");
        Student newStudent = new Student();
        boolean found = false;

        // Get an iterator to iterate over the students in the existing student set
        SortedIterator<Student> iterator = student.getIterator();
        // Iterate through the students

        while (iterator.hasNext()) {
            // Retrieve the next student from the iterator
            Student student = iterator.next();
            if (student.getStudentId().equals(studentId)) {
                newStudent = new Student(studentId,
                        student.getStudentName(),
                        student.getContactNo(),
                        student.getGender(),
                        student.getStudentProgramme(),
                        student.getStudentProgrammeCode());
                found = true;
                // Set the 'found' flag to true to indicate that the student was found
                break;
            }
        }
        // Check if the student set contains the new student
        if (!student.contains(newStudent) || found == false) {
            System.out.println("\nStudent " + studentId + " does not exist in the student set.");
            return;
        }
        // Check if the tutorial group exists
        TutorialGroup existingGroup = findGroupByName(groupName);
        if (existingGroup == null) {
            System.out.println("\nTutorial group with name " + groupName + " does not exist.");
            return;
        }

        // Check if the student is already assigned to a group
        if (assignedStudents.contains(newStudent)) {
            System.out.println("\nStudent " + newStudent.getStudentName() + " is already assigned to a tutorial group.");
            return;
        }

        // Add the student to the group
        existingGroup.addStudent(newStudent);
        //make sure newStudent from student add into assignedStudents, use to identify student from student set who is in group and not in group
        assignedStudents.add(newStudent);
        student.add(newStudent);

        System.out.println("Student " + newStudent.getStudentName() + " added to tutorial group " + groupName + ".");
    }

    private TutorialGroup findGroupByName(String groupName) {

        SortedIterator<TutorialGroup> groupIterator = tutorialGroups.getIterator();
        // Iterate through each TutorialGroup in the collection

        while (groupIterator.hasNext()) {
            TutorialGroup tutorialGroup = groupIterator.next();

            // Check if the current TutorialGroup's name matches the specified groupName
            if (tutorialGroup.getGroupName().equalsIgnoreCase(groupName)) {
                return tutorialGroup;
            }
        }
        return null;
    }

    private void listStudentsInGroup() {
        System.out.println("Enter Group name which you want to list");
        // Call inputgroupName method to get assigned group from the user
        String groupName = tutorialUI.inputgroupName();
        System.out.print("\n");

        TutorialGroup tutorialGroup = findGroupByName(groupName);

        if (tutorialGroup != null) {
            System.out.println("Students in " + groupName + ":");
            tutorialUI.groupListHeader();
            tutorialGroup.listStudents();
        } else {
            System.out.println("Error: Group '" + groupName + "' not found.");
        }
    }

    // Helper method to find a student by ID
    private Student findStudentById(String studentId) {
        SortedIterator<Student> iterator = student.getIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null; // Student not found
    }

    private void searchStudentInGroup() {
        // Call inputstudentId method to get student ID from the user
        String studentId = tutorialUI.inputstudentId();
        // Call inputgroupName method to get assigned group from the user
        String groupName = tutorialUI.inputgroupName();

        // Find the student by ID
        Student student = findStudentById(studentId);
        // Find the tutorial group by name
        TutorialGroup group = findGroupByName(groupName);

        // If both student and group are found, check if the student is in the group
        if (student != null && group != null && group.containsStudent(student)) {
            System.out.print("\n");
            System.out.println("Student found in group " + group.getGroupName());
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Student Name: " + student.getStudentName());
            System.out.println("Student Gender: " + student.getGender());
            System.out.println("Programme Code: " + student.getStudentProgrammeCode());
            System.out.println("Programme Name: " + student.getStudentProgramme());
            System.out.println("Student ContactNo: " + student.getContactNo());
        } else {
            System.out.println("Student not found in the specified tutorial group.");
        }
    }

    private void removeStudentFromGroup() {
        // Call inputstudentId method to get student ID from the user
        String studentId = tutorialUI.inputstudentId();
        // Call inputgroupName method to get assigned group from the user
        String groupName = tutorialUI.inputgroupName();
        Student student = findStudentById(studentId);
        TutorialGroup group = findGroupByName(groupName);

        if (student == null) {
            System.out.println("Error: Student with ID '" + studentId + "' not found.");
        } else if (group == null) {
            System.out.println("Error: Tutorial group '" + groupName + "' not found.");
        } else {
            if (group.containsStudent(student)) {
                group.removeStudent(student);
                assignedStudents.remove(student); // Optional: Remove student from assignedStudents set
                System.out.println("\nStudent removed from the group successfully.");
            } else {
                System.out.println("Error: Student not found in the specified tutorial group.");
            }
        }
    }

    private void changeStudentGroup() {
        // Call inputstudentId method to get student ID from the user
        String studentId = tutorialUI.inputstudentId();
        // Call inputgroupName method to get assigned group from the user
        System.out.println("Enter student's current tutorial group");
        String currentGroupName = tutorialUI.inputgroupName();

        System.out.println("Enter student's new tutorial group");
        String newGroupName = tutorialUI.inputgroupName();

        // Find the student and both current and new tutorial groups
        Student student = findStudentById(studentId);
        TutorialGroup currentGroup = findGroupByName(currentGroupName);
        TutorialGroup newGroup = findGroupByName(newGroupName);

        // Check if the student, current group, and new group exist
        if (student == null) {
            System.out.println("Error: Student with ID '" + studentId + "' not found.");
        } else if (currentGroup == null) {
            System.out.println("Error: Current tutorial group '" + currentGroupName + "' not found.");
        } else if (newGroup == null) {
            System.out.println("Error: New tutorial group '" + newGroupName + "' not found.");
        } else {
            // Check if the student is in the current group
            if (currentGroup.containsStudent(student)) {
                // Remove the student from the current group
                currentGroup.removeStudent(student);

                // Check if the student is already in the new group
                if (!newGroup.containsStudent(student)) {
                    // Add the student to the new group
                    newGroup.addStudent(student);

                    // Optionally, update the assignedStudents set if needed
                    assignedStudents.remove(student);
                    assignedStudents.add(student);

                    System.out.println("Student moved to the new group successfully.");
                } else {
                    System.out.println("Error: Student is already in the new group.");
                    // Revert the changes by adding the student back to the current group
                    currentGroup.addStudent(student);
                }
            } else {
                System.out.println("Error: Student not found in the specified current tutorial group.");
            }
        }
    }

    private void filterGroupsByNumberOfStudents() {
        int numberOfStudents = tutorialUI.inputNumberOfStudents();
        boolean groupsFound = false;

        SortedIterator<TutorialGroup> groupIterator = tutorialGroups.getIterator();
        // Iterate through each tutorial group in the set.

        while (groupIterator.hasNext()) {
            TutorialGroup tutorialGroup = groupIterator.next();

            // Check if the current tutorial group has the specified number of students.
            if (tutorialGroup.getSize() == numberOfStudents) {
                System.out.println("\nGroup " + tutorialGroup.getGroupName() + " has " + numberOfStudents + " students:");
                tutorialGroup.listStudents();
                groupsFound = true;
            }
        }

        if (!groupsFound) {
            System.out.println("No groups found with " + numberOfStudents + " students.");
        }
    }

    private void mergeGroups() {
        String groupName1 = tutorialUI.inputMergeGroups("Enter the name of the first tutorial group: ");
        String groupName2 = tutorialUI.inputMergeGroups("Enter the name of the second tutorial group: ");

        TutorialGroup group1 = findGroupByName(groupName1);
        TutorialGroup group2 = findGroupByName(groupName2);

        if (group1 != null && group2 != null) {
            SetInterface<Student> studentsGroup1 = group1.getStudentsSet();
            SetInterface<Student> studentsGroup2 = group2.getStudentsSet();

            int totalStudentsGroup1 = studentsGroup1.getSize();
            int totalStudentsGroup2 = studentsGroup2.getSize();

            if (totalStudentsGroup1 < 3 && totalStudentsGroup2 < 3) {
                // Use the union method to merge the sets of students
                studentsGroup1.union(studentsGroup2);

                // Remove one of the groups (e.g., group2) since they are merged
                tutorialGroups.remove(group2);

                System.out.println("Groups " + groupName1 + " and " + groupName2 + " merged successfully.");
            } else {
                System.out.println("Error: Cannot merge groups with more than three students.");
            }
        } else {
            System.out.println("Error: One or both groups not found.");
        }
    }

    private void generateSummaryReport() {
        tutorialUI.titleUI("Generate Report");
        SortedIterator<TutorialGroup> groupIterator = tutorialGroups.getIterator();
        while (groupIterator.hasNext()) {
            TutorialGroup tutorialGroup = groupIterator.next();
            System.out.println("\n");
            System.out.println("Tutorial Group: " + tutorialGroup.getGroupName());
            System.out.println("Number of student in group: " + tutorialGroup.getSize());
            tutorialUI.groupListHeader();
            if (tutorialGroup.getSize() == 0) {
                System.out.println("No students in this group.");
            } else {
                SortedIterator<Student> studentIterator = tutorialGroup.getStudentsSet().getIterator();
                while (studentIterator.hasNext()) {
                    Student student = studentIterator.next();
                    System.out.printf("%-15s \t %-15s \t %-15s\n",
                             student.getStudentId(),
                             student.getStudentName(),
                             student.getStudentProgrammeCode());
                }
            }
        }
    }
}
