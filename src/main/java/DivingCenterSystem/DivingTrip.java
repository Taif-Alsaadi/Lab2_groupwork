
package DivingCenterSystem;


public class DivingTrip extends Service {
      private String date;

    public DivingTrip(int serviceNum, String name, String type, String description, String date) {
        super(serviceNum, name, type, description);
        this.date = date;
    }

    public void divingTrip(int sNum, String name, String type, String description, String startTime, String endTime, String date) {
      
    }

    public void setDate(int serviceNum, String date) {
        
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
}
