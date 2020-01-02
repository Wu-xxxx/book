package cn.edu.book.mapper;

import cn.edu.book.model.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> getCourse(Course course);

    List<Course> getAllCourse();

    void addCourse(Course course);

    void updateCourse(Course course);

    void deleteCourseById(Integer courseId);
}
