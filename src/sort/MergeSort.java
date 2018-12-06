package sort;

public class MergeSort {

	/*
	 * Time Complexity : O(nlogn) [Worst Case]
	 * Space Complexity : O(n) [not in-place]
	 *
	 * https://www.youtube.com/watch?v=TzeBrDU-JaY
	 */

	public static void main(final String[] args) {
		final int[] arr = new int[] { 2, 1, 3, 1, 2 };
		final int[] sortedArray = sort(arr);

		for (final int i : sortedArray) {
			System.out.println(i);
		}
	}

	public static int[] sort(final int[] arr) {
		final int length = arr.length;

		if (length == 1) {
			return arr;
		}

		final int midPoint = length / 2;

		int[] leftArray = new int[midPoint];
		int[] rightArray = new int[length - midPoint];

		int i = 0;
		int j = 0;

		while (i < midPoint) {
			leftArray[i] = arr[i];
			i++;
		}

		while (i < length) {
			rightArray[j] = arr[i];
			j++;
			i++;
		}

		leftArray = sort(leftArray);
		rightArray = sort(rightArray);
		return merge(leftArray, rightArray);

	}

	private static int[] merge(final int[] leftArray, final int[] rightArray) {
		int i = 0;
		int j = 0;
		int k = 0;
		final int[] newArr = new int[leftArray.length + rightArray.length];

		while (i < leftArray.length && j < rightArray.length) {
			if (leftArray[i] <= rightArray[j]) {
				newArr[k] = leftArray[i];
				i++;
			}
			else {
				newArr[k] = rightArray[j];
				j++;
			}

			k++;
		}

		while (i < leftArray.length) {
			newArr[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < rightArray.length) {
			newArr[k] = rightArray[j];
			j++;
			k++;
		}

		return newArr;
	}
}
