package questions;

//https://www.youtube.com/watch?v=5dJSZLmDsxk&list=PLBZBJbE_rGRVnpitdvpdY9952IsKMDuev&index=7
public class CountNegativeNumberInArray {

	public static void main(final String[] args) {
		final int[][] arr = { { -5, -4, -3, -2 }, { -3, -2, -1, 9 } };
		final int negativeCount = getNegativeCount(arr);
		System.out.println("negativeCount: " + negativeCount);
	}

	public static int getNegativeCount(final int[][] arr) {
		final int rowLength = arr.length;
		final int colLength = arr[0].length;

		int row = 0;
		int col = colLength - 1;
		int count = 0;

		while (col >= 0 && row < rowLength) {
			if (arr[row][col] < 0) {
				count += col + 1;
				row++;
			}
			else {
				col--;
			}
		}

		return count;
	}
}
