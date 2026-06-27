# Day 1 Exercise 01 - Read and Explain the Demo Code

## Learning Goal

By the end of this exercise, you should be able to explain a basic Java class, object, constructor, field, method, and object relationship.

## Files to Open

Open the Day 1 demo project and review these files:

```text
Course.java
Instructor.java
Student.java
Main.java
```

## Tasks

Answer the following questions in your notebook or README.md file:

1. What is the purpose of `Course.java`?
- The purpose of Course.java is to act as a template for creating and managing information about an educational Course in the application.
2. What is the purpose of `Instructor.java`?
- The purpose of Instructor.java is to act as a template for creating and managing information about a teacher or Instructor in the application.
3. What is the purpose of `Student.java`?
- The purpose of Student.java is to act as a template for creating and managing information about a Student in the application.
4. What does the constructor do?
- A constructor is a special block of code used to initialize a new object from a class template. It runs automatically the exact moment we use the new keyword.
5. Why are the fields marked as `private`?
- The private fields just means putting a lock on your data so other code can't accidentally break it.
6. What does `course1.assignInstructor(instructor1);` mean?
- It means assigning a specific teacher (instructor1) to a specific course (course1).
It links the instructor object to the course object so the system knows who is teaching that class.
7. What does `student1.printProfile();` do?
- It prints the personal details (ID, Name, and Email) of `student1` to the screen.

## AI-Assisted Task

Use ChatGPT, Gemini, Claude, or Windsurf and ask:

```text
Explain this Java class to someone who already knows TypeScript or C#.
```

Then write down:

1. One explanation from AI that helped you.
- For someone from TS/C#, think of it as a normal class with private fields and public methods instead of property shorthand. If you already know C# or TypeScript, Java classes will feel incredibly familiar. They use the exact same Object-Oriented Programming (OOP) core.
2. One part you still needed the trainer or your own reading to understand.
- It takes a bit of extra reading to understand how the Course class stores an entire Instructor object rather than just a simple text string.
- Why Java prefers this explicit getter/setter pattern for encapsulation instead of the more compact property syntax used in TS/C#.
Example (Java): private String title;
Example (C#): public string Title { get; private set; }

## Submission Evidence

Add your answers to README.md under:

```text
## Day 1 Exercise 01 - Code Explanation
```
