## Day 3 Assignment Reflection

When `getCourseById("C004")` is called, the request goes to:

Answer:
1. `CodeFlowPractice.java`
2. `CourseService.java`
3. `InMemoryCourseRepository.java`

Why is InMemoryCourseRepository temporary storage?
What would probably replace it later when we use MongoDB?

Answer:
InMemoryCourseRepository is temporary storage because it keeps data only in memory using a `LinkedHashMap`, so the data is lost when the application stops. Later, MongoDB would probably replace it as the real persistent storage, so course data is saved in a database instead of only in memory.

Why is throwing CourseNotFoundException better than printing inside CourseService?

Answer:
Throwing `CourseNotFoundException` is better because the service reports the error without choosing how it should be shown.
- A console app, web API, or frontend app can each catch the exception and display a different friendly message.
- If the service printed directly, it would force one presentation style and make the service harder to reuse.

Why is CourseOffering a better design than putting start date, end date, and capacity directly inside Course?

Answer:
The same course can be offered multiple times with different start dates, end dates, and capacities. If these were in Course, we need to create duplicate course objects.

Which version is easier to understand: loop or stream? Why?

Answer:
The loop version is easier to understand for beginners because it is more explicit and step-by-step:
Create an empty list.
- Iterate through each course.
- Check the condition.
- Add to results.
The stream version is more compact but requires understanding functional concepts like filter() and method chaining, so it takes practice.

What does filter() do in a stream?

Answer:
filter() takes a condition (predicate) and keeps only the items that match it. Items that do not match are removed from the stream.