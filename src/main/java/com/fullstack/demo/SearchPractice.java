package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import com.fullstack.demo.service.CourseService;
import java.util.List;

public class SearchPractice {

    public static void main(String[] args) {
        CourseRepository courseRepository = new InMemoryCourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        // Add at least four courses
        Course course1 = new Course("C001", "Java Fundamentals", 10, "Beginner", "Core Java", true);
        Course course2 = new Course("C002", "React Frontend Development", 21, "Intermediate", "Frontend", true);
        Course course3 = new Course("C003", "MongoDB Basics", 12, "Beginner", "Database", true);
        Course course4 = new Course("C004", "Spring Boot API Development", 18, "Intermediate", "Backend", true);

        courseService.createCourse(course1);
        courseService.createCourse(course2);
        courseService.createCourse(course3);
        courseService.createCourse(course4);

        // Test loop version
        System.out.println("=== Beginner Courses (Using Loop) ===");
        List<Course> beginnerCourses = courseService.searchByLevelUsingLoop("Beginner");
        for (Course course : beginnerCourses) {
            System.out.println(course.getCourseId() + " - " + course.getTitle());
        }

        System.out.println("\n=== Intermediate Courses (Using Loop) ===");
        List<Course> intermediateCourses = courseService.searchByLevelUsingLoop("Intermediate");
        for (Course course : intermediateCourses) {
            System.out.println(course.getCourseId() + " - " + course.getTitle());
        }

        // Test stream version
        System.out.println("\n=== Beginner Courses (Using Stream) ===");
        List<Course> beginnerCoursesStream = courseService.searchByLevelUsingStream("Beginner");
        for (Course course : beginnerCoursesStream) {
            System.out.println(course.getCourseId() + " - " + course.getTitle());
        }

        // Test minimum duration search
        System.out.println("\n=== Courses with Minimum 15 Hours Duration ===");
        List<Course> longCourses = courseService.searchByMinimumDurationUsingLoop(15);
        for (Course course : longCourses) {
            System.out.println(course.getCourseId() + " - " + course.getTitle() + " (" + course.getDurationHours() + " hours)");
        }
    }
}
