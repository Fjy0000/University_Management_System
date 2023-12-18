package boundary;

import adt.SetInterface;
import adt.Set;
import control.CourseControl;
import java.util.Scanner;
import entity.Course;
import entity.Faculty;
import entity.Programme;

/**
 *
 * @author Yap Ki Nen
 */
public class CourseUI {

    Scanner scanner = new Scanner(System.in);

    public static int CourseManagementMenu() {
        int option = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.printf("%-10s\n", "Course Management");
        System.out.println("======================================");
        System.out.printf("%2s %-10s\n", "1", "Add New Course");
        System.out.printf("%2s %-10s\n", "2", "Remove Course");
        System.out.printf("%2s %-10s\n", "3", "Amend Course Details");
        System.out.printf("%2s %-10s\n", "4", "List course take by each faculties ");
        System.out.printf("%2s %-10s\n", "5", "List all courses for a programme ");
        System.out.printf("%2s %-10s\n", "6", "View Course List");
        System.out.printf("%2s %-10s\n", "7", "Search Course");
        System.out.printf("%2s %-10s\n", "8", "Add programme to Course");
        System.out.printf("%2s %-10s\n", "9", "Remove programme from a Course");
        System.out.printf("%2s %-10s\n", "10", "Generate Report");
        System.out.printf("%2s %-5s\n", "0", "Exit");
        System.out.println("======================================");
        System.out.print("Enter Number(0-10): ");
        option = scanner.nextInt();

        while (option < 0 || option > 10) {
            System.out.print("Invalid option! Please select a number between 0 and 10 : ");
            option = scanner.nextInt();
        }
        return option;
    }
    
    public void printLine(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("=");
            }
        }
        System.out.println();
    }

}
