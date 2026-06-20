package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.model.CourseOffering;
import com.fullstack.demo.model.Instructor;
import com.fullstack.demo.model.Student;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Syntax for creating a new object (instance) of the Course class
        // ClassName objectName = new Constructor();
        // ClassName and Constructor usually match
        
        // 1. Create Instructor
        Instructor instructor1 = new Instructor("I001", "Alice Johnson", "Java Development");
        Instructor instructor2 = new Instructor("I002", "Bob Smith", "React Development");
        Instructor instructor3 = new Instructor("I003", "Charlie Brown", "Python Development");

        // 2. Create Course
        Course course1 = new Course("C001", "Java Fundamentals", 14, "Beginner", "Programming", true);
        Course course2 = new Course("C002", "React Frontend Development", 21, "Intermediate", "Frontend", true);
        Course course3 = new Course("C003", "Python Data Science", 28, "Advanced", "Data Science", true);


        // 3. Assign instructors to courses
        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);
        course3.setInstructor(instructor3);

        // 4. Create Student
        Student student1 = new Student("S001", "Charlie Brown", "cFq0l@example.com");
        Student student2 = new Student("S002", "Daisy Duck", "d4oQG@example.com");
        Student student3 = new Student("S003", "Goofy Goof", "g7rTW@example.com");

        // 5. Create course Offering
        CourseOffering offering1 = new CourseOffering(
                "OFF001",
                "Java Fundamentals - June 2026 Intake",
                course1,
                instructor1,
                "2026-06-19",
                "2026-06-20",
                25,
                "Online"
        );

        CourseOffering offering2 = new CourseOffering(
                "OFF002",
                "React Frontend Development - July 2026 Intake",
                course2,
                instructor2,
                "2026-07-01",
                "2026-07-05",
                30,
                "Hybrid"
        );

         CourseOffering offering3 = new CourseOffering(
                "OFF003",
                "Python Data Science - August 2026 Intake",
                course3,
                instructor3,
                "2026-08-01",
                "2026-07-05",
                30,
                "Hybrid"
        );

        // 6. Store objects in ArrayList (repositories)
        List<Course> courses = new ArrayList<>();
        List<Instructor> instructors = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<CourseOffering> offerings = new ArrayList<>();

       // 7. Add objects to respective list 
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        instructors.add(instructor1);
        instructors.add(instructor2);   
        instructors.add(instructor3);

        students.add(student1);
        students.add(student2);
        students.add(student3);

        offerings.add(offering1);
        offerings.add(offering2);
        offerings.add(offering3);


        // 8. Print Objects
        for (Course course : courses) {
            System.out.println("Courses List:"+ System.lineSeparator());
            course.printSummary();
        }

        for (Instructor instructor : instructors) {
            System.out.println("Instructors List:"+ System.lineSeparator());
            instructor.printProfile();
        }

        for (Student student : students) {
            System.out.println("Students List:"+ System.lineSeparator());
            student.printProfile();
        }

        for (CourseOffering offering : offerings) {
            System.out.println("Courses Offering List:" + System.lineSeparator());
            offering.printOfferingSummary();
        }

        System.out.println("Instructor Profiles:");
        instructor1.printProfile();
        instructor2.printProfile();
        instructor3.printProfile();

        System.out.println("Course Summaries:");
        course1.printSummary();
        course2.printSummary();
        course3.printSummary();

        System.out.println("Course Offering Summaries:");
        offering1.printOfferingSummary();
        offering2.printOfferingSummary();
        offering3.printOfferingSummary();

        System.out.println("Student Profiles:");
        student1.printProfile();
        student2.printProfile();
        student3.printProfile();

    }
}
