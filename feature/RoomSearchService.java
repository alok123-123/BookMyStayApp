package feature;
import java.util.Map;

/**
 * ======================================================================
 * CLASS - RoomSearchService
 * ======================================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * This class provides search functionality
 * for guests to view available rooms.
 *
 * It reads room availability from inventory
 * and room details from Room objects.
 *
 * No inventory mutation or booking logic
 * is performed in this class.
 *
 * @version 4.0
 */
public class RoomSearchService {

    /**
     * Displays available rooms along with
     * their details and pricing.
     *
     * This method performs read-only access
     * to inventory and room data.
     *
     * @param inventory   centralized room inventory
     * @param singleRoom  single room definition
     * @param doubleRoom  double room definition
     * @param suiteRoom   suite room definition
     */
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Room Search\n");

        // Check and display Single Room availability
        if (availability.getOrDefault("Single Room", 0) > 0) {
            System.out.println("Single Room:");
            singleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Single Room") + "\n");
        }

        // Check and display Double Room availability
        if (availability.getOrDefault("Double Room", 0) > 0) {
            System.out.println("Double Room:");
            doubleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Double Room") + "\n");
        }

        // Check and display Suite Room availability
        if (availability.getOrDefault("Suite Room", 0) > 0) {
            System.out.println("Suite Room:");
            suiteRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Suite Room"));
        }
    }
}