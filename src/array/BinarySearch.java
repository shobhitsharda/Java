package array;

public class BinarySearch {

	/*
	 * Perform a binary search to find an element in a sorted array
	 * Time Complexity - O(logn) where n is the number of elements in an array
	 * Space Complexity - O(1) the space taken is always same for any number of array elements
	 */
	public static void main(final String[] args) {
		System.out.println(binarySearch(new int[] { 1, 2, 3, 4, 5, 6 }, 5));
	}

	public static boolean binarySearch(final int[] arr, final int number) {
		int min = 0;
		int max = arr.length - 1;

		while (min < max) {
			final int guess = (max + min) / 2;

			if (arr[guess] == number) {
				return true;
			}

			if (arr[guess] < number) {
				min = guess + 1;
			}
			else {
				max = guess - 1;
			}
		}

		return false;
	}
}
