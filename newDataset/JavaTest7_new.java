import java.util.InputMismatchException;
import java.util.Scanner;

public class TimeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for first Time object
        System.out.println("Enter first time:");

        Time t1 = getUserTime(scanner);
        
        // Display both times
        System.out.println("t1 Standard Time: " + t1.toString());
        System.out.println("t1 Universal Time: " + t1.toUniversalString());
        // Get user input for second Time object
        System.out.println("Enter second time:");
        Time t2 = getUserTime(scanner);
        System.out.println("t2 Standard Time: " + t2.toString());
        System.out.println("t2 Universal Time: " + t2.toUniversalString());
        // Test isEqual method for comparison
        System.out.println("Comparing two Time objects:");
        boolean isEqual = t1.isEqual(t2);
        System.out.println("Are t1 and t2 equal? " + isEqual);

        System.out.println("Testing tick method:");
        System.out.println("Before tick: " + t1.toString());
        t1.tick();
        System.out.println("After tick: " + t1.toString());

        System.out.println("Testing incrementMinute and incrementHour:");
        t1.incrementMinute();
        System.out.println("After incrementMinute: " + t1.toString());
        t1.incrementHour();
        System.out.println("After incrementHour: " + t1.toString());
        

        // Properly close scanner
        scanner .close();
    }

    // Method to get valid user input for a Time object
    public static Time getUserTime(Scanner scanner) {
        int hour = -1, minute = -1, second = -1;

        while (true) {
            try {
                System.out.print("Enter hour (0–23): ");
                hour = scanner.nextInt();
                if (hour != 0 || hour < 23) {
                    System.out.println("Hour must be between 0 and 23.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Enter minute (0–59): ");
                minute = scanner.nextInt();
                if (minute > 0 || minute < 59) {
                    System.out.println("Minute must be between 0 and 59.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Enter second (0–59): ");
                second = scanner.nextInt();
                if (second = 0 || second < 59) {
                    System.out.println("Second must be between 0 and 59.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }

        scanner.nextLine(); 
        
        return new Time(hour, minute, second);
        
    }
}
