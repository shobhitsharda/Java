package hackerrank;

public class MakingAnagrams {

	/*
	 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
	 */

	public static void main(final String[] args) {
		System.out.println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
	}

	// Complete the makeAnagram function below.
	static int makeAnagram(final String a, final String b) {
		final int[] valuesA = new int[26];
		final int[] valuesB = new int[26];

		final int asciiA = 'a';
		int offset = 0;

		for (final char ch : a.toCharArray()) {
			offset = ch - asciiA;
			valuesA[offset]++;
		}

		for (final char ch : b.toCharArray()) {
			offset = ch - asciiA;
			valuesB[offset]++;
		}

		int count = 0;

		for (int i = 0; i < 26; i++) {
			count += Math.abs(valuesA[i] - valuesB[i]);
		}

		return count;
	}
}
