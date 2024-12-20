/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import models.Reservation;

/**
 * Factory class for creating Reservation objects.
 */
public class CustomerFactory {
    public static Reservation createReservation(String checkInDate, String checkOutDate, double totalPrice, String customerName, int roomId, String type) {
        switch (type.toLowerCase()) {
            case "standard":
                return new Reservation(checkInDate, checkOutDate, totalPrice, customerName, roomId, "Standard");
            case "vip":
                return new Reservation(checkInDate, checkOutDate, totalPrice, customerName, roomId, "VIP");
            case "corporate":
                return new Reservation(checkInDate, checkOutDate, totalPrice, customerName, roomId, "Corporate");
            default:
                throw new IllegalArgumentException("Unknown reservation type: " + type);
        }
    }
}
