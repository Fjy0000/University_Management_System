package dao;

import adt.Set;
import adt.SetInterface;
import entity.Student;

/**
 *
 * @author Fong Jun Yi
 */
public class StudentInitializer {

    public SetInterface<Student> initializeStudent() {

        SetInterface<Student> stuList = new Set<>();

        //Initialize Student Data --------------------------------------------------------------------------------------------------
        stuList.add(new Student("F1001", "Fong Jun Yi", "0127995565", "Male", "Bachelor of Information Technology (Honours) in Software Systems Development", "RSD"));
        stuList.add(new Student("O1002", "Ong Kar Yi", "0127995565", "Male", "Bachelor of Information Technology (Honours) in Software Systems Development", "RSD"));
        stuList.add(new Student("C1003", "Cheng Yi", "0127995565", "Female", "Bachelor of Information Technology (Honours) in Software Systems Development", "RSD"));
        stuList.add(new Student("Y1004", "Yu Jun", "0127995565", "Female", "Bachelor of Information Technology (Honours) in Software Systems Development", "RSD"));

        return stuList;
    }
}
