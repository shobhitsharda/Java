package hackerrank;

import java.math.BigInteger;

/*
 * https://www.hackerrank.com/challenges/recursive-digit-sum/problem
 */
public class RecursiveDigitSum {
	public static void main(final String[] args) {
		final String n = "3546630947312051453014172159647935984478824945973141333062252613718025688716704470547449723886626736";
		final int k = 100000;

		System.out.println(superDigit(n, k));
	}

	static int superDigit(final String n, final int k) {
		BigInteger bigNum = new BigInteger(n);
		final BigInteger bigIntegerTen = new BigInteger("10");
		bigNum = superDigitUtil(bigNum, bigIntegerTen);
		bigNum = bigNum.multiply(new BigInteger(Integer.toString(k)));

		while (bigNum.compareTo(bigIntegerTen) >= 0) {
			bigNum = superDigitUtil(bigNum, bigIntegerTen);
		}

		return Integer.parseInt(bigNum.toString());
	}

	static BigInteger superDigitUtil(final BigInteger n, final BigInteger bigIntegerTen) {
		if (n.compareTo(bigIntegerTen) < 0) {
			return n;
		}

		return n.mod(bigIntegerTen).add(superDigitUtil(n.divide(bigIntegerTen), bigIntegerTen));
	}
}
