package Courses;

import java.util.ArrayList;
import java.util.List;

public class CourseFactory {
    private static final List<Course> courses = new ArrayList<>();

    // Private constructor to prevent instantiation
    private CourseFactory() {
    }

    public static Course getInstance(String name, int capacity, String type) {
        // Check if the course with the given name, capacity, and type already exists
        for (Course course : courses) {
            if (course.getName().equals(name) && course.getCapacity() == capacity && course instanceof SeminarCourseImpl) {
                return course; // Return existing SeminarCourse
            } else if (course.getName().equals(name) && course.getCapacity() == capacity && course instanceof ElectiveCourseImpl) {
                return course; // Return existing ElectiveCourse
            } else if (course.getName().equals(name) && course.getCapacity() == capacity && course instanceof CompulsoryCourseImpl) {
                return course; // Return existing CompulsoryCourse
            }
        }
        // If course doesn't exist, create a new one based on type
        String serialNumber = generateSerialNumber();
        Course newCourse = null;
        switch (type) {
            case "Seminar":
                newCourse = new SeminarCourseImpl(serialNumber, name, capacity);
                break;
            case "Elective":
                newCourse = new ElectiveCourseImpl(serialNumber, name, capacity);
                break;
            case "Compulsory":
                newCourse = new CompulsoryCourseImpl(serialNumber, name, capacity);
                break;
            default:
                System.out.println("Invalid type of course, you should use : Seminar/Elective/Compulsory");
                break;
        }
        courses.add(newCourse);
        return newCourse;
    }

    private static String generateSerialNumber() {
        // Generate unique serial number here
        return "C" + System.currentTimeMillis(); // Example: "C1622134091626"
    }
}
