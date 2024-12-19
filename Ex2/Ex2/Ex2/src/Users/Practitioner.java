package Users;

import Courses.Course;
import Courses.CourseFactory;
import system.CourseSystem;

import java.util.ArrayList;
import java.util.List;

public class Practitioner extends Student implements AdminUser{
    private List<Course> coursesTaught;
    private CourseSystem system;
    private List<Course> coursesEnrolled;
    private List<Course> waitingList;

    public Practitioner(int id, String fullName) {
        super(id, fullName);
        this.coursesTaught = new ArrayList<>();
    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(List<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
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
        return "Practitioner";
    }
    @Override
    public Course addCourse(String name, int capacity, String type) {
        Course course = CourseFactory.getInstance(name,capacity,type);
        coursesTaught.add(course);
        system.addCourse(course);
        return course;
    }
}
