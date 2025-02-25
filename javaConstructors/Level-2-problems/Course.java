public class Course {
    private String courseName;
    private  int duration;
    private  double fee;
    public static String instituteName="Chitkara University ";

    Course(String courseName,int duration,double fee){
        this.courseName = courseName;
        this.duration=duration;
        this.fee=fee;
    }

    public void displayCourseDetails(){
        System.out.println("Institute: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: $" + fee);

    }
    public static void updateInstituteName(String newinstituteName){
         instituteName = newinstituteName;
    }

    public static void main(String[] args) {

        Course course1 = new Course("Java Programming", 8, 300.0);
        course1.displayCourseDetails();
        Course course2 = new Course("Web Development", 10, 400.0);
        course2.displayCourseDetails();

        System.out.println();

        // Updating institute name
        Course.updateInstituteName("Tech University");

        course1.displayCourseDetails();
        course2.displayCourseDetails();

    }
}
