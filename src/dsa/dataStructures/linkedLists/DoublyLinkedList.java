package dsa.dataStructures.linkedLists;
import java.util.LinkedList;

public class DoublyLinkedList {
    private LinkedList<Integer> list;

    public DoublyLinkedList() {
        list = new LinkedList<>();
    }

    // Insertion at Front
    public void insertAtFront(int data) {
        list.addFirst(data);
    }

    // Insert at End
    public void insertAtEnd(int data) {
        list.addLast(data);
    }

    // Delete from Front
    public void deleteFromFront() {
        if (!list.isEmpty()) {
            list.removeFirst();
        }
        else {
            System.out.println("The list is empty.");
        }
    }

    // Delete from End
    public void deleteFromEnd() {
        if (!list.isEmpty()) {
            list.removeLast();
        }
        else {
            System.out.println("The list is empty.");
        }
    }

    // Traversal in Both Directions
    public void traverseForward() {
        for (Integer data : list) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    // Traverse Backwards.
    public void traverseBackward() {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    // Examples showing how to implement these methods.
    public static void main(String[] args) {
        DoublyLinkedList myDoublyList = new DoublyLinkedList();
        myDoublyList.insertAtFront(1);
        myDoublyList.insertAtEnd(2);
        myDoublyList.insertAtEnd(3);
        myDoublyList.insertAtFront(0);

        System.out.print("Forward traversal: ");
        myDoublyList.traverseForward(); // Output: Forward traversal: 0 1 2 3
        System.out.print("Backward traversal: ");
        myDoublyList.traverseBackward(); // Output: Backward traversal: 3 2 1 0

        myDoublyList.deleteFromFront();
        myDoublyList.deleteFromEnd();

        System.out.print("Forward traversal after deletions: ");
        myDoublyList.traverseForward(); // Output: Forward traversal after deletions: 1 2
    }
}