
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
}
