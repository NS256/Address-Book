



public class Contact {

    //public final String[][] AVAILABLEPARAMS = {}{}, "last name", "phone number", "email address"}; 
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    //may add a LocalDateTime field to reflect when a contact was created/last updated - perhaps both

    Contact(String firstName, String lastName, String phoneNumber, String emailAddress) {
        // Constructor logic can be added here
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        
    }

        //create a new contact
    public static boolean create(String firstName, String lastName, String phoneNo, String emailAddress){
        Contact contact = new Contact(firstName, lastName, phoneNo, emailAddress);
        AddressBook.createContact(contact);
        return true;
    }

        //Getter methods

    public String getFullName(){
        String fullName = this.firstName + " " + this.lastName;
        return fullName;
    }

    public static String getFullName(Contact contact){
        String fullName = contact.firstName + " " + contact.lastName;
        return fullName;
    }

    public static String getFirstName(Contact contact){
        return contact.firstName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public static String getLastName(Contact contact){
        return contact.lastName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public static String getEmailAddress(Contact contact){
        return contact.emailAddress;
    }
    
    public String getEmailAddress(){
        return this.emailAddress;
    }

    public static String getPhoneNo(Contact contact){
        return contact.phoneNumber;
    }

    public String getPhoneNo(){
        return this.phoneNumber;
    }

    

    //Setter methods
    public void updateFirstName(String newName){

        String originalKey = this.getFullName();

        this.firstName = newName;

        System.out.println("Name has been set to " + this.firstName + " " + this.lastName);
        AddressBook.updateAddressBookContact(this.getFullName(), this, originalKey);
    }

    public void updateLastName(String newName){
        String originalKey = this.getFullName();
        this.lastName = newName;
        System.out.println("Name has been set to " + this.firstName + " " + this.lastName);
        AddressBook.updateAddressBookContact(this.getFullName(), this, originalKey);
    }

    public void updatePhoneNo(String newNo){
        this.phoneNumber = newNo;
        System.out.println("Phone number has been set to " + this.phoneNumber);
        AddressBook.updateAddressBookContact(this.getFullName(), this);
    }

    public void updateEmail(String newEmail){
        this.emailAddress = newEmail;
        System.out.println("Email has been set to " + this.emailAddress);
        AddressBook.updateAddressBookContact(this.getFullName(), this);
    }
}
