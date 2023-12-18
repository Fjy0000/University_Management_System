package control;

import adt.Set;
import adt.SetInterface;
import dao.StudentInitializer;
import entity.Course;
import entity.Faculty;
import entity.Programme;
import entity.Student;
import entity.TutorialGroup;
import java.util.Scanner;

/**
 *
 * @author Fong Jun Yi
 */
public class Main {

    private static final int MAX_INVALID_ATTEMPTS = 3;

    // Page ------------------------------------------------------------------------
    private static StudentController studentPage = new StudentController();
    private static TutorialControl tutorialPage = new TutorialControl();
    private static ProgrammeController programmePage = new ProgrammeController();
    private static CourseControl coursePage = new CourseControl();

    // Set Array List --------------------------------------------------------------
    // Declare Collection ADT Object
    static SetInterface<Course> courseSet = new Set<>();
    static SetInterface<Faculty> facultySet = new Set<>();

    static StudentInitializer stu = new StudentInitializer();
    static SetInterface<Student> student = stu.initializeStudent();

    static SetInterface<Programme> programmeSet = new Set<>();

    //take student from student register set into assignedStudents
    static SetInterface<Student> assignedStudents = new Set<>();
    static SetInterface<TutorialGroup> tutorialGroups = new Set<>();

    public static void main(String[] args) {

        //Initialize Data --------------------------------------------------------------------------------------------------
        // Course & Faculty
        courseSet.add(new Course("1001", "Object-Oriented Programming"));
        courseSet.add(new Course("1002", "Cloud Computing"));
        courseSet.add(new Course("1003", "Web Design and Development"));

        facultySet.add(new Faculty("FAFB", "Faculty of Accountancy,Finance and Business"));
        facultySet.add(new Faculty("FOAS", "Faculty of Applied Sciences"));
        facultySet.add(new Faculty("FOCS", "Faculty of Computing and Information Technology"));
        facultySet.add(new Faculty("FAFB", "Faculty of Built Environment"));
        facultySet.add(new Faculty("FOET", "Faculty of Engineering and Technology"));
        facultySet.add(new Faculty("FCCI", "Faculty of Communication and Creative Industries"));
        facultySet.add(new Faculty("FSSH", "Faculty of Social Science and Humanities"));

        // Programme
        programmeSet.add(new Programme("RSD", "DEGREE", "Bachelor of Information Technology (Honours) in Software Systems Development", "FOCS", "June", 1));
        programmeSet.add(new Programme("RIT", "DEGREE", "Bachelor of Information Technology (Honours) in Internet Technology", "FOCS", "June", 1));
        programmeSet.add(new Programme("RSE", "DEGREE", "SOFTWARE ENGINEERING", "FOCS", "OCTOBER", 3));
        programmeSet.add(new Programme("RDS", "DEGREE", "DATA SCIENCE", "FOCS", "OCTOBER", 3));

        tutorialGroups.add(new TutorialGroup("G1"));
        tutorialGroups.add(new TutorialGroup("G2"));
        tutorialGroups.add(new TutorialGroup("G3"));

        homepage();
    }

    public static void homepage() {
        int countInvalidInput;
        int option;

        Scanner scanner = new Scanner(System.in);

        printLine(1, 40);
        System.out.println("Welcome to TARUC Management System");
        printLine(1, 40);

        do {
            countInvalidInput = 0;
            System.out.printf("%2s %-10s\n", "1)", "Student Registration Management");
            System.out.printf("%2s %-10s\n", "2)", "Course Management");
            System.out.printf("%2s %-10s\n", "3)", "Progremme Management");
            System.out.printf("%2s %-10s\n", "4)", "Tutorial Group Management");
            System.out.printf("%2s %-5s\n", "5)", "Exit System");
            printLine(1, 40);

            do {
                System.out.printf("%-10s", "Enter Number(1-5): ");
                option = scanner.nextInt();

                if (option < 1 || option > 5) {
                    System.out.println("Invalid option! Please enter a number between 1 and 5.");
                    ++countInvalidInput;
                }

                if (countInvalidInput >= MAX_INVALID_ATTEMPTS) {
                    break;
                }
            } while (option < 1 || option > 5);

            switch (option) {
                case 1: //Student Management
                    studentPage.studentManagement();
                    break;
                case 2: //Course Management
                    coursePage.CourseManagement();
                    break;
                case 3: // Progremme Management
                    programmePage.ProgrammeManagement();
                    break;
                case 4: // Tutorial Group Management
                    tutorialPage.tutorialtManagement();
                    break;
                default:
                    break;
            }

        } while (countInvalidInput >= MAX_INVALID_ATTEMPTS);
    }

    private static void printLine(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("=");
            }
        }
        System.out.println();
    }

}
