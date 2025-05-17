package lms;

/**
 * The Patron class represents a library user with a unique ID, name, address, and overdue fine.
 */
public class Patron {
    private String id;
    private String name;
    private String address;
    private double fine;

    public Patron(String id, String name, String address, double fine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.fine = fine;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Address: %s | Fine: $%.2f", id, name, address, fine);
    }
}
