# Day 6 Exercise 5 HTTP Test File Answer

The following endpoints were tested in `requests/day06-tickets.http` and worked as expected:

- `GET /api/health`
- `GET /api/about`
- `GET /api/tickets`
- `GET /api/tickets/{id}` with an existing ticket ID
- `GET /api/tickets/{id}` with a missing ticket ID
- `POST /api/tickets` with a valid ticket body
- `POST /api/tickets` with an invalid ticket body

Expected status codes:

- Health: `200`
- About: `200`
- Get all tickets: `200`
- Get existing ticket: `200`
- Get missing ticket: `404`
- Create valid ticket: `201`
- Create invalid ticket: `400`
