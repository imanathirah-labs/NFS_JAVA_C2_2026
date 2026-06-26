package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import com.fullstack.demo.service.CourseService;

public class CodeFlowPractice {

    public static void main(String[] args) {
        System.out.println("=== Add and Find Course ===");

        // Create the repository first because the service depends on it.
        // CourseService needs CourseRepository so it can delegate storage and retrieval.
        CourseRepository courseRepository = new InMemoryCourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        // Create a new course and save it through the service.
        Course newCourse = new Course(
                "C004",
                "Spring Boot API Development",
                18,
                "Intermediate",
                "Backend",
                true
        );

        // Demo class calls CourseService.
        // CourseService validates the course and asks CourseRepository to save it.
        courseService.createCourse(newCourse);

        // Retrieve the course by ID using the service.
        // CourseService asks CourseRepository to find the course.
        Course retrievedCourse = courseService.getCourseById("C004");

        // InMemoryCourseRepository stores and returns the course in memory.
        // Demo class receives the Course object and prints the summary.
        retrievedCourse.printSummary();
    }
}
