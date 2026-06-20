package com.fullstack.demo;

import com.fullstack.demo.exception.CourseNotFoundException;
import com.fullstack.demo.exception.InvalidCourseException;
import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import com.fullstack.demo.service.CourseService;
import java.util.List;

public class CourseServiceDemo {
    public static void main(String[] args) {
        CourseRepository courseRepository = new InMemoryCourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        Course course1 = new Course("C001", "Java Fundamentals", 40, "Beginner", "Programming", true);
        Course course2 = new Course("C002", "React Frontend Development", 30, "Intermediate", "Web Development", true);
        Course course3 = new Course("C003", "MongoDB Basics", 25, "Beginner", "Databases", true);

        courseService.createCourse(course1);
        courseService.createCourse(course2);
        courseService.createCourse(course3);

        System.out.println("\n=== Update Duration ===");
        try {
            Course updatedCourse = courseService.updateDuration("C001", 20);
            System.out.println(updatedCourse.getCourseId() + " duration updated to " + updatedCourse.getDurationHours() + " hours");
        } catch (InvalidCourseException | CourseNotFoundException e) {
            System.out.println("Validation error: " + e.getMessage());
        }

        System.out.println("\n=== Delete Course ===");
        try {
            courseService.deleteCourse("C003");
            System.out.println("C003 deleted successfully");
        } catch (CourseNotFoundException e) {
            System.out.println("Course not found error: " + e.getMessage());
        }

        System.out.println("\n=== Remaining Courses ===");
        List<Course> remainingCourses = courseService.getAllCourses();
        for (Course course : remainingCourses) {
            System.out.println(course.getCourseId() + " - " + course.getTitle());
        }

        System.out.println("\n=== Find Deleted Course ===");
        try {
            Course deletedCourse = courseService.getCourseById("C003");
            System.out.println(deletedCourse.getCourseId() + " - " + deletedCourse.getTitle());
        } catch (CourseNotFoundException e) {
            System.out.println("Course not found error: " + e.getMessage());
        }

        System.out.println("\n=== Invalid Duration Test ===\n");
        try {
            courseService.updateDuration("C002", 0);
            System.out.println("Duration updated successfully.");
        } catch (InvalidCourseException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}
