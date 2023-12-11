/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author 60111
 */
import adt.SetInterface;
import adt.arraySet;
import entity.Student;
import entity.TutorialGroup;

import java.util.Iterator;

public class TutorialControl {
    private SetInterface<Student> studentSet = new arraySet<>();
    private SetInterface<TutorialGroup> tutorialGroups = initializeTutorialGroups();
    private SetInterface<Student> assignedStudents = new arraySet<>();

    public SetInterface<Student> initializeStudents() {
        return new arraySet<>();
    }

    public SetInterface<TutorialGroup> initializeTutorialGroups() {
        SetInterface<TutorialGroup> tutorialGroupSet = new arraySet<>();
        tutorialGroupSet.add(new TutorialGroup("G1"));
        tutorialGroupSet.add(new TutorialGroup("G2"));
        return tutorialGroupSet;
    }
    

    public void listStudentsInGroup(String groupName) {
        TutorialGroup tutorialGroup = findGroupByName(groupName);

        if (tutorialGroup != null) {
            System.out.println("Students in " + groupName + ":");
            tutorialGroup.listStudents();
        } else {
            System.out.println("Error: Group '" + groupName + "' not found.");
        }
    }
    
    public void removeStudentFromGroup(String studentId, String groupName) {
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
                System.out.println("Student removed from the group successfully.");
            } else {
                System.out.println("Error: Student not found in the specified tutorial group.");
            }
        }
    }
      public void addStudentToGroup(String studentId, String studentName, String groupName) {
        // Check if the student ID is unique
        Student newStudent = new Student(studentId, studentName);
        if (studentSet.contains(newStudent)) {
            System.out.println("Student with ID " + studentId + " already exists. Please use a unique ID.");
            return;
        }

        // Check if the tutorial group exists
        TutorialGroup existingGroup = findGroupByName(groupName);
        if (existingGroup == null) {
            System.out.println("Tutorial group with name " + groupName + " does not exist.");
            return;
        }

        // Check if the student is already assigned to a group
        if (assignedStudents.contains(newStudent)) {
            System.out.println("Student " + studentName + " is already assigned to a tutorial group.");
            return;
        }

        // Add the student to the group
        existingGroup.addStudent(newStudent);
        assignedStudents.add(newStudent);
        studentSet.add(newStudent);

        System.out.println("Student " + studentName + " added to tutorial group " + groupName + ".");
    }


    
    // Helper method to find a student by ID
    private Student findStudentById(String studentId) {
        Iterator<Student> iterator = studentSet.getIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null; // Student not found
    }
    
    
    public TutorialGroup findGroupByName(String groupName) {
        Iterator<TutorialGroup> groupIterator = tutorialGroups.getIterator();
        while (groupIterator.hasNext()) {
            TutorialGroup tutorialGroup = groupIterator.next();
            if (tutorialGroup.getGroupName().equalsIgnoreCase(groupName)) {
                return tutorialGroup;
            }
        }
        return null;
    }
    
    public void searchStudentInGroup(String studentId, String groupName) {
        // Find the student by ID
        Student student = findStudentById(studentId);

        // Find the tutorial group by name
        TutorialGroup group = findGroupByName(groupName);

        // If both student and group are found, check if the student is in the group
        if (student != null && group != null && group.containsStudent(student)) {
            System.out.println("Student found in group:");
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student Name: " + student.getName());
        } else {
            System.out.println("Student not found in the specified tutorial group.");
        }
    }
    
    public void changeStudentGroup(String studentId, String currentGroupName, String newGroupName) {
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
    public void filterGroupsByNumberOfStudents(int numberOfStudents) {
        boolean groupsFound = false;

        Iterator<TutorialGroup> groupIterator = tutorialGroups.getIterator();
        while (groupIterator.hasNext()) {
            TutorialGroup tutorialGroup = groupIterator.next();

            if (tutorialGroup.getTotalEntries() == numberOfStudents) {
                System.out.println("Group " + tutorialGroup.getGroupName() + " has " + numberOfStudents + " students:");
                tutorialGroup.listStudents();
                groupsFound = true;
            }
        }

        if (!groupsFound) {
            System.out.println("No groups found with " + numberOfStudents + " students.");
        }
    }
    public void mergeGroups(String groupName1, String groupName2) {
        TutorialGroup group1 = findGroupByName(groupName1);
        TutorialGroup group2 = findGroupByName(groupName2);

        if (group1 != null && group2 != null) {
            SetInterface<Student> studentsGroup1 = group1.getStudentsSet();
            SetInterface<Student> studentsGroup2 = group2.getStudentsSet();

            int totalStudentsGroup1 = studentsGroup1.getTotalEntries();
            int totalStudentsGroup2 = studentsGroup2.getTotalEntries();

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
    public void generateSummaryReport() {
        Iterator<TutorialGroup> groupIterator = tutorialGroups.getIterator();
        while (groupIterator.hasNext()) {
            TutorialGroup tutorialGroup = groupIterator.next();

            System.out.println("\nTutorial Group: " + tutorialGroup.getGroupName());

            if (tutorialGroup.getTotalEntries() == 0) {
                System.out.println("No students in this group.");
            } else {
                Iterator<Student> studentIterator = tutorialGroup.getStudentsSet().getIterator();
                while (studentIterator.hasNext()) {
                    Student student = studentIterator.next();
                    System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName());
                }
            }
        }
    }
}
