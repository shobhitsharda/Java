package hackerrank;

public class Staircase {

	/*
	 * https://www.hackerrank.com/challenges/staircase/problem
	 */

	public static void main(final String[] args) {
		final int n = 4;

		for (int i = 1; i <= n; i++) {
			for (int k = 0; k < n - i; k++) {
				System.out.print(" ");
			}

			for (int j = 0; j < i; j++) {
				System.out.print("#");
			}

			System.out.println("");
		}
	}
}
