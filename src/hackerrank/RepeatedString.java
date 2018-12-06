package hackerrank;

public class RepeatedString {

	//https://www.hackerrank.com/challenges/repeated-string/problem

	public static void main(final String[] args) {
		System.out.println(repeatedString("ababa", 3));
	}

	public static long repeatedString(final String s, final long n) {
		long aCount = 0;
		final long stringLen = s.length();

		if (n < stringLen) {
			for (int i = 0; i < n; i++) {
				if (s.charAt(i) == 'a') {
					aCount++;
				}
			}

			return aCount;
		}

		for (final char c : s.toCharArray()) {
			if (c == 'a') {
				aCount++;
			}
		}

		final long frequency = n / s.length();
		aCount = aCount * frequency;
		final long remainingCount = n % (frequency * s.length());

		for (int i = 0; i < remainingCount; i++) {
			if (s.charAt(i) == 'a') {
				aCount++;
			}
		}

		return aCount;
	}
}
