## StructureCube - A Java Package For Data Structures & Algorithms :fire:
### By Garvit Singh

### Project Description :notebook: 

This Java package provides a comprehensive set of data structures and algorithms, designed to be efficient and easy to use. The package includes implementations of popular data structures and a variety of algorithms. It contains well-documented source code and includes numerous examples to help Java programmers get started with their DSA Journey!

I have designed this package to allow programmers to easily add new data structures and algorithms as needed by using the import statement and utilising the classes and methods provided in the package. This will make working with data structures and algorithms much easier.

This package will prove to be a valuable resource for anyone working with Data Structures and Algorithms in Java. It has various implementations. Needless to say, this package is consistently evolved and maintained by updating and correcting errors, or bugs. I keep on adding new functionalities as and when i create them.

I try my best to add proper documentation, wherever necessary. I would be glad if you could contribute to the project and help me in maintaining this repository effectively and in the best manner possible.

I understand that this java package might not be perfect and completely error free. This is just my attempt as a College student in his Sophomore Year who thought of simplifying DSA for himself and for anyone who wishes to utilise this package. 

I would like to advise you that this package is **not** to be utilised as some kind of shortcut to implement DSA. You should first learn all the concepts, make sure you understand what is happening in the code, and then go on using this package. Such packages should be utilised to ensure that you save time and save yourself the effort of typing so much repetitive code.

### Motivation Behind This Project :bulb: 

I got the inspiration and motivation to create this repository in my 3rd Semester of college where i was studying Data Structures and Algorithms. 

I felt that there needs to be a tool which provides more functionality than the Java Collections Framework. There needs to be something more effective. 

It was then I decided to maintain a package that helps people to implement various operations on Data Structures & Algorithms in an easy manner. This ultimately motivated me to the create this DSA package containing approximately 2800 lines of Java source code.

### How to Utilise This Package Effectively :key:

1. Download all the package files.
2. Store them in a directory.
3. Use import statment in your Java program.
4. For example - import dsa.dataStructures.BinaryTree.*

### List of Provided Subpackages, Classes and Methods with Brief Descriptions :pen: 

#### **1. Algorithms**
   
**Searching Algorithms**
  * Linear Search
  * Binary Search

**Sorting Algorithms**
  * Bubble Sort
  * Cyclic Sort
  * Insertion Sort
  * Merge Sort
  * Quick Sort
  * Selection Sort

#### **2. Data Structures**
   
**One Dimensional Arrays - Arrays Class & It's Methods**
  
  * Arrays() : Constructor method that initializes the array as an empty ArrayList.
  
  * insertAtEnd() : Inserts the given element at the end of the array.
  
  * insertAt() : Inserts the given element at the specified position in the array.
  
  * insertAtStart() : Inserts the given element at the beginning of the array.
  
  * deleteAtEnd() : Deletes the element at the end of the array
  
  * deleteAt() : Deletes the element at the specified position in the array.
  
  * deleteAtStart() : Deletes the element at the beginning of the array.
  
  * linearSearch() : Performs a linear search to find the target element in the array and returns its index. Returns -1 if the element is not found.
  
  * binarySearch() : Performs a binary search to find the target element in the sorted array and returns its index. Returns -1 if the element is not found.
  
  * displayArray() : Prints the contents of the array.
  
  * traverseArray() : Prints all elements in the array.
  
  * updateElement() : Updates the element at the specified index with a new value.
  
  * sortAscending() : Sorts the elements in the array in ascending order.
  
  * sortDescending() : Sorts the elements in the array in descending order.
  
  * mergeSortedArrays() : Merges two sorted ArrayLists (arr1 and arr2) into the current array. The result is a larger sorted array.
   
   
**Two Dimensional Arrays - Arrays2D Class & It's Methods**
       
  * Arrays2D() : Constructor method that initializes a 2D array with the specified number of rows and columns
  
  * inputMatrix() : Takes input from the user to fill the 2D matrix.
  
  * printMatrix() : Prints the elements of the matrix.
  
  * getElement() : Retrieves an element from the matrix at the specified row and column.
  
  * insertElement() : Inserts a value into the matrix at the specified row and column.
  
  * deleteElement() : Deletes an element from the matrix at the specified row and column.
  
  * traverseMatrix() : Prints the elements of the matrix in a traversed manner.
  
  * transposeMatrix() : Computes and prints the transpose of the matrix.
  
  * subtractMatrix() : Subtracts another matrix from the current matrix and returns the result.
  
  * addMatrix() : Adds another matrix to the current matrix and returns the result.
  
  * scalarMultiply() : Multiplies the matrix by a scalar value.
  
  * dotProduct() : Computes and returns the dot product of two matrices.
  
  * scalarDivide() : Divides the matrix by a scalar value.
  
  * determinant() : Calculates and returns the determinant of the matrix.
  
  * cofactor() : Calculates the cofactor of a specific matrix element.
  
  * inverse() : Calculates and returns the inverse of the matrix.
  
  * rotateClockwise() : Rotates the matrix clockwise by 90 degrees.
  
  * rotateAntiClockwise() : Rotates the matrix anti-clockwise by 90 degrees.
  
  * sortAscending() : Sorts the matrix elements in ascending order.
  
  * sortDescending() : Sorts the matrix elements in descending order.
   
