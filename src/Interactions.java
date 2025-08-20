
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
                    break;
                case 4:
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

    }

    public static void deleteContact(){

    }

    public static String promptForString(String message){
        System.out.print(message);
        return input.nextLine();
    }
}
