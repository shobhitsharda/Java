package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * How to Check or Detect Duplicate Elements in Array
 */

public class DetectDuplicateElement {

	public static void main(final String[] args) {
		final int[] arr = { 1, 2, 5, 4 };
		System.out.println("method1 : " + method1(arr));
		System.out.println("method2 : " + method2(arr));
		System.out.println("method3 : " + method3(arr));
	}

	/*
	 * solution 1
	 * -- brutforce
	 */
	public static boolean method1(final int[] arr) {
		final int n = arr.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i] == arr[j] && i != j) {
					return true;
				}
			}
		}

		return false;
	}

	/*
	 * solution 2
	 * -- using list, set and size
	 */
	public static boolean method2(final int[] arr) {
		final List<Integer> list = new ArrayList<>();

		for (final int num : arr) {
			list.add(num);
		}

		return arr.length > list.size();
	}

	/*
	 * solution 3
	 * -- using hashset
	 */
	public static boolean method3(final int[] arr) {
		final Set<Integer> set = new HashSet<>();

		for (final int num : arr) {
			if (!set.add(num)) {
				return true;
			}
		}

		return false;
	}
}
