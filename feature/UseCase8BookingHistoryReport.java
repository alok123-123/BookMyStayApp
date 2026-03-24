/**
 * ======================================================================
 * MAIN CLASS - UseCase8BookingHistoryReport
 * ======================================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * This class demonstrates how
 * confirmed bookings are stored
 * and reported.
 *
 * The system maintains an ordered
 * audit trail of reservations.
 *
 * @version 8.0
 */
public class UseCase8BookingHistoryReport {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Booking History and Reporting\n");

        // Initialize history and reporting services
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        // Simulate confirmed bookings (acting as the output from Use Case 6)
        // Using "Single", "Double", and "Suite" to match the exact expected output format
        Reservation res1 = new Reservation("Abhi", "Single");
        Reservation res2 = new Reservation("Subha", "Double");
        Reservation res3 = new Reservation("Vanmathi", "Suite");

        // Add confirmed bookings to the historical audit trail
        history.addReservation(res1);
        history.addReservation(res2);
        history.addReservation(res3);

        // Generate the admin report
        reportService.generateReport(history);
    }
}