package control;

import adt.SetInterface;
import adt.SortedIterator;
import boundary.StudentRegistrationUI;
import static control.Main.courseSet;
import static control.Main.homepage;
import static control.Main.programmeSet;
import static control.Main.student;
import entity.Course;
import entity.Programme;
import entity.Student;
import entity.StudentCourse;
import java.util.Iterator;

/**
 *
 * @author Fong Jun Yi
 */
public class StudentController {

    private final StudentRegistrationUI studentUI = new StudentRegistrationUI();

    public void studentManagement() {
        int result, exit;

        do {
            exit = 0;
            result = studentUI.studentManageMenu();

            switch (result) {
                case 1: {
                    exit = registration(student, programmeSet);
                    break;
                }
                case 2: {
                    exit = manageStudentCourse(student, courseSet);
                    break;
                }
                case 3: {
                    exit = searchStudent(student);
                    break;
                }
                case 4: {
                    exit = updateStudent(student, programmeSet);
                    break;
                }
                case 5: {
                    exit = removeStudent(student);
                    break;
                }
                case 6: {
                    exit = displayStudentList(student);
                    break;
                }
                case 7: {
                    exit = displayTotalCost(student);
                    break;
                }
                case 8: {
                    exit = generateStuBill(student);
                    break;
                }
                case 9: {
                    exit = generateStuReport(student);
                    break;
                }
                case 10:
                    homepage();
                    break;
            }
        } while (exit == 1);
    }

    private int registration(SetInterface<Student> student, SetInterface<Programme> programme) {
        int exit, randomNum;
        String id;
        boolean isSuccess, found = false;
        studentUI.titleUI("Add New Student");
        do {
            String name = studentUI.inputStudentName();
            String contactNo = studentUI.inputStudentContactNo();
            String gender = studentUI.inputStudentGender();

            listProgrammeOption(programme);
            String stuProgramme = studentUI.inputStudentProgramme();

            if (studentUI.inputConfirmation("add new student") == true) {

                Iterator<Programme> findProgramme = programme.getIterator();
                while (findProgramme.hasNext()) {
                    Programme result = findProgramme.next();
                    if (result.getProgrammeCode().equals(stuProgramme)) {
                        do {
                            randomNum = 1000 + (int) (Math.random() * ((9999 - 1000) + 1));
                            id = name.substring(0, 1).toUpperCase() + randomNum;
                            isSuccess = student.add(new Student(id, name, contactNo, gender, result.getProgrammeName(), result.getProgrammeCode()));
                        } while (isSuccess == false);
                        found = true;
                        break;
                    }
                }
                if (found == true) {
                    System.out.println("Successful Registered New Student !!!!");
                } else {
                    System.out.println("Unsuccessful Registering New Student cause No found this Programme !!!!");
                }
            } else {
                System.out.println("Cancelled Registration !!!!");
            }
            exit = studentUI.inputExitPage();
        } while (exit == 0);
        return exit;
    }

