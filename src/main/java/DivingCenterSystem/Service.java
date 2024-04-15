
package DivingCenterSystem;


public class Service {
    private int serviceNum;
    private String name;
    private String type;
    private String description;
    private String startTime;
    private String endTime;

    public Service(int serviceNum, String name, String type, String description) {
        this.serviceNum = serviceNum;
        this.name = name;
        this.type = type;
        this.description = description;
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
    
    public void service(int sNum, String name, String type, String description) {
       
    }

    public void removeService(int sNum) {
     
    }

    public void addStartTime(int sNum, String sTime) {
     
    }

    public void addEndTime(int sNum, String eTime) {
        
    }
}
