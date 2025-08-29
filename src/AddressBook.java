//import java.util.Scanner;
import java.util.ArrayList;
import java.util.TreeMap;

public class AddressBook {
    // This class can be used to manage a collection of contacts
    // For now, it is empty and can be expanded later
    private static TreeMap<String, Contact> addressBook = new TreeMap<>();
    //Scanner input = new Scanner(System.in);

    public void clearAddressBook() {
        addressBook.clear();    
        System.out.println("Address Book cleared.");
    }

    public static ArrayList<Contact> getAllContacts() {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        for (String key : addressBook.keySet()){
            Contact contact = findContact(key);
            contacts.add(contact);
        }
        return contacts;
    }

    public static void createContact(Contact contact){
        String name = contact.getFullName().toLowerCase();

        if(addressBook.containsKey(name)){
            System.out.print(name + " already exists in your address book, you'll need to create a different name instead.");
            return;
        }

        try {
            addressBook.put(name, contact);
            System.out.println("\n" + name + " has been added to your Address Book.");
            
        } catch (Exception e) {
            System.out.println("Failed to add contact to address book.\f" + e);
        }
    }

    public static void updateAddressBookContact(String key, Contact contact){
        //updating a contact field without changing key (e.g. email or phone no change.)
        addressBook.put(key, contact);
    } 

    public static void updateAddressBookContact(String key, Contact contact, String oldKey){
        //to be used when the key needs to be updated as well as a value in the Contact (e.g. name change)

        //delete the original key
        addressBook.remove(oldKey.toLowerCase());

        //add the new key
        addressBook.put(key.toLowerCase(), contact);
    }

    public static void deleteContact(Contact contact){
        String name = contact.getFullName();
        addressBook.remove(name.toLowerCase());
        System.out.println(name + " has been removed from your Address Book\n\n");
    }

    public static Contact findContact(String searchString){
        return addressBook.get(searchString.toLowerCase());
    }

}
