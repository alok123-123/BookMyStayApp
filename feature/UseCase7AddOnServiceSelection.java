/**
 * ======================================================================
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * ======================================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * This class demonstrates how optional
 * services can be attached to a confirmed
 * booking.
 *
 * Services are added after room allocation
 * and do not affect inventory.
 *
 * @version 7.0
 */
public class UseCase7AddOnServiceSelection {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Add-On Service Selection");

        // Simulate an existing reservation ID from Use Case 6
        String reservationId = "Single-1";

        // Initialize the manager
        AddOnServiceManager serviceManager = new AddOnServiceManager();

        // Create some sample services
        AddOnService spa = new AddOnService("Spa", 1000.0);
        AddOnService airportPickup = new AddOnService("Airport Pickup", 500.0);

        // Attach services to the reservation
        serviceManager.addService(reservationId, spa);
        serviceManager.addService(reservationId, airportPickup);

        // Calculate the total cost
        double totalCost = serviceManager.calculateTotalServiceCost(reservationId);

        // Print results exactly as expected
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}