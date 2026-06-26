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