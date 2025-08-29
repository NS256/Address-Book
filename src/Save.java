import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Save {
    public static boolean fileExists = false;
    private static File saveFile;

    public static void createSaveFile(){
        // may use local date time later to show when file was created
        //LocalDateTime currentDateTime = LocalDateTime.now();
        

        try {
            saveFile = new File("AddressBook.csv");
            saveFile.createNewFile();

            if(saveFile.createNewFile()){
                System.out.println("New address book file created");
            } else {
                System.out.println("Address Book found!");
            }

            fileExists = true;

        } catch (IOException e) {
            System.out.print("Failed to create Address Book.\n" + e);
        }
    }

    public static void updateSaveFile(TreeMap<String, Contact> addressBook){

        //convert the contacts inside address books to string so they can be saved
        //TreeMap<String,String> stringedAddressBook = new TreeMap<String,String>();

        //createString to be added to CSV file
        String csvAddressBook = new String();
        //add header files to CSV string
        csvAddressBook += "firstName,lastName,phoneNo,emailAddress1\n";


        for (String key : addressBook.keySet()){
            //stringedAddressBook.put(key,createStringForSave(addressBook.get(key)));

            csvAddressBook += createStringForSave(addressBook.get(key));
        }


        try {
            FileWriter updateFile = new FileWriter(saveFile.getPath());
            updateFile.write(csvAddressBook/*String.valueOf(stringedAddressBook)*/);
            updateFile.close();

        } catch (IOException e) {
            String errorFilePath = Log.createLogFile();
            System.out.println("Failed to update address file, changes haven't been saved...\n" + e);
            
            e.printStackTrace();

            Log.addLoggingDetails(errorFilePath, e, "Failed to update address file, changes haven't been saved...");

        }
        

    }

    public static String createStringForSave(Contact contact){
        String contactString = new String();

        contactString += contact.getFirstName() + ",";
        contactString += contact.getLastName() + ",";
        contactString += contact.getPhoneNo() + ",";
        contactString += contact.getEmailAddress() + "\n";

        return contactString;
    }

    public static void readCSV(){
        ArrayList<String> csvContents = new ArrayList<String>();

        try {
            Scanner readCSV = new Scanner(saveFile);
            while(readCSV.hasNextLine()){
                csvContents.add(readCSV.nextLine());
            }
            readCSV.close();

        } catch (IOException e) {
            String message = "Failed to read AddressBook File, any existing contacts will be unavailable...";
            System.out.println(message);
            String logFile = Log.createLogFile();
            Log.addLoggingDetails(logFile, e, message);
        }

        for (String row : csvContents){
            if (row.contains("firstName,")) continue;
            String[] contactDetails = row.split(",");

            Contact.create(contactDetails[0], contactDetails[1], contactDetails[2], contactDetails[3]);
        }

    }

    /*public static TreeMap<String,Contact> loadSaveFile(){
        TreeMap<String,Contact> output = new TreeMap<String,Contact>();

        try {
            String addressBookString = "";
            Scanner readAddressbook = new Scanner(saveFile);
            TreeMap<String,String> stringedAddressBook = new TreeMap<String,String>();

            while(readAddressbook.hasNextLine()){
                addressBookString += readAddressbook.nextLine();
            }
            readAddressbook


        } catch (IOException e) {
        }

        

        return output;
    }*/
}
