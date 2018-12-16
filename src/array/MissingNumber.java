package array;

import java.util.BitSet;

public class MissingNumber {

	//How to Find Missing Number on Integer Array of 1 to 100
	public static void main(final String[] args) {
		//printMissingNumberByBitSet(new int[] { 1, 2, 3, 4, 6, 9 }, 9);
		printMissingNumberBySummation(new int[] { 1, 2, 3, 7, 9, 5, 6, 4 }, 9);
	}

	/*
	 * solution 1
	 * -- using bitset
	 * -- can find any number of missing numbers
	 */
	public static void printMissingNumberByBitSet(final int[] arr, final int count) {
		final int missingCount = count - arr.length;
		final BitSet bits = new BitSet(count);

		for (final int number : arr) {
			bits.set(number - 1);
		}

		int lastMissingIndex = 0;
		System.out.println("bits: " + bits);
		for (int i = 0; i < missingCount; i++) {
			lastMissingIndex = bits.nextClearBit(lastMissingIndex);
			lastMissingIndex++;
			System.out.println(lastMissingIndex);
		}
	}

	/*
	 * solution 2
	 * -- using summation, nSum = (n(n + 1)) / 2
	 * -- can find only one missing number
	 */
	public static void printMissingNumberBySummation(final int[] arr, final int count) {
		final int expectedSum = count * (count + 1) / 2;
		int arrSum = 0;

		for (final int number : arr) {
			arrSum += number;
		}

		final int missingNumber = expectedSum - arrSum;

		System.out.println(missingNumber == 0 ? "no number is missing" : missingNumber);
	}
}
