package sort;

public class BubbleSort {
	/*
	 * Time Complexity :
	 * 		Best Case - O(n) when the array is sorted
	 * 		Average Case - O(n^2)
	 * 		Worst Case - O(n^2)
	 * Space Complexity : ~O(1) [in-place] using almost constant space in memory
	 */

	public static void main(final String[] args) {
		final int[] arr = new int[] { 10, 7, 8, 9, 1, 5 };
		sort_Improved(arr);

		printArr(arr, "Sorted Array");
	}

	public static void sort(final int[] arr) {
		final int length = arr.length;
		int temp = 0;

		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

				printArr(arr, "when i: " + i + " and j: " + j);
			}
		}
	}

	public static void sort_Improved(final int[] arr) {
		final int length = arr.length;
		int temp = 0;
		boolean flag = false;

		for (int i = 0; i < length - 1; i++) {
			flag = false;

			for (int j = 0; j < length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = true;
				}

				printArr(arr, "when i: " + i + " and j: " + j);
			}

			if (!flag) {
				break;
			}
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
