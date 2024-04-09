
package DivingCenterSystem;

public class Booking {
    private int bookingID;
    private int custNational_ID;
    private int serviceNum;
    private String bookingDate;
    
    
    public Booking(int bookingID, int custNational_ID, int serviceNum, String bookingDate) {
        this.bookingID = bookingID;
        this.custNational_ID = custNational_ID;
        this.serviceNum = serviceNum;
        this.bookingDate = bookingDate;
    }
    
    public void booking(int bID, int cID, int sNum, String date) {
       
    }

    public boolean canBook() {
        
        return true; 
    }
}
