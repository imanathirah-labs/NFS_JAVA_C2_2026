package com.fullstack.demo;

import com.fullstack.demo.exception.StudentNotFoundException;
import com.fullstack.demo.model.Student;
import com.fullstack.demo.repository.InMemoryStudentRepository;
import com.fullstack.demo.repository.StudentRepository;
import com.fullstack.demo.service.StudentService;
import java.util.List;

public class Day3_Assignment06_StudentServicePractice {

    public static void main(String[] args) {
        StudentRepository studentRepository = new InMemoryStudentRepository();
        StudentService studentService = new StudentService(studentRepository);

        System.out.println("=== Register Students ===");
        Student student1 = new Student("S001", "Roberto Chan", "roberto@example.com");
        Student student2 = new Student("S002", "Priya Nair", "priya@example.com");
        Student student3 = new Student("S003", "Lee Salazae", "lee@example.com");

        studentService.registerStudent(student1);
        studentService.registerStudent(student2);
        studentService.registerStudent(student3);

        System.out.println("=== All Students ===");
        List<Student> allStudents = studentService.getAllStudents();
        for (Student student : allStudents) {
            student.printProfile();
        }

        System.out.println("=== Find Student By ID ===");
        Student foundStudent = studentService.getStudentById("S002");
        foundStudent.printProfile();

        System.out.println("=== Search Student By Name ===");
        List<Student> searchResults = studentService.searchByNameUsingLoop("Lee");
        for (Student student : searchResults) {
            student.printProfile();
        }

        System.out.println("=== Missing Student Test ===");
        try {
            studentService.getStudentById("S999");
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
