/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.arraySet;
import adt.SetInterface;
import java.util.Iterator;

/**
 *
 * @author 60111
 */
public class TutorialGroup{
    private String groupName;
    private static int groupNum = 1;
    private boolean assigned;
    private SetInterface<Student> students = new arraySet<>();
    
    public TutorialGroup() {
        this.students = new arraySet<>(); // Initialize the set of students
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
            students.add(student);
        }

    // Method to list all students in the tutorial group
    public void listStudents() {
        System.out.println("Students in Tutorial Group " + groupName + ":");
        Iterator<Student> iterator = students.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
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
}
