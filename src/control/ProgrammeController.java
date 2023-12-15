package control;

import adt.Set;
import adt.SetInterface;
import boundary.ProgrammeMaintenanceUI;
import static control.Main.homepage;
import entity.Programme;
import java.util.Iterator;
import utility.MessageUI;
import static control.Main.programmeSet;

/**
 *
 * @author User
 */
public class ProgrammeController {

    private ProgrammeMaintenanceUI programmeUI = new ProgrammeMaintenanceUI();

//    static SetInterface<Programme> programme = new Set<>();
//    static ProgrammeInitializer pro = new ProgrammeInitializer();
    public void ProgrammeManagement() {
        int choice = 0;
        do {
            choice = programmeUI.getMenuChoice();

            switch (choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    homepage();
                    break;
                case 1:
                    addNewProgramme();
                    programmeUI.listAllProgramme(getAllProgrammes());
                    break;
                case 2:
                    removeProgramme();
                    programmeUI.listAllProgramme(getAllProgrammes());
                    break;
                case 3:
                    searchProgramme();
                    break;
                case 4:
                    updateProgramme();
                    programmeUI.listAllProgramme(getAllProgrammes());
                    break;
                case 5:
                    programmeUI.listAllProgramme(getAllProgrammes());
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }

        } while (choice != 0);
    }

    public void addNewProgramme() {
        programmeUI.titleUI("Add New Programme");

        do {
            Programme newProgramme = programmeUI.inputProgrammeDetails();
            boolean isAdded = programmeSet.add(newProgramme);

            if (isAdded) {
                System.out.println("Programme added successfully!\n");
            } else {
                System.out.println("Programme already exists. Duplicate not added.\n");
            }

            //Ask the user if they want to add another data
            String choice = programmeUI.confirmation();

            if (!choice.equals("Y")) {
                break; // Exit the loop if the user doesn't want to add another programme
            }
        } while (true);
    }

    public void removeProgramme() {

        String codeToSearch = programmeUI.inputProgrammeCode();
        Set<Programme> matchingProgrammes = findProgrammesByCode(codeToSearch);

        if (!matchingProgrammes.isEmpty()) {
            int matchingProgrammesCount = matchingProgrammes.getSize();
            System.out.println("Programmes found with code " + codeToSearch + ":");

            Iterator<Programme> programmeIterator = matchingProgrammes.getIterator();
            int index = 1;
            while (programmeIterator.hasNext()) {
                System.out.println(index + ". " + programmeIterator.next());
                index++;
            }

            // If there is more than one matching program, let the user choose which one to remove
            if (matchingProgrammesCount > 1) {
                System.out.print("Enter the number of the programme to remove: ");
                int choice = programmeUI.choosechoice();

                if (choice >= 1 && choice <= matchingProgrammesCount) {
                    Programme programmeToRemove = getProgrammeByIndex(matchingProgrammes, choice);

                    boolean isRemoved = programmeSet.remove(programmeToRemove);

                    if (isRemoved) {
                        System.out.println("Programme removed successfully!\n");
                    } else {
                        System.out.println("Failed to remove the programme.\n");
                    }
                } else {
                    System.out.println("Invalid choice. No programme removed.\n");
                }
            } else {
                Programme programmeToRemove = matchingProgrammes.getIterator().next();
                boolean isRemoved = programmeSet.remove(programmeToRemove);

                if (isRemoved) {
                    System.out.println("Programme removed successfully!\n");
                } else {
                    System.out.println("Failed to remove the programme.\n");
                }
            }
        } else {
            System.out.println("No programmes found with code " + codeToSearch + ".\n");
        }
    }

    private Programme getProgrammeByIndex(SetInterface<Programme> programmes, int index) {
        Iterator<Programme> iterator = programmes.getIterator();
        int currentIndex = 1;

        while (iterator.hasNext()) {
            Programme programme = iterator.next();
            if (currentIndex == index) {
                return programme;
            }
            currentIndex++;
        }

        return null;
    }

//Search function-------------------------------------------------------------------------------------------------------------------------
    public Set<Programme> findProgrammesByCode(String programmeCode) {
        Set<Programme> matchingProgrammes = new Set<>();

        Iterator<Programme> iterator = programmeSet.getIterator();

        while (iterator.hasNext()) {
            Programme currentProgramme = iterator.next();

            if (currentProgramme.getProgrammeCode().equals(programmeCode)) {
                matchingProgrammes.add(currentProgramme);
            }
        }

        return matchingProgrammes;
    }

