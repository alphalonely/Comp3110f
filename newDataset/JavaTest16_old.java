import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessMaker {
    private Person[] people;
    private int personCount;
    private int currentPerson;

    // Constructor to initialize with three people
    public GuessMaker(Person p1, Person p2, Person p3) {
        people = new Person[10]; // Assume max 10 persons
        people[0] = p1;
        people[1] = p2;
        people[2] = p3;
        personCount = 3;
        currentPerson = 0;
    }

    // Add a new person if the array is not full
    public void addPerson(Person person) {
        if (personCount >= people.length) {
            System.out.println("Cannot add more people, array is full.");
            return;
        }
        people[personCount] = person;
        personCount++;
    }

    // Main game loop
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Birthday Guessing Game!");

        while (true) {
            System.out.println("\nSelect a person to guess their birthday:");
            for (int i = 0; i < personCount; i++) {
                Person p = people[i];
                System.out.printf("%d. %s (%s)%n", i + 1, p.getName(), p.getCountry());
            }
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (choice < 1 || choice > personCount) {
                    System.out.println("Choice out of range. Try again.");
                } else {
                    currentPerson = choice - 1;
                    break; // valid input and in range
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Input. Please enter 1, or 2, or 3.");
                scanner.nextLine(); // clear invalid input
            }
        }
            Person selected = people[currentPerson];
            Date target = selected.getBirthday();

            while (true) {
                System.out.print("Enter birthday (DD/MM/YYYY or MMM DD, YYYY), or type 'quit': ");
                String guessInput = scanner.nextLine().trim();

                if (guessInput.equalsIgnoreCase("quit")) {
                    System.out.println("Thanks for playing. Goodbye!");
                    return;
                }

                try {
                    Date guess = new Date(guessInput);
                    

                    if (guess.equals(target)) {
                        System.out.println("Congratulations! You guessed correctly!");
                        System.out.println(selected.toString());
                        break;
                    } else if (guess.isBefore(target)) {
                        System.out.println("Too early. Try again.");
                    } else {
                        System.out.println("Too late. Try again.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error\n" + e.getMessage());
                }
              
                scanner.close(); }

        }
      
    

    // Main method for testing
    public static void main(String[] args) {
        Person p1 = new Person("Albert Einstein", new Date(14, 3, 1879), "Germany");
        Person p2 = new Person("Marie Curie", new Date("Nov 7, 1867"), "Poland");
        Person p3 = new Person("Ada Lovelace", new Date(10, 12, 1815), "UK");

        GuessMaker game = new GuessMaker(p1, p2, p3);
        game.startGame();
        
    }
}
