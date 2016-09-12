package lab12;

import java.util.Scanner;

public class Roshamboapp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Player opponent;
		String opponentChoice;
		Player randomPlayer = new RandomPlayer();
		Player humanPlayer = new HumanPlayer();
		Roshambo humanResult;
		Roshambo opponentResult;
		String playAgain = "y";

		System.out.println("Get ready to play Roshambo.");
		System.out.println("What is your name?");
		humanPlayer.setName(sc.next());
		sc.nextLine();
		while (playAgain.equalsIgnoreCase("y")) {
			while (true) {
				System.out.println("Do you want to play against a predictable opponent? (y/n)");
				opponentChoice = sc.next();
				if (opponentChoice.equalsIgnoreCase("y")) {
					opponent = new RockPlayer();
					break;
				} else if (opponentChoice.equalsIgnoreCase("n")) {
					opponent = new RandomPlayer();
					break;
				} else {
					System.out.println("Please choose Y for yes or N for no.");
					continue;
				}
			}
			humanResult = humanPlayer.generateRoshambo();
			opponentResult = opponent.generateRoshambo();
			System.out.println(humanPlayer.getName() + " threw: " + humanResult);
			System.out.println("Opponent throws: " + opponentResult);

			switch (humanResult) {
			case ROCK:
				if (opponentResult == Roshambo.PAPER) {
					System.out.println("Dang, you lost.");
					humanPlayer.losses++;
				} else if (opponentResult == Roshambo.ROCK) {
					System.out.println("It's a tie!  Nobody wins.");
					humanPlayer.ties++;
				} else {
					System.out.println("You won!  Woo!");
					humanPlayer.wins++;
				}
				break;
			case PAPER:
				if (opponentResult == Roshambo.SCISSORS) {
					System.out.println("Uh oh, you lost.");
					humanPlayer.losses++;
				} else if (opponentResult == Roshambo.PAPER) {
					System.out.println("It's a tie!  Nobody wins.");
					humanPlayer.ties++;
				} else {
					System.out.println("You won!  Woo!");
					humanPlayer.wins++;
				}
				break;
			case SCISSORS:
				if (opponentResult == Roshambo.ROCK) {
					System.out.println("You lost.  Better luck next time.");
					humanPlayer.losses++;
				} else if (opponentResult == Roshambo.SCISSORS) {
					System.out.println("It's a tie!  Nobody wins.");
					humanPlayer.ties++;
				} else {
					System.out.println("You won!  Woo!");
					humanPlayer.wins++;
				}
				break;
			default:

			}
			System.out.println("\nWins: " + humanPlayer.wins + "\nLosses: " + humanPlayer.losses + "\nTies: " 
			+ humanPlayer.ties + "\nTotal games: " + (humanPlayer.wins + humanPlayer.losses + humanPlayer.ties));
			sc.nextLine();
			System.out.println("\nWould you like to play again? (y/n)");
			playAgain = sc.next();
		}
		System.out.println("Goodbye.");
	}
}


