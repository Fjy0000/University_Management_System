package boundary;

import static control.Main.homepage;
import control.TutorialControl;
import java.util.Scanner;

public class TutorialGroupUI {
//    private TutorialControl controller = new TutorialControl();

    private TutorialControl controller = new TutorialControl();
    private Scanner scanner = new Scanner(System.in);

    public void tutorialtManagement() {
        int choice;
        do {
            choice = getMenuChoice();
            switch (choice) {
                case 1:
                    addStudentToTutorialGroup();
                    break;
                case 2:
                    listStudentsOfTutorialGroup();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    removeStudentFromGroup();
                    break;
                case 5:
                    changeStudentOfTutorialGroup();
                    break;
                case 6:
                    filterGroupsByNumberOfStudents();
                    break;
                case 7:
                    MergeGroup();
                    break;
                case 8:
                    Report();
                    break;
                case 0:
                    homepage();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public int getMenuChoice() {
        System.out.println("\nMAIN MENU");
        System.out.println("1. Add student to tutorial group");
        System.out.println("2. list students of tutorial group");
        System.out.println("3. search student of tutorial group");
        System.out.println("4. Remove student to tutorial group");
        System.out.println("5. Change student to tutorial group");
        System.out.println("6. Filter tutorial groups by given number of students");
        System.out.println("7. Merge tutorial groups who less than three students");
        System.out.println("8. Summary Report");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        return choice;
    }

    public void addStudentToTutorialGroup() {
        System.out.println("Enter student details (ID, Name, Group), or 'exit' to finish:");

        while (true) {
            System.out.print("Student ID: ");
            String studentId = scanner.nextLine().trim();

            System.out.print("Assigned Group: ");
            String groupName = scanner.nextLine().trim();
            System.out.print("\n");
            controller.addStudentToGroup(studentId, groupName);
//            controller.addStudentToGroup(studentId, studentName, contactNo, ic, progremme, groupName);
            break;
        }
    }

    public void listStudentsOfTutorialGroup() {
        System.out.print("Enter tutorial group name to list students: ");
        String groupName = scanner.nextLine().trim();
        System.out.print("\n");
        controller.listStudentsInGroup(groupName);
    }

    public void searchStudent() {
        System.out.print("Enter student ID to search: ");
        String studentId = scanner.nextLine().trim();

        System.out.print("Enter tutorial group name: ");
        String groupName = scanner.nextLine().trim();
        System.out.print("\n");
        controller.searchStudentInGroup(studentId, groupName);
    }

    private void removeStudentFromGroup() {
        System.out.print("Enter student ID to remove: ");
        String studentId = scanner.nextLine().trim();

        System.out.print("Enter tutorial group name for student removal: ");
        String groupName = scanner.nextLine().trim();
        System.out.print("\n");
        controller.removeStudentFromGroup(studentId, groupName);

    }

    private void changeStudentOfTutorialGroup() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine().trim();

        System.out.print("Enter current tutorial group name: ");
        String currentGroupName = scanner.nextLine().trim();

        System.out.print("Enter new tutorial group name: ");
        String newGroupName = scanner.nextLine().trim();

        System.out.print("\n");
        controller.changeStudentGroup(studentId, currentGroupName, newGroupName);

    }

    private void filterGroupsByNumberOfStudents() {
        System.out.print("Enter the number of students to filter tutorial groups: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("\n");
        controller.filterGroupsByNumberOfStudents(numberOfStudents);
    }

    private void MergeGroup() {
        System.out.print("Enter the name of the first tutorial group: ");
        String groupName1 = scanner.nextLine().trim();

        System.out.print("Enter the name of the second tutorial group: ");
        String groupName2 = scanner.nextLine().trim();
        System.out.print("\n");
        controller.mergeGroups(groupName1, groupName2);
    }

    private void Report() {
        System.out.print("\n");
        System.out.println("Summary Report:");
        controller.generateSummaryReport();
    }

//    public static void main(String[] args) {
//        TutorialGroupUI tutorialGroupUI = new TutorialGroupUI();
//        tutorialGroupUI.tutorialtManagement();
//    }
}
