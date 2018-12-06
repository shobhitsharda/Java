package sort;

public class InsertionSort {
	/*
	 * Time Complexity :
	 * 		Best Case: O(n) when the array is sorted
	 * 		Average Case: O(n^2), but the number of scenarios are less when compared to bubble and selection sort
	 * 		Worst Case: O(n^2) when the array is reverse sorted
	 * Space Complexity : ~O(1) [in-place] using almost constant space in memory
	 *
	 * https://www.youtube.com/watch?v=i-SKeOcBwko&t=570s
	 */

	public static void main(final String[] args) {
		final int[] arr = new int[] { 10, 7, 8, 9, 1, 5 };
		sort(arr);

		printArr(arr, "Sorted Array");
	}

	private static void sort(final int[] arr) {
		final int length = arr.length;
		int tempValue = 0;
		int tempValueIndex = 0;

		for (int i = 1; i < length; i++) {
			tempValue = arr[i];
			tempValueIndex = i;

			while (tempValueIndex > 0 && arr[tempValueIndex - 1] > tempValue) {
				arr[tempValueIndex] = arr[tempValueIndex - 1];
				tempValueIndex--;
			}

			arr[tempValueIndex] = tempValue;
		}
	}

	private static void printArr(final int[] arr, final String msg) {
		System.out.print(msg + " - ");

		for (final int a : arr) {
			System.out.print(a + " ");
		}

		System.out.println();
	}
}
