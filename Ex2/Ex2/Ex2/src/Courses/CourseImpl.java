package Courses;

import Users.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class CourseImpl extends Observable implements Course {
    private final String serialNumber;
    private final String name;
    private final int capacity;
    private final List<Student> registeredStudents;
    private final List<Student> waitingList;

    // Public constructor
    public CourseImpl(String serialNumber, String name, int capacity) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.capacity = capacity;
        this.waitingList = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }
    @Override
    public List<Student> getWaitingList() {
        return waitingList;
    }

    @Override
    public boolean registerStudent(Student student) {
        // Check if the course is already full
        if (registeredStudents.size() < capacity) {
            // Add the student to the registered students list
            registeredStudents.add(student);
            student.setCoursesEnrolled(this);
            return true; // Student successfully registered
        } else {
            waitingList.add(student);
            student.setWaitingList(this);
            addObserver(student); // Add the student as an observer of the course
            return false; // Course is full, student cannot be registered
        }
    }

    @Override
    // Method to remove student registration
    public boolean removeStudent(Student student) {
        if (registeredStudents.contains(student)) {
            registeredStudents.remove(student);
            // Notify waiting students
            setChanged();
            notifyObservers(student);
            return true;
        } else {
            System.out.println("Student is not registered");
            return false;
        }

    }


}

