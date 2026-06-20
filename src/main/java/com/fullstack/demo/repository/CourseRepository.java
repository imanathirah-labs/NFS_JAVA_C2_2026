package com.fullstack.demo.repository;

import com.fullstack.demo.model.Course;
import java.util.Optional;
import java.util.List;

public interface CourseRepository {
     Course save(Course course);
     Optional<Course> findById(String courseId);
     List<Course> findAll();
     void deleteById(String courseId);
     boolean existsById(String courseId);
}