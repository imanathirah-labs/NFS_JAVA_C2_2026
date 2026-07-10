# Day 5 Exercise 5.1: HTTP Investigation Answers

## Investigation Table

| Method | URL | Status Code | Response Type | What Happened? |
|---|---|---:|---|---|
| GET | http://localhost:8081/api/events | 200 | List | This was a successful request that returned the full list of events. The response body contained an array of event objects. |
| GET | http://localhost:8081/api/events/EV001 | 200 | Single object | This was a successful request for one event. The API returned the details of the event with ID EV001. |
| GET | http://localhost:8081/api/events/EV999 | 404 | Error object | This request asked for an event that does not exist. The server returned a not-found error and explained that the event was not found. |
| POST | http://localhost:8081/api/bookings | 201 | Single object | This was a successful create request. The booking was created and the API returned the new booking object with an ID and confirmed status. |
| POST | http://localhost:8081/api/bookings | 400 | Error object | This failed create request had invalid input fields such as empty event ID, empty participant name, empty email, and invalid seat value. The server returned a validation error with details. |

## Questions to Answer

1. Which request returned a successful list response?  
   The GET request to http://localhost:8081/api/events returned a successful list response with status code 200.

2. Which request returned a not-found response?  
   The GET request to http://localhost:8081/api/events/EV999 returned a 404 not-found response.

3. Which request returned a validation error?  
   The POST request to http://localhost:8081/api/bookings with empty/invalid fields returned a 400 validation error.

4. What is the difference between a successful response and an error response?  
   A successful response means the server understood the request and completed it, usually with a 2xx status code and data in the body. An error response means the request could not be completed, usually with a 4xx or 5xx status code and an error message or validation details.

5. Why is the status code important for frontend developers?  
   Status codes tell frontend developers whether the request succeeded, failed, or needs special handling. They help decide whether to display data, show an error message, retry the request, or redirect the user.

## Reflection

One thing I understand better about REST after this exercise is that HTTP methods and status codes give a clear structure for client-server communication. A request can be understood not only by the body it returns, but also by the status code that explains what happened.
