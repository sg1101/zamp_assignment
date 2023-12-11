import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search by Name");
            System.out.println("3. Search by Phone Number");
            System.out.println("4. Exit");

            try{
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println("Enter First Name:");
                        String firstName = scanner.nextLine();

                        System.out.println("Enter Last Name:");
                        String lastName = scanner.nextLine();

                        System.out.println("Enter Address:");
                        String address = scanner.nextLine();

                        System.out.println("Enter Phone Number:");
                        String phoneNumber = scanner.nextLine();

                        addressBook.addContact(firstName, lastName, address, phoneNumber);
                        System.out.println("Contact added successfully!");
                        break;

                    case 2:
                        System.out.println("Enter Name to search:");
                        String searchName = scanner.nextLine();
                        List<Contact> resultByName = addressBook.searchByName(searchName);
                        displaySearchResults(resultByName);
                        break;

                    case 3:
                        System.out.println("Enter Phone Number to search:");
                        String searchPhone = scanner.nextLine();
                        List<Contact> resultByPhone = addressBook.searchByPhoneNumber(searchPhone);
                        displaySearchResults(resultByPhone);
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();  // Consume the invalid input
            }
        }
    }

    private static void displaySearchResults(List<Contact> results) {
        if (results.isEmpty()) {
            System.out.println("No matching contacts found.");
        } else {
            System.out.println("Search results:");
            for (Contact contact : results) {
                System.out.println("Name: " + contact.firstName + " " + contact.lastName +
                        ", Address: " + contact.address +
                        ", Phone Number: " + contact.phoneNumber);
            }
        }
    }
}