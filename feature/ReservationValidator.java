/**
 * ======================================================================
 * CLASS - ReservationValidator
 * ======================================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * This class is responsible for validating
 * booking requests before they are processed.
 *
 * All validation rules are centralized
 * to avoid duplication and inconsistency.
 *
 * @version 9.0
 */
public class ReservationValidator {

    /**
     * Validates booking input provided by the user.
     *
     * @param guestName name of the guest
     * @param roomType requested room type
     * @param inventory centralized inventory
     * @throws InvalidBookingException if validation fails
     */
    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory
    ) throws InvalidBookingException {
        
        // Basic check for empty names
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Strict, case-sensitive check for valid room types
        if (!roomType.equals("Single") && !roomType.equals("Double") && !roomType.equals("Suite")) {
            throw new InvalidBookingException("Invalid room type selected.");
        }
        
        // Optional: You could also check the inventory here to ensure availability > 0
        // before allowing it into the queue.
    }
}