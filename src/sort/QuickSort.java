package sort;

public class QuickSort {

	/*
	 * Time Complexity
	 * 		Worst Case - O(n^2)
	 * 		average Case - O(nlogn)
	 * Space Complexity - ~O(1) [in-place] using almost constant space in memory
	 *
	 * https://www.youtube.com/watch?v=COk73cpQbFQ&t=139s
	 */
	public static void main(final String[] args) {
		final int[] arr = new int[] { 10, 7, 8, 9, 1, 5 };
		sort(arr);

		printArr(arr, "Sorted Array");
	}

	public static void sort(final int[] arr) {
		sortUtil(arr, 0, arr.length - 1);
	}

	private static void sortUtil(final int[] arr, final int startIndex, final int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}

		final int pIndex = partition(arr, startIndex, endIndex);
		sortUtil(arr, startIndex, pIndex - 1);
		sortUtil(arr, pIndex + 1, endIndex);
	}

	//return the index of the pivot element after placing is correctly.
	private static int partition(final int[] arr, final int startIndex, final int endIndex) {
		final int pivot = arr[endIndex];
		int pIndex = startIndex;
		int temp = 0;

		for (int i = startIndex; i < endIndex; i++) {
			if (arr[i] <= pivot) {
				temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;

				pIndex++;
			}
		}

		arr[endIndex] = arr[pIndex];
		arr[pIndex] = pivot;

		return pIndex;
	}

	private static void printArr(final int[] arr, final String msg) {
		System.out.println(msg);

		for (final int a : arr) {
			System.out.print(a + " ");
		}
	}

}
