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

    CourseControl courseInitializer = new CourseControl();

    Scanner scanner = new Scanner(System.in);

    public static void CourseManagement() {

        Scanner input = new Scanner(System.in);
        int selection;

        System.out.println("======================================");
        System.out.printf("%-10s\n", "Course Management");
        System.out.println("======================================");
        System.out.printf("%2s %-10s\n", "1", "Add New Course");
        System.out.printf("%2s %-10s\n", "2", "Remove Course");
        System.out.printf("%2s %-10s\n", "3", "Update Course Details");
        System.out.printf("%2s %-10s\n", "4", "List course take by each faculties ");
        System.out.printf("%2s %-10s\n", "5", "View Course List");
        System.out.printf("%2s %-10s\n", "6", "Search Course");
        System.out.printf("%2s %-10s\n", "7", "Add programme to Course");
        System.out.printf("%2s %-10s\n", "8", "Remove programme from a Course");
        System.out.printf("%2s %-10s\n", "9", "Generate Report");
        System.out.printf("%2s %-5s\n", "10", "Exit");
        System.out.println("======================================");

        do {
            System.out.printf("%-10s", "Enter Number(0-9): ");
            selection = input.nextInt();

            if (selection < 1 || selection > 10) {
                System.out.println("Invalid option !!! Please try again....!");
            }
        } while (selection < 1 || selection > 10);

        switch (selection) {
            case 1: {
                System.out.printf("%-10s\n", "Add New Course");
                System.out.printf("%10s\n", "====================================");
            }
            case 2: {
                System.out.printf("%-10s\n", "Remove Course");
                System.out.printf("%10s\n", "====================================");
            }
            case 3: {
                System.out.printf("%-10s\n", "Update Course Details");
                System.out.printf("%10s\n", "====================================");
            }
            case 4: {
                System.out.printf("%-10s\n", "List course take by each faculties");
                System.out.printf("%10s\n", "====================================");
            }
            case 5: {
                System.out.printf("%-10s\n", "View Course List");
                System.out.printf("%10s\n", "====================================");
            }
            case 6: {
                System.out.printf("%-10s\n", "Search Course");
                System.out.printf("%10s\n", "====================================");
            }
            case 7: {
                System.out.printf("%-10s\n", "Add programme to Course");
                System.out.printf("%10s\n", "====================================");
            }
            case 8: {
                System.out.printf("%-10s\n", "Remove programme from a Course");
                System.out.printf("%10s\n", "====================================");
            }
            case 9: {
                System.out.printf("%-10s\n", "Generate Report");
                System.out.printf("%10s\n", "====================================");
            }
            default:
                System.out.println("Invalid search choice.");
                return;

        }
    }

    private void addCourse() {
        scanner.nextLine(); // Consume newline left by previous nextInt()
        System.out.println("Enter Course details (ID, Name, Faculty, fee):");

        System.out.print("Course ID: ");
        String courseId = scanner.nextLine().trim();

        System.out.print("Course Name: ");
        String courseName = scanner.nextLine().trim();

        System.out.print("Enter faculty: ");
        String faculty = scanner.nextLine().trim();

        System.out.print("Enter the Fee: ");
        int courseFee = scanner.nextInt();

        courseInitializer.addCourseByUserInput();

//         String logEntry = "Added course - ID: " + courseId + ", Name: " + courseName + ", Faculty: " + faculty;
//        reportLog.append(logEntry).append("\n");
    }

//    private void listCoursesByFaculty() {
//        scanner.nextLine(); // Consume newline left by previous nextInt()
//        System.out.print("Enter Faculty name to list courses: ");
//        String facultyName = scanner.nextLine().trim();
//        courseInitializer.listCoursesByFaculty(facultyName);
//    }
    private void viewCourseList() {
        courseInitializer.getCourseSet();
    }

    private void searchCourse() {
        scanner.nextLine(); // Consume newline left by previous nextInt()
        System.out.print("Enter Course ID to search: ");
        String courseId = scanner.nextLine().trim();
        courseInitializer.searchCourseByUserInput();
    }

    private void removeCourse() {
        scanner.nextLine(); // Consume newline left by previous nextInt()
        System.out.print("Enter Course ID to remove: ");
        String courseId = scanner.nextLine().trim();
        courseInitializer.removeCourseByUserInput();

//        String logEntry = "Removed course - ID: " + courseId;
//        reportLog.append(logEntry).append("\n");
    }

