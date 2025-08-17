

public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    Contact(String firstName, String lastName, String phoneNumber, String emailAddress) {
        // Constructor logic can be added here
        System.out.println("New contact constructor called.");
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        
    }

    public static boolean create(String firstName, String lastName, String phoneNo, String emailAddress){
        Contact contact = new Contact(firstName, lastName, phoneNo, emailAddress);
        AddressBook.createContact(contact);
        return true;
    }

    public static String getFullName(Contact contact){
        String fullName = contact.firstName + " " + contact.lastName;
        return fullName;
    }

    public static String getFirstName(Contact contact){
        return contact.firstName;
    }

    public static String getLastName(Contact contact){
        return contact.lastName;
    }

    public static String getEmailAddress(Contact contact){
        return contact.emailAddress;
    }

    public static String getPhoneNo(Contact contact){
        return contact.emailAddress;
    }

    public static void updateFirstName(String newName, Contact contact){
        contact.firstName = newName;
        AddressBook.updateAddressBook(Contact.getFullName(contact), contact);
    }
}
