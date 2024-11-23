package misc.examples;

import java.util.Queue;
import java.util.LinkedList;

public class QueueEg {
    public static void main(String[] args) {
        // Create a Queue using LinkedList
        Queue<String> queue = new LinkedList<>();

        // Enqueue elements (add elements to the queue)
        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Cherry");

        // Display the elements in the queue
        System.out.println("Queue: " + queue);

        // Dequeue elements (remove elements from the queue)
        System.out.println("Dequeued: " + queue.poll());  // Removes "Apple"
        System.out.println("Dequeued: " + queue.poll());  // Removes "Banana"

        // Display the remaining elements
        System.out.println("Queue after dequeue: " + queue);

        // Peek at the front of the queue (without removing)
        System.out.println("Front of the queue: " + queue.peek());  // Shows "Cherry" but doesn't remove it
    }
}