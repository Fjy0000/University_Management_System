package boundary;

import entity.Programme;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ProgrammeMaintenanceUI {

    Scanner scanner = new Scanner(System.in);

    public void titleUI(String header) {
        System.out.println();
        printLine(1, 20);
        System.out.println(header);
        printLine(1, 20);
    }

    public int getMenuChoice() {
        int choice = 0;

        while (true) {
            System.out.println("\nWelcome to Programme Menu ");
            System.out.println("1. Add new programme");
            System.out.println("2. Remove a programme");
            System.out.println("3. Search programme");
            System.out.println("4. Amend programme details");
            System.out.println("5. List all programme");
            System.out.println("0. Quit");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                try {
                    choice = Integer.parseInt(input);

                    if (choice >= 0 && choice <= 5) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please enter a valid option (0-5).");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            } else {
                System.out.println("Input cannot be blank. Please enter a valid option (0-5).");
            }
        }
        return choice;
    }

    public void listAllProgramme(String outputStr) {
        System.out.println("\nList of Programme:");
        System.out.printf("%-10s %-15s %-40s %-10s %-15s %-10s", "Code", "LevelofStudy", "Name", "Faculty", "Year Intake", "Duration(Year)" + "\n" + outputStr);
    }
//-------------------------------------------ADD PROGRAMME-------------------------------------------------------//

    public String inputProgrammeCode() {
        String programmecode;
        do {
            System.out.print("Enter Programme Code : ");
            programmecode = scanner.nextLine().toUpperCase();
            if (programmecode.trim().isEmpty()) {
                System.out.println("Programme Code cannot be blank. Please enter a valid code.");
            } else if (programmecode.length() < 3 || programmecode.length() > 4) {
                System.out.println("Programme Code must be at least 3 letters but not more than 4 letters.");
            }

        } while (programmecode.trim().isEmpty() || programmecode.length() < 3 || programmecode.length() > 4);
        System.out.println();
        return programmecode;
    }

    public String inputProgrammeLevelofstudy() {
        String levelofstudy = "";

        while (true) {

            System.out.println("Choose Programme level of education: ");
            System.out.println("1. Foundation");
            System.out.println("2. Diploma");
            System.out.println("3. Degree");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice = choosechoice();

                switch (choice) {
                    case 1:
                        levelofstudy = "FOUNDATION";
                        break;
                    case 2:
                        levelofstudy = "DIPLOMA";
                        break;
                    case 3:
                        levelofstudy = "DEGREE";
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter valid choice(1,2,3)");
                        continue;

                }
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        scanner.nextLine(); // Consume the newline character
        return levelofstudy;
    }

    public String inputProgrammeName() {
        String name;
        do {
            System.out.print("Enter Programme Name : ");
            name = scanner.nextLine().toUpperCase();
            if (name.trim().isEmpty() && name.length() < 4) {
                System.out.println("Programme Name must more than 4 letter and cannot leave it blank");
            }
        } while (name.trim().isEmpty() && name.length() < 4);
        System.out.println();
        return name;
    }

    public String inputProgrammeFaculty() {
        String faculty = "";
        while (true) {

            System.out.println("Choose Programme Faculty: ");
            System.out.println("1. Faculty of Accountancy,Finance and Business");
            System.out.println("2. Faculty of Applied Sciences");
            System.out.println("3. Faculty of Computing and Information Technology");
            System.out.println("4. Faculty of Built Environment");
            System.out.println("5. Faculty of Engineering and Technology");
            System.out.println("6. Faculty of Communication and Creative Industries");
            System.out.println("7. Faculty of Social Science and Humanities");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice = choosechoice();

                switch (choice) {
                    case 1:
                        faculty = "FAFB";
                        break;
                    case 2:
                        faculty = "FOAS";
                        break;
                    case 3:
                        faculty = "FOCS";
                        break;
                    case 4:
                        faculty = "FOBE";
                        break;
                    case 5:
                        faculty = "FOET";
                        break;
                    case 6:
                        faculty = "FCCI";
                        break;
                    case 7:
                        faculty = "FSSH";
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter valid choice(1-7)");
                        continue;

                }
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        scanner.nextLine(); // Consume the newline character
        return faculty;
    }

    public String inputProgrammeyearIntake() {
        String year = "";

        while (true) {

            System.out.println("Choose Programme Semester Intake: ");
            System.out.println("1. February");
            System.out.println("2. June");
            System.out.println("3. October");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice = choosechoice();

                switch (choice) {
                    case 1:
                        year = "FEBRUARY";
                        break;
                    case 2:
                        year = "JUNE";
                        break;
                    case 3:
                        year = "OCTOBER";
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter valid choice(1,2,3)");
                        continue;

                }
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        scanner.nextLine(); // Consume the newline character
        return year;
    }

    public int inputProgrammeDuration() {
        int duration = 0;
        while (true) {

            System.out.println("Choose Programme Duration: ");
            System.out.println("1. 1 Year");
            System.out.println("2. 2 Year");
            System.out.println("3. 3 year");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice = choosechoice();

                switch (choice) {
                    case 1:
                        duration = 1;
                        break;
                    case 2:
                        duration = 2;
                        break;
                    case 3:
                        duration = 3;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter valid choice(1,2,3)");
                        continue;

                }
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        scanner.nextLine(); // Consume the newline character
        return duration;
    }

    public Programme inputProgrammeDetails() {
        String programmeCode = inputProgrammeCode();
        String levelofstudy = inputProgrammeLevelofstudy();
        String programmeName = inputProgrammeName();
        String faculty = inputProgrammeFaculty();
        String yearIntake = inputProgrammeyearIntake();
        int duration = inputProgrammeDuration();

        return new Programme(programmeCode, levelofstudy, programmeName, faculty, yearIntake, duration);
    }

//-------------------------------------------------Update Programme-----------------------------------------------------------
    public int updateChoice() {

        while (true) {
            System.out.println("Choose what to update:");
            System.out.println("1. Programme Code");
            System.out.println("2. Programme Name");
            System.out.println("3. Faculty");
            System.out.println("4. Year Intake");
            System.out.println("5. Duration");
            System.out.println("6. Tutorial Group");
            System.out.println("Choose one to update (1-6):");

            if (scanner.hasNextInt()) {
                int choice = choosechoice();
                return choice;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

    }

    public int inputProgrammeUpdateChoice(int maxChoice) {
        int choice;

        do {
            System.out.print("Enter your choice (1-" + maxChoice + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume the invalid input
            }
            choice = choosechoice();

            if (choice < 1 || choice > maxChoice) {
                System.out.println("Invalid choice. Please enter a number between 1 and " + maxChoice + ".");
            }

        } while (choice < 1 || choice > maxChoice);

        return choice;
    }
    
    public String updateProgrammeCode() {
        String programmecode;
        do {
            scanner.nextLine();
            System.out.print("Enter Programme Code : ");
            programmecode = scanner.nextLine().toUpperCase();
            if (programmecode.trim().isEmpty()) {
                System.out.println("Programme Code cannot be blank. Please enter a valid code.");
            } else if (programmecode.length() < 3 || programmecode.length() > 4) {
                System.out.println("Programme Code must be at least 3 letters but not more than 4 letters.");
            }

        } while (programmecode.trim().isEmpty() || programmecode.length() < 3 || programmecode.length() > 4);
        System.out.println();
        return programmecode;
    }
    
    public String updateProgrammeName() {
        String name;
        do {
            scanner.nextLine();
            System.out.print("Enter Programme Name : ");
            name = scanner.nextLine().toUpperCase();
            if (name.trim().isEmpty() && name.length() < 4) {
                System.out.println("Programme Name must more than 4 letter and cannot leave it blank");
            }
        } while (name.trim().isEmpty() && name.length() < 4);

        System.out.println();
        return name;
    }
    
//--------------------------------------------------Search Programme----------------------------------------------------

    public int inputSearchChoice() {

        while (true) {
            System.out.println("Make your choice for searching >");
            System.out.println("1. Search by programme code");
            System.out.println("2. Search by programme name");
            System.out.println("3. Search by programme levelofeducation");
            System.out.println("4. Search by programme faculty");
            System.out.println("5. Search by programme semester offer");
            System.out.println("6. Search by programme duration ");
            System.out.print("Enter your choice(1-6): ");

            if (scanner.hasNextInt()) {
                int choice = choosechoice();
                return choice;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

    }

//--------------------------------------------------Others--------------------------------------------------------------
    public String confirmation() {
        while (true) {
            System.out.print("Do you want to continue? (Y/N): ");
            String choice = scanner.nextLine().toUpperCase();

            if (choice.equals("Y") || choice.equals("N")) {
                return choice;
            } else {
                System.out.println("Invalid choice. Please enter 'Y' or 'N'.");
            }
        }
    }

    //Input choice-----------------------------------------------------------------------------------
    public int choosechoice() {
        int choice = scanner.nextInt();
        System.out.println();
        return choice;
    }

    // Print Line UI --------------------------------------------------------------------------------
    public void printLine(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("+");
            }
        }
        System.out.println();
    }
}

