const API_BASE_URL = "http://localhost:8081/api";

const eventList = document.getElementById("eventList");
const statusText = document.getElementById("statusText");
const eventIdInput = document.getElementById("eventIdInput");
const searchButton = document.getElementById("searchButton");

function renderEvents(events) {
  eventList.innerHTML = "";

  events.forEach(event => {
    const listItem = document.createElement("li");
    listItem.textContent = `${event.title} - ${event.date} - ${event.venue} - ${event.availableSeats} seats available`;
    eventList.appendChild(listItem);
  });
}

async function loadAllEvents() {
  statusText.textContent = "Loading events...";

  try {
    const response = await fetch(`${API_BASE_URL}/events`);

    if (!response.ok) {
      throw new Error("Failed to load events");
    }

    const events = await response.json();
    renderEvents(events);
    statusText.textContent = `${events.length} event(s) loaded successfully.`;
  } catch (error) {
    statusText.textContent = `Error: ${error.message}`;
  }
}

async function searchEventById(eventId) {
  statusText.textContent = `Searching for ${eventId}...`;

  try {
    const response = await fetch(`${API_BASE_URL}/events/${eventId}`);

    if (!response.ok) {
      throw new Error(`Event ${eventId} was not found`);
    }

    const event = await response.json();
    eventList.innerHTML = "";
    const listItem = document.createElement("li");
    listItem.textContent = `${event.title} - ${event.date} - ${event.venue} - ${event.availableSeats} seats available`;
    eventList.appendChild(listItem);
    statusText.textContent = `Loaded event ${event.id}`;
  } catch (error) {
    eventList.innerHTML = "";
    const listItem = document.createElement("li");
    listItem.textContent = error.message;
    eventList.appendChild(listItem);
    statusText.textContent = "Search failed";
  }
}

searchButton.addEventListener("click", () => {
  const eventId = eventIdInput.value.trim();

  if (eventId) {
    searchEventById(eventId);
  } else {
    loadAllEvents();
  }
});

loadAllEvents();
