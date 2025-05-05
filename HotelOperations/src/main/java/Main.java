import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        displayHomeMenu(scanner);
        scanner.close();
    }

    public static void displayHomeMenu(Scanner scanner) {

        System.out.println("\n===== Welcome to Million's Hotel =====");
        System.out.println("\nC) Check pricing for room type");
        System.out.println("\nR) Make a Reservation");
        System.out.println("\nX) Close out of application");
        System.out.print("\nChoose your option: ");
        String userChoice = scanner.nextLine();

        switch (userChoice.toUpperCase()) {
            case "C":
                checkPricing(scanner);
                break;
            case "R":
                makeReservation(scanner);
                break;
            case "X":
                System.out.println("Thank you for visiting Million's Hotel. Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public static void checkPricing(Scanner scanner) {
        System.out.print("Enter room type (king/double): ");
        String roomType = scanner.nextLine();
        Reservation reservation = new Reservation();

        try {
            reservation.setRoomType(roomType);
            double price = reservation.getPrice();
            System.out.println("Price for " + roomType.toLowerCase() + " room: $" + price);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void makeReservation(Scanner scanner) {
        Reservation reservation = new Reservation();

        try {
            System.out.print("Enter room type (king/double): ");
            String roomType = scanner.nextLine();
            reservation.setRoomType(roomType);

            System.out.print("Enter number of nights: ");
            String nightsInput = scanner.nextLine();
            int numberOfNights = Integer.parseInt(nightsInput);
            reservation.setNumberOfNights(numberOfNights);

            System.out.print("Is it a weekend? (yes/no): ");
            String weekendInput = scanner.nextLine();
            boolean isWeekend = weekendInput.equalsIgnoreCase("yes");
            reservation.setWeekend(isWeekend);

            double totalPrice = reservation.getPrice() * numberOfNights;
            if (isWeekend) {
                totalPrice *= 1.2; // Apply 20% increase for weekends
            }

            System.out.println("\n--- Reservation Summary ---");
            System.out.println("Room Type: " + reservation.getRoomType());
            System.out.println("Number of Nights: " + reservation.getNumberOfNights());
            System.out.println("Weekend: " + (reservation.isWeekend() ? "Yes" : "No"));
            System.out.printf("Total Price: $%.2f%n", totalPrice);

        } catch (Exception e) {
            System.out.println("Error during reservation: " + e.getMessage());
        }
    }
}