//    private void updateCourseDetail() {
//    scanner.nextLine(); // Consume newline left by previous nextInt()
//    System.out.print("Enter Course ID to update details: ");
//    String courseId = scanner.nextLine().trim();
//
//    Course courseToUpdate = courseInitializer.searchCourseByUserInput();
//
//        if (courseToUpdate != null) {
//            System.out.println("Enter new details for the course:");
//        
//            System.out.print("New Course Name: ");
//            String newCourseName = scanner.nextLine().trim();
//        
//            System.out.print("New Faculty: ");
//            String newFaculty = scanner.nextLine().trim();
//
//            System.out.print("New Fee: ");
//            int newFee = scanner.nextInt();
//
//        // Update course details
//            courseToUpdate.setCourseName(newCourseName);
//            courseToUpdate.setFaculty(newFaculty);
//            courseToUpdate.setCourseFee(newFee);
//
//            System.out.println("Course details updated successfully: " + courseToUpdate);
//            } else {
//            System.out.println("Course with ID " + courseId + " not found.");
//                }
////                 String logEntry = "Updated course details - ID: " + courseId + ", Updated Name: " + updatedName +
////                ", Updated Faculty: " + updatedFaculty + ", Updated Fee: " + updatedFee;
////        reportLog.append(logEntry).append("\n");
//            }
//    public void addProgrammeToCourse() {
//    Scanner scanner = new Scanner(System.in);
//
//    System.out.print("Enter Course ID to add programme: ");
//    String courseId = scanner.nextLine().trim();
//
//    Course course = findCourseById(courseId);
//
//    if (course != null) {
//        System.out.print("Enter Faculty Name: ");
//        String facultyName = scanner.nextLine().trim();
//
//        if (course.getFaculty().equals(facultyName)) {
//            System.out.print("Enter Programme ID: ");
//            String programmeId = scanner.nextLine().trim();
//
//            System.out.print("Enter Programme Name: ");
//            String programmeName = scanner.nextLine().trim();
//
//            Programme programme = new Programme(programmeId, programmeName);
//
//            if (course.addProgramme(programme)) {
//                System.out.println("Programme added to the course successfully: " + programme);
//            } else {
//                System.out.println("Programme with ID " + programmeId + " already exists in the course.");
//            }
//        } else {
//            System.out.println("Faculty name does not match the course's faculty.");
//            }
//        } else {
//        System.out.println("Course with ID " + courseId + " not found.");
//        }
//    
////        String logEntry = "Added course - ID: " + courseId + ", Name: " + courseName + ", Faculty: " + faculty;
////        reportLog.append(logEntry).append("\n");
//    }
//    public void removeProgrammeFromCourse() {
//    Scanner scanner = new Scanner(System.in);
//
//    System.out.print("Enter Course ID to remove programme: ");
//    String courseId = scanner.nextLine().trim();
//
//    Course course = findCourseById(courseId);
//
//    if (course != null) {
//        System.out.print("Enter Faculty Name: ");
//        String facultyName = scanner.nextLine().trim();
//
//        if (course.getFaculty().equals(facultyName)) {
//            System.out.print("Enter Programme ID to remove: ");
//            String programmeId = scanner.nextLine().trim();
//
//            Programme programmeToRemove = new Programme(programmeId, "");
//
//            if (course.removeProgramme(programmeToRemove)) {
//                System.out.println("Programme removed from the course successfully: " + programmeToRemove);
//            } else {
//                System.out.println("Programme with ID " + programmeId + " not found in the course.");
//            }
//        } else {
//            System.out.println("Faculty name does not match the course's faculty.");
//            }
//        } else {
//        System.out.println("Course with ID " + courseId + " not found.");
//            }
//        }
//    
//    public void generateSummaryReport() {
//        // Get current date and time (this is just an example, you may need to use a proper date/time library)
//        String currentTime = java.time.LocalDateTime.now().toString();
//
//        // Create a title for the report
//        String reportTitle = "Course Management System - Summary Report";
//
//        // Combine all information into a summary report
//        StringBuilder summaryReport = new StringBuilder();
//        summaryReport.append(reportTitle).append("\n");
//        summaryReport.append("Date and Time: ").append(currentTime).append("\n\n");
//        summaryReport.append("Operations Log:\n").append(reportLog);
//
//        // Display or save the summary report as needed
//        System.out.println(summaryReport.toString());
}
