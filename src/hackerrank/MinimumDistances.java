package hackerrank;

import java.util.HashMap;

public class MinimumDistances {

	//https://www.hackerrank.com/challenges/minimum-distances/problem

	public static void main(final String[] args) {
		System.out.println(minimumDistances(new int[]{7, 1, 3, 4, 1, 7}));
	}

	public static int minimumDistances(final int[] a) {
		final HashMap<Integer, Integer> map = new HashMap<>();
		int minDistance = Integer.MAX_VALUE;
		int distance = 0;

		for (int i = 0; i < a.length; i++) {
			if (!map.containsKey(a[i])) {
				map.put(a[i], i);
				continue;
			}

			distance = i - map.get(a[i]);
			minDistance = distance < minDistance ? distance : minDistance;
		}

		return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
	}
}
