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
            System.out.print("Enter your choice (1-6): ");

            int choice = getIntInput(1, 6); // Validate input for menu selection
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
            }
        }
        scanner.close();
    }

    private static void initializeServices() {
        new DivingTrip(101, "Explore Red Sea", "Trip", "Dive at the beautiful coral reefs", "2024-07-15");
        new DivingCourse(102, "Beginner Diving Course", "Course", "Learn basic diving skills", "2024-08-01", "2024-08-20", "Beginner");
    }

    private static void searchForService() {
        System.out.print("Enter 't' for Diving Trip or 'c' for Diving Course: ");
        String type;
        while (true) {
            type = scanner.nextLine().trim().toLowerCase();
            if (type.equals("t") || type.equals("c")) {
                break;
            }
            System.out.print("Invalid input. Please enter 't' for Diving Trip or 'c' for Diving Course: ");
        }

        List<Service> foundServices = Service.findServiceByType(type);
        if (!foundServices.isEmpty()) {
            System.out.println("Services found:");
            for (Service service : foundServices) {
                System.out.println(service.getName() + " (Service number: " + service.getServiceNum() + ") - " + service.getDescription());
            }
        } else {
            System.out.println("No services found for the specified type.");
        }
    }

    private static void bookService() {
        System.out.print("Enter Customer National ID: ");
        int nationalID = getIntInput(); // Get national ID as integer
        Customer customer = Customer.findCustomer(nationalID);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter 't' for Diving Trip or 'c' for Diving Course to view services: ");
        String type = scanner.nextLine().trim().toLowerCase();
        List<Service> services = Service.findServiceByType(type);
        if (services.isEmpty()) {
            System.out.println("No services of the selected type available.");
            return;
        }

        System.out.println("Please select a service number to book:");
        for (Service service : services) {
            System.out.println(service.getName() + " (Service number: " + service.getServiceNum() + ")");
        }

        int serviceNum = getIntInput(); // Assume the user knows the service number
        Service service = Service.findService(serviceNum);
        if (service == null) {
            System.out.println("Service not found.");
            return;
        }

        System.out.print("Enter booking date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        Booking booking = customer.bookService(service.getServiceNum(), date);
        if (booking != null) {
            System.out.println("Booking successful. Booking ID: " + booking.getBookingID());
        } else {
            System.out.println("Failed to book. Please check the availability and try again.");
        }
    }

    private static void cancelBooking() {
        System.out.print("Enter Customer National ID: ");
        int nationalID = getIntInput();
        Customer customer = Customer.findCustomer(nationalID);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter Booking ID to cancel: ");
        int bookingID = getIntInput();
        String result = customer.cancelBooking(bookingID);
        System.out.println(result);
    }

    private static void showServiceInfo() {
        System.out.print("Enter 't' for Diving Trip or 'c' for Diving Course to show info: ");
        String type = scanner.nextLine();
        List<Service> services = Service.findServiceByType(type);
        if (!services.isEmpty()) {
            for (Service service : services) {
                if (service instanceof DivingTrip) {
                    System.out.println(((DivingTrip) service).getDivingTripInfo());
                } else if (service instanceof DivingCourse) {
                    System.out.println(((DivingCourse) service).getDivingCourseInfo());
                }
            }
        } else {
            System.out.println("No services of the selected type found.");
        }
    }

    // Helper method to ensure integer input
    private static int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    // Generic integer input validation
    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
