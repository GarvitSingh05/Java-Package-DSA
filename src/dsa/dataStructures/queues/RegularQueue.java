package dsa.dataStructures.queues;
import java.util.LinkedList;
import java.util.Queue;

public class RegularQueue<T> {
    private Queue<T> queue;

    public RegularQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(T element) {
        queue.offer(element);
    }

    public T dequeue() {
        return queue.poll();
    }

    public T front() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public void clear() {
        queue.clear();
    }

    public void initialize(T[] elements) {
        queue.clear();
        for (T element : elements) {
            enqueue(element);
        }
    }

    public boolean isFull(int maxSize) {
        return size() >= maxSize;
    }

    public void traverse() {
        Queue<T> tempQueue = new LinkedList<>(queue);

        System.out.print("Queue Elements: ");
        while (!tempQueue.isEmpty()) {
            System.out.print(tempQueue.poll() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RegularQueue<Integer> queue = new RegularQueue<>();

        System.out.println("Is Empty: " + queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front: " + queue.front());
        System.out.println("Size: " + queue.size());
        queue.traverse();

        int dequeued = queue.dequeue();
        System.out.println("Dequeued: " + dequeued);
        System.out.println("Size: " + queue.size());
        queue.traverse();

        queue.clear();
        System.out.println("Is Empty: " + queue.isEmpty());
    }
}

