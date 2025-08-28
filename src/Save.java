import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class Save {
    public static boolean fileExists = false;

    public static void createSaveFile(){
        LocalDateTime currentDateTime = LocalDateTime.now();

        try {
            File saveFile = new File("AddressBook.txt");
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
}
