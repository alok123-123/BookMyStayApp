import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ======================================================================
 * CLASS - CancellationService
 * ======================================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class is responsible for handling
 * booking cancellations.
 *
 * It ensures that:
 * - Cancelled room IDs are tracked
 * - Inventory is restored correctly
 * - Invalid cancellations are prevented
 *
 * A stack is used to model rollback behavior.
 *
 * @version 10.0
 */
public class CancellationService {

    /** Stack that stores recently released room IDs. */
    private Stack<String> releasedRoomIds;

    /** Maps reservation ID to room type. */
    private Map<String, String> reservationRoomTypeMap;

    /** Initializes cancellation tracking structures. */
    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    /**
     * Registers a confirmed booking.
     *
     * This method simulates storing confirmation
     * data that will later be required for cancellation.
     *
     * @param reservationId confirmed reservation ID
     * @param roomType allocated room type
     */
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    /**
     * Cancels a confirmed booking and
     * restores inventory safely.
     *
     * @param reservationId reservation to cancel
     * @param inventory centralized room inventory
     */
    public void cancelBooking(String reservationId, RoomInventory inventory) {
        if (reservationRoomTypeMap.containsKey(reservationId)) {
            String roomType = reservationRoomTypeMap.get(reservationId);
            
            // 1. Record the cancelled ID in our rollback stack (LIFO)
            releasedRoomIds.push(reservationId);
            
            // 2. Safely restore the inventory (+1)
            Map<String, Integer> availability = inventory.getRoomAvailability();
            int currentAvailable = availability.getOrDefault(roomType, 0);
            inventory.updateAvailability(roomType, currentAvailable + 1);
            
            // 3. Remove from active reservations to prevent double-cancellations
            reservationRoomTypeMap.remove(reservationId);
            
            // Formatting the output to perfectly match the assignment's expected snapshot
            String displayType = roomType.replace(" Room", "");
            System.out.println("Booking cancelled successfully. Inventory restored for room type: " + displayType);
        } else {
            System.out.println("Cancellation failed: Invalid reservation ID.");
        }
    }

    /**
     * Displays recently cancelled reservations.
     *
     * This method helps visualize rollback order.
     */
    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");
        
        // Iterating through the stack backwards to display the Last-In-First-Out order
        for (int i = releasedRoomIds.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + releasedRoomIds.get(i));
        }
    }
}