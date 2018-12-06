package hackerrank;

public class InsertionSort1 {

	/*
	 * https://www.hackerrank.com/challenges/insertionsort1/problem
	 */

	public static void main(final String[] args) {
		final int[] arr = new int[] { 2, 4, 6, 8, 3 };
		insertionSort1(5, arr);
	}

	static void insertionSort1(final int n, final int[] arr) {
		final int temp = arr[n - 1];
		int i = 0;

		for (i = n - 2; i >= 0; i--) {
			if (arr[i] > temp) {
				arr[i + 1] = arr[i];
				printArr(arr);
			}
			else {
				break;
			}
		}

		arr[i + 1] = temp;

		printArr(arr);
	}

	private static void printArr(final int[] arr) {
		for (final int a : arr) {
			System.out.print(a + " ");
		}

		System.out.println();
	}
}
