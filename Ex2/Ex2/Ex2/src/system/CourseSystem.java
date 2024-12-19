package system;

import Courses.Course;
import Users.Active;
import Users.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseSystem implements CourseSystemInterface {
    private static CourseSystem instance;
    private final String SysName;
    private static final int MAX_ACTIVES = 100;
    private List<Active> activeParticipants;
    private List<Course> courses;

    private CourseSystem(String SysName){
        this.SysName = SysName;
        activeParticipants = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public static synchronized CourseSystem getInstance(String SysName) {
        if(instance == null){
            instance = new CourseSystem(SysName);
        }
        return instance;
    }

    @Override
    public void addCourse(Course course) {
        if (course == null) {
            return;
        }
        courses.add(course);
    }

    @Override
    public String getSysName() {
        return SysName;
    }

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public boolean addActives(List<Active> activeParticipants_list) {
        for (Active active : activeParticipants_list) {
            if (!addActive(active))
                return false;
        }
        return true;
    }
    @Override
    public boolean addActive(Active active) {
        // Check if the system is already full
        if (this.activeParticipants.size() >= MAX_ACTIVES) {
            System.out.println("ERROR : System is full. Cannot add more actives.");
            return false;
        }

        // Check if the ID is already in use
        for (Active existingActive : this.activeParticipants) {
            if (existingActive.getId() == active.getId()) {
                System.out.println("Error: Duplicate active ID.");
                return false;
            }
        }

        // Add the active participant to the system
        this.activeParticipants.add(active);
        active.setSystem(this);
        return true;
    }

    @Override
    public boolean registerStudent(Student student, Course course){
        return course.registerStudent(student);
    }

    @Override
    public boolean removeStudent(Student student, Course course){
        return course.removeStudent(student);
    }


    // Other methods for managing courses, such as adding, removing, or accessing courses
    @Override
    public List<Active> getActiveParticipants() {
        return activeParticipants;
    }

    @Override
    public void printActiveParticipants() {
        List<Active> sysActiveUsers = getActiveParticipants();
        for (Active active : sysActiveUsers) {
            System.out.println(
                    "Active type: " + active.ActiveType() +
                            " Name: " + active.getFullName() +
                            " ID: " + active.getId());
        }
    }
    @Override
    public void printCourseStudents(Course course) {
        List<Student> registeredStudents = course.getRegisteredStudents();
        System.out.println("Registered Students for Course " + course.getName() + ":");
        for (Student student : registeredStudents) {
            System.out.println(student.getFullName());
        }
    }


}

