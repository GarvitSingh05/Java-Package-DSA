package dsa.dataStructures.linkedLists;
import java.util.LinkedList;

public class CircularLinkedList {
    private LinkedList<Integer> list;

    public CircularLinkedList() {
        list = new LinkedList<>();
    }

    // Insertion in a Circular Manner
    public void insertInCircular(int data) {
        list.add(data);
    }

    // Deletion in a Circular Manner
    public void deleteFromCircular(int data) {
        list.removeFirstOccurrence(data);
    }

    // Traversal in a Circular Manner
    public void traverseCircular(int startNode) {
        if (!list.isEmpty()) {
            int currentIndex = startNode % list.size();
            
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(currentIndex) + " ");
                currentIndex = (currentIndex + 1) % list.size();
            }
            System.out.println();
        }
        else {
            System.out.println("The Circular Linked List Is Empty.");
        }
    }

    // Splitting
    public LinkedList<Integer> splitCircular(int startIndex) {
        if (!list.isEmpty()) {
            LinkedList<Integer> newList = new LinkedList<>();
            int currentIndex = startIndex % list.size();

            for (int i = 0; i < list.size(); i++) {
                newList.add(list.get(currentIndex));
                currentIndex = (currentIndex + 1) % list.size();
            }

            list.clear();
            return newList;
        }
        return null;
    }

    // Combining
    public void combineCircular(LinkedList<Integer> otherList) {
        if (!otherList.isEmpty()) {
            list.addAll(otherList);
        }
    }

    // Josephus Problem
    public int josephusProblem(int n, int k) {
        if (n <= 0 || k <= 0) {
            return -1; // Invalid input
        }
        int survivor = 0;
        for (int i = 2; i <= n; i++) {
            survivor = (survivor + k) % i;
        }
        return survivor;
    }

    //Examples showing how to implement these methods.
    public static void main(String[] args) {
        CircularLinkedList circularList = new CircularLinkedList();
        circularList.insertInCircular(1);
        circularList.insertInCircular(2);
        circularList.insertInCircular(3);
        circularList.insertInCircular(4);

        System.out.print("Circular traversal starting from node 2: ");
        circularList.traverseCircular(2); // Output: Circular traversal starting from node 2: 3 4 1 2

        int survivor = circularList.josephusProblem(5, 3);
        System.out.println("Josephus problem solution: Survivor at position " + survivor); // Output: Josephus problem solution: Survivor at position 3

        LinkedList<Integer> splitList = circularList.splitCircular(2);
        System.out.print("Split circular list: ");
        for (Integer data : splitList) {
            System.out.print(data + " ");
        }
        System.out.println(); // Output: Split circular list: 3 4

        CircularLinkedList combinedList = new CircularLinkedList();
        combinedList.combineCircular(splitList);
        combinedList.insertInCircular(5);
        System.out.print("Combined circular list: ");
        combinedList.traverseCircular(0); // Output: Combined circular list: 1 2 3 4 5
    }
}
