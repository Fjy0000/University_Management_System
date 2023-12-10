/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.Set;
import adt.SetInterface;
import boundary.StudentRegistrationUI;
import entity.Student;
import java.util.Scanner;

/**
 *
 * @author Fong Jun Yi
 */
public class StudentController {

    private StudentRegistrationUI studentUI = new StudentRegistrationUI();
    private SetInterface<Student> student = new Set<>();

    Scanner input = new Scanner(System.in);

    public void studentManagement() {

        int result, exit;

        do {
            exit = -1;
            result = studentUI.studentManageMenu();

            switch (result) {
                case 1: {
                    exit = registration(student);
                    break;
                }
                case 2: {
                    exit = displayStudentList(student);
                    break;
                }
                case 3: {
                    studentUI.headerUI("Update Student Details");
                    break;
                }
                case 4: {
                    exit = manageStudentCourse(student);
                    break;
                }
                case 5: {
                    studentUI.headerUI("Remove Student");
                    break;
                }
                case 6: {
                    studentUI.headerUI("Calculate Total Cost of Registed Course");
                    break;
                }
                case 7: {
                    studentUI.headerUI("Generate Report");
                    break;
                }
                default:
                    break;
            }

        } while (exit == 0);

    }

    private int displayStudentList(SetInterface<Student> student) {
        int exit;
        int count = 0;

        studentUI.headerUI("View Student List");
        studentUI.printLine(1, 150);
        studentUI.studentListHeader();
        studentUI.printLine(1, 150);
        if (student.isEmpty()) {
            System.out.println("Oops !!! Student List is Empty............");
        } else {
            for (int i = 0; i < student.getSize(); i++) {
                ++count;
                System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s\n",
                        count, student.getElements(i).getStudentId(), student.getElements(i).getStudentName(),
                        student.getElements(i).getContactNo(), student.getElements(i).getStudentIc(),
                        student.getElements(i).getStudentProgremme(), student.getElements(i).getStudentCourse());

            }
        }
        
        exit = studentUI.studentListExit();
        return exit;
    }

    private int manageStudentCourse(SetInterface<Student> student) {
        int exit;
        studentUI.headerUI("Manage Student Course");
        
        exit = studentUI.inputExitPage();
        return exit;
    }

    private int registration(SetInterface<Student> student) {
        int exit;
        studentUI.headerUI("Add New Student");
        do {
            Student newStudent = studentUI.inputStudentDetails();
            if (studentUI.inputConfirmation() == true) {
                student.add(newStudent);
                System.out.println("Successful Registered !!!!");
            } else {
                System.out.println("Cancelled Registration !!!!");
            }
            exit = studentUI.inputExitPage();
        } while (exit == 1);
        return exit;
    }
}
