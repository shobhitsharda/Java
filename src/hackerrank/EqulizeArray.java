package hackerrank;

public class EqulizeArray {

	/*
	 * https://www.hackerrank.com/challenges/equality-in-a-array/problem
	 */

	public static void main(final String[] args) {

	}

	public static int equalizeArray(final int[] arr) {
		final int[] helperArr = new int[100];
		int max = 0;

		for (final int i : arr) {
			helperArr[i]++;

			if (helperArr[i] > max) {
				max = helperArr[i];
			}
		}

		return arr.length - max;
	}
}
