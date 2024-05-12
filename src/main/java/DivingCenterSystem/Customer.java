
package DivingCenterSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    
    private int national_ID;
    private String fname;
    private String lname;
    private String phone;
    private String birthdate;
    private String sex;
    private List<Booking> bookingsList;
    private static List<Customer> registeredCustomers = new ArrayList<>();
    
    public Customer(int national_ID, String fname, String lname, String phone, String birthdate, String sex) {
        this.national_ID = national_ID;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.birthdate = birthdate;
        this.sex = sex;
        this.bookingsList = new ArrayList<>(); 
    }
    
       public static void registerCustomer(Scanner scanner) {
       // Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name:");
        String fname = scanner.nextLine();
        System.out.println("Enter Last Name:");
        String lname = scanner.nextLine();
        System.out.println("Enter Sex (Male/Female):");
        String sex = scanner.nextLine();
         System.out.println("Enter Birthdate (DD-MM-YYYY):");
        String birthdate = scanner.nextLine();
        System.out.println("Enter National ID:");
        int national_ID = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter Phone Number:");
        String phone = scanner.nextLine();
       
       

        Customer newCustomer = new Customer(national_ID, fname, lname, phone, birthdate, sex);
        registeredCustomers.add(newCustomer);
        System.out.println("Customer registered successfully: " + fname + " " + lname);

    
    }

       public static Customer findCustomer(int nationalID) {
    for (Customer customer : registeredCustomers) {
        if (customer.national_ID == nationalID) {
            return customer;
        }
    }
    return null;
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
