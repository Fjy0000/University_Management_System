/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

import adt.SetInterface;
import static control.StudentController.studentManagement;
import dao.TutorInitializer;
import entity.Tutor;
import java.util.Scanner;

/**
 *
 * @author fongj
 */
public class Main {
    
    public static void main(String[] args) {
        
        // static Data --------------------------------------------------
        TutorInitializer t = new TutorInitializer();
        SetInterface<Tutor> tutorList = t.initializeTutor();
        
        
        int userType;
        Scanner scanner = new Scanner(System.in);

        printHyphen(1, 30);
        System.out.println("Welcome to TARUC Management System");
        printHyphen(1, 30);
        
        studentManagement();

//        do{
//        userType = login(scanner);
//
//        switch (userType) {
//            case 1 -> {
//                System.out.print("\033[H\033[2J");
//                tutorMenu();
//            }
//            case 2 ->{
//                System.out.print("\033[H\033[2J");
//                
//            }
//        }
//        }while(userType == 0);

    }

//    private static int login(Scanner scanner) {
//        String loginId, password;
//
//        System.out.printf("%-10s", "Login ID: ");
//        loginId = scanner.nextLine();
//        System.out.printf("%-10s", "Password: ");
//        password = scanner.nextLine();
//
//        //match with staff user then return 1
//        if () {
//            return 1;
//        } // match with student user then return 2
//        else if () {
//            return 2;
//        } // dont match any user then return 0
//        else {
//            return 0;
//        }
//    }
    
    private static void tutorMenu() {
        System.out.printf("%2d%2s %-10s\n", ")", "Student Registration Management");
        System.out.printf("%2d%2s %-10s\n", ")", "Course Management");
        System.out.printf("%2d%2s %-10s\n", ")", "Progremme Management");
        System.out.printf("%2d%2s %-10s\n", ")", "Tutorial Group Management");
        System.out.printf("%2d%2s %-5s\n", ")", "Logout");
        printHyphen(1,30);
    }

    private static void printHyphen(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("-");
            }
        }
        System.out.println();
    }
}
