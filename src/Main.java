public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        System.out.println("Welcome to your Address Book!");
        Contact contact = new Contact("John", "Doe", "123-456-7890", "email@address.com");
        Contact contact2 = new Contact("Jane", "Smith", "098-765-4321", "email@address.com");


        Contact.create("Nathan","Smith","07415266178","nls999@icloud.com");


        System.out.println(AddressBook.addressBook);
    }
}
