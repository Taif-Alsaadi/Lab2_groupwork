
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


    public Booking bookService(int serviceNum, Booking[] bookingsList) {
        
        return null; 
    }

    public String cancelBooking(Booking booking, Booking[] bookingsList) {
        
        return null; 
    }
}
