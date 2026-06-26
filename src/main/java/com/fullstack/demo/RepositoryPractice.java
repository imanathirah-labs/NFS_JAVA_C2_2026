package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import java.util.List;
import java.util.Optional;

public class RepositoryPractice {

    public static void main(String[] args) {
        System.out.println("=== All Courses ===");

        // The variable type is CourseRepository, but the actual object is InMemoryCourseRepository.
        CourseRepository courseRepository = new InMemoryCourseRepository();

        Course apiCourse = new Course("C005", "API Documentation", 7, "Beginner", "Backend", true);
        Course collectionsCourse = new Course("C006", "Java Collections Practice", 12, "Beginner", "Core Java", true);
        Course cleanCodeCourse = new Course("C007", "Clean Code Basics", 8, "Intermediate", "Software Engineering", true);

        courseRepository.save(apiCourse);
        courseRepository.save(collectionsCourse);
        courseRepository.save(cleanCodeCourse);

        List<Course> courses = courseRepository.findAll();
        for (Course course : courses) {
            course.printSummary();
        }

        System.out.println("=== Find C006 ===");
        Optional<Course> optionalCourse = courseRepository.findById("C006");
        if (optionalCourse.isPresent()) {
            Course foundCourse = optionalCourse.get();
            foundCourse.printSummary();
        } else {
            System.out.println("Course not found.");
        }

        System.out.println("=== Exists Check ===");
        System.out.println("C007 exists: " + courseRepository.existsById("C007"));
    }
}
