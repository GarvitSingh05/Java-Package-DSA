package dsa.dataStructures.stacks;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;


public class Stack<T> {
    private List<T> stack;
    private Integer maxSize; // Maximum stack size, set to -1 for unlimited size
    
    // Constructors
    public Stack() {
        this.stack = new ArrayList<>();
        this.maxSize = -1; // Unlimited size by default
    }

    public Stack(int maxSize) {
        this.stack = new ArrayList<>();
        this.maxSize = maxSize;
    }

    // Push element to the stack
    public void push(T element) {
        stack.add(element);
    }

    // Pop an element from the stack.
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int lastIndex = stack.size() - 1;
        T poppedElement = stack.get(lastIndex);
        stack.remove(lastIndex);
        return poppedElement;
    }

    // Return the top element without removing it.
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int lastIndex = stack.size() - 1;
        return stack.get(lastIndex);
    }

    // Check if the stack is empty.
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Find the size of stack.
    public int size() {
        return stack.size();
    }

    // Clear all elements from the stack.
    public void clear() {
        stack.clear();
    }

    // Create a stack with all the elements passed.
    public void initializeStack(List<T> elements) {
        clear();
        stack.addAll(elements);
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    // Check if the stack is full.
    public boolean isFull() {
        return maxSize != -1 && stack.size() >= maxSize;
    }

    // Create a duplicate of the stack.
    public Stack<T> duplicate() {
        Stack<T> duplicateStack = new Stack<>(this.maxSize); // Pass maxSize explicitly
        duplicateStack.stack.addAll(this.stack);
        return duplicateStack;
    }

    // Merge with another stack.
    public void merge(Stack<T> anotherStack) {
        while (!anotherStack.isEmpty()) {
            this.push(anotherStack.pop());
        }
    }

    // Reverse the stack.
    public void reverse() {
        List<T> reversedList = new ArrayList<>();
        while (!isEmpty()) {
            reversedList.add(pop());
        }
        stack = reversedList;
    }

    // Check if the parenthesis of an expression are balanced or not.
    public static boolean isBalancedParentheses(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    } // End of isBalancedParenthesis() method.

    // Examples portraying how to implement and utilise these methods.
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>(5);
        Stack<Integer> stack2 = new Stack<>();

        // Push elements onto stack1
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        System.out.println("Stack: " + stack1);

        // Pop and print elements from the stack
        System.out.println("Popped element: " + stack1.pop());
        System.out.println("Popped element: " + stack1.pop());

        // Peek at the top element
        System.out.println("Peeked element: " + stack1.peek());

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack1.isEmpty());

        // Get the size of the stack
        System.out.println("Stack size: " + stack1.size());

        // Clear the stack
        stack1.clear();
        System.out.println("Stack after clearing: " + stack1);

        // Initialize the stack with predefined elements
        List<Integer> elements = List.of(4, 5, 6);
        stack1.initializeStack(elements);
        System.out.println("Stack after initialization: " + stack1);

        // Duplicate stack1
        Stack<Integer> duplicateStack = stack1.duplicate();
        System.out.println("Duplicate Stack: " + duplicateStack);

        // Merge stack2 into stack1
        stack2.push(4);
        stack2.push(5);
        stack1.merge(stack2);
        System.out.println("Merged Stack: " + stack1);

        // Reverse stack1
        stack1.reverse();
        System.out.println("Reversed Stack: " + stack1);

        // Checking for Balanced Parentheses
        String expression1 = "{[()]()}";
        String expression2 = "{[()()]()";
        System.out.println("Is expression1 balanced? " + Stack.isBalancedParentheses(expression1));
        System.out.println("Is expression2 balanced? " + Stack.isBalancedParentheses(expression2));
    }
}