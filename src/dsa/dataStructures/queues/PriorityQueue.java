package dsa.dataStructures.queues;
import java.util.*;

public class PriorityQueue<T> {
    
    private static class Element<T> {
        T element;
        int priority;

        Element(T element, int priority) {
            this.element = element;
            this.priority = priority;
        }
    }

    private java.util.PriorityQueue<Element<T>> priorityQueue;

    public PriorityQueue() {
        priorityQueue = new java.util.PriorityQueue<>(Comparator.comparingInt(e -> e.priority));
    }

    public void enqueueWithPriority(T element, int priority) {
        priorityQueue.offer(new Element<>(element, priority));
    }

    public T extractHighestPriority() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty");
        }
        return priorityQueue.poll().element;
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        System.out.println("Is Empty: " + priorityQueue.isEmpty());

        priorityQueue.enqueueWithPriority("Item A", 2);
        priorityQueue.enqueueWithPriority("Item B", 1);
        priorityQueue.enqueueWithPriority("Item C", 3);

        System.out.println("Highest Priority: " + priorityQueue.extractHighestPriority());
        System.out.println("Is Empty: " + priorityQueue.isEmpty());
    }
}
