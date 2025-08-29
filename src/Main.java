public class Main {

    public static boolean runAddressBook = true;
    public static void main(String[] args) {
        Save.createSaveFile();

        if (!Save.fileExists) {
            System.out.println("Failed to find save file... No changes will be saved.");
        } else {
            Save.readCSV();
        }

        
        AddressBook addressBook = new AddressBook();
        System.out.println("Welcome to your Address Book!");

        

        while (runAddressBook){
            Interactions.selectProcess();
        }
    }
}
