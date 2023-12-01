/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author hongli
 */
import adt.Set;
import adt.SetInterface;
import java.io.Serializable;

/**
 *
 * @author 60111
 */
public class TutorialGroup implements Serializable{
    private String groupName;
    private static int groupNum = 1;
    private boolean assigned;
    
    public TutorialGroup() {
    }

    public TutorialGroup(String groupName) {
        this.groupName = groupName;
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
