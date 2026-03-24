import java.util.LinkedList;
import java.util.Queue;

/**
 * ======================================================================
 * CLASS - BookingRequestQueue
 * ======================================================================
 *
 * Use Case 5: Booking Request (First-Come-First-Served)
 *
 * Description:
 * This class manages incoming booking requests using a FIFO Queue.
 * It ensures that guests are served in the exact order they applied.
 *
 * No inventory mutation or allocation happens here.
 *
 * @version 5.0
 */
public class BookingRequestQueue {

    /**
     * The FIFO queue holding incoming reservations.
     */
    private Queue<Reservation> requestQueue;

    /**
     * Initializes the empty booking queue.
     */
    public BookingRequestQueue() {
        // LinkedList is a standard implementation for a Queue in Java
        requestQueue = new LinkedList<>();
    }

    /**
     * Adds a new reservation request to the back of the queue.
     *
     * @param reservation the booking request to add
     */
    public void addRequest(Reservation reservation) {
        requestQueue.add(reservation);
        System.out.println("Request added to queue: " + reservation.getGuestName() + " for a " + reservation.getRequestedRoomType());
    }

    /**
     * Returns the current number of requests waiting in line.
     *
     * @return size of the queue
     */
    public int getQueueSize() {
        return requestQueue.size();
    }

    /**
     * Displays all requests currently waiting in the queue in order.
     */
    public void displayQueueStatus() {
        System.out.println("\nCurrent Booking Queue Status:");
        if (requestQueue.isEmpty()) {
            System.out.println("The queue is currently empty.");
        } else {
            int position = 1;
            for (Reservation res : requestQueue) {
                System.out.println(position + ". " + res.getGuestName() + " (" + res.getRequestedRoomType() + ")");
                position++;
            }
        }
        System.out.println("Total requests pending: " + requestQueue.size() + "\n");
    }
}