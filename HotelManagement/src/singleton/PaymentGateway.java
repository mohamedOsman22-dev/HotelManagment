package singleton;

/**
 * Singleton class to handle payment processing in the Hotel Reservation System.
 */
public class PaymentGateway {
    private static PaymentGateway instance;

    // Private constructor to prevent direct instantiation
    private PaymentGateway() {
        // Initialize any resources required for payment processing
        System.out.println("PaymentGateway initialized.");
    }

    // Public static method to provide a single instance
    public static synchronized PaymentGateway getInstance() {
        if (instance == null) {
            instance = new PaymentGateway();
        }
        return instance;
    }

    // Method to process payment
    public boolean processPayment(String paymentType, double amount, String customerName) {
        System.out.println("Processing payment for customer: " + customerName);
        switch (paymentType.toLowerCase()) {
            case "credit card":
                return processCreditCardPayment(amount);
            case "paypal":
                return processPayPalPayment(amount);
            case "bank transfer":
                return processBankTransferPayment(amount);
            default:
                System.out.println("Unsupported payment type: " + paymentType);
                return false;
        }
    }

    // Private methods for specific payment types
    private boolean processCreditCardPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Add your credit card processing logic here
        // Simulate success
        return amount > 0;
    }

    private boolean processPayPalPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        // Add your PayPal processing logic here
        // Simulate success
        return amount > 0;
    }

    private boolean processBankTransferPayment(double amount) {
        System.out.println("Processing bank transfer payment of $" + amount);
        // Add your bank transfer processing logic here
        // Simulate success
        return amount > 0;
    }
}
