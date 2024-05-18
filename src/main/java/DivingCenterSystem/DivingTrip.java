package DivingCenterSystem;

import java.util.ArrayList;
import java.util.List;

public class DivingTrip extends Service {
    
    private static List<DivingTrip> divingTrips = new ArrayList<>();
    private static final int MAX_CAPACITY = 6; // Maximum capacity for diving trips
    private static int currentCapacity;
    private String date;

    public DivingTrip(int serviceNum, String name, String type, String description, String date) {
        super(serviceNum, name, type, description);
        this.date = date;
        divingTrips.add(this); // Add this diving trip to the list upon creation
        this.currentCapacity = 0; // Initially no bookings
    }

    public static int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public String getDate() {
        return date;
    }

    public static void setDivingTrips(List<DivingTrip> divingTrips) {
        DivingTrip.divingTrips = divingTrips;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    

    public static List<DivingTrip> getDivingTrips() {
        return divingTrips;
    }
    
    // Method to check if the trip can be booked
    public boolean canBook() {
        return currentCapacity < MAX_CAPACITY;
    }
        
    public void addBooking() {
        if (canBook()) {
            currentCapacity++;
        } else {
            System.out.println("Sorry, the diving trip is already fully booked.");
        }
    }

    public static void removeDivingTrip(int serviceNum) {
        for (DivingTrip trip : divingTrips) {
            if (trip.getServiceNum() == serviceNum) {
                divingTrips.remove(trip);
                currentCapacity--;
                break;
            }
        }
    }


    public String getDivingTripInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Diving Trip Information:\n");
        info.append("Service Number: ").append(getServiceNum()).append("\n");
        info.append("Name: ").append(getName()).append("\n");
        info.append("Type: ").append(getType()).append("\n");
        info.append("Description: ").append(getDescription()).append("\n");
        info.append("Date: ").append(date).append("\n");
        return info.toString();
    }

        public static DivingTrip findDivingTrip(int serviceNum) {
        for (DivingTrip trip : divingTrips) {
            if (trip.getServiceNum() == serviceNum) {
                return trip;
            }
        }
        return null;
    }

    public static List<String> getDivingTripInfoByDate(String targetDate) {
        List<String> tripInfoList = new ArrayList<>();
        for (DivingTrip trip : divingTrips) {
            if (trip.getDate().equals(targetDate)) {
                tripInfoList.add(trip.getDivingTripInfo());
            }
        }
        return tripInfoList;
    }
} 
