
/* 
   name: Asil Asaad Mufti
   ID: 2106122
   section: DAR
 */

import java.util.concurrent.Semaphore;
import java.lang.Thread;

public class Lab6 {

    private static final int BUFFER_SIZE = 5; // Size of the buffer
    private static final int MAX_ITEMS = 20; // Maximum number of items to produce/consume
    private static int[] buffer = new int[BUFFER_SIZE]; // Buffer to hold items
    private static int in = 0; // Index for adding items to the buffer
    private static int out = 0; // Index for removing items from the buffer
    private static int produced_count = 0; // Counter for produced items
    private static int consumed_count = 0; // Counter for consumed items
    private static Semaphore mutex = new Semaphore(1); // Semaphore for mutual exclusion
    private static Semaphore full = new Semaphore(0); // Semaphore to signal when buffer is full
    private static Semaphore empty = new Semaphore(BUFFER_SIZE); // Semaphore to signal when buffer is empty

    public static void main(String[] args) throws InterruptedException {
        // Create producer and consumer threads
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        // Start the threads
        producerThread.start();
        consumerThread.start();

        // Wait for threads to finish
        producerThread.join();
        consumerThread.join();

    }

    // Producer thread 
    private static Runnable producer = new Runnable() {
        @Override
        public void run() {
            int item = 1;
            // Continue producing until reaching the maximum item count
            while (produced_count < MAX_ITEMS) {
                try {
                    empty.acquire();
                    mutex.acquire();

                    // Add item to the buffer
                    buffer[in] = item;
                    System.out.println("Produced: " + item);
                    item++;
                    in = (in + 1) % BUFFER_SIZE; // Move to the next position in the buffer

                    produced_count++; // Increment produced items counter

                    mutex.release();
                    full.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    // Consumer thread 
    private static Runnable consumer = new Runnable() {
        @Override
        public void run() {
            // Continue consuming until reaching the maximum item count
            while (consumed_count < MAX_ITEMS) {
                try {
                    full.acquire();
                    mutex.acquire();

                    // Remove item from the buffer
                    int item = buffer[out];
                    System.out.println("Consumed: " + item);
                    out = (out + 1) % BUFFER_SIZE; // Move to the next position in the buffer

                    consumed_count++; // Increment consumed items counter

                    mutex.release();
                    empty.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}
