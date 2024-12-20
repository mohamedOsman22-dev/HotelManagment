/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package builder;

import models.Payment;
import models.Reservation;
import models.Room;

public class PaymentBuilder {
   private int paymentId;       // Unique ID for the payment
    private String type;
    private double price;
    private String status;
    private String customername;    // ID of the reservation for which payment is made
    private String customerprofile;        // Amount paid in the payment
    private String paymentmethod;   // Date when the payment was made

    public PaymentBuilder setPaymentId(int paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public PaymentBuilder setType(String type) {
        
        this.type = type;
    return this;
    }

    public PaymentBuilder setPrice(double price) {
        this.price = price;
   return this;
    }

    public PaymentBuilder setStatus(String status) {
        this.status = status;
    return this;
    }

    public PaymentBuilder setCustomername(String customername) {
        this.customername = customername;
    
    return this;
    }

    public PaymentBuilder setCustomerprofile(String customerprofile) {
        this.customerprofile = customerprofile;
   return this;
    }

    public PaymentBuilder setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    return this;
    }

    
   
    public Payment build()
    {
        return new Payment(paymentId,type,price,status,customername,customerprofile,paymentmethod);
    }
    
    
}
