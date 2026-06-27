const students = [
  { studentId: 'S001', studentName: 'Ignacio de Paul', email: 'ignacio@example.com', status: 'Active' },
  { studentId: 'S002', studentName: 'Ben Tan', email: 'ben@example.com', status: 'Inactive' },
  { studentId: 'S003', studentName: 'Chong Mei', email: 'mei@example.com', status: 'Active' },
  { studentId: 'S004', studentName: 'Aina Rahman', email: 'aina@example.com', status: 'Active' }
];

const searchInput = document.getElementById('search-input');
const searchButton = document.getElementById('search-button');
const resetButton = document.getElementById('reset-button');
const studentList = document.getElementById('student-list');

function renderStudents(studentArray) {
  studentList.innerHTML = '';

  if (studentArray.length === 0) {
    const message = document.createElement('p');
    message.className = 'no-results';
    message.textContent = 'No students found';
    studentList.appendChild(message);
    return;
  }

  studentArray.forEach((student) => {
    const card = document.createElement('div');
    card.innerHTML = `
      <br><p><strong>Student ID:</strong> ${student.studentId}</p>
      <p><strong>Name:</strong> ${student.studentName}</p>
      <p><strong>Email:</strong> ${student.email}</p>
      <p><strong>Status:</strong> ${student.status}</p>
    `;
    studentList.appendChild(card);
  });
}

searchButton.addEventListener('click', () => {
  const searchText = searchInput.value.trim().toLowerCase();
  const filteredStudents = students.filter((student) =>
    student.studentName.toLowerCase().includes(searchText)
  );
  renderStudents(filteredStudents);
});

resetButton.addEventListener('click', () => {
  searchInput.value = '';
  renderStudents(students);
});

renderStudents(students);
