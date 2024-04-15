package DivingCenterSystem;

import java.util.ArrayList;
import java.util.List;

public class DivingTrip extends Service {
    private static List<DivingTrip> divingTrips = new ArrayList<>();
    private String date;

    public DivingTrip(int serviceNum, String name, String type, String description, String date) {
        super(serviceNum, name, type, description);
        this.date = date;
        divingTrips.add(this); // Add this diving trip to the list upon creation
    }

    public static List<DivingTrip> getDivingTrips() {
        return divingTrips;
    }

    public static void removeDivingTrip(int serviceNum) {
        for (DivingTrip trip : divingTrips) {
            if (trip.getServiceNum() == serviceNum) {
                divingTrips.remove(trip);
                break;
            }
        }
    }

    public static DivingTrip findDivingTrip(int serviceNum) {
        for (DivingTrip trip : divingTrips) {
            if (trip.getServiceNum() == serviceNum) {
                return trip;
            }
        }
        return null;
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
