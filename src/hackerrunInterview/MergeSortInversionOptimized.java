package hackerrunInterview;

public class MergeSortInversionOptimized {

	static long inversion = 0;

	public static void main(final String[] args) {
		final int[] arr = new int[] { 7, 5, 3, 1 };
		sort(arr);

		System.out.println("inversion: " + inversion);

		for (final int i : arr) {
			System.out.println(i);
		}
	}

	public static void sort(final int[] arr) {
		inversion = 0;

		final int[] helper = new int[arr.length];
		sortUtil(arr, helper, 0, arr.length - 1);
	}

	private static void sortUtil(final int[] arr, final int[] helper, final int startIndex, final int endIndex) {
		if (startIndex < endIndex) {
			final int midIndex = (startIndex + endIndex) / 2;
			sortUtil(arr, helper, startIndex, midIndex);
			sortUtil(arr, helper, midIndex + 1, endIndex);
			merge(arr, helper, startIndex, midIndex, endIndex);
		}
	}

	private static void merge(final int[] arr, final int[] helper, final int startIndex, final int midIndex, final int endIndex) {
		for (int k = 0; k <= endIndex; k++) {
			helper[k] = arr[k];
		}

		int currentIndex = startIndex;
		int i = startIndex;
		int j = midIndex + 1;

		while (i <= midIndex && j <= endIndex) {
			if (helper[i] <= helper[j]) {
				arr[currentIndex] = helper[i];
				i++;
				currentIndex++;
			}
			else {
				arr[currentIndex] = helper[j];
				currentIndex++;
				j++;

				inversion += midIndex + 1 - i;
			}
		}

		while (i <= midIndex) {
			arr[currentIndex] = helper[i];
			currentIndex++;
			i++;
		}
	}
}
