import java.util.Scanner;
import java.util.TreeMap;

public class AddressBook {
    // This class can be used to manage a collection of contacts
    // For now, it is empty and can be expanded later
    public static TreeMap<String, Contact> addressBook = new TreeMap<>();
    Scanner input = new Scanner(System.in);

    public void clearAddressBook() {
        addressBook.clear();    
        System.out.println("Address Book cleared.");
    }

    public static boolean createContact(String name, Contact contact){
        if(addressBook.containsKey(name)){
            System.out.print(name + " already exists in your address book, you'll need to create a different name instead.");
            return false;
        }

        try {
            addressBook.put(name, contact);
            System.out.println(name + " has been added to your Address Book.");
            return true;
            
        } catch (Exception e) {
            System.out.println("Failed to add contact to address book.\f" +e);
            return false;
        }
    }
}
