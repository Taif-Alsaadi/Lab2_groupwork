package DivingCenterSystem;

public class Booking {
    private int bookingID;
    private int custNational_ID;
    private int serviceNum;
    private String bookingDate;

    public Booking(int bookingID, int custNational_ID, int serviceNum, String bookingDate) {
        this.bookingID = bookingID;
        this.custNational_ID = custNational_ID;
        this.serviceNum = serviceNum;
        this.bookingDate = bookingDate;
    }

    public int getBookingID() {
        return bookingID;
    }

    public int getServiceNum() {
        return serviceNum;
    }

    public void cancelBooking() {
        // Perform cancellation logic here
        // This method can be implemented based on your specific requirements.
        // For example, you can update a database record, send a cancellation notification, etc.
        System.out.println("Booking with ID: " + bookingID + " has been canceled.");
    }
}