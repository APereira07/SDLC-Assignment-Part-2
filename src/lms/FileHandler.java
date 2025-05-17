package lms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Handles reading patron data from a text file and adding them to the manager.
 */
public class FileHandler {

    // Loads patron data from a file
    public static void loadFromFile(PatronManager manager, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length != 4) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                String id = parts[0];
                String name = parts[1];
                String address = parts[2];
                double fine;

                try {
                    fine = Double.parseDouble(parts[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid fine for line: " + line);
                    continue;
                }

                manager.addPatron(new Patron(id, name, address, fine));
                count++;
            }

            System.out.println("Loaded " + count + " patrons from file.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
