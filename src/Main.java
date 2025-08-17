public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        System.out.println("Welcome to your Address Book!");

        


        Contact.create("Nathan","Smith","07415266178","nls999@icloud.com");

        System.out.println(Contact.getFirstName(AddressBook.findContact("Nathan Smith")));

        Contact.updateFirstName("Nath", AddressBook.findContact("Nathan Smith"));

        System.out.println(Contact.getFirstName(AddressBook.findContact("Nath Smith")));
    }
}
