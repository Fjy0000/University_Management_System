package control;

import adt.Set;
import adt.SetInterface;
import adt.SortedIterator;
import entity.Course;
import entity.Faculty;
import entity.Programme;
import java.util.Scanner;
import static control.Main.courseSet;
import static control.Main.facultySet;
import static control.Main.homepage;
import static control.Main.programmeSet;

/**
 *
 * @author User
 */
public class CourseControl {

    public static void main(String[] args) {
        // Create an instance of Course_Faculty
        CourseControl course = new CourseControl();
        Scanner scanner = new Scanner(System.in);

        // Main Menu
        System.out.println("Menu:");
        System.out.println("1. Add Course");
        System.out.println("2. Remove Course");
        System.out.println("3. Search Course");
        System.out.println("4. Display All Courses");
        System.out.println("5. Display Courses Taken by Faculty");
        System.out.println("6. Amend Courses detail");
        System.out.println("7. List all course for a programme ");
        System.out.println("8. Add programme to a course ");
        System.out.println("9. Remove programme to a course ");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                course.addCourseByUserInput();
                break;
            case 2:
                course.removeCourseByUserInput();
                break;
            case 3:
                course.searchCourseByUserInput();
                break;
            case 4:
                course.displayAllCourses(courseSet);
                break;
            case 5:
                System.out.print("Enter Faculty ID: ");
                String facultyId = scanner.next();

                System.out.println("Courses taken by Faculty " + facultyId + ":");
                //course.displayAllCourses(coursesTakenByFaculty);
                break;
            case 6:
                course.editCourseDetail();
                break;
            case 7:
//                System.out.print("Enter Programme ID: ");
//                String programmeId = scanner.next();
//                SetInterface<Course> coursesForProgramme = initializer.getCoursesForProgramme(programmeId);
//                System.out.println("Courses for Programme " + programmeId + ":");
//                initializer.displayAllCourses(coursesForProgramme);
                break;
            case 8:
//                course.addProgramToCourse();
                break;
            case 9:
//                course.removeProgramFromCourse();
                break;
            case 0:
                homepage();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

    }

    public void addCourseByUserInput() {
        Scanner scanner = new Scanner(System.in);
        int continueAdd = 0;

        System.out.println("Enter Course ID:");
        String courseId = scanner.next();

        // Check if the course already exists before adding
        if (findCourseById(courseId) == null) {
            System.out.println("Enter Course Name:");
            String courseName = scanner.next();

            System.out.println("Enter Faculty:");
            String faculty = scanner.next();

            System.out.println("Confirm Add Course? (yes =1 / no =2)");
            int enter = scanner.nextInt();
            if (enter == 1) {
                Course newCourse = new Course(courseId, courseName);
                courseSet.add(newCourse);

                // Display Faculty List
                SortedIterator<Faculty> getFaculty = facultySet.getIterator();
                while (getFaculty.hasNext()) {

                    Faculty facultyOj = getFaculty.next();
                    System.out.println("ID \t Faculty Name");
                    System.out.println(facultyOj.getfacultyId() + ")" + facultyOj.getfacultyName());
                }
                do {
                    System.out.println("Enter Select the Faculty : ");
                    String facultyID = scanner.nextLine();
                    SortedIterator<Course> getCourse = courseSet.getIterator();
                    while (getCourse.hasNext()) {
                        Course courseOj = getCourse.next();
                        if (courseOj.getCourseId().equals(courseId)) {
                            while (getFaculty.hasNext()) {
                                Faculty facultyOj = getFaculty.next();
                                if (facultyOj.getfacultyId().equals(facultyID)) {
                                    courseOj.addFaculty(facultyOj);
                                }
                            }
                        }

                    }
                    System.out.println("Do you want to add another more faculty to this course (yes=1/no=2) :");
                    continueAdd = scanner.nextInt();
                } while (continueAdd == 1);
                System.out.println("Course added successfully: " + newCourse);
            } else {
                System.out.println("Cancelled !!!!");
            }
        } else {
            System.out.println("Course with ID " + courseId + " already exists.");
        }
    }

    public void removeCourseByUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Course ID to remove:");
        String courseId = scanner.next();

        Course courseToRemove = findCourseById(courseId);

        if (courseToRemove != null) {
            courseSet.remove(courseToRemove);
            System.out.println("Course removed successfully: " + courseToRemove);
        } else {
            System.out.println("Course with ID " + courseId + " not found.");
        }
    }

    public void searchCourseByUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Course ID to search:");
        String courseId = scanner.next();

        Course foundCourse = findCourseById(courseId);

        if (foundCourse != null) {
            System.out.println("Found Course: " + foundCourse);
        } else {
            System.out.println("Course not found.");
        }
    }

    public void editCourseDetail() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Course ID to edit:");
        String courseId = scanner.next();

        Course courseToEdit = findCourseById(courseId);

        if (courseToEdit != null) {
            System.out.println("Current Course Details:");
            System.out.println(courseToEdit);

            System.out.println("Enter new Course Name (or press Enter to keep the current name):");
            String newCourseName = scanner.next();
            scanner.nextLine();
            if (!newCourseName.isEmpty()) {
                courseToEdit.setCourseName(newCourseName);
            }
            
            System.out.println("Course details updated successfully: " + courseToEdit);
        } else {
            System.out.println("Course with ID " + courseId + " not found.");
        }
    }

