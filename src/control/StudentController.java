/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.Set;
import adt.SetInterface;
import boundary.StudentRegistrationUI;
import static control.Main.homepage;
import entity.Student;
import entity.StudentCourse;
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
                    exit = updateStudent(student);
                    break;
                }
                case 4: {
                    exit = manageStudentCourse(student);
                    break;
                }
                case 5: {
                    exit = removeStudent(student);
                    break;
                }
                case 6: {
                    exit = displayTotalCost(student);
                    break;
                }
                case 7: {
                    exit = displayReport(student);
                    break;
                }
                case 8:
                    homepage();
                    break;
            }
        } while (exit == 1);
    }

    private int registration(SetInterface<Student> student) {
        int exit;
        studentUI.titleUI("Add New Student");
        do {
            Student newStudent = studentUI.inputStudentDetails();
            if (studentUI.inputConfirmation("add new student") == true) {
                student.add(newStudent);
                System.out.println("Successful Registered !!!!");
            } else {
                System.out.println("Cancelled Registration !!!!");
            }
            exit = studentUI.inputExitPage();
        } while (exit == 0);
        return exit;
    }

    private int manageStudentCourse(SetInterface<Student> student) {
        int exit;
        String id, course, status;
        int count;
        boolean findId = false;

        studentUI.titleUI("Manage Student Course");
        do {
            count = 0;
            int select = studentUI.addOrRemoveCourse();
            if (select == 1) { // register course
                id = studentUI.inputStudentId();
                course = studentUI.inputStudentCourse();
                status = studentUI.inputCourseStatus();

                for (int i = 0; i < student.getSize(); i++) {
                    if (student.getElements(i).getStudentId().equals(id)) {
                        count = i;
                        findId = true;
                        break;
                    }
                }
                if (findId = true) {
                    student.getElements(count).addStudentCourse(new StudentCourse(id, course, status));
                    System.out.println("Added Course to this Student Successful........");
                } else {
                    System.out.println("The Student ID no inside the list...");
                }
                exit = studentUI.inputExitPage();
                return exit;
            } else { // remove course
                id = studentUI.inputStudentId();
                course = studentUI.inputStudentCourse();
                status = studentUI.inputCourseStatus();

                for (int i = 0; i < student.getSize(); i++) {
                    if (student.getElements(i).getStudentId().equals(id)) {
                        count = i;
                        findId = true;
                        break;
                    }
                }
                if (findId = true) {
                    student.getElements(count).removeStudentCourse(new StudentCourse(id, course, status));
                    System.out.println("Removed Course from this Student Successful........");
                } else {
                    System.out.println("The Student ID no inside the list...");
                }
                exit = studentUI.inputExitPage();
                return exit;
            }
        } while (exit == 0);
    }

    private int updateStudent(SetInterface<Student> student) {
        int exit;

        studentUI.titleUI("Update Student Details");
        do {

            exit = studentUI.inputExitPage();
        } while (exit == 0);
        return exit;
    }

    private int removeStudent(SetInterface<Student> student) {
        int exit;

        studentUI.titleUI("Remove Student");
        do {

            exit = studentUI.inputExitPage();
        } while (exit == 0);
        return exit;
    }

    private int displayStudentList(SetInterface<Student> student) {
        int exit;
        int count = 0;

        studentUI.titleUI("View Student List");
        studentUI.studentListHeader();
        if (student.isEmpty()) {
            System.out.println("Oops !!! Student List is Empty............");
        } else {
            for (int i = 0; i < student.getSize(); i++) {
                ++count;
                if (student.getElements(i).getStudentCourseSize() != 0) {
                    for (int j = 0; j < student.getElements(i).getStudentCourseSize(); j++) {
                        if (j > 0) {
                            System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s\n",
                                    "", "", "", "", "", "", 
                                    student.getElements(i).getStudentCourse().getElements(j).getCourse());
                        } else {
                            System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s\n",
                                    count, student.getElements(i).getStudentId(), student.getElements(i).getStudentName(),
                                    student.getElements(i).getContactNo(), student.getElements(i).getStudentIc(),
                                    student.getElements(i).getStudentProgremme(),
                                    student.getElements(i).getStudentCourse().getElements(j).getCourse());
                        }
                    }
                } else {
                    System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s \t \n",
                            count, student.getElements(i).getStudentId(), student.getElements(i).getStudentName(),
                            student.getElements(i).getContactNo(), student.getElements(i).getStudentIc(),
                            student.getElements(i).getStudentProgremme());
                }

            }
        }

        exit = studentUI.studentListExit();
        return exit;
    }

    private int displayTotalCost(SetInterface<Student> student) {
        int exit;

        studentUI.titleUI("Calculate Total Cost of Registed Course");
        studentUI.totalCostListHeader();
        exit = studentUI.studentListExit();
        return exit;
    }

    private int displayReport(SetInterface<Student> student) {
        int exit;

        studentUI.titleUI("Generate Report");
        studentUI.summaryReportHeader();
        exit = studentUI.studentListExit();
        return exit;
    }
}
