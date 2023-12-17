package boundary;

import java.util.Scanner;

public class TutorialGroupUI {

    private Scanner scanner = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    public int getMenuChoice() {
        int option;
        System.out.println("\nMAIN MENU");
        System.out.println("1. Add student to tutorial group");
        System.out.println("2. list students of tutorial group");
        System.out.println("3. search student of tutorial group");
        System.out.println("4. Remove student to tutorial group");
        System.out.println("5. Change student to tutorial group");
        System.out.println("6. Filter tutorial groups by given number of students");
        System.out.println("7. Merge tutorial groups who less than three students");
        System.out.println("8. Summary Report");
        System.out.println("9. Quit");
        System.out.print("\n");
        System.out.print("Enter choice: ");
        option = input.nextInt();
        System.out.print("\n");

        while (option < 1 || option > 9) {
            System.out.print("Invalid option! Please select a number between 1 and 8 : ");
            option = input.nextInt();
        }

        return option;
    }

    public String inputstudentId() {
        System.out.println("Enter student details (ID, Name, Group)");
        System.out.print("Student ID: ");
        return scanner.nextLine().trim();
    }

    public String inputgroupName() {
        System.out.print("Group Name: ");
        return scanner.nextLine().trim();
    }
    
    public int inputNumberOfStudents() {
        System.out.print("Enter the number of students to filter tutorial groups: ");
        return scanner.nextInt();
    }
    
    public String inputMergeGroups(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    
    public void titleUI(String header) {
        System.out.println();
        System.out.println(header);
        printLine(1, 35);
    }
    
     public void groupListHeader() {
        System.out.println();
        printLine(1, 52);
        System.out.printf("%-15s \t %-15s \t %-15s\n",
                "Student ID", "Student Name", "Programme");
        printLine(1, 52);
    }
//    --------------------------------------------------------------------------------------------------------------
    public void printLine(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("-");
            }
        }
        System.out.println();
    }
}