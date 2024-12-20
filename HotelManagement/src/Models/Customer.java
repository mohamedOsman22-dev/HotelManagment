package models;

/**
 *
 * @author moham
 */
public class Customer {
    private int customerId;      // Unique ID for the customer
    private String name;         // Name of the customer
    private String email;        // Email of the customer
    private String phone;        // Phone number of the customer
    private String customerType; // Type of the customer (e.g., Regular, VIP, Corporate)

    // Constructor
    public Customer(String name, String email, String phone, String customerType) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
