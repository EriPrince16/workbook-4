import java.util.Scanner;

public class Main {

    static Room room = new Room(2, 100.00, false, false); // single shared room instance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayHomeMenu(scanner);
            System.out.print("\nWould you like to perform another action? (yes/no): ");
            String again = scanner.nextLine();
            running = again.equalsIgnoreCase("yes");
        }

        scanner.close();
        System.out.println("Thank you for visiting Million's Hotel. Goodbye!");
    }

    public static void displayHomeMenu(Scanner scanner) {
        System.out.println("\n===== Welcome to Million's Hotel =====");
        System.out.println("C) Check pricing for room type");
        System.out.println("R) Make a Reservation");
        System.out.println("E) View employee payroll information");
        System.out.println("I) Check into a room");
        System.out.println("O) Check out of a room");
        System.out.println("L) Clean a room");
        System.out.println("X) Exit");
        System.out.print("Choose your option: ");
        String userChoice = scanner.nextLine();

        switch (userChoice.toUpperCase()) {
            case "C":
                checkPricing(scanner);
                break;
            case "R":
                makeReservation(scanner);
                break;
            case "E":
                viewEmployeePayroll(scanner);
                break;
            case "I":
                checkIntoRoom();
                break;
            case "O":
                checkOutOfRoom();
                break;
            case "L":
                cleanRoom();
                break;
            case "X":
                System.exit(0);
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
            int numberOfNights = Integer.parseInt(scanner.nextLine());
            reservation.setNumberOfNights(numberOfNights);

            System.out.print("Is it a weekend? (yes/no): ");
            boolean isWeekend = scanner.nextLine().equalsIgnoreCase("yes");
            reservation.setWeekend(isWeekend);

            double totalPrice = reservation.getPrice() * numberOfNights;
            if (isWeekend) {
                totalPrice *= 1.10;
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

    public static void viewEmployeePayroll(Scanner scanner) {
        try {
            System.out.print("Enter Employee ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            System.out.print("Enter Pay Rate ($/hour): ");
            double payRate = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter Hours Worked: ");
            double hoursWorked = Double.parseDouble(scanner.nextLine());

            Employee employee = new Employee(id, name, department, payRate, hoursWorked);

            System.out.println("\n--- Employee Payroll ---");
            System.out.println("Name: " + employee.getName());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("Hours Worked: " + employee.getHoursWorked());
            System.out.println("Regular Hours: " + employee.getRegularHours());
            System.out.println("Overtime Hours: " + employee.getOvertimeHours());
            System.out.printf("Total Pay: $%.2f%n", employee.getTotalPay());

        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered. Please try again.");
        }
    }

    public static void checkIntoRoom() {
        if (room.isAvailable()) {
            room.checkIn();
            System.out.println("Guest has been checked in. Room is now occupied and dirty.");
        } else {
            System.out.println("Room is not available for check-in.");
        }
    }

    public static void checkOutOfRoom() {
        if (room.isOccupied()) {
            room.checkOut();
            System.out.println("Guest has checked out. Room needs to be cleaned.");
        } else {
            System.out.println("Room is not currently occupied.");
        }
    }

    public static void cleanRoom() {
        if (room.isDirty() && !room.isOccupied()) {
            room.cleanRoom();
            System.out.println("Room has been cleaned and is now available.");
        } else {
            System.out.println("Room is either already clean or still occupied.");
        }
    }
}