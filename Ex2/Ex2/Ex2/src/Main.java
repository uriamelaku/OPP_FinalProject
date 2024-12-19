import Courses.Course;
import Users.*;
import system.CourseSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // system - singelton design pattern
        CourseSystem system = CourseSystem.getInstance("Ariel University");


        // Create lecturer
        Lecturer lecturer = new Lecturer(7, "Almond Ner");

        // Create students
        Student student1 = new Student(1, "John Doe");
        Student student2 = new Student(2, "Tai Rail");
        Student student3 = new Student(3, "Rom Levin");

        // Attempt to create a student with the same ID as an existing one
        Student student4 = new Student(1, "Jane Smith");

        // Create a list of Active and add Lecturer and Students to it
        List<Active> activeList = new ArrayList<>();
        activeList.add(lecturer);
        activeList.add(student1);
        activeList.add(student2);
        activeList.add(student3);
//        activeList.add(student4); // Attempt to add a duplicate student, it will not work with it!

        // Create a practitioner
        Practitioner practitioner = new Practitioner(8, "Alice Wonderland");
        activeList.add(practitioner);

        //we have to add the users to the system
        system.addActives(activeList);


        //Admin decorator
        AdminUser adminLecturer = new AdminDecorator(lecturer);
        AdminUser adminPractitioner = new AdminDecorator(practitioner);

        // Create a course with capacity 2, Factory DP
        Course course1 = adminPractitioner.addCourse("Introduction to Java Programming", 2, "Seminar");

        // we will use course1 due to Singleton
        Course course2 = adminLecturer.addCourse("Introduction to Java Programming", 2, "Seminar");

        // Enroll students in the course
        system.registerStudent(student1, course1);
        system.registerStudent(student2, course1);
        system.registerStudent(student3, course1);

        // Attempt to register more students than the course capacity
        Student student5 = new Student(4, "Bob Builder");
        system.registerStudent(student5, course1);

        // Attempt to create more than 100 actives
        for (int i = 0; i < 110; i++) {
            Active active = new Student(i + 10, "Student" + i);
            system.addActive(active);
        }

        // Print registered students for the course
        system.printCourseStudents(course1);

        // Simulate a student removing their registration from the course - Observer DP
        // For demonstration purposes, we remove the student we just registered
        system.removeStudent(student1, course1);

        // Print all active participants in the system
        system.printActiveParticipants();
    }
}
