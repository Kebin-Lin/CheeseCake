# CheeseCake - Henry Carver, Kevin Lin, Kevin Feng
## Merges
We decided to use the body from Kevin Lin's and the main method from Henry's because each respective part was more robust and clearer. 
Kevin Lin's code threw exceptions to catch errors, and had a slight difference in a couple if statements for precision.
## Runtime
We decided to write our code with runtime that the API doesn't have. The API has constant time for the add method and linear time for the other methods. We have two linear methods, removeMin and add, while peekMin and isEmpty are constant.

## Methods
- isEmpty() returns false if the queue has elements, returns true otherwise.
- peekMin() returns the value at the front of the queue without removing it.
- removeMin() returns the value at the front of the queue and removes it.
- add(String x) inserts a value into the queue, basing its position on its priority.

## Heap To Do
- peekMin()
- minChildPos(int pos)
- removeMin()
- add()
