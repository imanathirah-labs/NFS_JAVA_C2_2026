const courses = [
    {
        id: "C001",
        title: "JavaScript Fundamentals",
        durationHours: 12,
        level: "Beginner",
    },
    {
        id: "C002",
        title: "React Frontend Development",
        durationHours: 16,
        level: "Intermediate",
    },
    {
        id: "C003",
        title: "MongoDB Basics",
        durationHours: 8,
        level: "Advanced",
    }
];

console.log("==== Course Details ====");

for (const course of courses) {
    console.log(`Course ID: ${course.id}`);
    console.log(`Title: ${course.title}`);
    console.log(`Duration (Hours): ${course.durationHours}`);
    console.log(`Level: ${course.level}`);
    console.log("-------------------------");
}

console.log("Total Courses: " + courses.length);