import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        boolean done = false;
        while (!done) {
            boolean playAgain = true;
            while (playAgain) {
                int die1 = rnd.nextInt(6) + 1;
                int die2 = rnd.nextInt(6) + 1;
                int crapsRoll = die1 + die2;
                if ((crapsRoll == 2) || (crapsRoll == 3) || (crapsRoll == 12)) {
                    System.out.println("You crapped out, better luck next time! Your roll was: " + crapsRoll);
                    playAgain = false;
                } else if ((crapsRoll == 7) || (crapsRoll == 11)) {
                    System.out.println("You rolled a natural, congratulations! Your roll was: " + crapsRoll);
                    playAgain = false;
                } else {
                    System.out.println("Your point is: " + crapsRoll);
                    boolean pointFinish = false;

                    while (!pointFinish) {
                        int point1 = rnd.nextInt(6) + 1;
                        int point2 = rnd.nextInt(6) + 1;
                        int pointRoll = point1 + point2;
                        if (pointRoll == crapsRoll) {
                            System.out.println("You rolled your point, congratulations you win! Your point: " + crapsRoll);
                            playAgain = false;
                            pointFinish = true;
                        } else if (pointRoll == 7) {
                            System.out.println("You rolled a 7, sorry you crapped out.");
                            playAgain = false;
                            pointFinish = true;
                        } else {
                            System.out.println("You rolled a " + pointRoll);
                        }
                    }
                }
            }

            System.out.println("Would you like to play again? Yes or No.");
            String respond = in.nextLine().trim();
            if (!respond.equalsIgnoreCase("Yes")) {
                done = true;
            }
        }
        in.close();
    }
}