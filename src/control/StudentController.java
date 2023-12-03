/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.Scanner;

/**
 *
 * @author Fong Jun Yi
 */
public class StudentController {

    public static void studentManagement() {

        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("======================================");
        System.out.printf("%-10s\n", "Student Management");
        System.out.println("======================================");
        System.out.printf("%2s %-10s\n", "1)", "Add Student");
        System.out.printf("%2s %-10s\n", "2)", "View Student List");
        System.out.printf("%2s %-10s\n", "3)", "Update Student Details");
        System.out.printf("%2s %-10s\n", "4)", "Manage Student Course ");
        System.out.printf("%2s %-10s\n", "5)", "Remove Student");
        System.out.printf("%2s %-10s\n", "6)", "Calculate Total Cost of Registed Course");
        System.out.printf("%2s %-10s\n", "7)", "Generate Report");
        System.out.printf("%2s %-5s\n", "8)", "Exit");
        System.out.println("======================================");
        do {
            System.out.printf("%-10s", "Enter Number(1-8): ");
            option = input.nextInt();

            if (option < 1 || option > 8) {
                System.out.println("Invalid option !!! Please try again....!");
            }
        } while (option < 1 || option > 8);

        switch (option) {
            case 1 -> {
                System.out.printf("%-10s\n", "Add New Student");
                System.out.printf("%10s\n", "====================================");
            }
            case 2 -> {
                System.out.printf("%-10s\n", "View Student List");
                System.out.printf("%10s\n", "====================================");
            }
            case 3 -> {
                System.out.printf("%-10s\n", "Add New Student");
                System.out.printf("%10s\n", "====================================");
            }
            case 4 -> {
                System.out.printf("%-10s\n", "View Student List");
                System.out.printf("%10s\n", "====================================");
            }
            case 5 -> {
                System.out.printf("%-10s\n", "Add New Student");
                System.out.printf("%10s\n", "====================================");
            }
            case 6 -> {
                System.out.printf("%-10s\n", "View Student List");
                System.out.printf("%10s\n", "====================================");
            }
            case 7 -> {
                System.out.printf("%-10s\n", "Add New Student");
                System.out.printf("%10s\n", "====================================");
            }
        }
        // Exit Student Management
        // page----------------------------------------------------------------
    }

}
