
package DivingCenterSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Service {
    
    private int serviceNum;
    private String name;
    private String type;
    private String description;
    private String startTime;
    private String endTime;
    private static List<Service> allServices = new ArrayList<>(); // Static list to store all services
    private int[] bookingIDs=new int[30];

    public Service(int serviceNum, String name, String type, String description) {
        this.serviceNum = serviceNum;
        this.name = name;
        this.type = type;
        this.description = description;
        allServices.add(this);  // Add the newly created service to the list of all services         
        Arrays.fill(bookingIDs, -1); // Initialize the booking IDs array with -1 to indicate empty slots
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

     public int getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(int serviceNum) {
        this.serviceNum = serviceNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
      
    // Static method to retrieve all services
    public static List<Service> getAllServices() {
        return allServices;
    }
    
public void service(int sNum, String name, String type, String description) {
    // Create a new service object and add it to the list of all services
    Service newService = new Service(sNum, name, type, description);
}

public void removeService(int sNum) {
    // Iterate through the list of all services
    for (Service service : Service.getAllServices()) {
        // If the service number matches, remove it from the list
        if (service.getServiceNum() == sNum) {
            Service.getAllServices().remove(service);
            break; // Exit the loop after removing the service
        }
    }
}

public void addStartTime(int sNum, String sTime) {
    for (Service service : Service.getAllServices()) {
        if (service.getServiceNum() == sNum) {
            service.setStartTime(sTime);
            break; 
        }
    }
}

public void addEndTime(int sNum, String eTime) {
    for (Service service : Service.getAllServices()) {
        if (service.getServiceNum() == sNum) {
            service.setEndTime(eTime);
            break; 
        }
    }
}


//--------------------------------------------------

// Method to add booking ID to this service
    public void addBookingID(int bookingID) {
        // Find the first empty slot in the booking IDs array
        for (int i = 0; i < bookingIDs.length; i++) {
            if (bookingIDs[i] == -1) {
                bookingIDs[i] = bookingID;
                break;
            }
        }
    }

    // Method to get all booking IDs for this service
     public int[] getBookingIDs() {
        return bookingIDs;
    }
    // Method to remove booking ID from this service
    public void removeBookingID(int bookingID) {
     
        // Find and remove the specified booking ID from the array
        for (int i = 0; i < bookingIDs.length; i++) {
            if (bookingIDs[i] == bookingID) {
                bookingIDs[i] = -1; // Mark the slot as empty
                break;
            }
        }
    }
    
     // Method to search for services based on a keyword
    public static List<Service> searchServices(String keyword) {
        List<Service> matchingServices = new ArrayList<>();

        for (Service service : allServices) {
            if (service.getName().contains(keyword) || service.getDescription().contains(keyword)) {
                matchingServices.add(service);
            }
        }

        return matchingServices;
    }
   

    
}
