import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;

        boolean playAgain = true;

        try {
            while (playAgain) {
                int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                int attempts = 0;

                System.out.println("Guess the number between " + minRange + " and " + maxRange + "!");

                while (attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int guess = scanner.nextInt();

                    if (guess == randomNumber) {
                        System.out.println("Congratulations! You guessed the correct number!");
                        score++;
                        break;
                    } else if (guess < randomNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }

                    attempts++;
                }

                if (attempts == maxAttempts) {
                    System.out.println("Oops! You couldn't guess the number. The correct number was " + randomNumber + ".");
                }

                System.out.println("Your score: " + score);

                System.out.print("Do you want to play again? (yes/no): ");
                String playAgainInput = scanner.next();

                if (!playAgainInput.equalsIgnoreCase("yes")) {
                    playAgain = false;
                    System.out.println("Thank you for playing! Your final score: " + score);
                }
            }
        } finally {
            scanner.close();
        }
    }
}