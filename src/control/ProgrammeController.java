package control;

import adt.Set;
import adt.SetInterface;
import adt.SortedIterator;
import boundary.ProgrammeUI;
import static control.Main.homepage;
import static control.Main.programmeSet;
import static control.Main.tutorialGroups;
import entity.TutorialGroup;
import entity.Programme;
import utility.MessageUI;

/**
 *
 * @author Geng Seng
 */
public class ProgrammeController {

    private ProgrammeUI programmeUI = new ProgrammeUI();

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
                case 6:
                    addProgrammeToGroup();
                    programmeUI.listofGroupwithProgramme(getListofGroupwithProgramme());
                    break;
                case 7:
                    programmeUI.listofGroupwithProgramme(getListofGroupwithProgramme());
                    removeTutorialGroupFromProgramme();
                    break;
                case 8:
                    programmeUI.listofGroupwithProgramme(getListofGroupwithProgramme());
                    break;
                case 9:
                    generateSummaryReport();
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
            String choice = programmeUI.inputYOrN();

            if (!choice.equals("Y")) {
                break; // Exit the loop if the user doesn't want to add another programme
            }
        } while (true);
    }

    public void removeProgramme() {

        programmeUI.titleUI("Remove A Programme");

        String codeToSearch = programmeUI.inputProgrammeCode();
        Set<Programme> matchingProgrammes = findProgrammesByCode(codeToSearch);

        //If matching programs are found, it displays the count and details of the matching programs. 
        //If there is more than one matching program, it allows the user to choose which one to remove.
        if (!matchingProgrammes.isEmpty()) {
            int matchingProgrammesCount = matchingProgrammes.getSize();
            System.out.println("Programmes found with code " + codeToSearch + ":");

            SortedIterator<Programme> programmeIterator = matchingProgrammes.getIterator();
            int index = 1;
            while (programmeIterator.hasNext()) {
                System.out.println(index + ". " + programmeIterator.next());
                index++;
            }

            // If there is more than one matching program, let the user choose which one to remove
            if (matchingProgrammesCount > 1) {
                int choice = -1;
                boolean validChoice = false;

                while (!validChoice) {
                    System.out.print("Enter the number of the programme to remove: ");
                    choice = programmeUI.choosechoice();

                    if (choice >= 1 && choice <= matchingProgrammesCount) {
                        validChoice = true;
                    } else {
                        System.out.println("Invalid choice. Please enter a number between 1 and " + matchingProgrammesCount + ".");
                    }
                }

                Programme programmeToRemove = getProgrammeByIndex(matchingProgrammes, choice);
                handleProgrammeRemoval(programmeToRemove);
            } else {
                Programme programmeToRemove = matchingProgrammes.getIterator().next();
                handleProgrammeRemoval(programmeToRemove);
            }
        } else {
            System.out.println("No matching programmes found.\n");
        }

        // Ask the user if they want to continue using the remove function
        System.out.print("Do you want to continue removing programmes? (Y/N): ");
        String continueChoice = programmeUI.justYorN();
        if (continueChoice.equalsIgnoreCase("Y")) {
            removeProgramme();
        }
    }

    private void handleProgrammeRemoval(Programme programmeToRemove) {
        // Display confirmation prompt only if the user confirms the removal
        System.out.print("Do you confirm to remove? (Y/N): ");
        String confirmChoice = programmeUI.justYorN();

        if (confirmChoice.equalsIgnoreCase("Y")) {
            boolean isRemoved = programmeSet.remove(programmeToRemove);

            if (isRemoved) {
                System.out.println("Programme removed successfully!\n");
            } else {
                System.out.println("Failed to remove the programme.\n");
            }
        } else {
            System.out.println("Programme removal canceled.\n");
        }
    }

    private Programme getProgrammeByIndex(SetInterface<Programme> programmes, int index) {
        SortedIterator<Programme> iterator = programmes.getIterator();
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

        SortedIterator<Programme> iterator = programmeSet.getIterator();

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

        SortedIterator<Programme> iterator = programmeSet.getIterator();
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
                    } else if (programme.getProgrammeName().toLowerCase().contains(searchKeyword.toLowerCase())) {
                        // Add programs that contain the search keyword in their names
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

        programmeUI.titleUI("Search Programme");

        int searchChoice = programmeUI.inputSearchChoice();
        String searchKeyword = "";

        switch (searchChoice) {
            case 1:
                searchKeyword = programmeUI.inputProgrammeCode();
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
                int search = programmeUI.inputProgrammeDuration();
                break;
            default:
                System.out.println("Invalid search choice.");
                return;
        }

        Set<Programme> matchingProgrammes = findProgrammesByCriteria(searchChoice, searchKeyword);

        if (!matchingProgrammes.isEmpty()) {
            int matchingProgrammesCount = matchingProgrammes.getSize();
            System.out.println("Programmes found with the specified criteria:");

            SortedIterator<Programme> programmeIterator = matchingProgrammes.getIterator();
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

        programmeUI.titleUI("Update Programme");

        String codeToSearch = programmeUI.inputProgrammeCode();
        SortedIterator<Programme> iterator = programmeSet.getIterator();

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

        // Ask for confirmation
        System.out.print("Are you sure to make the changes? (Y/N): ");
        String confirmChoice = programmeUI.justYorN();

        if (confirmChoice.equalsIgnoreCase("Y")) {
            System.out.println("Programme details updated successfully.");
        } else {
            // Revert changes if the user doesn't confirm
            System.out.println("Programme update canceled.");
        }
        String continueChoice = programmeUI.inputYOrN();
        if (continueChoice.equals("Y")) {
            updateProgramme();
        }
    }

    private void updateProgrammeDetails(Programme programme) {
        int choice;

        choice = programmeUI.updateChoice();
        switch (choice) {
            case 1:
                String newCode = programmeUI.inputProgrammeCode();
                programme.setProgrammeCode(newCode);
                break;
            case 2:
                String newName = programmeUI.inputProgrammeName();
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

    //Assign a tutorial group to a programme---------------------------------------------------------------------------------------------------------------
    public void addProgrammeToGroup() {
        programmeUI.titleUI("Add a tutorial group to a programme");

        Programme existingProgramme = null;
        do {
            // Call inputProgrammeCode method to get program code from the user
            String programmeCode = programmeUI.inputProgrammeCode();
            Set<Programme> matchingProgrammes = findProgrammesByCode(programmeCode);

            if (matchingProgrammes.isEmpty()) {
                System.out.println("\nProgram with code " + programmeCode + " does not exist in the program set. Please try again.");
            } else if (matchingProgrammes.getSize() > 1) {
                System.out.println("Multiple programs found with code " + programmeCode + ". Please choose one:");
                existingProgramme = getProgrammeByUserChoice(matchingProgrammes);
            } else {
                existingProgramme = matchingProgrammes.getIterator().next();
            }
        } while (existingProgramme == null);

        // Ensure the program code is found before proceeding to input the group name
        if (existingProgramme != null) {
            // Call inputGroupName method to get assigned group from the user
            String groupName = programmeUI.inputGroupName();
            System.out.print("\n");

            // Check if the tutorial group exists
            TutorialGroup existingGroup = findGroupByName(groupName);
            if (existingGroup == null) {
                System.out.println("\nTutorial group with name " + groupName + " does not exist.");
                return;
            }

            // Assign the tutorial group to the program
            existingProgramme.addTutorialGroup(existingGroup);

            System.out.println("Program " + existingProgramme.getProgrammeName() + " assigned to tutorial group " + groupName + ".");
        }
    }

    private Programme getProgrammeByUserChoice(Set<Programme> matchingProgrammes) {
        displayMatchingPrograms(matchingProgrammes);

        // Prompt the user to choose one of the matching programs
        int choice;
        boolean validChoice = false;
        Programme existingProgramme = null;

        while (!validChoice) {
            System.out.print("Enter the number of the program to use: ");
            choice = programmeUI.choosechoice();

            if (choice >= 1 && choice <= matchingProgrammes.getSize()) {
                validChoice = true;
                existingProgramme = getProgrammeByIndex(matchingProgrammes, choice);
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and " + matchingProgrammes.getSize() + ".");
            }
        }

        return existingProgramme;
    }

    private void displayMatchingPrograms(Set<Programme> matchingProgrammes) {
        SortedIterator<Programme> iterator = matchingProgrammes.getIterator();
        int index = 1;

        while (iterator.hasNext()) {
            System.out.println(index + ". " + iterator.next());
            index++;
        }
    }

    private TutorialGroup findGroupByName(String groupName) {

        SortedIterator<TutorialGroup> groupIterator = tutorialGroups.getIterator();
        // Iterate through each TutorialGroup in the collection

        while (groupIterator.hasNext()) {
            TutorialGroup tutorialGroup = groupIterator.next();

            // Check if the current TutorialGroup's name matches the specified groupName
            if (tutorialGroup.getGroupName().equalsIgnoreCase(groupName)) {
                return tutorialGroup;
            }
        }
        return null;
    }

    public void removeTutorialGroupFromProgramme() {
        programmeUI.titleUI("Remove a Tutorial Group from a Programme");

        // Call inputProgrammeCode method to get program code from the user
        String programmeCode = programmeUI.inputProgrammeCode();
        Set<Programme> matchingProgrammes = findProgrammesByCode(programmeCode);

        if (!matchingProgrammes.isEmpty()) {
            Programme programmeToRemoveFrom = null;

            if (matchingProgrammes.getSize() > 1) {
                System.out.println("Multiple programs found with code " + programmeCode + ". Please choose one:");
                programmeToRemoveFrom = getProgrammeByUserChoice(matchingProgrammes);
            } else {
                programmeToRemoveFrom = matchingProgrammes.getIterator().next();
            }

            // Call inputGroupName method to get the group name from the user
            String groupName = programmeUI.inputGroupName();

            // Check if the tutorial group exists in the programme
            TutorialGroup tutorialGroupToRemove = findTutorialGroupInProgramme(programmeToRemoveFrom, groupName);

            if (tutorialGroupToRemove != null) {
                // Display confirmation prompt only if the user confirms the removal
                System.out.print("Do you confirm to remove tutorial group? (Y/N): ");
                String confirmChoice = programmeUI.justYorN();

                if (confirmChoice.equalsIgnoreCase("Y")) {
                    // Remove the tutorial group from the programme
                    programmeToRemoveFrom.removeTutorialGroup(tutorialGroupToRemove);
                    System.out.println("Tutorial group removed successfully!\n");
                } else {
                    System.out.println("Tutorial group removal canceled.\n");
                }
            } else {
                System.out.println("Tutorial group with name " + groupName + " not found in the programme.\n");
            }
        } else {
            System.out.println("Program with code " + programmeCode + " does not exist in the program set.\n");
        }
    }

    private TutorialGroup findTutorialGroupInProgramme(Programme programme, String groupName) {
        SortedIterator<TutorialGroup> iterator = programme.getTutorialGroups().getIterator();

        while (iterator.hasNext()) {
            TutorialGroup tutorialGroup = iterator.next();
            if (tutorialGroup.getGroupName().equalsIgnoreCase(groupName)) {
                return tutorialGroup;
            }
        }

        return null; // Tutorial group not found in the programme
    }

//---------------------------------------------------------------------------------------------------------------------------
    public void generateSummaryReport() {
        programmeUI.titleUI("Year Intake Summary Report");

        // Create a set to store unique year intakes
        Set<String> uniqueYearIntakes = new Set<>();

        // Iterate through each program
        SortedIterator<Programme> programmeIterator = programmeSet.getIterator();
        while (programmeIterator.hasNext()) {
            Programme currentProgramme = programmeIterator.next();

            // Get the year intake from the program (replace "getYearIntake()" with your actual method)
            String yearIntake = currentProgramme.getYearIntake();

            // Add the year intake to the set
            uniqueYearIntakes.add(yearIntake);
        }

        // Display the summary report using an iterator
        System.out.println("Year Intake Summary Report:");

        // Create an iterator for the set of unique year intakes
        SortedIterator<String> yearIntakeIterator = uniqueYearIntakes.getIterator();

        // Iterate through each unique year intake using the iterator
        while (yearIntakeIterator.hasNext()) {
            // Get the current year intake from the iterator
            String yearIntake = yearIntakeIterator.next();

            // Count the number of programs for the current year intake
            int count = countProgramsByYearIntake(yearIntake);

            // Display the summary for the current year intake
            System.out.println("Year Intake: " + yearIntake + "\n Number of Programs: " + count);

            // Display program details for the current year intake
            displayProgramDetailsByYearIntake(yearIntake);

            System.out.println(); // Add a newline for better readability between summaries
        }
    }

// Helper method to display program details for a specific year intake
    private void displayProgramDetailsByYearIntake(String yearIntake) {
        // Iterate through each program
        SortedIterator<Programme> programmeIterator = programmeSet.getIterator();
        while (programmeIterator.hasNext()) {
            Programme currentProgramme = programmeIterator.next();

            // Check if the current program has the specified year intake
            if (currentProgramme.getYearIntake().equals(yearIntake)) {
                // Display the program details
                System.out.println("\tProgram Code: " + currentProgramme.getProgrammeCode());
                System.out.println("\tProgram Name: " + currentProgramme.getProgrammeName());
                System.out.println("\tFaculty: " + currentProgramme.getFaculty());
                System.out.println("\tDuration: " + currentProgramme.getDuration() + " years");
                
                System.out.println(); // Add a newline for better readability between programs
            }
        }
    }

// Helper method to count the number of programs for a specific year intake
    private int countProgramsByYearIntake(String yearIntake) {
        int count = 0;

        // Iterate through each program
        SortedIterator<Programme> programmeIterator = programmeSet.getIterator();
        while (programmeIterator.hasNext()) {
            Programme currentProgramme = programmeIterator.next();

            // Check if the current program has the specified year intake
            if (currentProgramme.getYearIntake().equals(yearIntake)) {
                count++;
            }
        }

        return count;
    }

//--------------------------------------------------------------------------------------------------------------------------
    public String getAllProgrammes() {
        StringBuilder outputStr = new StringBuilder();
        SortedIterator<Programme> iterator = programmeSet.getIterator();

        while (iterator.hasNext()) {
            outputStr.append(iterator.next()).append("\n");
        }

        return outputStr.toString();
    }

    public String getListofGroupwithProgramme() {
        StringBuilder outputStr = new StringBuilder();
        SortedIterator<Programme> iterator = programmeSet.getIterator();

        while (iterator.hasNext()) {
            Programme currentProgramme = iterator.next();

            // Check if the program has associated tutorial groups
            if (!currentProgramme.getTutorialGroups().isEmpty()) {
                SortedIterator<TutorialGroup> groupIterator = currentProgramme.getTutorialGroups().getIterator();
                while (groupIterator.hasNext()) {
                    TutorialGroup tutorialGroup = groupIterator.next();
                    outputStr.append(String.format("%-10s\t %-15s\t %-80s", tutorialGroup.getGroupName(), currentProgramme.getProgrammeCode(), currentProgramme.getProgrammeName())).append("\n");
                }
            }
        }

        // If no data is found, append a message
        if (outputStr.length() == 0) {
            outputStr.append("No data found.\n");
        }

        return outputStr.toString();
    }
}
