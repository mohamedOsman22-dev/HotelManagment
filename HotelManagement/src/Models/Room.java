
package models;

import prototype.Prototype;
import Models.RoomComponent;

/**
 * Represents a room in the Hotel Reservation System.
 */
public class Room implements Prototype, RoomComponent {
    private int id;               // Unique ID for the room
    private String type;          // Type of the room (e.g., Standard, Deluxe, Suite)
    private double price;         // Price per night for the room
    private String status;        // Status of the room (e.g., Available, Booked)

    // Constructor without ID
    public Room(String type, double price, String status) {
        this.type = type;
        this.status = status;
        this.price = price;
        this.id = generateId();  // ID can be auto-generated
    }

    // Constructor with ID
    public Room(int id, String type, double price, String status) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.price = price;
    }

    // Generate a unique ID (this can be adjusted to a more advanced method as needed)
    private int generateId() {
        return (int) (Math.random() * 10000);  // For example, generate a random ID
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public double getPrice() {
        return price;
    }

    // Prototype pattern: Cloning the current object
    @Override
    public Room clone() {
        return new Room(this.id, this.type, this.price, this.status);
    }
}