    private Set<Programme> findProgrammesByCriteria(int searchChoice, String searchKeyword) {
        Set<Programme> matchingProgrammes = new Set<>();

        Iterator<Programme> iterator = programmeSet.getIterator();
        while (iterator.hasNext()) {
            Programme programme = iterator.next();
            switch (searchChoice) {
                case 1:
                    // Search by programme code
                    if (programme.getProgrammeCode().equalsIgnoreCase(searchKeyword)) {
                        matchingProgrammes.add(programme);
                    }
                    break;
                case 2:
                    // Search by programme name
                    if (programme.getProgrammeName().equalsIgnoreCase(searchKeyword)) {
                        matchingProgrammes.add(programme);
                    }
                    break;
                case 3:
                    // Search by level of study
                    if (programme.getLevelofstudy().equalsIgnoreCase(searchKeyword)) {
                        matchingProgrammes.add(programme);
                    }
                    break;
                case 4:
                    // Search by faculty
                    if (programme.getFaculty().equalsIgnoreCase(searchKeyword)) {
                        matchingProgrammes.add(programme);
                    }
                    break;
                case 5:
                    // Search by year intake
                    if (programme.getYearIntake().equalsIgnoreCase(searchKeyword)) {
                        matchingProgrammes.add(programme);
                    }
                    break;
                case 6:
                    // Search by duration
                    try {
                    int searchDuration = Integer.parseInt(searchKeyword);
                    if (programme.getDuration() == searchDuration) {
                        matchingProgrammes.add(programme);
                    }
                } catch (NumberFormatException e) {
                    // Handle the case where searchKeyword is not an int
                    System.out.println("Invalid search keyword for duration: " + searchKeyword);
                }
                break;

                default:
                    System.out.println("Invalid search choice.");
                    return new Set<>(); // Return an empty set for invalid choices
            }
        }

        return matchingProgrammes;
    }

    public void searchProgramme() {

        int searchChoice = programmeUI.inputSearchChoice();
        String searchKeyword = "";

        int search = 0; // Declare search variable

        switch (searchChoice) {
            case 1:
                searchKeyword = programmeUI.updateProgrammeCode();
                break;
            case 2:
                searchKeyword = programmeUI.inputProgrammeName();
                break;
            case 3:
                searchKeyword = programmeUI.inputProgrammeLevelofstudy();
                break;
            case 4:
                searchKeyword = programmeUI.inputProgrammeFaculty();
                break;
            case 5:
                searchKeyword = programmeUI.inputProgrammeyearIntake();
                break;
            case 6:
                search = programmeUI.inputProgrammeDuration();
                break;

            default:
                System.out.println("Invalid search choice.");
                return;
        }

        Set<Programme> matchingProgrammes = findProgrammesByCriteria(searchChoice, searchKeyword);

        if (!matchingProgrammes.isEmpty()) {
            int matchingProgrammesCount = matchingProgrammes.getSize();
            System.out.println("Programmes found with the specified criteria:");

            Iterator<Programme> programmeIterator = matchingProgrammes.getIterator();
            while (programmeIterator.hasNext()) {
                System.out.println(programmeIterator.next());
            }

            System.out.println("Total matching programmes: " + matchingProgrammesCount + "\n");
        } else {
            System.out.println("No programmes found with the specified criteria.\n");
        }
    }

//Update function --------------------------------------------------------------------------------------------------------------------------------
    public void updateProgramme() {
        String codeToSearch = programmeUI.inputProgrammeCode();
        Iterator<Programme> iterator = programmeSet.getIterator();

        // List programs with the same code
        System.out.println("Programmes with the code '" + codeToSearch + "':");
        int count = 1;
        while (iterator.hasNext()) {
            Programme currentProgramme = iterator.next();
            if (currentProgramme.getProgrammeCode().equals(codeToSearch)) {
                System.out.println(count + ". " + currentProgramme);
                count++;
            }
        }

        // Check if any programs were found
        if (count == 1) {
            System.out.println("No programmes found with the code '" + codeToSearch + "'.");
            return;
        }

        // Prompt user to choose a program to update
        int programChoice = programmeUI.inputProgrammeUpdateChoice(count - 1);

        // Iterate again to find the chosen program
        iterator = programmeSet.getIterator();
        Programme selectedProgramme = null;
        count = 1;
        while (iterator.hasNext()) {
            Programme currentProgramme = iterator.next();
            if (currentProgramme.getProgrammeCode().equals(codeToSearch)) {
                if (count == programChoice) {
                    selectedProgramme = currentProgramme;
                    break;
                }
                count++;
            }
        }

        // Check if a program was selected
        if (selectedProgramme == null) {
            System.out.println("Invalid choice.");
            return;
        }

        // Update the selected program
        updateProgrammeDetails(selectedProgramme);
        System.out.println("Programme details updated successfully.");
    }

    private void updateProgrammeDetails(Programme programme) {
        int choice;

        choice = programmeUI.updateChoice();
        switch (choice) {
            case 1:
                String newCode = programmeUI.updateProgrammeCode();
                programme.setProgrammeCode(newCode);
                break;
            case 2:
                String newName = programmeUI.updateProgrammeName();
                programme.setProgrammeName(newName);
                break;
            case 3:
                String newFaculty = programmeUI.inputProgrammeFaculty();
                programme.setFaculty(newFaculty);
                break;
            case 4:
                String newYearIntake = programmeUI.inputProgrammeyearIntake();
                programme.setYearIntake(newYearIntake);
                break;
            case 5:
                int newDuration = programmeUI.inputProgrammeDuration();
                programme.setDuration(newDuration);
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    public String getAllProgrammes() {
        StringBuilder outputStr = new StringBuilder();
        Iterator<Programme> iterator = programmeSet.getIterator();

        while (iterator.hasNext()) {
            outputStr.append(iterator.next()).append("\n");
        }

        return outputStr.toString();
    }

}
