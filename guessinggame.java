import java.util.Scanner;
public class guessinggame {
    
        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            Scanner range = new Scanner(System.in);
            int minRange = 1;
            int maxRange = 100;
            int maxAttempts = 10;
            int rounds = 0;
            int score = 0;
    
            System.out.println("Welcome to the Number Guessing Game!");
    
            while (true) {
                int targetNumber = generateRandomNumber(minRange, maxRange);
                int attempts = 0;
    
                System.out.println("Round " + (rounds + 1) + ": Guess the number between " + minRange + " and " + maxRange + ".");
    
                while (attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int userGuess = input.nextInt();
                    attempts++;
    
                    if (userGuess < minRange || userGuess > maxRange) {
                        System.out.println("Your guess is out of range. Try again.");
                    } else if (userGuess < targetNumber) {
                        System.out.println("Too low. Try again.");
                    } else if (userGuess > targetNumber) {
                        System.out.println("Too high. Try again.");
                    } else {
                        System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                        score += maxAttempts - attempts + 1;
                        break;
                    }
                }
    
                if (attempts >= maxAttempts) {
                    System.out.println("You've reached the maximum number of attempts. The correct number was: " + targetNumber);
                }
    
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = input.next();
    
                if (!playAgain.equalsIgnoreCase("yes")) {
                    break;
                }
    
                rounds++;
            }
    
            System.out.println("Game Over! Your total score is: " + score);
        }
    
        // Custom random number generator within a range
        public static int generateRandomNumber(int min, int max) {
            return min + (int) (Math.random() * (max - min + 1));
        }
    }
        
