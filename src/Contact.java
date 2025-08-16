

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

        AddressBook.createContact((firstName + " " + lastName),this);
        
    }

    public static boolean create(String firstName, String lastName, String phoneNo, String emailAddress){
        Contact contact = new Contact(firstName, lastName, phoneNo, emailAddress);

        return true;
    }
}
