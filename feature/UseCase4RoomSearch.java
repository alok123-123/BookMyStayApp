package feature;
/**
 * ======================================================================
 * MAIN CLASS - UseCase4RoomSearch
 * ======================================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * This class demonstrates how guests
 * can view available rooms without
 * modifying inventory data.
 *
 * The system enforces read-only access
 * by design and usage discipline.
 *
 * @version 4.0
 */
public class UseCase4RoomSearch {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // 1. Initialize domain models (Room types)
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // 2. Initialize state manager (Centralized Inventory)
        RoomInventory inventory = new RoomInventory();

        // 3. Initialize the service layer
        RoomSearchService searchService = new RoomSearchService();

        // 4. Execute read-only search
        searchService.searchAvailableRooms(inventory, singleRoom, doubleRoom, suiteRoom);
    }
}