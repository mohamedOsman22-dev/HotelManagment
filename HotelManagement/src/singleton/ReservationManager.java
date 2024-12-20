package singleton;

import Models.RoomComponent;
import java.util.ArrayList;
import java.util.List;
import models.Reservation;
import models.Room;

public class ReservationManager {
    private static ReservationManager instance;
    private List<RoomComponent> reservations;

    // Private constructor to enforce Singleton pattern
    private ReservationManager() {
        reservations = new ArrayList<>();
    }

    // Method to get the single instance of ReservationManager
    public static ReservationManager getInstance() {
        if (instance == null) {
            instance = new ReservationManager();
        }
        return instance;
    }

    // Add a new reservation to the list
    public void addRoom(RoomComponent room) {
        reservations.add(room);
        System.out.println(room.getType() + " added.");
    }

    // Clear all reservations
    public void clearReservations() {
        reservations.clear();
        System.out.println("All reservations cleared.");
    }

    // Calculate the total revenue from all reservations
    public List<String> getType()
    {
    List<String>types=new ArrayList<>();
    
    for (RoomComponent room :  ReservationManager.getInstance().getResevationItems()) {
            types.add( room.getType());
        }
    
    return types;
    }
    
    public List<String> getPrice()
    {
    List <String> prices =new ArrayList<>();
    for (RoomComponent room :  ReservationManager.getInstance().getResevationItems()) {
            prices.add(String.valueOf(room.getPrice()));          
        }
    
    
    return prices;
    }
    public List<String> getStatus()
    {
    List<String>status=new ArrayList<>();
    for (RoomComponent room :  ReservationManager.getInstance().getResevationItems()) {
            status.add( room.getStatus());
        }
    return status;
    }
    
    public double calculateReservationTotal() {
        double total = 0.0;

        for (RoomComponent room :  ReservationManager.getInstance().getResevationItems()) {
            total += room.getPrice();
        }

        return total;
    }

      public void clearCart() {
        reservations.clear();
    }
    // Get all reservations
    public List<RoomComponent> getResevationItems() {
        return reservations;
    }

    public void updateRoom(int index, RoomComponent room) {
      reservations.set(index,room);
        }
}