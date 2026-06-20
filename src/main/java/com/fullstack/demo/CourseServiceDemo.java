package com.fullstack.demo;

import com.fullstack.demo.exception.InvalidCourseException;
import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import com.fullstack.demo.service.CourseService;
import java.util.List;

public class CourseServiceDemo {
    public static void main(String[] args) {
        // Create a CourseRepository
        CourseRepository courseRepository = new InMemoryCourseRepository();
        
        // Create a CourseService
        CourseService courseService = new CourseService(courseRepository);
        
        System.out.println("=== Valid Course Test ===");
        // Test valid course
        Course validCourse = new Course("C001", "Java Fundamentals", 40, "Beginner", "Programming", true);
        try {
            Course savedCourse = courseService.createCourse(validCourse);
            System.out.println("Course saved successfully: " + savedCourse.getCourseId());
        } catch (InvalidCourseException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
        
        System.out.println("\n=== Invalid Course Tests ===");
        
        // Test 1: Null course
        System.out.println("\nTest 1: Null course");
        try {
            courseService.createCourse(null);
            System.out.println("Course saved successfully.");
        } catch (InvalidCourseException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
        
        // Test 2: Add more valid courses
        System.out.println("\nTest 2: Add valid course (C002)");
        Course course2 = new Course("C002", "React Frontend Development", 30, "Intermediate", "Web Development", true);
        try {
            Course savedCourse2 = courseService.createCourse(course2);
            System.out.println("Course saved successfully: " + savedCourse2.getCourseId());
        } catch (InvalidCourseException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
        
        // Test 3: Add another valid course
        System.out.println("\nTest 3: Add valid course (C003)");
        Course course3 = new Course("C003", "MongoDB Basics", 25, "Beginner", "Databases", true);
        try {
            Course savedCourse3 = courseService.createCourse(course3);
            System.out.println("Course saved successfully: " + savedCourse3.getCourseId());
        } catch (InvalidCourseException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
        
        // Print all valid courses
        System.out.println("\n=== All Valid Courses ===");
        List<Course> allCourses = courseService.getAllCourses();
        for (Course course : allCourses) {
            System.out.println(course.getCourseId() + " - " + course.getTitle());
        }
    }
}
