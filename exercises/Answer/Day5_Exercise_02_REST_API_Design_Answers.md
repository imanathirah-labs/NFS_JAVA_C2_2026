# Day 5 Exercise 5.2: REST API Design Answers

## 1. API Specification Table

| Resource | Method | Endpoint | Purpose | Request Body Needed? | Success Status | Possible Error Status |
|---|---|---|---|---|---:|---:|
| Events | GET | /api/events | View all available events | No | 200 OK | 404 Not Found (if the resource is unavailable), 500 Internal Server Error |
| Event | GET | /api/events/{eventId} | View details of one event | No | 200 OK | 404 Not Found |
| Bookings | POST | /api/bookings | Create a new booking | Yes | 201 Created | 400 Bad Request, 404 Not Found, 409 Conflict |
| Bookings | GET | /api/bookings | View all bookings | No | 200 OK | 404 Not Found, 500 Internal Server Error |
| Booking | GET | /api/bookings/{bookingId} | View details of one booking | No | 200 OK | 404 Not Found |
| Booking | DELETE | /api/bookings/{bookingId} | Cancel a booking | No | 200 OK | 404 Not Found, 409 Conflict |

## 2. Request Body Planning

| Endpoint | Request Body Description |
|---|---|
| /api/bookings | Should contain booking details such as the event ID, participant name, participant email, and number of seats requested. |

## 3. Error Planning

| Error Case | Related Endpoint | Suitable Status Code | Explanation |
|---|---|---:|---|
| Required booking field is missing | /api/bookings | 400 Bad Request | The request body is incomplete and cannot be processed. |
| Event does not exist | /api/bookings | 404 Not Found | The booking references an event ID that does not exist. |
| Event is fully booked or seats are insufficient | /api/bookings | 409 Conflict | The requested seats cannot be reserved because availability is insufficient. |
| Booking does not exist | /api/bookings/{bookingId} | 404 Not Found | The booking ID does not match any existing booking. |
| Booking is already cancelled | /api/bookings/{bookingId} | 409 Conflict | The booking cannot be cancelled again because it is already cancelled. |

## 4. Why These Endpoint Names Follow REST Principles

These endpoint names use resource-based URLs instead of action-style names. For example, /api/events and /api/bookings represent resources, while the HTTP method describes the action. GET is used for reading, POST for creating, and DELETE for cancelling. This makes the API easier to understand and follow standard REST conventions.
