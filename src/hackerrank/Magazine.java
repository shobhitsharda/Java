package hackerrank;

import java.util.HashMap;

/*
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */

public class Magazine {

	public static void main(final String[] args) {

	}

	static void checkMagazine(final String[] magazine, final String[] note) {
		final HashMap<String, Integer> magazineMap = new HashMap<>();

		for (final String word : magazine) {
			if (!magazineMap.containsKey(word)) {
				magazineMap.put(word, 1);
			}
			else {
				magazineMap.replace(word, magazineMap.get(word) + 1);
			}
		}

		for (final String word : note) {
			if (!magazineMap.containsKey(word) || magazineMap.get(word) == 0) {
				System.out.print("No");
				return;
			}

			magazineMap.replace(word, magazineMap.get(word) - 1);
		}

		System.out.print("Yes");
	}
}
