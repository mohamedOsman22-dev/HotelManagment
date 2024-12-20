package models;

/**
 *
 * @author moham
 */
public class Payment {
    
    private int paymentId;       // Unique ID for the payment
    private String type;
    private double price;
    private String status;
    private String customername;    // ID of the reservation for which payment is made
    private String customerprofile;        // Amount paid in the payment
    private String paymentmethod;   // Date when the payment was made

    public Payment(int paymentId, String type, double price, String status, String customername, String customerprofile, String paymentmethod) {
        this.paymentId = paymentId;
        this.type = type;
        this.price = price;
        this.status = status;
        this.customername = customername;
        this.customerprofile = customerprofile;
        this.paymentmethod = paymentmethod;
    }

    public Payment(String type, double price, String status, String customername, String customerprofile, String paymentmethod) {
        this.type = type;
        this.price = price;
        this.status = status;
        this.customername = customername;
        this.customerprofile = customerprofile;
        this.paymentmethod = paymentmethod;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomerprofile() {
        return customerprofile;
    }

    public void setCustomerprofile(String customerprofile) {
        this.customerprofile = customerprofile;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }
   
  
}
