package lms;

import java.util.Scanner;

/**
 * Main class for the Library Management System (LMS).
 * This class provides a command-line menu to manage patrons:
 * - Load patron data from a file
 * - Add new patrons manually
 * - Remove existing patrons
 * - Display all patrons
 * - Exit the program
 */
public class Main {

    public static void main(String[] args) {
        // Create a Scanner to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Create an instance of PatronManager to manage patron records
        PatronManager manager = new PatronManager();

        boolean running = true;

        // Loop to display the main menu until user chooses to exit
        while (running) {
            // Display menu options
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Load patron data from file");
            System.out.println("2. Add a new patron manually");
            System.out.println("3. Remove a patron by ID");
            System.out.println("4. Display all patrons");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            String choice = scanner.nextLine();

            // Handle menu selection
            switch (choice) {
                case "1":
                    // Prompt for file path and load patron data
                    System.out.print("Enter the file path to load patrons (e.g., patrons.txt): ");
                    String filePath = scanner.nextLine();
                    FileHandler.loadFromFile(manager, filePath);
                    break;
                case "2":
                    // Prompt for patron details and add a new patron
                    System.out.print("Enter Patron ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Patron Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Patron Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Overdue Fine (0-250): ");
                    double overdueFine = 0.0;
                    try {
                        overdueFine = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for overdue fine. Setting to 0.");
                    }
                    manager.addPatron(new Patron(id, name, address, overdueFine));
                    break;
                case "3":
                    // Remove a patron by ID
                    System.out.print("Enter the Patron ID to remove: ");
                    String removeId = scanner.nextLine();
                    manager.removePatron(removeId);
                    break;
                case "4":
                    // Display all patrons
                    manager.displayPatrons();
                    break;
                case "5":
                    // Exit the program
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