//    public void addProgramToCourse() {
//        Scanner scanner = new Scanner(System.in);
//
//        // Get Course ID from the user
//        System.out.print("Enter Course ID to add a program: ");
//        String courseId = scanner.next();
//
//        // Find the course
//        Course course = findCourseById(courseId);
//
//        if (course != null) {
//            // Display available programs
//            System.out.println("Available Programs:");
//            displayAllPrograms(programmeSet);
//
//            // Get Program ID from the user
//            System.out.print("Enter Program ID to add to the course: ");
//            String programId = scanner.next();
//
//            // Check if the program exists
//            Programme program = findProgramById(programId);
//
//            if (program != null) {
//                // Add the program to the course
//                course.addProgram(program);
//
//                System.out.println("Program added to the course successfully.");
//                System.out.println("Updated Course Details: " + course);
//            } else {
//                System.out.println("Program with ID " + programId + " not found.");
//            }
//        } else {
//            System.out.println("Course with ID " + courseId + " not found.");
//        }
//    }
//    public boolean removeProgram(String programId) {
//        Programme programToRemove = findProgramById(programId);
//
//        return programmeSet.remove(programToRemove);
//    }
//
//    private Programme findProgramById(String programId) {
//        SortedIterator<Programme> iterator = programmeSet.getIterator();
//
//        while (iterator.hasNext()) {
//            Programme program = iterator.next();
//            if (program.getprogrammeId().equals(programId)) {
//                return program;
//            }
//        }
//
//        return null;
//    }
//
//    public void removeProgramFromCourse() {
//        Scanner scanner = new Scanner(System.in);
//
//        // Display all courses and programs for user reference
//        displayAllCourses(courseSet);
//        displayAllPrograms(programmeSet);
//
//        System.out.println("Enter Course ID to remove a program:");
//        String courseId = scanner.next();
//
//        Course courseToRemoveProgram = findCourseById(courseId);
//
//        if (courseToRemoveProgram != null) {
//            System.out.println("Enter Program ID to remove:");
//            String programId = scanner.next();
//
//            if (courseToRemoveProgram.removeProgram(programId)) {
//                System.out.println("Program removed successfully from Course " + courseId + ": " + programId);
//            } else {
//                System.out.println("Program with ID " + programId + " not found in Course " + courseId + ".");
//            }
//        } else {
//            System.out.println("Course with ID " + courseId + " not found.");
//        }
//    }
//
//    private void displayAllPrograms(SetInterface<Programme> programmeSet) {
//        SortedIterator<Programme> iterator = programmeSet.getIterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//    }
//    public SetInterface<Course> getCoursesForProgramme(String programmeId) {
//    SetInterface<Course> coursesForProgramme = new arraySet<>();
//
//    // Assuming you have a method to find the programme by ID
//    Programme programme = findProgrammeById(programmeId);
//
//    if (programme != null) {
//        // Iterate through all courses and check if they are associated with the given programme
//        Iterator<Course> iterator = courseSet.getIterator();
//        while (iterator.hasNext()) {
//            Course course = iterator.next();
//            if (course.getfacultyId().equals(programmeId)) {
//                coursesForProgramme.add(course);
//            }
//        }
//    } else {
//        System.out.println("Programme with ID " + programmeId + " not found.");
//    }
//
//    return coursesForProgramme;
//}
// Assuming you have a method to find the programme by ID
//    private Programme findProgrammeById(String programmeId) {
//        SortedIterator<Programme> iterator = programmeSet.getIterator();
//
//        while (iterator.hasNext()) {
//            Programme programme = iterator.next();
//            if (programme.getprogrammeId().equals(programmeId)) {
//                return programme;
//            }
//        }
//
//        return null;
//    }
    public SetInterface<Course> getCourseSet() {
        return courseSet;
    }

    private void displayAllCourses(SetInterface<Course> courseSet) {
        SortedIterator<Course> iterator = courseSet.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private Faculty findFacultyById(String facultyId) {
        SortedIterator<Faculty> iterator = facultySet.getIterator();

        while (iterator.hasNext()) {
            Faculty faculty = iterator.next();
            if (faculty.getfacultyId().equals(facultyId)) {
                return faculty;
            }
        }

        return null;
    }

    private Course findCourseById(String courseId) {
        SortedIterator<Course> iterator = courseSet.getIterator();

        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }

        return null;
    }
}
