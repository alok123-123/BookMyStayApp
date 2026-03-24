/**
 * ======================================================================
 * MAIN CLASS - UseCase2RoomInitialization
 * ======================================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This class demonstrates room initialization
 * using domain models before introducing
 * centralized inventory management.
 *
 * Availability is represented using
 * simple variables to highlight limitations.
 *
 * @version 2.1
 */
public class UseCase2RoomInitialization {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Initialize room objects using polymorphism
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Storing availability using simple variables (intentionally static)
        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability = 2;

        // Console Output
        System.out.println("Hotel Room Initialization\n");

        System.out.println("Single Room:");
        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailability + "\n");

        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailability + "\n");

        System.out.println("Suite Room:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailability);
    }
}