import java.util.LinkedList;
import java.util.Queue;

/**
 * ======================================================================
 * MAIN CLASS - UseCase6RoomAllocation
 * ======================================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class demonstrates how booking
 * requests are confirmed and rooms
 * are allocated safely.
 *
 * It consumes booking requests in FIFO
 * order and updates inventory immediately.
 *
 * @version 6.0
 */
public class UseCase6RoomAllocation {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // 1. Initialize State and Services
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();
        
        // 2. Set up the FIFO Queue (representing incoming requests from Use Case 5)
        Queue<Reservation> bookingQueue = new LinkedList<>();
        bookingQueue.add(new Reservation("Abhi", "Single Room"));
        bookingQueue.add(new Reservation("Subha", "Single Room"));
        bookingQueue.add(new Reservation("Vanmathi", "Suite Room"));
        
        System.out.println("Room Allocation Processing");
        
        // 3. Process requests in FIFO order
        while (!bookingQueue.isEmpty()) {
            Reservation nextRequest = bookingQueue.poll(); // Dequeues the oldest request
            allocationService.allocateRoom(nextRequest, inventory);
        }
    }
}