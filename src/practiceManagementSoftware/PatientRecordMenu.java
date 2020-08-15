package practiceManagementSoftware;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;


//Deleter hinzufügen
class PatientRecordMenu {
    static void Menu() throws CloneNotSupportedException, IOException {
        System.out.println("Please choose between the different options by pressing the number [] and [Enter]:\n" +
                "[1]Look for a specific person  \n" +
                "[2]Create new entry  \n" +
                "[3] List all entry's \n" +
                "[0]Return "
        );
        InsideMenuMedicine(GetIntOrString.GetmyInt());

    }
    private static void InsideMenuMedicine(int switcher) throws CloneNotSupportedException, IOException {
        switch (switcher){
            case 0:
                MainMenu.Menu();
            case 1:
                int a = PatientRecordObject.SelectSearch();
                List <String> myList  = PatientRecordObject.switcherMedicineCategory(a);
                var listInCapitals = HelperFunctions.getList(myList);
                var upperItem = HelperFunctions.makeStringToCapital();
                HelperFunctions.patientFinder(listInCapitals, upperItem);
                Menu();
            case 2:
                new PatientRecordObject().newEntry();
                Menu();
            case 3:
                PatientRecordObject.ListAllItems();
                Menu();
            default:
                System.out.println("You entered an invalid number");
                Menu();
        }

    }
}
