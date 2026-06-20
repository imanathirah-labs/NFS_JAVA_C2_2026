package com.fullstack.demo.service;

import com.fullstack.demo.exception.CourseNotFoundException;
import com.fullstack.demo.exception.DuplicateCourseException;
import com.fullstack.demo.exception.InvalidCourseException;
import com.fullstack.demo.model.Course;
import com.fullstack.demo.model.Instructor;
import com.fullstack.demo.repository.CourseRepository;
import java.util.List;

public class CourseService {
    private  final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        validateCourse(course);
        if (courseRepository.existsById(course.getCourseId())) {
            throw new DuplicateCourseException("Course with ID '" + course.getCourseId() + "' already exists.");
        }
        return courseRepository.save(course);
    }

    public Course getCourseById(String courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course with ID '" + courseId + "' not found."));
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> searchByTitle(String keyword) {
        String safeKeyword = (keyword == null) ? "" : keyword.trim().toLowerCase();
        return courseRepository.findAll().stream()
                .filter(course -> course.getTitle().toLowerCase().contains(safeKeyword))
                .toList();
    }

    public List<Course> filterByLevel(String level) {
        String safeLevel = (level == null) ? "" : level.trim().toLowerCase();
        
        // String safeLevel;
        // if (level == null || level.trim().isEmpty()) {
        //     safeLevel = "";
        // } else {
        //     safeLevel = level.trim().toLowerCase();
        // }

        return courseRepository.findAll()
                .stream()
                .filter(course -> course.getLevel().equalsIgnoreCase(safeLevel))
                .toList();
    }

    public Course assignInstructor(String courseId, Instructor instructor) {
        Course course = getCourseById(courseId);
        course.setInstructor(instructor);
        return courseRepository.save(course);
    }

    public List<Course> searchByInstructorName(String instructorName) {
        String safeInstructorName = (instructorName == null) ? "" : instructorName.trim().toLowerCase();
        return courseRepository.findAll()
                .stream()
                .filter(course -> course.getInstructor() != null)
                .filter(course -> course.getInstructor()
                        .getInstructorName()
                        .toLowerCase()
                        .contains(safeInstructorName))
                .toList();
    }

    private void validateCourse(Course course) {
        if (course == null) {
            throw new InvalidCourseException("Course cannot be null.");
        }
        if (isBlank(course.getCourseId())) {
            throw new InvalidCourseException("Course ID is required.");
        }
        if (isBlank(course.getTitle())) {
            throw new InvalidCourseException("Course title is required.");
        }
        if (course.getDurationHours() <= 0) {
            throw new InvalidCourseException("Course duration must be greater than zero.");
        }
        if (isBlank(course.getLevel())) {
            throw new InvalidCourseException("Course level is required.");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}