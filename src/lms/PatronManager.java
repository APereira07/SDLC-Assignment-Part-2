package lms;

import java.util.ArrayList;

/**
 * PatronManager class manages the collection of Patron objects.
 * It supports adding, removing, and displaying patrons.
 */
public class PatronManager {
    // List to store Patron objects
    private ArrayList<Patron> patrons;

    /**
     * Constructor initializes the patrons list.
     */
    public PatronManager() {
        patrons = new ArrayList<>();
    }

    /**
     * Adds a new patron to the list.
     * @param patron The Patron object to add
     */
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    /**
     * Removes a patron from the list by their unique ID.
     * @param id The 7-digit ID of the patron to remove
     * @return true if a patron was removed; false otherwise
     */
    public boolean removePatron(String id) {
        // Remove any patron whose ID matches the given id
        return patrons.removeIf(p -> p.getId().equals(id));
    }

    /**
     * Displays all patrons currently stored in the system.
     * Prints a message if no patrons are found.
     */
    public void displayPatrons() {
        if (patrons.isEmpty()) {
            System.out.println("No patrons found.");
        } else {
            System.out.println("\nList of all patrons:");
            for (Patron p : patrons) {
                // Print each patron's details by calling their toString() method
                System.out.println(p);
            }
        }
    }

    /**
     * Getter method to access the list of patrons.
     * @return ArrayList of Patron objects
     */
    public ArrayList<Patron> getPatrons() {
        return patrons;
    }
}
