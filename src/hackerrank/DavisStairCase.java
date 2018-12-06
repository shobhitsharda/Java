package hackerrank;

import java.util.HashMap;

public class DavisStairCase {
	/*
	 * https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
	 */

	public static void main(final String[] args) {
		System.out.println(stepPerms(1));
		System.out.println(stepPerms(3));
		System.out.println(stepPerms(7));
	}

	static int stepPerms(final int n) {
		final HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 4);
		return stepPermsUtil(n, map);
	}

	static int stepPermsUtil(final int n, final HashMap<Integer, Integer> map) {
		if (map.containsKey(n)) {
			return map.get(n);
		}

		final int stepCount = stepPermsUtil(n - 1, map) + stepPermsUtil(n - 2, map) + stepPermsUtil(n - 3, map);
		map.put(n, stepCount);

		return stepCount;
	}
}
