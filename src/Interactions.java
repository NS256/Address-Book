
import java.util.Scanner;

public class Interactions {
    private static final Scanner input = new Scanner(System.in);

    public static void selectProcess(){
        boolean interactionChosen = false;

        do {
            System.out.println("What would you like to do today?\n1. Search for a contact | 2. Add a new contact | 3. Update a contact | 4. Delete a contact | 5. Exit");
            byte userChoice = Byte.parseByte(input.nextLine());

            switch (userChoice){
                case 1:
                    break;
                case 2:
                    createNewContact();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    Main.runAddressBook = false;
                    break;
                default:
                    System.out.println("Oops! You'll need to enter a number between 1 & 5 to choose a function. Try again!\n");
                    break;
            }

            if (userChoice >= 1 && userChoice <= 5) interactionChosen = true;
    } while (!interactionChosen);


    }

    public static void searchContacts(){

    }

    public static void createNewContact(){
        

        

        System.out.println("Let's do it!\nI'll need to get a few details from you to create this.\n\n");
        
        final String firstName = promptForString("Enter the first name for your new contact:");
        final String lastName = promptForString("Enter the last name:");
        final String phoneNo = promptForString("Enter phone number:");
        final String emailAddress = promptForString("Enter email address:");
        

        if (!Contact.create(firstName, lastName, phoneNo, emailAddress)){
            System.out.println("Failed to create contact.");
        }

        System.out.println("\n\n\n");
    }

    public static void editContact(){
        //method to find specific user that wants to be edited before calling the editContact method using this
        String contactToEdit = promptForString("Who's contact would you like to update?");

        Contact contact = AddressBook.findContact(contactToEdit);

        editContact(contact);
    }

    public static void editContact(Contact contact){
        //method to be used when user selects Edit contact in searchContact()

        System.out.println("You're tryign to edit " + contact.getFullName());

        byte paramToUpdate = Byte.parseByte(promptForString("Which field would you like to update?\n 1. First Name | 2. Last Name | 3. Phone Number | 4. Last Name\n"));
        String newString = promptForString("And what would you like to set this field to?");
        boolean fieldChosen;

        do {
            fieldChosen = true;
            switch(paramToUpdate){
                case 1:
                    System.out.println("Update first Name chosen");
                    contact.updateFirstName(newString);
                    break;
                case 2:
                    contact.updateLastName(newString);
                    break;
                case 3:
                    contact.updatePhoneNo(newString);
                    break;
                case 4:
                    contact.updateEmail(newString);
                    break;
                default:
                    System.out.println("Whoops! You'll need to enter a number between 1 and 4 to select a field to update.");
                    fieldChosen = true;
                    break;
            } 
        } while (!fieldChosen);
        





    }

    public static void deleteContact(){
        String contactName = promptForString("Who would you like to remove from your Address Book? ");
        Contact contactToRemove = AddressBook.findContact(contactName);

        deleteContact(contactToRemove);
    }

    public static void deleteContact(Contact contact){
        String proceedWithDelete = promptForString("Are you wanting to delete " + contact.getFullName() + "? (Y/N): ");

        if (!proceedWithDelete.toLowerCase().contains("y")){
            System.out.println("No worries! Let's go back a step!");
            return;
        }

        AddressBook.deleteContact(contact);
    }

    public static String promptForString(String message){
        System.out.print(message + " ");
        return input.nextLine();
    }
}
