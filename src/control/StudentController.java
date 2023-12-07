/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.Set;
import adt.SetInterface;
import entity.Student;
import java.util.Scanner;

/**
 *
 * @author Fong Jun Yi
 */
public class StudentController {

    private static final int MAX_INVALID_ATTEMPTS = 3;

    public static void studentManagement() {

        SetInterface<Student> student = new Set<>();

        Scanner input = new Scanner(System.in);
        int countInvalidInput;
        int option, exit;

        do {
            exit = 0;
            countInvalidInput = 0;

            studentManageMenu();

            do {
                System.out.printf("%-10s", "Enter Number(1-8): ");
                option = input.nextInt();

                if (option < 1 || option > 8) {
                    System.out.println("Invalid option! Please enter a number between 1 and 8.");
                    ++countInvalidInput;
                }

                if (countInvalidInput >= MAX_INVALID_ATTEMPTS) {
                    break;
                }
            } while (option < 1 || option > 8);

            switch (option) {
                case 1 -> {
                    headerUI("Add New Student", 1, 30);
                    exit = registration(student);
                }
                case 2 -> {
                    headerUI("View Student List", 1, 30);

                }
                case 3 -> {
                    headerUI("Update Student Details", 1, 30);

                }
                case 4 -> {
                    headerUI("Manage Student Course", 1, 30);

                }
                case 5 -> {
                    headerUI("Remove Student", 1, 30);

                }
                case 6 -> {
                    headerUI("Calculate Total Cost of Registed Course", 1, 30);

                }
                case 7 -> {
                    headerUI("Generate Report", 1, 30);
                }
            }

        } while (countInvalidInput >= MAX_INVALID_ATTEMPTS || exit == 1);

    }

    private static int registration(SetInterface<Student> student) {
        Scanner input = new Scanner(System.in);
        String id, name, password, ic, progremme, confirm;
        int countInvalidInput, exit;

        do {
            countInvalidInput = 0;

            // Consume the newline character left in the buffer
            input.nextLine();

            do {
                System.out.printf("%-20s", "Enter Student Name : ");
                name = input.nextLine();
                if (name.length() < 3) {
                    System.out.println("Student Name must more than 3 letter...");
                }
            } while (name.length() < 3);

            do {
                System.out.printf("%-20s", "Enter Student Password : ");
                password = input.nextLine();
                if (password.length() < 5) {
                    System.out.println("Student Password must more than 5 character...");
                }
            } while (password.length() < 5);

            do {
                System.out.printf("%-20s", "Enter Student IC : ");
                ic = input.nextLine();
                if (ic.length() != 12 || ic.matches("\\d+") == false) {
                    System.out.println("Student IC must be real...");
                }
            } while (ic.length() != 12 || ic.matches("\\d+") == false);

            do {
                System.out.printf("%-20s", "Enter Student Progremme (exp: RSD): ");
                progremme = input.nextLine();
                if (progremme.isEmpty()) {
                    System.out.println("Student Progremme cannot leave empty...");
                }
            } while (progremme.isEmpty());

            System.out.println();
            System.out.printf("%-20s", "Confirm Registration the Student Account? (Y/N): ");
            confirm = input.nextLine();

            if (confirm.toLowerCase().equals("y")) {
                //generate student id first 3 character of name + year + number
                id = name.substring(0, 3) + "1";

                // added new student account
                student.add(new Student(id, name, password, ic, progremme));
                System.out.println("Successful Registered !!!!");
            } else if (confirm.toLowerCase().equals("n")) {
                System.out.println("Cancelled Registration !!!!");
            }

            //Exit or Continue registration
            System.out.printf("%-30s", "Do you want to continue registering student ? (Yes=0/No=1) :");
            exit = input.nextInt();
            while (exit < 0 || exit > 1) {
                ++countInvalidInput;
                System.out.printf("%-30s", "Invalid Input! Please enter 0 or 1 (Yes=0/No=1) :");
                exit = input.nextInt();

                if (countInvalidInput >= MAX_INVALID_ATTEMPTS) {
                    break;
                }
            }
        } while (countInvalidInput >= MAX_INVALID_ATTEMPTS || exit == 0);
        return exit;
    }

    private static void headerUI(String header, int row, int col) {
        System.out.printf("%-20s\n", header);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    private static void studentManageMenu() {
        System.out.println("======================================");
        System.out.printf("%-10s\n", "Student Management");
        System.out.println("======================================");
        System.out.printf("%2s %-10s\n", "1)", "Add Student");
        System.out.printf("%2s %-10s\n", "2)", "View Student List");
        System.out.printf("%2s %-10s\n", "3)", "Update Student Details");
        System.out.printf("%2s %-10s\n", "4)", "Manage Student Course");
        System.out.printf("%2s %-10s\n", "5)", "Remove Student");
        System.out.printf("%2s %-10s\n", "6)", "Calculate Total Cost of Registed Course");
        System.out.printf("%2s %-10s\n", "7)", "Generate Report");
        System.out.printf("%2s %-5s\n", "8)", "Exit");
        System.out.println("======================================");
    }
}
