package hackerrank;

/*
 * https://www.hackerrank.com/challenges/runningtime/problem
 */
public class RunningTimeOfAlgorithms {

	public static void main(final String[] args) {
		final int[] arr = new int[] { 2, 1, 3, 1, 2 };
		System.out.println(insertionSort(arr));
	}

	public static int insertionSort(final int[] arr) {
		int swapCount = 0;

		for (int i = 1; i < arr.length; i++) {
			final int value = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > value) {
				arr[j + 1] = arr[j];
				j = j - 1;
				swapCount++;
			}
			arr[j + 1] = value;
		}

		return swapCount;
	}
}
