package com.fullstack.demo;

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
        Course course4 = new Course("C004", "Advanced Java Backend", 45, "Advanced", "Programming", true);

        courseService.createCourse(course1);
        courseService.createCourse(course2);
        courseService.createCourse(course3);
        courseService.createCourse(course4);

        System.out.println("=== Search by Title: java ===");
        List<Course> javaResults = courseService.searchByTitle("java");
        for (Course course : javaResults) {
            System.out.println(course.getCourseId() + " - " + course.getTitle());
        }

        System.out.println("\n=== Search by Title: react ===");
        List<Course> reactResults = courseService.searchByTitle("react");
        for (Course course : reactResults) {
            System.out.println(course.getCourseId() + " - " + course.getTitle());
        }

        System.out.println("\n=== Filter by Level: Beginner ===");
        List<Course> beginnerResults = courseService.filterByLevel("Beginner");
        for (Course course : beginnerResults) {
            System.out.println(course.getCourseId() + " - " + course.getTitle());
        }

        System.out.println("\n=== Filter by Level: Advanced ===");
        List<Course> advancedResults = courseService.filterByLevel("Advanced");
        for (Course course : advancedResults) {
            System.out.println(course.getCourseId() + " - " + course.getTitle());
        }
    }
}
