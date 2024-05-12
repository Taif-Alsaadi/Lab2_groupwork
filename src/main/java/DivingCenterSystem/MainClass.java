package DivingCenterSystem;

import java.util.Scanner;
import java.util.List;

public class MainClass {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
 initializeServices(); // Initialize services to start with

        boolean run = true;
        while (run) {
            System.out.println("\n--- Diving Center System Menu ---");
            System.out.println("1. Register Customer");
            System.out.println("2. Search for Service");
            System.out.println("3. Book Service");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Show Service Information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            switch (choice) {
                case 1:
                    Customer.registerCustomer(scanner);
                    break;
                case 2:
                    searchForService();
                    break;
                case 3:
                    bookService();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    showServiceInfo();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void initializeServices() {
        // Example services
        new DivingTrip(101, "Explore Red Sea", "Trip", "Dive at the beautiful coral reefs", "2024-07-15");
        new DivingCourse(102, "Beginner Diving Course", "Course", "Learn basic diving skills", "2024-08-01", "2024-08-20", "Beginner");
    }

    private static void searchForService() {
        System.out.print("Enter keyword to search for services: ");
        String keyword = scanner.nextLine();
        List<Service> foundServices = Service.searchServices(keyword);
        if (!foundServices.isEmpty()) {
            System.out.println("Services found:");
            for (Service service : foundServices) {
                System.out.println(service.getName() + " - " + service.getDescription());
            }
        } else {
            System.out.println("No services found with the keyword '" + keyword + "'.");
        }
    }

    private static void bookService() {
        System.out.print("Enter Customer National ID: ");
        int nationalID = scanner.nextInt();
        Customer customer = Customer.findCustomer(nationalID);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter Service Number to book: ");
        int serviceNum = scanner.nextInt();
        Service service = Service.findService(serviceNum);
        if (service == null) {
            System.out.println("Service not found.");
            return;
        }

        System.out.print("Enter booking date (YYYY-MM-DD): ");
        scanner.nextLine(); // Clear buffer
        String date = scanner.nextLine();
        Booking booking = customer.bookService(serviceNum, date);
        if (booking != null) {
            System.out.println("Booking successful. Booking ID: " + booking.getBookingID());
        } else {
            System.out.println("Failed to book. Please check the availability and try again.");
        }
    }

    private static void cancelBooking() {
        System.out.print("Enter Customer National ID: ");
        int nationalID = scanner.nextInt();
        Customer customer = Customer.findCustomer(nationalID);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter Booking ID to cancel: ");
        int bookingID = scanner.nextInt();
        String result = customer.cancelBooking(bookingID);
        System.out.println(result);
    }

    private static void showServiceInfo() {
        System.out.print("Enter Service Number to show info: ");
        int serviceNum = scanner.nextInt();
        Service service = Service.findService(serviceNum);
        if (service instanceof DivingTrip) {
            System.out.println(((DivingTrip) service).getDivingTripInfo());
        } else if (service instanceof DivingCourse) {
            System.out.println(((DivingCourse) service).getDivingCourseInfo());
        } else {
            System.out.println("Service not found.");
        }
    }
}
