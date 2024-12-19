package system;

import Courses.Course;
import Users.Active;
import Users.Student;

import java.util.List;

/**
 * The interface representing the course system, which manages courses and active participants.
 */
public interface CourseSystemInterface {
    /**
     * Adds a course to the course system.
     *
     * @param course The course to add.
     */
    void addCourse(Course course);

    /**
     * Adds an active participant to the course system.
     *
     * @param active The active participant to add.
     * @return true if the active participant was successfully added, false otherwise.
     */
    boolean addActive(Active active);

    /**
     * Adds a list of active participants to the course system.
     *
     * @param activeParticipants The list of active participants to add.
     * @return true if all active participants were successfully added, false otherwise.
     */
    boolean addActives(List<Active> activeParticipants);

    /**
     * Registers a student for a course.
     *
     * @param student The student to register.
     * @param course  The course in which to register the student.
     * @return true if the student was successfully registered for the course, false otherwise.
     */
    boolean registerStudent(Student student, Course course);

    /**
     * Removes a student's registration from a course.
     *
     * @param student The student to remove from the course.
     * @param course  The course from which to remove the student's registration.
     * @return true if the student's registration was successfully removed from the course, false otherwise.
     */
    boolean removeStudent(Student student, Course course);

    /**
     * Prints the details of all active participants in the course system.
     */
    void printActiveParticipants();

    /**
     * Prints the names of all students registered for a given course.
     *
     * @param course The course for which to print registered students.
     */
    void printCourseStudents(Course course);

    /**
     * Gets the list of active participants in the course system.
     *
     * @return The list of active participants.
     */
    List<Active> getActiveParticipants();

    /**
     * Gets the list of courses in the course system.
     *
     * @return The list of courses.
     */
    List<Course> getCourses();

    /**
     * Gets the name of the course system.
     *
     * @return The name of the course system.
     */
    String getSysName();
}
