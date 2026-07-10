# Day 5 Exercise 5 Final: Completed Endpoints Note

I completed the main booking endpoints for the mock API:

- GET /api/bookings to view all bookings
- GET /api/bookings/{id} to view one booking by ID
- POST /api/bookings to create a new booking

I also included validation and error handling for:

- missing booking fields
- unknown event IDs
- insufficient available seats

The API returns the expected status codes for successful and failed requests, including 200, 201, 400, and 404.
