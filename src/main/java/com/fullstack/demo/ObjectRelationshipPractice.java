package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.model.CourseOffering;
import com.fullstack.demo.model.Instructor;

public class ObjectRelationshipPractice {

    public static void main(String[] args) {
        Instructor mikeRahman = new Instructor("I001", "Mike Rahman", "Java and Spring Boot");
        Instructor marcusLee = new Instructor("I002", "Marcus Lee", "React and Frontend Development");

        Course javaFundamentals = new Course("C001", "Java Fundamentals", 14, "Beginner", "Core Java", true);
        Course reactFrontend = new Course("C002", "React Frontend Development", 21, "Intermediate", "Frontend", true);

        javaFundamentals.setInstructor(mikeRahman);
        reactFrontend.setInstructor(marcusLee);

        System.out.println("=== Courses ===");
        javaFundamentals.printSummary();
        reactFrontend.printSummary();

        CourseOffering offering1 = new CourseOffering(
                "OFF001",
                "Java Fundamentals June Intake",
                javaFundamentals,
                mikeRahman,
                "2026-06-29",
                "2026-06-30",
                25,
                "Physical"
        );

        CourseOffering offering2 = new CourseOffering(
                "OFF002",
                "React Frontend July Intake",
                reactFrontend,
                marcusLee,
                "2026-07-01",
                "2026-07-03",
                20,
                "Hybrid"
        );

        System.out.println("=== Course Offerings ===");
        offering1.printOfferingSummary();
        offering2.printOfferingSummary();

        CourseOffering offering3 = new CourseOffering(
                "OFF003",
                "Java Fundamentals July Weekend Intake",
                javaFundamentals,
                mikeRahman,
                "2026-07-05",
                "2026-07-07",
                30,
                "Physical"
        );

        System.out.println("=== Extension: Another Offering for Same Course ===");
        offering3.printOfferingSummary();
    }
}
