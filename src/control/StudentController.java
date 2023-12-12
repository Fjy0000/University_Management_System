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
import java.util.Iterator;
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
            exit = 0;
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
        boolean isSuccessful = false;

        studentUI.titleUI("Manage Student Course");
        do {
            int select = studentUI.addOrRemoveCourse();

            switch (select) {
                case 1: {
                    id = studentUI.inputStudentId();
                    course = studentUI.inputStudentCourse();
                    status = studentUI.inputCourseStatus();
                    if (studentUI.inputConfirmation("add this Course") == true) {
                        Iterator<Student> getStudent = student.getIterator();
                        while (getStudent.hasNext()) {
                            Student object = getStudent.next();
                            if (object.getStudentId().equals(id)) {
                                object.addStudentCourse(new StudentCourse("courseid", course, status));
                                isSuccessful = true;
                                break;
                            }
                        }

                        if (isSuccessful == true) {
                            System.out.println("Added Course to this Student Successful........");

                        } else {
                            System.out.println("The Student ID no inside the list...");
                        }
                    } else {
                        System.out.println("Cancelled Adding the Course !!!!");
                    }
                    break;
                }
                case 2: {
                    id = studentUI.inputStudentId();
                    course = studentUI.inputStudentCourse();
                    if (studentUI.inputConfirmation("remove this Course") == true) {
                        Iterator<Student> getStudent = student.getIterator();
                        while (getStudent.hasNext()) {
                            Student object1 = getStudent.next();
                            if (object1.getStudentId().equals(id)) {
                                Iterator<StudentCourse> getStudentCourse = object1.getStudentCourse().getIterator();
                                while (getStudentCourse.hasNext()) {
                                    StudentCourse object2 = getStudentCourse.next();
                                    if (object2.getCourse().equals(course)) {
                                        object1.removeStudentCourse(object2);
                                        isSuccessful = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if (isSuccessful == true) {
                            System.out.println("Removed Course from this Student Successful........");
                        } else {
                            System.out.println("The Student ID no inside the list...");
                        }
                    } else {
                        System.out.println("Cancelled Removing the Course !!!!");
                    }
                    break;
                }
                default:
                    break;
            }
            exit = studentUI.inputExitPage();
        } while (exit == 0);
        return exit;
    }

    private int updateStudent(SetInterface<Student> student) {
        int exit;

        studentUI.titleUI("Update Student Details");
        do {
            studentUI.inputStudentId();
            System.out.println("1) Student Name");
            System.out.println("2) Student Contact No");
            System.out.println("3) Student IC");
            System.out.println("4) Student Progremme");
            System.out.print("Choose one to update : ");
            System.out.print("Enter New Student Name : ");
            System.out.print("Enter New Student Contact No : ");
            System.out.print("Enter New Student IC : ");
            System.out.print("Enter New Student Progremme : ");
            studentUI.inputConfirmation("update the student info");

            exit = studentUI.inputExitPage();
        } while (exit == 0);
        return exit;
    }

    private int removeStudent(SetInterface<Student> student) {
        int exit;
        String id;
        boolean isSuccessful = false;

        studentUI.titleUI("Remove Student");
        do {
            id = studentUI.inputStudentId();

            if (studentUI.inputConfirmation("remove this Student") == true) {
                Iterator<Student> getStudent = student.getIterator();
                while (getStudent.hasNext()) {
                    Student object = getStudent.next();
                    if (object.getStudentId().equals(id)) {
                        student.remove(object);
                        isSuccessful = true;
                        break;
                    }
                }
                if (isSuccessful == true) {
                    System.out.println("Removed the Student Successful........");
                } else {
                    System.out.println("The Student ID no inside the list...");
                }
            } else {
                System.out.println("Cancelled Removing the Student !!!!");
            }

            exit = studentUI.inputExitPage();
        } while (exit == 0);
        return exit;
    }

    private int displayStudentList(SetInterface<Student> student) {
        int exit;
        int count1 = 0, count2;

        studentUI.titleUI("View Student List");
        studentUI.studentListHeader();
        if (student.isEmpty()) {
            System.out.println("Oops !!! Student List is Empty............");
        } else {
            Iterator<Student> getStudent = student.getIterator();
            while (getStudent.hasNext()) {
                ++count1;
                Student studentObject = getStudent.next();
                if (studentObject.getStudentCourseSize() != 0) {
                    Iterator<StudentCourse> getStudentCourse = studentObject.getStudentCourse().getIterator();
                    count2 = 0;
                    while (getStudentCourse.hasNext()) {
                        StudentCourse courseObject = getStudentCourse.next();
                        if (count2 == 0) {
                            System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s\n",
                                    count1, studentObject.getStudentId(), studentObject.getStudentName(),
                                    studentObject.getContactNo(), studentObject.getStudentIc(),
                                    studentObject.getStudentProgremme(), courseObject.getCourse());
                            count2++;
                        } else {
                            System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s\n",
                                    "", "", "", "", "", "", courseObject.getCourse());
                            count2++;
                        }
                    }
                } else {
                    System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s \t \n",
                            count1, studentObject.getStudentId(), studentObject.getStudentName(),
                            studentObject.getContactNo(), studentObject.getStudentIc(),
                            studentObject.getStudentProgremme());
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
