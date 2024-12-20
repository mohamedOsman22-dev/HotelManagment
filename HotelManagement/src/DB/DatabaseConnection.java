/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Payment;
import models.Room;

/**
 *
 * @author moham
 */
public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=HotelDB;encrypt=false";
    private static final String USER = "sa";
    private static final String PASSWORD = "123";

    // Private constructor for singleton instance
    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        // Check if the connection is closed, and re-establish it if needed
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void insertRoom(Room Room) {
        String sql = "INSERT INTO Rooms (type,price,status) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = getInstance().getConnection().prepareStatement(sql)) {
            pstmt.setString(1, Room.getType());
            pstmt.setDouble(2, Room.getPrice());
            pstmt.setString(3, Room.getStatus());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting product: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    public static void insertPayment(Payment Payment) {
        String sql = "INSERT INTO Payments (type,price,status,customername,customerprofile,paymentmethod) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement pstmt = getInstance().getConnection().prepareStatement(sql)) {
            pstmt.setString(1, Payment.getType());
            pstmt.setString(2, Double.toString(Payment.getPrice()));
            pstmt.setString(3, Payment.getStatus());
            pstmt.setString(4, Payment.getCustomername());
            pstmt.setString(5, Payment.getCustomerprofile());
            pstmt.setString(6, Payment.getPaymentmethod());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Paymnet inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting Payment: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void closeConnection() {
        if (instance != null && instance.connection != null) {
            try {
                instance.connection.close();
                instance.connection = null; // Reset connection
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
