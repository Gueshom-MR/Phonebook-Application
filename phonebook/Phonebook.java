package phonebook;

import java.util.Arrays;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;

    // Constructor
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // toString method to display contact details
    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}

public class Phonebook {
    private Contact[] contacts;
    private int count;
    private final int MAX_SIZE = 100;

    // Constructor to initialize phonebook
    public Phonebook() {
        contacts = new Contact[MAX_SIZE];
        count = 0;
    }

    // 1. Insert Contact
    public void insertContact(String name, String phoneNumber) {
        if (count < MAX_SIZE) {
            contacts[count] = new Contact(name, phoneNumber);
            count++;
            System.out.println("Contact added: " + name);
        } else {
            System.out.println("Phonebook is full!");
        }
    }

    // 2. Search Contact
    public void searchContact(String name) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].name.equalsIgnoreCase(name)) {
                System.out.println("Contact found: " + contacts[i]);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // 3. Display All Contacts
    public void displayAllContacts() {
        if (count == 0) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("All Contacts:");
            for (int i = 0; i < count; i++) {
                System.out.println(contacts[i]);
            }
        }
    }

    // 4. Delete Contact
    public void deleteContact(String name) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].name.equalsIgnoreCase(name)) {
                for (int j = i; j < count - 1; j++) {
                    contacts[j] = contacts[j + 1];
                }
                contacts[count - 1] = null;
                count--;
                System.out.println("Contact deleted: " + name);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // 5. Update Contact
    public void updateContact(String name, String newPhoneNumber) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].name.equalsIgnoreCase(name)) {
                contacts[i].phoneNumber = newPhoneNumber;
                System.out.println("Contact updated: " + name);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // 6. Sort Contacts
    public void sortContacts() {
        if (count == 0) {
            System.out.println("Phonebook is empty.");
            return;
        }
        Arrays.sort(contacts, 0, count, (c1, c2) -> c1.name.compareToIgnoreCase(c2.name));
        System.out.println("Contacts sorted alphabetically.");
    }

    // 7. Analyze Search Efficiency (Linear Search)
    public void analyzeSearchEfficiency() {
        System.out.println("Search efficiency depends on the number of contacts.");
        System.out.println("Time complexity of search (linear search): O(n)");
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nPhonebook Menu:");
            System.out.println("1. Insert Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Display All Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Update Contact");
            System.out.println("6. Sort Contacts");
            System.out.println("7. Analyze Search Efficiency");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    phonebook.insertContact(name, phoneNumber);
                    break;
                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    phonebook.searchContact(searchName);
                    break;
                case 3:
                    phonebook.displayAllContacts();
                    break;
                case 4:
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    phonebook.deleteContact(deleteName);
                    break;
                case 5:
                    System.out.print("Enter name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhone = scanner.nextLine();
                    phonebook.updateContact(updateName, newPhone);
                    break;
                case 6:
                    phonebook.sortContacts();
                    break;
                case 7:
                    phonebook.analyzeSearchEfficiency();
                    break;
                case 8:
                    System.out.println("Exiting Phonebook...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}