import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phone;
    private String email;

    // Constructor
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Name: " + name + " | Phone: " + phone + " | Email: " + email;
    }
}

public class SimpleContactManagementSystem {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n====== Contact Management System ======");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> updateContact();
                case 4 -> deleteContact();
                case 5 -> System.out.println("👋 Exiting... Thank you!");
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    // ➕ Add a new contact
    private static void addContact() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("✅ Contact added successfully!");
    }

    // 👀 View all contacts
    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("⚠️ No contacts found!");
        } else {
            System.out.println("\n------ Contact List ------");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    // ✏️ Update a contact
    private static void updateContact() {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("\nEnter contact number to update: ");
        int index = sc.nextInt() - 1;
        sc.nextLine(); // consume newline

        if (index >= 0 && index < contacts.size()) {
            Contact contact = contacts.get(index);

            System.out.print("Enter new name (" + contact.getName() + "): ");
            String name = sc.nextLine();
            System.out.print("Enter new phone (" + contact.getPhone() + "): ");
            String phone = sc.nextLine();
            System.out.print("Enter new email (" + contact.getEmail() + "): ");
            String email = sc.nextLine();

            if (!name.isEmpty()) contact.setName(name);
            if (!phone.isEmpty()) contact.setPhone(phone);
            if (!email.isEmpty()) contact.setEmail(email);

            System.out.println("✅ Contact updated successfully!");
        } else {
            System.out.println("❌ Invalid contact number!");
        }
    }

    // 🗑️ Delete a contact
    private static void deleteContact() {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("\nEnter contact number to delete: ");
        int index = sc.nextInt() - 1;

        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("🗑️ Contact deleted successfully!");
        } else {
            System.out.println("❌ Invalid contact number!");
        }
    }
}
