import java.util.Random;
import java.util.Scanner;
public class FullGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int maxAttempts = 7;
            int attemptsTaken = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nNew Round! Guess the number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attemptsTaken < maxAttempts) {
                System.out.print("Enter your guess: ");
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                int guess = scanner.nextInt();
                attemptsTaken++;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed the number in " + attemptsTaken + " attempts.");
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attemptsTaken));
            }

            roundsPlayed++;
            if (guessedCorrectly) {
                roundsWon++;
            } else {
                System.out.println("You used all attempts! The correct number was: " + numberToGuess);
            }

            // Display score
            System.out.println("Score: " + roundsWon + " wins out of " + roundsPlayed + " rounds.");

            // Ask if the user wants to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // clear the buffer
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
                System.out.println("Thanks for playing! Final Score:");
                System.out.println(roundsWon + " wins out of " + roundsPlayed + " rounds.");
            }
        }

        scanner.close();
    }
}


OUTPUT:


Welcome to the Number Guessing Game!

New Round! Guess the number between 1 and 100.
You have 7 attempts.
Enter your guess: 78
Too low!
Attempts left: 6
Enter your guess: 89
Too low!
Attempts left: 5
Enter your guess: 98
Too high!
Attempts left: 4
Enter your guess: 95
Too low!
Attempts left: 3
Enter your guess: 96
Too low!
Attempts left: 2
Enter your guess: 97
Correct! You guessed the number in 6 attempts.
Score: 1 wins out of 1 rounds.
Do you want to play another round? (yes/no): n0
Thanks for playing! Final Score:
1 wins out of 1 rounds.


