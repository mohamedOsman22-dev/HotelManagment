package factory;

import models.Room;

public class RoomFactory {
    // Create a room without an ID
    public static Room createRoom(String type, double price, String status) {
        switch (type.toLowerCase()) {
            case "standard":
                return new Room(type, price, status);
            case "deluxe":
                return new Room(type, price, status);
            case "suite":
                return new Room(type, price, status);
            default:
                throw new IllegalArgumentException("Unknown room type: " + type);
        }
    }

    // Create a room with an ID
    public static Room createRoomWithId(int id,String type, double price, String status) {
        switch (type.toLowerCase()) {
            case "standard":
                return new Room(type, price, status);
            case "deluxe":
                return new Room(type, price, status);
            case "suite":
                return new Room(type, price, status);
            default:
                throw new IllegalArgumentException("Unknown room type: " + type);
        }
    }
}
