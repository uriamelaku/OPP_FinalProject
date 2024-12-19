package Users;

import Courses.Course;
import system.CourseSystem;

public class AdminDecorator implements AdminUser {
    private Active user;

    public AdminDecorator(Active user) {
        this.user = user;
    }

    @Override
    public Course addCourse(String name, int capacity, String type) {
        if (user instanceof Lecturer || user instanceof Practitioner) {
            return ((AdminUser) user).addCourse(name, capacity, type);
        } else {
            System.out.println("Error: Only lecturers and practitioners can add courses.");
            return null;
        }
    }

    // Delegate other methods to the wrapped user
    @Override
    public int getId() {
        return user.getId();
    }

    @Override
    public String getFullName() {
        return user.getFullName();
    }

    @Override
    public String ActiveType() {
        return user.ActiveType();
    }

    @Override
    public void setFullName(String fullName) {
        user.setFullName(fullName);
    }

    @Override
    public void setSystem(CourseSystem system) {
        user.setSystem(system);
    }

    @Override
    public String getSysName() {
        return user.getSysName();
    }

}

