package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * How to find all pairs in an array of integers whose sum is equal to a given number?
 * Assumption: Array can contain positive and negative numbers
 */
public class PairSum {
	public static void main(final String[] args) {
		findPairUsingSet(new int[] { 1, 2, 5, -4, -2, -11 }, -6);
		finadPairUsingTwoPointer(new int[] { 1, 2, 5, -4, -2, -11 }, -6);
	}

	/*
	 * Time Complexity : O(n), but additional space is needed for storing a set
	 */
	public static void findPairUsingSet(final int[] arr, final int number) {
		final Set<Integer> set = new HashSet<>();

		for (final int num : arr) {
			final int firstCompliment = number - num;

			if (set.contains(firstCompliment)) {
				System.out.println(num + ", " + firstCompliment);
			}
			else {
				set.add(num);
			}
		}
	}

	/*
	 * Time Complexity : O(nLogn) mainly because of the sorting
	 * no extra space is required
	 */
	public static void finadPairUsingTwoPointer(final int[] arr, final int number) {
		Arrays.sort(arr); //quick sort, O(nLogn)

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			final int sum = arr[left] + arr[right];
			if (sum == number) {
				System.out.println(arr[left] + ", " + arr[right]);
				left++;
				right--;
			}
			else if (sum < number) {
				left++;
			}
			else {
				right--;
			}
		}
	}
}