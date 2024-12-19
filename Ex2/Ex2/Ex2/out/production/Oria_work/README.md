# Course System

The Course System is a Java application designed to manage courses, participants, and registrations within an educational institution. It provides functionality for creating courses, enrolling participants, and managing course capacities.

## Usage

To use the Course System, follow these steps:

1. **Create a Course System instance:** Instantiate a `CourseSystem` object, specifying the name of the educational institution.

2. **Add participants:** Create instances of participants, such as lecturers, students, or practitioners, and add them to the system using the `addActive()` method.

3. **Create courses:** Create courses using the `addCourse()` method provided by lecturers or practitioners.

4. **Register students:** Enroll students in courses using the `registerStudent()` method. Ensure that the course capacity is not exceeded.

5. **Manage registrations:** Remove student registrations using the `removeStudent()` method.

6. **Print course participants:** Use the `printCourseStudents()` method to print the list of registered students for a specific course.

7. **Print active participants:** Use the `printActiveParticipants()` method to print all active participants in the system.

## Example

```java
// Create a Course System instance
CourseSystem system = new CourseSystem("Ariel University");

// Create lecturer
Lecturer lecturer = new Lecturer(7, "Almond Ner");

// Create students
Student student1 = new Student(1, "John Doe");
Student student2 = new Student(2, "Tai Rail");
Student student3 = new Student(3, "Rom Levin");

// Create a list of Active and add Lecturer and Students to it
List<Active> activeList = new ArrayList<>();
activeList.add(lecturer);
activeList.add(student1);
activeList.add(student2);
activeList.add(student3);

// Add participants to the system
system.addActives(activeList);

// Create a practitioner
Practitioner practitioner = new Practitioner(8, "Alice Wonderland");
activeList.add(practitioner);

// Create a course with capacity 2
Course course1 = practitioner.addCourse("Introduction to Java Programming", 2, "Seminar");

// Enroll students in the course
system.registerStudent(student1, course1);
system.registerStudent(student2, course1);
system.registerStudent(student3, course1);

// Print registered students for the course
system.printCourseStudents(course1);

// Simulate a student removing their registration from the course
system.removeStudent(student1, course1);

// Print all active participants in the system
system.printActiveParticipants();
