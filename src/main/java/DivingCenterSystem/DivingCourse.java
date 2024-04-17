package DivingCenterSystem;

import java.util.ArrayList;
import java.util.List;

public class DivingCourse extends Service {
    private static final int MAX_CAPACITY = 4; // Maximum capacity for diving courses
    private static int currentCapacity; // Current number of bookings 
    private static List<DivingCourse> divingCourses = new ArrayList<>();
    private String startDate;
    private String endDate;
    private String level;

    public DivingCourse(int serviceNum, String name, String type, String description, String startDate, String endDate, String level) {
        super(serviceNum, name, type, description);
        this.startDate = startDate;
        this.endDate = endDate;
        this.level = level;
        divingCourses.add(this); // Add this diving course to the list upon creation
        this.currentCapacity = 0; // Initially no bookings
    }

    // Method to check if the course can be booked
    public boolean canBook() {
        return currentCapacity < MAX_CAPACITY;
    }

    public void addBooking() {
        if (canBook()) {
            currentCapacity++;
        } else {
            System.out.println("Sorry, the diving course is already fully booked.");
        }
    }
    
    public static List<DivingCourse> getDivingCourses() {
        return divingCourses;
    }

    public static void removeDivingCourse(int serviceNum) {
        for (DivingCourse course : divingCourses) {
            if (course.getServiceNum() == serviceNum) {
                divingCourses.remove(course);
                currentCapacity--;
                break;
            }
        }
    }
  
    public String getDivingCourseInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Diving Course Information:\n");
        info.append("Service Number: ").append(getServiceNum()).append("\n");
        info.append("Name: ").append(getName()).append("\n");
        info.append("Type: ").append(getType()).append("\n");
        info.append("Description: ").append(getDescription()).append("\n");
        info.append("Start Date: ").append(startDate).append("\n");
        info.append("End Date: ").append(endDate).append("\n");
        info.append("Level: ").append(level).append("\n");
        return info.toString();
    }
  
    public static DivingCourse findDivingCourse(int serviceNum) {
        for (DivingCourse course : divingCourses) {
            if (course.getServiceNum() == serviceNum) {
                return course;
            }
        }
        return null;
    }

    public static List<String> getDivingCourseInfoByDate(String targetDate) {
        List<String> courseInfoList = new ArrayList<>();
        for (DivingCourse course : divingCourses) {
            if (course.getStartDate().equals(targetDate) || course.getEndDate().equals(targetDate)) {
                courseInfoList.add(course.getDivingCourseInfo());
            }
        }
        return courseInfoList;
    }


    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getLevel() {
        return level;
    }
}
