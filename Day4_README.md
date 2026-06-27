## Day 4 Assignment Reflection

How is a JavaScript array similar to Java ArrayList?:

Answer:
Both are dynamic lists that can grow and shrink at runtime, and both let you store objects and iterate over them easily. JavaScript arrays and Java `ArrayList` both support common operations like adding items, reading by index, and checking length/size.

1. What is the difference between filter, find, and map?

Answer:
- `filter` returns a new array with all items that match a condition.
- `find` returns the first single item that matches a condition (or `undefined` if none).
- `map` returns a new array where each item is transformed into something else.

2. Which four array methods change the original array?

Answer:
The four array methods that change the original array are:

- `push`
- `pop`
- `shift`
- `unshift`

3. What does push return?

Answer:
- `push` returns the new length of the array after the item is added.

4. What does pop return?

Answer:
- `pop` returns the item that was removed from the end of the array.

5. What is the difference between shift and unshift?

Answer:
- `shift` removes the first item from the array and returns it.
- `unshift` adds one or more items to the beginning of the array and returns the new length.

How is JavaScript filter used in a search feature?

Answer:
In a search feature, filter goes through the student array and returns only the students whose names match the search text.
That filtered array is then passed to renderStudents(...) to show only matching students.