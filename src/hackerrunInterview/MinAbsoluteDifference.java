package hackerrunInterview;

import java.util.Arrays;

public class MinAbsoluteDifference {

	public static void main(final String[] args) {
		System.out.println(minimumAbsoluteDifference(new int[] { 0, -3, 7 }));

	}

	// Complete the minimumAbsoluteDifference function below.
	static int minimumAbsoluteDifference(final int[] arr) {
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		int currentMin = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			currentMin = Math.abs(arr[i] - arr[i + 1]);

			if (currentMin < min) {
				min = currentMin;
			}
		}

		return min;
	}
}
