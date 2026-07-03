const statusMessage = document.getElementById("status-message");
const studentList = document.getElementById("student-list");

function renderStudents(students) {
  studentList.innerHTML = "";

  students.forEach((student) => {
    const studentCard = document.createElement("div");

    studentCard.innerHTML = `
      <h2>${student.studentName}</h2>
      <p>Student ID: ${student.studentId}</p>
      <p>Email: ${student.email}</p>
      <p>Status: ${student.status}</p>
      <hr>
    `;

    studentList.appendChild(studentCard);
  });
}

async function loadStudents() {
  try {
    statusMessage.textContent = "Loading students...";

    const response = await fetch("students.json");

    if (!response.ok) {
      throw new Error("Failed to load student data.");
    }

    const students = await response.json();

    statusMessage.textContent = "";
    renderStudents(students);
  } catch (error) {
    statusMessage.textContent = "Error: " + error.message;
  }
}

loadStudents();
