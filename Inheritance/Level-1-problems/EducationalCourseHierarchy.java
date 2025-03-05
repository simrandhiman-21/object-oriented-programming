
// Base class: Course
class Course {
    protected String courseName;
    protected int duration; // Duration in weeks
    
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    
    public void displayCourseInfo() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks");
    }
}

// Subclass: OnlineCourse
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;
    
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    
    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass: PaidOnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;
    
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    
    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Fee: $" + fee + ", Discount: " + discount + "%");
    }
}

// Main class to test the hierarchy
public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        Course basicCourse = new Course("Math Basics", 6);
        OnlineCourse onlineCourse = new OnlineCourse("Java Programming", 8, "Udemy", true);
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Advanced AI", 12, "Coursera", true, 199.99, 20);
        
        basicCourse.displayCourseInfo();
        System.out.println();
        onlineCourse.displayCourseInfo();
        System.out.println();
        paidCourse.displayCourseInfo();
    }
}
