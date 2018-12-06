package hackerrank;

public class CamelCase {

	/*
	 * https://www.hackerrank.com/challenges/camelcase/problem
	 */
	// Complete the camelcase function below.
	static int camelcase(final String s) {
		final int asciiA = 'A';
		final int asciiZ = 'Z';
		int asciiValue = 0;

		int wordCount = 1;

		for (final char ch : s.toCharArray()) {
			asciiValue = ch;

			if (asciiValue >= asciiA && asciiValue <= asciiZ) {
				wordCount++;
			}
		}

		return wordCount;
	}
}
