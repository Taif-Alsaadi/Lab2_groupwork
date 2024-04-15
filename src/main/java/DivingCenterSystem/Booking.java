package DivingCenterSystem;

public class Customer {
    private int national_ID;
    private String fname;
    private String lname;
    private String phone;
    private String birthdate;
    private String sex;
    private Booking[] bookingsList;

    public Customer(int national_ID, String fname, String lname, String phone, String birthdate, String sex) {
        this.national_ID = national_ID;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.birthdate = birthdate;
        this.sex = sex;
        this.bookingsList = new Booking[10]; // Assuming maximum 10 bookings
    }

    public Booking bookService(int serviceNum, String bookingDate) {
        for (int i = 0; i < bookingsList.length; i++) {
            if (bookingsList[i] == null) {
                Booking booking = new Booking(i + 1, national_ID, serviceNum, bookingDate);
                bookingsList[i] = booking;
                return booking;
            }
        }
        return null; // If no available slots for booking
    }

    public String cancelBooking(int bookingID) {
        for (int i = 0; i < bookingsList.length; i++) {
            if (bookingsList[i] != null && bookingsList[i].getBookingID() == bookingID) {
                bookingsList[i] = null;
                return "Booking canceled successfully.";
            }
        }
        return "Booking not found."; // If booking ID not found
    }
}
