import java.util.Scanner;

public class BookMyStayApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Welcome to BookMyStay ---");
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        
        System.out.print("Enter number of nights: ");
        int nights = scanner.nextInt();
        
        int totalCost = nights * 100;
        
        System.out.println("\n--- Booking Confirmed ---");
        System.out.println("Guest: " + name);
        System.out.println("Destination: " + destination);
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("Thank you for booking with us!");
        
        scanner.close();
    }
}