**Stacks - Stack Class & It's Methods**
       
  * Stack() : Constructor for an empty stack with unlimited size.
       
  * Stack() : Constructor for a stack with a specified maximum size.
       
  * push() : Adds an element to the top of the stack.
       
  * pop() : Removes and returns the top element from the stack.
       
  * peek() : Returns the top element of the stack without removing it.
       
  * isEmpty() : Checks if the stack is empty.
       
  * size() : Returns the number of elements in the stack.
       
  * clear() : Clears all elements from the stack.
       
  * initializeStack() : Initializes the stack with the elements from the provided list.
       
  * toString() : Returns a string representation of the stack.
       
  * isFull() : Checks if the stack is full (reached its maximum size).
       
  * duplicate() : Creates a duplicate of the stack.
       
  * merge() : Merges the elements of another stack into the current stack.
       
  * reverse() : Reverses the elements in the stack.
       
  * isBalancedParentheses() : Static method to check if parentheses in a given expression are balanced using a stack of characters. 

**Queues**

RegularQueue Class & It's Methods
       
  * RegularQueue() : Constructor that initializes an empty regular queue.
       
  * enqueue() : Adds an element to the back of the queue.
       
  * dequeue() : Removes and returns the element from the front of the queue.
       
  * front() : Returns the element at the front of the queue without removing it.
       
  * isEmpty() : Checks if the queue is empty and returns a boolean value accordingly.
       
  * size() : Returns the current number of elements in the queue.
       
  * clear() : Removes all elements from the queue, making it empty.
       
  * initialize() : Clears the queue and initializes it with the elements from the provided array, adding them to the back of the queue.
       
  * isFull() : Checks if the queue is full based on a maximum size (maxSize) and returns a boolean value accordingly.
       
  * traverse() : Prints the elements in the queue from front to back, without removing them, and displays them as "Queue Elements." 


PriorityQueue Class & It's Methods
       
  * PriorityQueue() : Constructor that initializes an empty priority queue.
       
  * enqueueWithPriority() : Adds an element with a specified priority to the priority queue. Elements with higher priorities will be extracted first.
       
  * extractHighestPriority() : Removes and returns the element with the highest priority from the priority queue. If the priority queue is empty, it throws an IllegalStateException.
       
  * isEmpty() : Checks if the priority queue is empty and returns a boolean value accordingly.  

**Linked Lists**
     
SinglyLinkedList Class & It's Methods
       
  * SinglyLinkedList() : Constructor that initializes an empty singly linked list.
  
  * display() : Displays the linked list.
  
  * insertAtBeginning() : Inserts a new node with the given data at the beginning of the list.
  
  * insertAtEnd() : Inserts a new node with the given data at the end of the list.
  
  * insertAtPosition() : Inserts a new node with the given data at a specific position in the list.
  
  * deleteFromBeginning() : Deletes the first node from the list.
  
  * deleteFromEnd() : Deletes the last node from the list.
  
  * deleteNodeByValue() : Deletes the first occurrence of a node with the given data from the list.
  
  * traverse() : Traverses and prints the elements of the list.
  
  * search() : Searches for a specific value in the list and returns true if found, false otherwise.
  
  * length() : Returns the number of nodes in the list.
  
  * reverse() : Reverses the order of nodes in the list.
  
  * concatenate() : Concatenates another singly linked list to the current list.
  
  * cloneList() : Creates a deep copy (clone) of the current list.
  
  * mergeSortedLists() : Static method that merges two sorted singly linked lists into a new sorted list.
  
  * hasCycle() : Uses Floyd's cycle detection algorithm to check if the linked list contains a cycle.
     

DoublyLinkedList Class & It's Methods
       
  * DoublyLinkedList() : Constructor that initializes an empty doubly linked list.
       
  * insertAtFront() : Inserts a new node with the given data at the front (beginning) of the list.
       
  * insertAtEnd() : Inserts a new node with the given data at the end of the list.
       
  * deleteFromFront() : Deletes the first node (head) from the list.
       
  * deleteFromEnd() : Deletes the last node (tail) from the list.
       
  * traverseForward() : Traverses and prints the elements of the list from the head to the tail.
       
  * traverseBackward() : Traverses and prints the elements of the list from the tail to the head.
     

