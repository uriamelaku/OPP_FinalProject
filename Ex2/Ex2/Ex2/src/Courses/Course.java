package Courses;
import Users.Student;

import java.util.List;

/**
 * Interface representing a course.
 */
public interface Course {
    /**
     * Gets the serial number of the course.
     *
     * @return The serial number of the course.
     */
    String getSerialNumber();

    /**
     * Gets the name of the course.
     *
     * @return The name of the course.
     */
    String getName();

    /**
     * Gets the capacity of the course.
     *
     * @return The capacity of the course.
     */
    int getCapacity();

    /**
     * Gets the list of students registered for the course.
     *
     * @return The list of students registered for the course.
     */
    List<Student> getRegisteredStudents();

    /**
     * Gets the list of students on the waiting list for the course.
     *
     * @return The list of students on the waiting list for the course.
     */
    List<Student> getWaitingList();

    /**
     * Registers a student for the course.
     *
     * @param student The student to register.
     * @return true if the student was successfully registered for the course, false otherwise.
     */
    boolean registerStudent(Student student);

    /**
     * Removes a student's registration from the course.
     *
     * @param student The student whose registration is to be removed.
     * @return true if the student's registration was successfully removed from the course, false otherwise.
     */
    boolean removeStudent(Student student);
}

