package dsa.dataStructures.linkedLists;
import java.util.LinkedList;

public class SinglyLinkedList {
    
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private LinkedList<Integer> list;

    public SinglyLinkedList() {
        list = new LinkedList<>();
        head = null;
    }

    // Display the linked list
    public void display() {
        System.out.println(list);
    }

    // 1) Insertion at the Beginning
    public void insertAtBeginning(int data) {
        list.addFirst(data);
    }

    // 2) Insertion at the End
    public void insertAtEnd(int data) {
        list.addLast(data);
    }

    // 3) Insertion at a Specific Position
    public void insertAtPosition(int data, int position) {
        if (position >= 0 && position <= list.size()) {
            list.add(position, data);
        } 
        else {
            System.out.println("Invalid position.");
        }
    }

    // 4) Deletion from the Beginning
    public void deleteFromBeginning() {
        if (!list.isEmpty()) {
            list.removeFirst();
        } 
        else {
            System.out.println("The list is empty.");
        }
    }

    // 5) Deletion from the End
    public void deleteFromEnd() {
        if (!list.isEmpty()) {
            list.removeLast();
        } 
        else {
            System.out.println("The list is empty.");
        }
    }

    // 6) Deletion of a Specific Node by Value
    public void deleteNodeByValue(int data) {
        if (list.removeFirstOccurrence(data)) {
            System.out.println("Node with value " + data + " deleted.");
        } 
        else {
            System.out.println("Node with value " + data + " not found.");
        }
    }

    // 7) Traversal
    public void traverse() {
        for (Integer data : list) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    // 8) Searching
    public boolean search(int target) {
        return list.contains(target);
    }

    // 9) Length Count
    public int length() {
        return list.size();
    }

    // 10) Reversal
    public void reverse() {
        LinkedList<Integer> reversedList = new LinkedList<>();
        for (Integer data : list) {
            reversedList.addFirst(data);
        }
        list = reversedList;
    }

    // 11) Concatenation
    public void concatenate(SinglyLinkedList otherList) {
        list.addAll(otherList.list);
    }

    // 12) Cloning/Copying
    public SinglyLinkedList cloneList() {
        SinglyLinkedList newList = new SinglyLinkedList();
        newList.list = new LinkedList<>(this.list);
        return newList;
    }

    // 13) Merging (Assuming both lists are sorted)
    public static SinglyLinkedList mergeSortedLists(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList mergedList = new SinglyLinkedList();
        LinkedList<Integer> result = new LinkedList<>();

        int i = 0, j = 0;
        while (i < list1.length() && j < list2.length()) {
            int num1 = list1.list.get(i);
            int num2 = list2.list.get(j);

            if (num1 < num2) {
                result.add(num1);
                i++;
            } else {
                result.add(num2);
                j++;
            }
        }

        while (i < list1.length()) {
            result.add(list1.list.get(i));
            i++;
        }

        while (j < list2.length()) {
            result.add(list2.list.get(j));
            j++;
        }

        mergedList.list = result;
        return mergedList;
    }

    // 14) Detecting Loops/Cycles (Floyd's cycle detection algorithm)
    public boolean hasCycle() {
        if (head == null || head.next == null) {
            return false; // No cycle in an empty list or a list with only one node.
        }
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle detected
    }

    //Examples on how to implement all these methods in your code.
    public static void main(String[] args) {
        SinglyLinkedList myList1 = new SinglyLinkedList();
        myList1.insertAtEnd(1);
        myList1.insertAtEnd(3);

        SinglyLinkedList myList2 = new SinglyLinkedList();
        myList2.insertAtEnd(2);
        myList2.insertAtEnd(4);

        System.out.print("List 1: ");
        myList1.traverse(); // Output: List 1: 1 3
        System.out.print("List 2: ");
        myList2.traverse(); // Output: List 2: 2 4

        // Concatenation
        myList1.concatenate(myList2);
        System.out.print("Concatenated List: ");
        myList1.traverse(); // Output: Concatenated List: 1 3 2 4

        // Cloning
        SinglyLinkedList clonedList = myList1.cloneList();
        System.out.print("Cloned List: ");
        clonedList.traverse(); // Output: Cloned List: 1 3 2 4

        // Merging
        SinglyLinkedList mergedList = SinglyLinkedList.mergeSortedLists(myList1, myList2);
        System.out.print("Merged List: ");
        mergedList.traverse(); // Output: Merged List: 1 2 3 4

        // Detecting Loops
        System.out.println("Does myList1 have a cycle? " + myList1.hasCycle()); // Output: Does myList1 have a cycle? false
    }
}
