/**
 * ======================================================================
 * CLASS - Reservation
 * ======================================================================
 *
 * Use Case 5: Booking Request (First-Come-First-Served)
 *
 * Description:
 * This class represents a guest's intent to book a room.
 * It stores the guest's name and the type of room they want.
 *
 * @version 5.0
 */
public class Reservation {
    private String guestName;
    private String requestedRoomType;

    /**
     * Constructs a new booking request.
     *
     * @param guestName name of the guest
     * @param requestedRoomType type of room requested
     */
    public Reservation(String guestName, String requestedRoomType) {
        this.guestName = guestName;
        this.requestedRoomType = requestedRoomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRequestedRoomType() {
        return requestedRoomType;
    }

    @Override
    public String toString() {
        return "Reservation[Guest: " + guestName + ", Room: " + requestedRoomType + "]";
    }
}