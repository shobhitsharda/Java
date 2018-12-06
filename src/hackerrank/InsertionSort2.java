package hackerrank;

public class InsertionSort2 {

	/*
	 * https://www.hackerrank.com/challenges/insertionsort2/problem
	 */

	public static void main(final String[] args) {
		final int[] arr = new int[] { 4, 4, 3, 4 };
		insertionSort2(4, arr);
	}

	static void insertionSort2(final int n, final int[] arr) {
		int temp = 0;
		int swapCount = 0;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;

					swapCount++;
				}
			}

			printArr(arr);
		}

		System.out.println("swapCount: " + swapCount);
	}

	private static void printArr(final int[] arr) {
		for (final int a : arr) {
			System.out.print(a + " ");
		}

		System.out.println();
	}
}
