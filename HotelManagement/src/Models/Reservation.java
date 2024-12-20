/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author moham
 */
public class Reservation {
    private int reservationId;   // Unique ID for the reservation
    private int roomId;          // ID of the reserved room
    private double totalPrice;   // Total price of the reservation
    private String checkInDate;  // Check-in date
    private String checkOutDate; // Check-out date
    private String customerName; // Name of the customer
    private String status;       // Status of the reservation (e.g., Confirmed, Cancelled)

    public Reservation(String checkInDate, String checkOutDate, double totalPrice, String customerName, int roomId, String status) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.customerName = customerName;
        this.roomId = roomId;
        this.status = status;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getStatus() {
        return status;
    }
}
