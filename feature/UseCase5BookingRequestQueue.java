/**
 * ======================================================================
 * MAIN CLASS - UseCase5BookingRequestQueue
 * ======================================================================
 *
 * Use Case 5: Booking Request (First-Come-First-Served)
 *
 * Description:
 * This class demonstrates how the system handles
 * multiple booking requests by placing them in a FIFO queue.
 *
 * @version 5.0
 */
public class UseCase5BookingRequestQueue {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hotel Booking System - Request Intake\n");

        // Initialize the queue service
        BookingRequestQueue queueService = new BookingRequestQueue();

        // Simulate guests submitting booking requests
        queueService.addRequest(new Reservation("Alice Smith", "Single Room"));
        queueService.addRequest(new Reservation("Bob Jones", "Suite Room"));
        queueService.addRequest(new Reservation("Charlie Brown", "Double Room"));
        queueService.addRequest(new Reservation("Diana Prince", "Single Room"));

        // Display the state of the queue to prove FIFO order is maintained
        queueService.displayQueueStatus();
    }
}