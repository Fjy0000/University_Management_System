/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.Student;
import entity.StudentCourse;
import java.util.Scanner;

/**
 *
 * @author fongj
 */
public class StudentRegistrationUI {

    Scanner input = new Scanner(System.in);

    public void titleUI(String header) {
        System.out.println();
        System.out.printf("%-20s\n", header);
        printLine(1, 35);
    }

    // Student Menu UI----------------------------------------------------------------------------------------------------------------------------
    public int studentManageMenu() {
        int option;

        System.out.println();
        printLine(1, 35);
        System.out.printf("%-10s\n", "Student Management");
        printLine(1, 35);
        System.out.printf("%2s %-10s\n", "1)", "Add Student");
        System.out.printf("%2s %-10s\n", "2)", "View Student List");
        System.out.printf("%2s %-10s\n", "3)", "Update Student Details");
        System.out.printf("%2s %-10s\n", "4)", "Manage Student Course");
        System.out.printf("%2s %-10s\n", "5)", "Remove Student");
        System.out.printf("%2s %-10s\n", "6)", "Calculate Total Cost of Registed Course");
        System.out.printf("%2s %-10s\n", "7)", "Generate Report");
        System.out.printf("%2s %-5s\n", "8)", "Exit");
        printLine(1, 35);

        System.out.printf("%-10s", "Enter Number(1-8): ");
        option = input.nextInt();

        while (option < 1 || option > 8) {
            System.out.print("Invalid option! Please select a number between 1 and 8 : ");
            option = input.nextInt();
        }

        return option;
    }

    // Student Registration UI------------------------------------------------------------------------------------------------------------------
    public String inputStudentName() {
        String name;

        do {
            System.out.printf("%-20s", "Enter Student Name : ");
            name = input.nextLine();
            if (name.length() < 4) {
                System.out.println("Student Name must more than 4 letter...");
            }
        } while (name.length() < 4);
        return name;
    }

    public String inputStudentContactNo() {
        String contactNo;

        do {
            System.out.printf("%-20s", "Enter Student Contact No : ");
            contactNo = input.nextLine();
            if (contactNo.length() < 10) {
                System.out.println("Please enter correct and real contact no...");
            }
        } while (contactNo.length() < 10);
        return contactNo;
    }

    public String inputStudentIc() {
        String ic;

        do {
            System.out.printf("%-20s", "Enter Student IC : ");
            ic = input.nextLine();
            if (ic.length() != 12 || ic.matches("\\d+") == false) {
                System.out.println("Student IC must be real...");
            }
        } while (ic.length() != 12 || ic.matches("\\d+") == false);
        return ic;
    }

    public String inputStudentProgremme() {
        String progremme;

        do {
            System.out.printf("%-20s", "Enter Student Progremme (exp: RSD): ");
            progremme = input.nextLine();
            if (progremme.isEmpty()) {
                System.out.println("Student Progremme cannot leave empty...");
            }
        } while (progremme.isEmpty());
        return progremme;
    }

    public Student inputStudentDetails() {
        input.nextLine();
        String name = inputStudentName();
        String contactNo = inputStudentContactNo();
        String ic = inputStudentIc();
        String progremme = inputStudentProgremme();
        System.out.println();

        String id = name.substring(0, 3) + "1";
        return new Student(id, name, contactNo, ic, progremme);
    }

    // Student Course UI -------------------------------------------------------------------------------------------------------------------------
    public String inputStudentId() {
        input.nextLine();
        System.out.print("Enter the Student ID : ");
        String id = input.nextLine();
        return id;
    }

    public String inputStudentCourse() {
        System.out.print("Enter the Course : ");
        String course = input.nextLine();
        return course;
    }

    public String inputCourseStatus() {
        int select;

        System.out.print("Enter the number of Course Status (Main = 1/Resit = 2/Repeat = 3) : ");
        select = input.nextInt();
        while (select < 0 || select > 3) {
            System.out.print("Invalid Enter! Please select a number between 1 and 3 (Main = 1/Resit = 2/Repeat = 3) : ");
            select = input.nextInt();
        }
        if (select == 1) {
            return "Main";
        } else if (select == 2) {
            return "Resit";
        } else {
            return "Repeat";
        }
    }

    public int addOrRemoveCourse() {
        int select;

        System.out.printf("%-20s", "Do you want to Register or Remove a student's course? (Register = 1/Remove = 2) : ");
        select = input.nextInt();
        while (select < 0 || select > 2) {
            System.out.print("Invalid Enter! Please select a number between 1 and 2 (Register = 1/Remove = 2) : ");
            select = input.nextInt();
        }
        return select;
    }

    // Display Student List UI ---------------------------------------------------------------------------------------------------------------------
    public void studentListHeader() {
        printLine(1, 150);
        System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s\n",
                "NO", "Student ID", "Student Name", "Contact No", "Student IC", "Programme", "Courses");
        printLine(1, 150);
    }

    // Display Total Cost of Registered Course UI ---------------------------------------------------------------------------------------------------------------------
    public void totalCostListHeader() {
        printLine(1, 100);
        System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \n",
                "NO", "Student ID", "Student Name", "Courses", "Total Fees");
        printLine(1, 100);
    }

    // Display Summary Report UI ---------------------------------------------------------------------------------------------------------------------
    public void summaryReportHeader() {
        printLine(1, 180);
        System.out.printf("%-15s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s \t %-15s\n",
                "Student ID", "Student Name", "Contact No", "Student IC",
                "Programme", "Courses", "Total Main", "Total Resit", "Total Repeat");
        printLine(1, 180);
    }

    // Display List Exit UI ---------------------------------------------------------------------------------------------------------------------
    public int studentListExit() {
        int exit;

        System.out.println();
        do {
            System.out.print("Enter 1 to exit this page : ");
            exit = input.nextInt();
        } while (exit != 1);
        return exit;
    }

    // Confirmation Page UI ------------------------------------------------------------------------------------------------------------------------------
    public boolean inputConfirmation(String str) {
        System.out.printf("%-20s", "Confirm to " + str + "? (Y/N): ");
        String confirm = input.nextLine();
        if (confirm.toLowerCase().equals("y") || confirm.toUpperCase().equals("Y")) {
            return true;
        } else {
            return false;
        }
    }

    // Exit Page UI ------------------------------------------------------------------------------------------------------------------------------
    public int inputExitPage() {
        int exit;

        System.out.printf("%-30s", "Do you want to EXIT this page? (Yes=1/No=0) :");
        exit = input.nextInt();
        while (exit < 0 || exit > 1) {
            System.out.printf("%-30s", "Invalid Input! Please enter 0 or 1 (Yes=1/No=0) :");
            exit = input.nextInt();
        }
        return exit;
    }

    // Print Line UI ------------------------------------------------------------------------------------------------------------------------------
    public void printLine(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("=");
            }
        }
        System.out.println();
    }
}
