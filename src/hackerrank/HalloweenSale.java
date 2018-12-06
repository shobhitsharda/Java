package hackerrank;

/*
 * https://www.hackerrank.com/challenges/halloween-sale/problem
 */

public class HalloweenSale {

	public static void main(final String[] args) {
		System.out.println(howManyGames(1, 1, 1, 1));
	}

	static int howManyGames(final int p, final int d, final int m, final int s) {
		int gameCount = 0;
		int currentGameValue = p;
		int totalSpent = p;

		while (totalSpent <= s) {
			gameCount++;
			currentGameValue = currentGameValue - d < m ? m : currentGameValue - d;
			totalSpent += currentGameValue;
		}

		return gameCount;
	}
}
