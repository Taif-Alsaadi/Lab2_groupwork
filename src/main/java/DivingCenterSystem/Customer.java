package DivingCenterSystem;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int national_ID;
    private String fname;
    private String lname;
    private String phone;
    private String birthdate;
    private String sex;
    private List<Booking> bookingsList;

    public Customer(int national_ID, String fname, String lname, String phone, String birthdate, String sex) {
        this.national_ID = national_ID;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.birthdate = birthdate;
        this.sex = sex;
        this.bookingsList = new ArrayList<>(); 
    }

    public Booking bookService(int serviceNum, String bookingDate) {
        if (bookingsList.size() < 10) { // Check if there's still capacity for booking
            Booking booking = new Booking(bookingsList.size() + 1, national_ID, serviceNum, bookingDate);
            bookingsList.add(booking);
            return booking;
        } else {
            return null; // If no available slots for booking
        }
    }

    public String cancelBooking(int bookingID) {
        for (Booking booking : bookingsList) {
            if (booking.getBookingID() == bookingID) {
                bookingsList.remove(booking);
                return "Booking canceled successfully.";
            }
        }
        return "Booking not found."; // If booking ID not found
    }
}
