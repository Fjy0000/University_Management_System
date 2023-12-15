package dao;

import adt.SetInterface;
import entity.Student;

/**
 *
 * @author Fong Jun Yi
 */
public class StudentInitializer {

    public void initializeStudent(SetInterface<Student> studentList) {
        studentList.add(new Student("F1001", "Fong Jun Yi", "0127995565", "Male", "Bachelor of Information Technology (Honours) in Software Systems Development"));
        studentList.add(new Student("O1002", "Ong Kar Yi", "0127995565", "Male", "Bachelor of Information Technology (Honours) in Software Systems Development"));
        studentList.add(new Student("C1003", "Cheng Yi", "0127995565", "Female", "Bachelor of Information Technology (Honours) in Software Systems Development"));
        studentList.add(new Student("Y1004", "Yu Jun", "0127995565", "Female", "Bachelor of Information Technology (Honours) in Software Systems Development"));
    }
}
