
import java.util.Scanner;

public class Interactions {
    public static void selectProcess(){
        Scanner input = new Scanner(System.in);
        boolean interactionChosen = false;

        do {
            System.out.println("What would you like to do today?\n1. Search for a contact | 2. Add a new contact | 3. Update a contact | 4. Delete a contact");
            byte userChoice = input.nextByte();



            switch (userChoice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Oops! You'll need to enter a number between 1 & 4 to choose a function. Try again!\n");
                    break;
            }

            if (userChoice >= 1 && userChoice <= 4) interactionChosen = true;
    } while (!interactionChosen);


    }
}
