package hackerrank;

//https://www.hackerrank.com/challenges/minimum-swaps-2/problem

public class MinimumSwap {
	public static void main(final String[] args) {
		System.out.println(minimumSwaps(new int[] {4, 3, 1, 2}));
	}

	static int minimumSwaps(final int[] arr) {
		int temp1Index = 0;
		int temp2Index = 0;
		int swapCount = 0;
		int temp = 0;
		boolean isSwapped = false;
		boolean isInitial = true;
		final int prevSwapCount = 0;

		while(isInitial || isSwapped) {
			isSwapped = false;
			isInitial = false;

			for (int i = 0; i < arr.length; i++) {
				if (i + 1 == arr[i]) {
					continue;
				}

				temp1Index = i;
				temp2Index = arr[i] - 1;

				temp = arr[temp1Index];
				arr[temp1Index] = arr[temp2Index];
				arr[temp2Index] = temp;

				swapCount++;
				isSwapped = true;
			}
		}

		return swapCount;
	}
}
