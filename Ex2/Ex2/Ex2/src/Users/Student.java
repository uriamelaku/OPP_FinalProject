package Users;
import Courses.Course;
import Courses.CourseFactory;
import system.CourseSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class Student implements Active, Observer {
    private final int id;
    private String fullName;
    private CourseSystem system;
    private List<Course> coursesEnrolled;
    private List<Course> waitingList;


    // Constructor for Users.Practitioner
    public Student(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.coursesEnrolled = new ArrayList<>();
        this.waitingList = new ArrayList<>();
    }
    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @Override
    public void setSystem(CourseSystem system){
        this.system = system;
    }

    @Override
    public String getSysName(){
        return this.system.getSysName();
    }
    // getters, and setters
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    public List<Course> getCoursesEnrolled() {
        return coursesEnrolled;
    }

    public void setCoursesEnrolled(Course course) {
        this.coursesEnrolled.add(course);
        System.out.println("Student " + fullName + " Successfully registered for the course: " + course.getName());
    }

    public void setWaitingList(Course course){
        this.waitingList.add(course);
        System.out.println("ERROR: Student " + fullName + " Registered for the course: " + course.getName() + " waiting list");
    }

    public List<Course> getWaitingList() {
        return waitingList;
    }

    public boolean removeRegistration(Course course){
        if (coursesEnrolled.contains(course)){
            coursesEnrolled.remove(course);
            return course.removeStudent(this);
        }
        System.out.println("Student is not registered");
        return false;
    }
    @Override
    public String ActiveType() {
        return "Student";
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Course && arg instanceof Student) {
            Course course = (Course) o;
            Student removedStudent = (Student) arg;
            if ( !removedStudent.equals(this) && waitingList.contains(course)) {
                // the Student who removed from course is not the one we want to notify, and he was in the waiting list
                // notification register for the course
                System.out.println("Notification: for student: " + fullName +  " A spot is available in the course: " + course.getName());
            }
        }
    }
}

