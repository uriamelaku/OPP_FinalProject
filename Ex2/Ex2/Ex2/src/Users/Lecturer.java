package Users;
import Courses.Course;
import Courses.CourseFactory;
import system.CourseSystem;

import java.util.ArrayList;
import java.util.List;

public class Lecturer implements AdminUser {
    private final int id;
    private String fullName;
    private CourseSystem system;
    private List<Course> coursesTaught;

    // Constructor for Users.Lecturer
    public Lecturer(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.coursesTaught = new ArrayList<>();
    }
    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(List<Course> coursesTaught) {this.coursesTaught = coursesTaught;}


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFullName() {
        return fullName;
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
    @Override
    public String ActiveType() {
        return "Lecturer";
    }

    public Course addCourse(String name, int capacity, String type) {
        Course course = CourseFactory.getInstance(name,capacity,type);
            coursesTaught.add(course);
            system.addCourse(course);
            return course;
    }


}