CircularLinkedList Class & It's Methods
       
  * CircularLinkedList() : Constructor that initializes an empty circular linked list.
  
  * insertInCircular() : Inserts a new node with the given data into the circular linked list.
  
  * deleteFromCircular() : Deletes the first occurrence of a node with the given data from the circular linked list.
  
  * traverseCircular() : Traverses and prints the elements of the circular linked list starting from the specified node.
  
  * josephusProblem() : Solves the Josephus problem for the given number of participants n and the counting interval k to determine the surviving participant's position.
  
  * splitCircular() : Splits the circular linked list into a new linked list starting from the specified index. The original list is cleared.
  
  * combineCircular() : Combines the current circular linked list with another linked list. 


**Binary Trees - BinaryTree Class & It's Methods**
       
  * BinaryTree() : Constructor that initializes an empty binary tree.
  
  * insert() : Inserts a node with the specified data value into the binary tree.
  
  * delete() : Deletes a node with the specified data value from the binary tree.
  
  * search() : Searches for a node with the specified data value in the binary tree and returns true if found, false otherwise.
  
  * inorderTraversal() : Performs an inorder traversal of the binary tree, printing the data of each node.
  
  * preorderTraversal() : Performs a preorder traversal of the binary tree, printing the data of each node.
  
  * postorderTraversal() : Performs a postorder traversal of the binary tree, printing the data of each node.
  
  * levelOrderTraversal() : Performs a level-order traversal of the binary tree, printing the data of each node.
  
  * findMin() : Finds and returns the minimum value in the binary tree.
  
  * findMax() : Finds and returns the maximum value in the binary tree.
  
  * findSuccessor() : Finds and returns the successor (in-order successor) of a node with the specified data value.
  
  * findPredecessor() : Finds and returns the predecessor (in-order predecessor) of a node with the specified data value.
  
  * getHeight() : Calculates and returns the height (or depth) of the binary tree.
  
  * getSize() : Calculates and returns the size (or count) of nodes in the binary tree.
  
  * getDiameter() : Calculates and returns the diameter of the binary tree.
  
  * isBalanced() : Checks if the binary tree is balanced (i.e., the heights of its subtrees differ by at most 1).
  
  * treeToArray() : Converts the binary tree into an array, preserving the inorder traversal order.
  
  * arrayToTree() : Converts an array into a balanced binary tree.
  
  * mirror() : Inverts (mirrors) the binary tree.
  
  * prune() : Prunes (removes) nodes with a specific target value from the binary tree.
  
  * combine() : Combines the binary tree with another binary tree.
  
  * serialize() : Serializes the binary tree into a string representation.
  
  * deserialize() : Deserializes a string representation of a binary tree to reconstruct the tree structure.


**Binary Search Trees - BinarySearchTree Class & It's Methods**

  * BinarySearchTree() : Constructor that initializes an empty binary search tree.
  
  * insert() : Inserts a node with the specified value into the binary search tree while maintaining the binary search tree property.
  
  * delete() : Deletes a node with the specified value from the binary search tree while maintaining the binary search tree property.
  
  * search() : Searches for a node with the specified value in the binary search tree and returns true if found, false otherwise.
  
  * inorderTraversal() : Performs an inorder traversal of the binary search tree, printing the values of each node in sorted order.
  
  * preorderTraversal() : Performs a preorder traversal of the binary search tree, printing the values of each node.
  
  * postorderTraversal() : Performs a postorder traversal of the binary search tree, printing the values of each node.
  
  * findMinimumValue() : Finds and returns the minimum value in the binary search tree.
  
  * findMaximumValue() : Finds and returns the maximum value in the binary search tree.
  
  * findSuccessor() : Finds and returns the successor of a node with the specified value.
  
  * findPredecessor() : Finds and returns the predecessor of a node with the specified value.
  
  * getHeight() : Calculates and returns the height (or depth) of the binary search tree.
  
  * getSize() : Calculates and returns the size (or count) of nodes in the binary search tree.
  
  * getDiameter() : Calculates and returns the diameter of the binary search tree.
  
  * isBalanced() : Checks if the binary search tree is balanced (i.e., the heights of its subtrees differ by at most 1).
  
  * toArray() : Converts the binary search tree into a sorted array.
  
  * fromSortedArray() : Converts a sorted array into a binary search tree.
  
  * combine() : Combines the binary search tree with another binary search tree by inserting values from the other tree.
  
  * serialize() : Serializes the binary search tree into a string representation.
  
  * deserialize() : Deserializes a string representation of a binary search tree to reconstruct the tree structure. 
