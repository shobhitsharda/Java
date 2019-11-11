package questions;

import java.util.HashSet;
import java.util.Set;

//First Recurring Character
//https://www.youtube.com/watch?v=GJdiM-muYqc

public class FirstRecurring {
	public static void main(final String[] args) {
		final String str = "ABCdEFDd";

		System.out.println(byAsciiValuesUsingBooleanArray(str));
		System.out.println(byAsciiValuesusingIntegerArray(str));
		System.out.println(byAsciiValuesusingHashSet(str));
	}

	public static char byAsciiValuesusingHashSet(final String str) {
		final Set<Character> charSet = new HashSet<>();

		for (final char ch : str.toCharArray()) {
			if (charSet.contains(ch)) {
				return ch;
			}

			charSet.add(ch);
		}

		return '\u0000';
	}

	public static char byAsciiValuesusingIntegerArray(final String str) {
		final int[] asciiValues = new int[128];
		int asciiValue = 0;

		for (final char ch : str.toCharArray()) {
			asciiValue = ch;

			if (asciiValues[asciiValue] == 1) {
				return ch;
			}

			asciiValues[asciiValue] += 1;
		}

		return '\u0000';
	}

	public static char byAsciiValuesUsingBooleanArray(final String str) {
		final boolean[] asciiValues = new boolean[128];
		int asciiValue = 0;

		for (final char ch : str.toCharArray()) {
			asciiValue = ch;

			if (asciiValues[asciiValue]) {
				return ch;
			}
			else {
				asciiValues[asciiValue] = true;
			}
		}

		return '\u0000';
	}
}