import java.util.Scanner;

public class GuessingNumGame {
    public static void guessingNumber() {

        Scanner input = new Scanner(System.in);

        System.out.println("Valid numbers are between 1 and 10,000");
        System.out.print("Play the game from number 1 to ?: ");
        int number = input.nextInt();

        if (number >= 1 && number <= 10000) {

            int randomNum = (int) Math.floor(Math.random() * number) + 1;
            int tries = 0;

            System.out.print("Enter your guess number: ");
            int guess = input.nextInt();

            while (true) {
                if (randomNum == guess) {
                    System.out.println("\n------------congratulations-------------");
                    System.out.println("You're right! This is the right number.  ");
                    System.out.println("You won the game after " + tries + " tries.");
                    System.out.println("-----------------------------------------");
                    break;
                } else if (randomNum < guess) {
                    System.out.print("Too high: Try again Enter your guess number: ");
                    guess = input.nextInt();
                    tries++;
                } else if (randomNum > guess) {
                    System.out.print("Too Low: Try again Enter your guess number: ");
                    guess = input.nextInt();
                    tries++;
                }
            }
        } else {
            System.out.println("You entered an invalid number. You are out of the game.");
        }

    }

    public static void main(String[] args) {
        guessingNumber();
    }
}