    private int manageStudentCourse(SetInterface<Student> student, SetInterface<Course> course) {
        int exit, opt;
        double fees;
        String id, courseId, status;
        boolean isSuccess = false, found = false;

        studentUI.titleUI("Manage Student Course");
        do {
            int select = studentUI.addOrRemoveCourse();

            switch (select) {
                case 1: {
                    id = studentUI.inputStudentId();

                    listCourseOption(course);
                    courseId = studentUI.inputStudentCourse();

                    opt = studentUI.inputCourseStatus();
                    if (opt == 1) {
                        status = "Main";
                        fees = 777.00;
                    } else if (opt == 2) {
                        status = "Resit";
                        fees = 90.00;
                    } else {
                        status = "Repeat";
                        fees = 777.00;
                    }

                    if (studentUI.inputConfirmation("add this Course") == true) {

                        // Checking the Input Course ID is same with the Course ID in Array Course or not
                        Iterator<Course> findCourse = course.getIterator();
                        while (findCourse.hasNext()) {
                            Course result = findCourse.next();
                            if (result.getCourseId().equals(courseId)) {

                                // Checking the Input Student ID is same with the Student ID in Array Student or not
                                Iterator<Student> getStudent = student.getIterator();
                                while (getStudent.hasNext()) {
                                    Student object = getStudent.next();
                                    if (object.getStudentId().equals(id)) {
                                        isSuccess = object.addStudentCourse(new StudentCourse(result.getCourseId(), result.getCourseName(), status, fees));
                                        if (isSuccess == true) {
                                            found = true;
                                            break;
                                        } else {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        if (found == true) {
                            System.out.println("Added Course to this Student Successful.......");
                        } else {
                            System.out.print("""
                                             Unsuccessful Adding Course to Student Reason: 
                                             1.Student Already registered this course....
                                             2.Enter Course ID no match with the Course ID inside the Course List....
                                             3.Enter Student ID no found in Student List....
                                             """);
                        }
                    } else {
                        System.out.println("Cancelled Adding the Course !!!!");
                    }
                    break;
                }
                case 2: {
                    id = studentUI.inputStudentId();
                    courseId = studentUI.inputStudentCourse();
                    if (studentUI.inputConfirmation("remove this Course") == true) {
                        Iterator<Student> getStudent = student.getIterator();
                        while (getStudent.hasNext()) {
                            Student object1 = getStudent.next();
                            if (object1.getStudentId().equals(id)) {
                                Iterator<StudentCourse> getStudentCourse = object1.getStudentCourse().getIterator();
                                while (getStudentCourse.hasNext()) {
                                    StudentCourse object2 = getStudentCourse.next();
                                    if (object2.getCourseId().equals(courseId)) {
                                        object1.removeStudentCourse(object2);
                                        isSuccess = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if (isSuccess == true) {
                            System.out.println("Removed Course from this Student Successful........");
                        } else {
                            System.out.println("Invalid Removing ! This Student no pick this course...");
                        }
                    } else {
                        System.out.println("Cancelled Removing the Course !!!!");
                    }
                    break;
                }
            }
            exit = studentUI.inputExitPage();
        } while (exit == 0);
        return exit;
    }

    private int searchStudent(SetInterface<Student> student) {
        int exit, count = 0, foundObject = 0;
        String key;

        do {
            key = studentUI.inputStuSearch();

            studentUI.searchStudenHeader();
            Iterator<Student> getStudent = student.getIterator();
            while (getStudent.hasNext()) {
                Student studentObject = getStudent.next();
                if (studentObject.getStudentId().equals(key) || studentObject.getStudentName().equals(key) || studentObject.getStudentProgrammeCode().equals(key)) {
                    ++foundObject;
                    if (studentObject.getStudentCourseSize() != 0) {
                        Iterator<StudentCourse> getStudentCourse = studentObject.getStudentCourse().getIterator();
                        count = 0;
                        while (getStudentCourse.hasNext()) {
                            StudentCourse courseObject = getStudentCourse.next();
                            if (count == 0) {
                                System.out.printf("%-15s \t %-15s \t %-15s \t %-15s \t %-75s \t %-45s \t %-15s\n",
                                        studentObject.getStudentId(), studentObject.getStudentName(),
                                        studentObject.getContactNo(), studentObject.getGender(),
                                        studentObject.getStudentProgramme(), courseObject.getCourse(), courseObject.getStatus());
                                count++;
                            } else {
                                System.out.printf("%-15s \t %-15s \t %-15s \t %-15s \t %-75s \t %-45s \t %-15s\n",
                                        "", "", "", "", "", courseObject.getCourse(), courseObject.getStatus());
                                count++;
                            }
                        }
                    } else {
                        System.out.printf("%-15s \t %-15s \t %-15s \t %-15s \t %-75s\n",
                                studentObject.getStudentId(), studentObject.getStudentName(),
                                studentObject.getContactNo(), studentObject.getGender(),
                                studentObject.getStudentProgramme());
                    }
                    System.out.println();
                }
            }
            if (foundObject == 0) {
                System.out.println("No Found the Student.......");
            }
            exit = studentUI.inputExitPage();
        } while (exit == 0);
        return exit;
    }

    private int updateStudent(SetInterface<Student> student, SetInterface<Programme> programme) {
        int exit, option, count;
        String id, name = "", gender = "", contactNo = "", programmeID = "";
        boolean isSuccess = false;

        studentUI.titleUI("Update Student Details");
        do {
            id = studentUI.inputStudentId();
            option = studentUI.updateMenu();
            switch (option) {
                case 1: {
                    name = studentUI.inputStuNewName();
                    break;
                }
                case 2: {
                    contactNo = studentUI.inputStuNewContactNo();
                    break;
                }
                case 3: {
                    gender = studentUI.inputStuNewGender();
                    break;
                }
                case 4: {
                    listProgrammeOption(programme);
                    programmeID = studentUI.inputStuNewProgramme();
                    break;
                }
            }
            if (studentUI.inputConfirmation("update the student detail") == true) {
                Iterator<Student> getStudent = student.getIterator();
                count = 0;
                while (getStudent.hasNext()) {
                    count++;
                    Student object = getStudent.next();
                    if (object.getStudentId().equals(id)) {
                        if (option == 1) {
                            isSuccess = student.replace(new Student(object.getStudentId(), name,
                                    object.getContactNo(), object.getGender(),
                                    object.getStudentProgramme(), object.getStudentProgrammeCode(), object.getStudentCourse()),
                                    count);
                            break;
                        }
                        if (option == 2) {
                            isSuccess = student.replace(new Student(object.getStudentId(), object.getStudentName(),
                                    contactNo, object.getGender(),
                                    object.getStudentProgramme(), object.getStudentProgrammeCode(), object.getStudentCourse()),
                                    count);
                            break;
                        }
                        if (option == 3) {
                            isSuccess = student.replace(new Student(object.getStudentId(), object.getStudentName(),
                                    object.getContactNo(), gender,
                                    object.getStudentProgramme(), object.getStudentProgrammeCode(), object.getStudentCourse()),
                                    count);
                            break;
                        }
                        if (option == 4) {
                            Iterator<Programme> findProgramme = programme.getIterator();
                            while (findProgramme.hasNext()) {
                                Programme result = findProgramme.next();
                                if (result.getProgrammeCode().equals(programmeID)) {
                                    isSuccess = student.replace(new Student(object.getStudentId(), object.getStudentName(),
                                            object.getContactNo(), object.getGender(),
                                            result.getProgrammeName(), result.getProgrammeCode(), object.getStudentCourse()),
                                            count);
                                    break;
                                }
                            }
                        }
                    }
                }
                if (isSuccess == true) {
                    System.out.println("Successful Updated Student Detail.....");
                } else {
                    System.out.println("Unsuccessful Updating Student Detail.....");
                }
            } else {
                System.out.println("Cancelled Updating Student Detail !!!!");
            }
            exit = studentUI.inputExitPage();
        } while (exit == 0);
        return exit;
    }

    private int removeStudent(SetInterface<Student> student) {
        int exit;
        String id;
        boolean isSuccess = false;

        studentUI.titleUI("Remove Student");
        do {
            id = studentUI.inputStudentId();
            if (studentUI.inputConfirmation("remove this Student") == true) {
                Iterator<Student> getStudent = student.getIterator();
                while (getStudent.hasNext()) {
                    Student object = getStudent.next();
                    if (object.getStudentId().equals(id)) {
                        student.remove(object);
                        isSuccess = true;
                        break;
                    }
                }
                if (isSuccess == true) {
                    System.out.println("Removed the Student Successful........");
                } else {
                    System.out.println("The Student ID no inside the list...");
                }
            } else {
                System.out.println("Cancelled Removing the Student !!!!");
            }

            exit = studentUI.inputExitPage();
        } while (exit == 0);
        return exit;
    }

    private int generateStuBill(SetInterface<Student> student) {
        int exit;
        String id;
        double totalFees = 0.00;
        studentUI.titleUI("Generate A Student Bill");
        do {
            id = studentUI.inputStuBill();

            Iterator<Student> getStudent = student.getIterator();
            while (getStudent.hasNext()) {
                Student object1 = getStudent.next();
                if (object1.getStudentId().equals(id)) {
                    studentUI.billHeader(object1.getStudentName(), object1.getStudentId(), object1.getContactNo(), object1.getStudentProgramme());

                    Iterator<StudentCourse> getStudentCourse = object1.getStudentCourse().getIterator();
                    while (getStudentCourse.hasNext()) {
                        StudentCourse object2 = getStudentCourse.next();
                        totalFees += object2.getFees();
                        System.out.printf("%3s %1s%s%1s %-30s\t \t \t \t %6.2f\n", "-", "(", object2.getStatus(), ") ", object2.getCourse(), object2.getFees());
                    }
                    studentUI.billFooter(totalFees);
                }
            }
            exit = studentUI.inputExitPage();
        } while (exit == 0);
        return exit;
    }

    private int displayStudentList(SetInterface<Student> student) {
        int exit;
        int count = 0, countCoursePicked;
        boolean isSort = false;

        studentUI.titleUI("View Student List");
        isSort = studentUI.inputSortList();

        studentUI.studentListHeader();

        if (isSort == true) {
            if (student.selectionSort() == false) {
                System.out.println("Oops !!! Student List is Empty............");
            } else {
                SortedIterator<Student> getStudent = student.getIterator();
                while (getStudent.hasNext()) {
                    ++count;
                    Student studentObject = getStudent.sortedNext();
                    if (studentObject.getStudentCourseSize() != 0) {
                        SortedIterator<StudentCourse> getStudentCourse = studentObject.getStudentCourse().getIterator();
                        countCoursePicked = 0;
                        while (getStudentCourse.hasNext()) {
                            StudentCourse courseObject = getStudentCourse.next();
                            if (countCoursePicked == 0) {
                                System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \t %-75s \t %-45s\n",
                                        count, studentObject.getStudentId(), studentObject.getStudentName(),
                                        studentObject.getContactNo(), studentObject.getGender(),
                                        studentObject.getStudentProgramme(), courseObject.getCourse());
                                countCoursePicked++;
                            } else {
                                System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \t %-75s \t %-45s\n",
                                        "", "", "", "", "", "", courseObject.getCourse());
                                countCoursePicked++;
                            }
                        }
                    } else {
                        System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \t %-75s\n",
                                count, studentObject.getStudentId(), studentObject.getStudentName(),
                                studentObject.getContactNo(), studentObject.getGender(),
                                studentObject.getStudentProgramme());
                    }
                }
            }
        } else {
            if (student.isEmpty()) {
                System.out.println("Oops !!! Student List is Empty............");
            } else {
                SortedIterator<Student> getStudent = student.getIterator();
                while (getStudent.hasNext()) {
                    ++count;
                    Student studentObject = getStudent.next();
                    if (studentObject.getStudentCourseSize() != 0) {
                        SortedIterator<StudentCourse> getStudentCourse = studentObject.getStudentCourse().getIterator();
                        countCoursePicked = 0;
                        while (getStudentCourse.hasNext()) {
                            StudentCourse courseObject = getStudentCourse.next();
                            if (countCoursePicked == 0) {
                                System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \t %-75s \t %-45s\n",
                                        count, studentObject.getStudentId(), studentObject.getStudentName(),
                                        studentObject.getContactNo(), studentObject.getGender(),
                                        studentObject.getStudentProgramme(), courseObject.getCourse());
                                countCoursePicked++;
                            } else {
                                System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \t %-75s \t %-45s\n",
                                        "", "", "", "", "", "", courseObject.getCourse());
                                countCoursePicked++;
                            }
                        }
                    } else {
                        System.out.printf("%-5s \t %-15s \t %-15s \t %-15s \t %-15s \t %-75s\n",
                                count, studentObject.getStudentId(), studentObject.getStudentName(),
                                studentObject.getContactNo(), studentObject.getGender(),
                                studentObject.getStudentProgramme());
                    }
                }
            }
        }

        exit = studentUI.studentListExit();
        return exit;
    }

    private int displayTotalCost(SetInterface<Student> student) {
        int exit;
        int count = 0, countCoursePicked;
        double totalFees;
        boolean isSort = false;

        studentUI.titleUI("Calculate Total Cost of Registed Course");
        isSort = studentUI.inputSortList();

        studentUI.totalCostListHeader();

        if (isSort == true) {
            if (student.selectionSort() == false) {
                System.out.println("Oops !!! Student List is Empty............");
            } else {
                SortedIterator<Student> getStudent = student.getIterator();
                while (getStudent.hasNext()) {
                    ++count;
                    totalFees = 0.00;

                    Student studentObject = getStudent.sortedNext();
                    if (studentObject.getStudentCourseSize() != 0) {
                        SortedIterator<StudentCourse> getStudentCourse = studentObject.getStudentCourse().getIterator();
                        SortedIterator<StudentCourse> getCourseFees = studentObject.getStudentCourse().getIterator();

                        countCoursePicked = 0;

                        // Calculate Student Total Course Fees
                        while (getCourseFees.hasNext()) {
                            StudentCourse courseFees = getCourseFees.next();
                            totalFees += courseFees.getFees();
                        }

                        // Display List
                        while (getStudentCourse.hasNext()) {
                            StudentCourse courseObject = getStudentCourse.next();
                            if (countCoursePicked == 0) {
                                System.out.printf("%-5s \t %-15s \t %-15s \t %-45s \t %-15.2f\n",
                                        count, studentObject.getStudentId(), studentObject.getStudentName(),
                                        courseObject.getCourse(), totalFees);

                                countCoursePicked++;
                            } else {
                                System.out.printf("%-5s \t %-15s \t %-15s \t %-45s\n",
                                        "", "", "", courseObject.getCourse());

                                countCoursePicked++;
                            }
                        }
                    } else {
                        System.out.printf("%-5s \t %-15s \t %-15s \t %-45s \t %-15.2f\n",
                                count, studentObject.getStudentId(), studentObject.getStudentName(), "", totalFees);
                    }
                }
            }
        } else {
            if (student.isEmpty()) {
                System.out.println("Oops !!! Student List is Empty............");
            } else {
                SortedIterator<Student> getStudent = student.getIterator();
                while (getStudent.hasNext()) {
                    ++count;
                    totalFees = 0.00;

                    Student studentObject = getStudent.next();
                    if (studentObject.getStudentCourseSize() != 0) {
                        SortedIterator<StudentCourse> getStudentCourse = studentObject.getStudentCourse().getIterator();
                        SortedIterator<StudentCourse> getCourseFees = studentObject.getStudentCourse().getIterator();

                        countCoursePicked = 0;

                        // Calculate Student Total Course Fees
                        while (getCourseFees.hasNext()) {
                            StudentCourse courseFees = getCourseFees.next();
                            totalFees += courseFees.getFees();
                        }

                        // Display List
                        while (getStudentCourse.hasNext()) {
                            StudentCourse courseObject = getStudentCourse.next();
                            if (countCoursePicked == 0) {
                                System.out.printf("%-5s \t %-15s \t %-15s \t %-45s \t %-15.2f\n",
                                        count, studentObject.getStudentId(), studentObject.getStudentName(),
                                        courseObject.getCourse(), totalFees);

                                countCoursePicked++;
                            } else {
                                System.out.printf("%-5s \t %-15s \t %-15s \t %-45s\n",
                                        "", "", "", courseObject.getCourse());

                                countCoursePicked++;
                            }
                        }
                    } else {
                        System.out.printf("%-5s \t %-15s \t %-15s \t %-45s \t %-15.2f\n",
                                count, studentObject.getStudentId(), studentObject.getStudentName(), "", totalFees);
                    }
                }
            }
        }
        exit = studentUI.studentListExit();
        return exit;
    }

    private int generateStuReport(SetInterface<Student> student) {
        int exit;
        int totalRegistered = 0, countCoursePicked;
        int countMain = 0, countResit = 0, countRepeat = 0;
        double totalPaidFees = 0.00;
        boolean isSort = false;

        studentUI.titleUI("Generate Student Report");
        isSort = studentUI.inputSortList();
        studentUI.summaryReportHeader();

        if (isSort == true) {
            if (student.selectionSort() == false) {
                System.out.println("Oops !!! No Found Any Data............");
            } else {
                SortedIterator<Student> getStudent = student.getIterator();
                while (getStudent.hasNext()) {
                    ++totalRegistered;
                    Student studentObject = getStudent.sortedNext();
                    if (studentObject.getStudentCourseSize() != 0) {
                        SortedIterator<StudentCourse> getStudentCourse = studentObject.getStudentCourse().getIterator();
                        SortedIterator<StudentCourse> getCourseSubItems = studentObject.getStudentCourse().getIterator();

                        countCoursePicked = 0;
                        countMain = 0;
                        countResit = 0;
                        countRepeat = 0;

                        // Calculate current Student Each Course Status & Total up All Student Course Fees
                        while (getCourseSubItems.hasNext()) {
                            StudentCourse subItems = getCourseSubItems.next();
                            if (subItems.getStatus().equals("Main")) {
                                countMain++;
                            } else if (subItems.getStatus().equals("Resit")) {
                                countResit++;
                            } else if (subItems.getStatus().equals("Repeat")) {
                                countRepeat++;
                            }
                            totalPaidFees += subItems.getFees();
                        }

                        // List out current student all courses
                        while (getStudentCourse.hasNext()) {
                            StudentCourse courseObject = getStudentCourse.next();
                            if (countCoursePicked == 0) {
                                System.out.printf("%-10s \t %-15s \t %-15s \t %-7s \t %-75s \t %-45s \t %-15d \t %-15d \t %-15d\n",
                                        studentObject.getStudentId(), studentObject.getStudentName(),
                                        studentObject.getContactNo(), studentObject.getGender(),
                                        studentObject.getStudentProgramme(), courseObject.getCourse(), countMain, countResit, countRepeat);
                                countCoursePicked++;
                            } else {
                                System.out.printf("%-10s \t %-15s \t %-15s \t %-7s \t %-75s \t %-45s\n",
                                        "", "", "", "", "", courseObject.getCourse());
                                countCoursePicked++;
                            }
                        }
                    } else {
                        System.out.printf("%-10s \t %-15s \t %-15s \t %-7s \t %-75s\n",
                                studentObject.getStudentId(), studentObject.getStudentName(),
                                studentObject.getContactNo(), studentObject.getGender(),
                                studentObject.getStudentProgramme());
                    }
                }
            }
        } else {
            if (student.isEmpty()) {
                System.out.println("Oops !!! No Found Any Data............");
            } else {
                SortedIterator<Student> getStudent = student.getIterator();
                while (getStudent.hasNext()) {
                    ++totalRegistered;
                    Student studentObject = getStudent.next();
                    if (studentObject.getStudentCourseSize() != 0) {
                        SortedIterator<StudentCourse> getStudentCourse = studentObject.getStudentCourse().getIterator();
                        SortedIterator<StudentCourse> getCourseSubItems = studentObject.getStudentCourse().getIterator();

                        countCoursePicked = 0;
                        countMain = 0;
                        countResit = 0;
                        countRepeat = 0;

                        // Calculate current Student Each Course Status & Total up All Student Course Fees
                        while (getCourseSubItems.hasNext()) {
                            StudentCourse subItems = getCourseSubItems.next();
                            if (subItems.getStatus().equals("Main")) {
                                countMain++;
                            } else if (subItems.getStatus().equals("Resit")) {
                                countResit++;
                            } else if (subItems.getStatus().equals("Repeat")) {
                                countRepeat++;
                            }
                            totalPaidFees += subItems.getFees();
                        }

                        // Display List
                        while (getStudentCourse.hasNext()) {
                            StudentCourse courseObject = getStudentCourse.next();
                            if (countCoursePicked == 0) {
                                System.out.printf("%-10s \t %-15s \t %-15s \t %-7s \t %-75s \t %-45s \t %-15d \t %-15d \t %-15d\n",
                                        studentObject.getStudentId(), studentObject.getStudentName(),
                                        studentObject.getContactNo(), studentObject.getGender(),
                                        studentObject.getStudentProgramme(), courseObject.getCourse(), countMain, countResit, countRepeat);
                                countCoursePicked++;
                            } else {
                                System.out.printf("%-10s \t %-15s \t %-15s \t %-7s \t %-75s \t %-45s\n",
                                        "", "", "", "", "", courseObject.getCourse());
                                countCoursePicked++;
                            }
                        }
                    } else {
                        System.out.printf("%-10s \t %-15s \t %-15s \t %-7s \t %-75s\n",
                                studentObject.getStudentId(), studentObject.getStudentName(),
                                studentObject.getContactNo(), studentObject.getGender(),
                                studentObject.getStudentProgramme());
                    }
                }
            }
        }

        studentUI.summaryReportFooter(totalRegistered, totalPaidFees);
        exit = studentUI.studentListExit();
        return exit;
    }

    private void listProgrammeOption(SetInterface<Programme> programme) {
        studentUI.optionListHeader("Programme Name");
        SortedIterator<Programme> getProgramme = programme.getIterator();
        while (getProgramme.hasNext()) {
            Programme programmeItem = getProgramme.next();
            System.out.printf("%-5s \t %-50s\n", programmeItem.getProgrammeCode(), programmeItem.getProgrammeName());
        }
        System.out.println();
    }

    private void listCourseOption(SetInterface<Course> course) {
        studentUI.optionListHeader("Course Name");
        SortedIterator<Course> getCourse = course.getIterator();
        while (getCourse.hasNext()) {
            Course courseItem = getCourse.next();
            System.out.printf("%-5s \t %-50s\n", courseItem.getCourseId(), courseItem.getCourseName());
        }
        System.out.println();
    }
}
