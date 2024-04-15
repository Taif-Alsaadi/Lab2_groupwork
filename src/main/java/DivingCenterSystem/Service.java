
package DivingCenterSystem;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private int serviceNum;
    private String name;
    private String type;
    private String description;
    private String startTime;
    private String endTime;

       // Static list to store all services
    private static List<Service> allServices = new ArrayList<>();

    public Service(int serviceNum, String name, String type, String description) {
        this.serviceNum = serviceNum;
        this.name = name;
        this.type = type;
        this.description = description;
                // Add the newly created service to the list of all services
        allServices.add(this);
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

    
}
