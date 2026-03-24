import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ======================================================================
 * CLASS - RoomAllocationService
 * ======================================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class is responsible for confirming
 * booking requests and assigning rooms.
 *
 * It ensures:
 * - Each room ID is unique
 * - Inventory is updated immediately
 * - No room is double-booked
 *
 * @version 6.0
 */
public class RoomAllocationService {

    /**
     * Stores all allocated room IDs to
     * prevent duplicate assignments.
     */
    private Set<String> allocatedRoomIds;

    /**
     * Stores assigned room IDs by room type.
     *
     * Key   -> Room type
     * Value -> Set of assigned room IDs
     */
    private Map<String, Set<String>> assignedRoomsByType;

    /**
     * Initializes allocation tracking structures.
     */
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Confirms a booking request by assigning
     * a unique room ID and updating inventory.
     *
     * @param reservation booking request
     * @param inventory centralized room inventory
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRequestedRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();
        
        // Check if there is inventory left for this room type
        int currentAvailable = availability.getOrDefault(roomType, 0);

        if (currentAvailable > 0) {
            // 1. Generate unique room ID
            String roomId = generateRoomId(roomType);
            
            // 2. Record it to prevent reuse (prevent double booking)
            allocatedRoomIds.add(roomId);
            assignedRoomsByType.get(roomType).add(roomId);
            
            // 3. Decrement inventory immediately
            inventory.updateAvailability(roomType, currentAvailable - 1);
            
            // 4. Confirm reservation
            System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() + ", Room ID: " + roomId);
        } else {
            System.out.println("Booking failed for Guest: " + reservation.getGuestName() + " - No " + roomType + " available.");
        }
    }

    /**
     * Generates a unique room ID
     * for the given room type.
     *
     * @param roomType type of room
     * @return unique room ID
     */
    private String generateRoomId(String roomType) {
        // Ensure the inner Set exists for this room type
        assignedRoomsByType.putIfAbsent(roomType, new HashSet<>());
        
        // Calculate the next ID number based on how many are already assigned
        int nextNumber = assignedRoomsByType.get(roomType).size() + 1;
        
        // Extract the prefix (e.g., gets "Single" from "Single Room")
        String prefix = roomType.split(" ")[0]; 
        
        return prefix + "-" + nextNumber;
    }
}