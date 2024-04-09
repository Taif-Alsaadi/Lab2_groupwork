
package DivingCenterSystem;


public class DivingCourse extends Service{
  private String startDate;
    private String endDate;
    private String level;

    public DivingCourse(int serviceNum, String name, String type, String description, String startDate, String endDate, String level) {
        super(serviceNum, name, type, description);
        this.startDate = startDate;
        this.endDate = endDate;
        this.level = level;
    }

    public void divingCourse(int sNum, String name, String type, String description, String startTime, String endTime, String sDate, String eDate, String level) {
       
    }

    public void setSdate(int serviceNum, String sDate) {
        
    }

    public void setEdate(int serviceNum, String eDate) {
       
    }
}
