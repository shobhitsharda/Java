package array;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RepeatedTwice {

	/*
	 * There is an array with every element repeated twice except one. Find that element?
	 */
	public static void main(final String[] args) {
		final int[] arr = new int[] { 1, 1, 2, 3, 3, 4, 4 };
		System.out.println("repeatedTwiceUsingSet: " + repeatedTwiceUsingSet(arr));
		System.out.println("repeatTwiceUsingHashMap: " + repeatTwiceUsingHashMap(arr));
	}

	public static int repeatedTwiceUsingSet(final int[] arr) {
		final Set<Integer> set = new HashSet<>();

		for (final int num : arr) {
			if (set.contains(num)) {
				set.remove(num);
			}
			else {
				set.add(num);
			}
		}

		return set.size() > 0 ? set.iterator().next() : -1;
	}

	public static int repeatTwiceUsingHashMap(final int[] arr) {
		final Map<Integer, Integer> map = new LinkedHashMap<>();

		for (final int num : arr) {
			map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
		}

		for (final Map.Entry<Integer, Integer> pair : map.entrySet()) {
			if (pair.getValue() == 1) {
				return pair.getKey();
			}
		}

		return -1;
	}
}
