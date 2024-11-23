package misc.examples;

import java.util.Deque;
import java.util.ArrayDeque;
//Double Ended Queue
public class DequeEg {
    public static void main(String[] args) {
        // Create a Deque using ArrayDeque
        Deque<String> deque = new ArrayDeque<>();

        // Add elements at the front and rear of the deque
        deque.offerFirst("Apple");  // Adds "Apple" to the front
        deque.offerLast("Banana");  // Adds "Banana" to the rear
        deque.offerFirst("Cherry"); // Adds "Cherry" to the front
        deque.offerLast("Date");    // Adds "Date" to the rear

        // Display the deque
        System.out.println("Deque after adding elements: " + deque);

        // Remove elements from the front and rear of the deque
        System.out.println("Removed from front: " + deque.pollFirst());  // Removes "Cherry"
        System.out.println("Removed from rear: " + deque.pollLast());   // Removes "Date"

        // Display the deque after removal
        System.out.println("Deque after removals: " + deque);

        // Peek at the front and rear elements without removing
        System.out.println("Front of the deque: " + deque.peekFirst());  // "Apple"
        System.out.println("Rear of the deque: " + deque.peekLast());    // "Banana"
    }
}