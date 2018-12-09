package hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * https://www.hackerrank.com/challenges/strong-password/problem
 */
public class StrongPassword {

	public static void main(final String[] args) {
		//System.out.println(minimumNumber(4, "4700"));
		System.out.println(minimumNumber(7, "AUzs-nV"));
	}

	// Complete the minimumNumber function below.
	static int minimumNumber(final int n, final String password) {
		final String[] regxs = new String[] { "[0-9]", "[a-z]+", "[A-Z]+", "[!@#$%^&*()\\-+]+" };
		Pattern pattern;
		Matcher matcher;

		int count = 0;

		for (final String regx : regxs) {
			pattern = Pattern.compile(regx);
			matcher = pattern.matcher(password);

			if (!matcher.find()) {
				count++;
			}
		}

		return Math.max(count, 6 - n);
	}
}
