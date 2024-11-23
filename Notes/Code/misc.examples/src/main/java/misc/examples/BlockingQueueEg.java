package misc.examples;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueEg {

    public static void main(String[] args) throws InterruptedException {
        // Create a BlockingQueue with capacity of 10 elements
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        // Start the producer and consumer threads
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();

        // Wait for the threads to finish (optional in this case)
        producer.join();
        consumer.join();
    }
}

class Producer implements Runnable {
    private final BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            // Produce 5 items
            for (int i = 1; i <= 5; i++) {
                String item = "Item " + i;
                System.out.println("Producing: " + item);
                queue.put(item); // put() blocks if the queue is full
                Thread.sleep(1000); // Simulate some delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            // Consume 5 items
            for (int i = 1; i <= 5; i++) {
                String item = queue.take(); // take() blocks if the queue is empty
                System.out.println("Consuming: " + item);
                Thread.sleep(1500); // Simulate processing time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
