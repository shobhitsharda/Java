package sort;

public class SelectionSort {
	/*
	 * Time Complexity : O(n^2)
	 * Space Complexity : ~O(1) [in-place] using almost constant space in memory
	 *
	 * https://www.youtube.com/watch?v=GUDLRan2DWM&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=2
	 */

	public static void main(final String[] args) {
		final int[] arr = new int[] { 10, 7, 8, 9, 1, 5 };
		sort(arr);

		printArr(arr, "Sorted Array");
	}

	private static void sort(final int[] arr) {
		final int length = arr.length;
		int temp = 0;

		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (arr[j] < arr[i]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
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
