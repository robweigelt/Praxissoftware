package practiceManagementSoftware;

import java.io.IOException;
import java.util.Scanner;

public class PatientMenu {

    private final Scanner input;
    private final PatientManager ptm;

    public PatientMenu() {
        this.input = new Scanner(System.in);
        this.ptm = new PatientManager();
    }

    public void runProgram() throws IOException, CloneNotSupportedException {
        ptm.readPatientCSV();

            mainMenu();

    }

    private void mainMenu() throws IOException, CloneNotSupportedException {
        System.out.println("__________________________________________");
        System.out.println("Main Menu");
        System.out.println("⌞ Patients Menu");
        System.out.println();
        System.out.println("[1] Show all patients");
        System.out.println("[2] Show patient with ID");
        System.out.println("[3] Add, edit or delete");
        System.out.println("[-]");
        System.out.println("[9] Return (discard changes)");
        System.out.println("[0] Return (save to CSV)");
        System.out.println();
        System.out.print("Enter choice here: ");
        int choice = input.nextInt();
        switch (choice) {
            case 0:
                ptm.writePatientToCSV();
                MainMenu.Menu();
                break;
            case 1:
                ptm.printPatients();
                System.out.println();
                break;
            case 2:
                int id;
                System.out.print("Enter patient ID to Search: ");
                id = input.nextInt();
                PatientObject foundPatient = ptm.searchPatientByID(id);
                System.out.println("__________________________________________\n");
                ptm.showPatientById(foundPatient);
                break;
            case 3:
                addEditDeleteMenu();
                break;
            case 9:
                MainMenu.Menu();
                break;
            default:
                System.out.println("Invalid input!");
        }
        mainMenu();
    }

    public void addEditDeleteMenu() throws IOException, CloneNotSupportedException {
        int p_choice;
        System.out.println("__________________________________________");
        System.out.println("Main Menu");
        System.out.println("⌞ Patients Menu");
        System.out.println("  ⌞ Add, edit and delete");
        System.out.println();
        System.out.println("[1] Add patient");
        System.out.println("[2] Edit patient with ID");
        System.out.println("[3] Delete patient with ID");
        System.out.println("[-] ");
        System.out.println("[0] Return");
        System.out.println();
        System.out.print("Enter choice here: ");
        p_choice = input.nextInt();
        if (p_choice == 1) {
            System.out.println("__________________________________________");
            System.out.println("Add patient");
            ptm.addingPatient();
        } else if (p_choice == 2) {
            System.out.print("Enter patient ID to edit: ");
            int id = input.nextInt();
            System.out.println("__________________________________________");
            System.out.println("Edit patient");
            ptm.editPatient(id);
        } else if (p_choice == 3) {
            System.out.print("Enter ID to delete: ");
            int i = input.nextInt();
            PatientObject foundPatient = ptm.searchPatientByID(i);
            ptm.deletePatient(foundPatient);
            System.out.println("The patient " + foundPatient.getName() + " was successfully removed!");
        } else {
            mainMenu();
        }
    }
}
