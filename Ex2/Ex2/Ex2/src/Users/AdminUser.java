package Users;

import Courses.Course;

public interface AdminUser extends Active {
    Course addCourse(String name, int capacity, String type);
}
