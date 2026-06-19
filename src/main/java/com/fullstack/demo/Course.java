package com.fullstack.demo;

public class Course {
    private String courseId;
    private String title;
    private int durationHours;
    private String level;
    private Instructor instructor;
    private String category;
    private boolean active;

    public Course(String courseId, String title, int durationHours, String level, String category, boolean active) {
        setCourseId(courseId);
        setTitle(title);
        setDurationHours(durationHours);
        setLevel(level);
        this.category = requireText(category, "Course category");
        this.active = active;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = requireText(courseId, "Course ID");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = requireText(title, "Course title");
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        if (durationHours <= 0) {
            throw new IllegalArgumentException("Duration hours must be greater than zero.");
        }
        this.durationHours = durationHours;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = requireText(level, "Course level");
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void printSummary() {
        String instructorName = instructor == null ? "Not assigned yet" : instructor.getInstructorName();
        String statusText = active ? "Active" : "Inactive";

        System.out.println("Course ID: " + courseId);
        System.out.println("Title: " + title);
        System.out.println("Duration: " + durationHours + " hours");
        System.out.println("Level: " + level);
        System.out.println("Category: " + category);
        System.out.println("Status: " + statusText);
        System.out.println("Instructor: " + instructorName);
        System.out.println();
    }

    private String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " is required.");
        }
        return value.trim();
    }

    @Override
    public String toString() {
        String instructorName = instructor == null ? "Not assigned yet" : instructor.getInstructorName();

        return "Course ID: " + courseId + "\n"
                + "Title: " + title + "\n"
                + "Duration: " + durationHours + " hours\n"
                + "Level: " + level + "\n"
                + "Instructor: " + instructorName;
    }
}
