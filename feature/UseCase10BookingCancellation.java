/**
 * ======================================================================
 * MAIN CLASS - UseCase10BookingCancellation
 * ======================================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class demonstrates how confirmed
 * bookings can be cancelled safely.
 *
 * Inventory is restored and rollback
 * history is maintained.
 *
 * @version 10.0
 */
public class UseCase10BookingCancellation {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Booking Cancellation");

        // 1. Initialize core state and services
        RoomInventory inventory = new RoomInventory(); // Single Room starts at 5 internally
        CancellationService cancelService = new CancellationService();

        // 2. Simulate a booking that already exists in the system
        // (Pre-registering it so the cancelService knows about it)
        cancelService.registerBooking("Single-1", "Single Room");

        // 3. Process the cancellation request
        cancelService.cancelBooking("Single-1", inventory);

        // 4. View the Stack (Audit Trail)
        cancelService.showRollbackHistory();

        // 5. Verify the inventory actually incremented (5 + 1 = 6)
        int updatedSingleRoomCount = inventory.getRoomAvailability().get("Single Room");
        System.out.println("\nUpdated Single Room Availability: " + updatedSingleRoomCount);
    }
}