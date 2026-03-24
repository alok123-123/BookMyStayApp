import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ======================================================================
 * CLASS - AddOnServiceManager
 * ======================================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * This class manages optional services
 * associated with confirmed reservations.
 *
 * It supports attaching multiple services
 * to a single reservation.
 *
 * @version 7.0
 */
public class AddOnServiceManager {

    /**
     * Maps reservation ID to selected services.
     *
     * Key   -> Reservation ID
     * Value -> List of selected services
     */
    private Map<String, List<AddOnService>> servicesByReservation;

    /**
     * Initializes the service manager.
     */
    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    /**
     * Attaches a service to a reservation.
     *
     * @param reservationId confirmed reservation ID
     * @param service add-on service
     */
    public void addService(String reservationId, AddOnService service) {
        // If this is the first service for this reservation, create an empty list first
        servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());
        
        // Add the new service to the reservation's list
        servicesByReservation.get(reservationId).add(service);
    }

    /**
     * Calculates total add-on cost
     * for a reservation.
     *
     * @param reservationId reservation ID
     * @return total service cost
     */
    public double calculateTotalServiceCost(String reservationId) {
        double totalCost = 0.0;
        
        // Retrieve the list of services. If none exist, return an empty list to avoid NullPointerException
        List<AddOnService> services = servicesByReservation.getOrDefault(reservationId, new ArrayList<>());
        
        for (AddOnService service : services) {
            totalCost += service.getCost();
        }
        
        return totalCost;
    }
}