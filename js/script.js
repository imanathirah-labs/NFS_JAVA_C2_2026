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

/*
DOM Rendering and manipulation

HTML = Page Structure
CSS = Page Styling
JS = Page Behavior
DOM = Document Object Model browser's object version of HTML page
*/
const courseList = document.getElementById("course-list"); // Finding the HTML element

courses.forEach(course => {
    const courseCard = document.createElement("div");

    courseCard.innerHTML = `
        <h3>${course.title}</h3>
        <p><strong>Course ID:</strong> ${course.id}</p>
        <p><strong>Duration (Hours):</strong> ${course.durationHours}</p>
        <p><strong>Level:</strong> ${course.level}</p>
    `;
    courseList.appendChild(courseCard);
});