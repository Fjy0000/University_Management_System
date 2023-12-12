/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.SetInterface;
import entity.Student;

/**
 *
 * @author Fong Jun Yi
 */
public class StudentInitializer {

    public void initializeStudent(SetInterface<Student> studentList) {
        studentList.add(new Student("1001", "Fong Jun Yi", "0127995565", "0123456789635", "RSD"));
        studentList.add(new Student("1002", "Ong Kar Yi", "0127995565", "0123456789635", "RSD"));
        studentList.add(new Student("1003", "Cheng Yi", "0127995565", "0123456789635", "RSD"));
        studentList.add(new Student("1004", "Yu Jun", "0127995565", "0123456789635", "RSD"));
    }
}
