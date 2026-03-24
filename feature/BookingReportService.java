import java.util.List;

/**
 * ======================================================================
 * CLASS - BookingReportService
 * ======================================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * This class generates reports
 * from booking history data.
 *
 * Reporting logic is separated
 * from data storage.
 *
 * @version 8.0
 */
public class BookingReportService {

    /**
     * Displays a summary report
     * of all confirmed bookings.
     *
     * @param history booking history
     */
    public void generateReport(BookingHistory history) {
        System.out.println("Booking History Report");
        
        List<Reservation> reservations = history.getConfirmedReservations();
        
        for (Reservation res : reservations) {
            System.out.println("Guest: " + res.getGuestName() + ", Room Type: " + res.getRequestedRoomType());
        }
    }
}