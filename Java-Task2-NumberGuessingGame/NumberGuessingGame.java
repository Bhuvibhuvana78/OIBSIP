package numberguessing;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int round = 0;
        int totalWins = 0;

        System.out.println("=== NUMBER GUESSING GAME ===");

        String playAgain;

        do {
            round++;

            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\nRound " + round);
            System.out.println("Guess a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid integer.");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You won!");
                    System.out.println("Attempts used: " + attempts);
                    totalWins++;
                    guessed = true;
                    break;
                } else if (guess < number) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }

                System.out.println(
                        "Attempts remaining: " + (maxAttempts - attempts)
                );
            }

            if (!guessed) {
                System.out.println("You Lost!");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("\nRounds played: " + round);
            System.out.println("Rounds won: " + totalWins);

            System.out.print("Play again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\nThanks for playing!");

        sc.close();
    }
}

