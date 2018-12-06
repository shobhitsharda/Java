package hackerrank;

public class CountValleys {

	/*
	 * https://www.hackerrank.com/challenges/counting-valleys/problem
	 */
	public static void main(final String[] args) {
		System.out.println(countingValleys(3, "DDU"));
	}

	public static int countingValleys(final int n, final String s) {
		int valleyCount = 0;
		int sealevel = 0;

		final char[] chars = s.toCharArray();
		char ch;

		for (int i = 0; i < n - 1; i++) {
			ch = chars[i];

			if (ch == 'D') {
				sealevel--;

				if (sealevel == -1) {
					valleyCount++;
				}
			}
			else if (ch == 'U') {
				sealevel++;
			}
		}

		return valleyCount;
	}

}
