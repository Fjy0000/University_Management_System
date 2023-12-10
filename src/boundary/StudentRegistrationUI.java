/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.Student;
import java.util.Scanner;

/**
 *
 * @author fongj
 */
public class StudentRegistrationUI {

    Scanner input = new Scanner(System.in);

    public void headerUI(String header) {
        System.out.println();
        System.out.printf("%-20s\n", header);
        System.out.println("==========================================");
    }

    // Student Menu ----------------------------------------------------------------------------------------------------------------------------
    public int studentManageMenu() {
        int option;

        System.out.println();
        System.out.println("============================================");
        System.out.printf("%-10s\n", "Student Management");
        System.out.println("============================================");
        System.out.printf("%2s %-10s\n", "1)", "Add Student");
        System.out.printf("%2s %-10s\n", "2)", "View Student List");
        System.out.printf("%2s %-10s\n", "3)", "Update Student Details");
        System.out.printf("%2s %-10s\n", "4)", "Manage Student Course");
        System.out.printf("%2s %-10s\n", "5)", "Remove Student");
        System.out.printf("%2s %-10s\n", "6)", "Calculate Total Cost of Registed Course");
        System.out.printf("%2s %-10s\n", "7)", "Generate Report");
        System.out.printf("%2s %-5s\n", "8)", "Exit");
        System.out.println("=============================================");

        System.out.printf("%-10s", "Enter Number(1-8): ");
        option = input.nextInt();

        while (option < 1 || option > 8) {
            System.out.print("Invalid option! Please select a number between 1 and 8 : ");
            option = input.nextInt();
        }

        return option;
    }

    // Student Registration ------------------------------------------------------------------------------------------------------------------
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
            if (contactNo.length() < 12 ) {
                System.out.println("Please enter correct and real contact no...");
            }
        } while (contactNo.length() < 12);
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

    public int inputContinuePage() {
        int exit;
        System.out.printf("%-30s", "Do you want to continue this page? (Yes=1/No=0) :");
        exit = input.nextInt();
        while (exit < 0 || exit > 1) {
            System.out.printf("%-30s", "Invalid Input! Please enter 0 or 1 (Yes=1/No=0) :");
            exit = input.nextInt();
        }
        return exit;
    }

    public boolean inputConfirmation() {
        System.out.printf("%-20s", "Confirm Registration the Student Account? (Y/N): ");
        String confirm = input.nextLine();
        if (confirm.toLowerCase().equals("y") || confirm.toUpperCase().equals("Y")) {
            return true;
        } else {
            return false;
        }
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

}
