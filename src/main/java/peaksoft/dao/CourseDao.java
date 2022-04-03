package peaksoft.dao;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseDao {

    List<Course> courseList();

    void saveCourse(Course course);

    Course findId(Long id);

    void update(Course course);

    void delete(Long id);
}
