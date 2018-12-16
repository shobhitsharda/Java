package matrix;

public class CountZeroInSortedMatrix {

	/*
	 * Count zeros in a row wise and column wise sorted matrix
	 */
	public void countZeros(final int[][] matrix) {
		int row = 0;
		int col = matrix.length - 1;
		int count = 0;

		while (row < matrix.length && col > -1) {
			if (matrix[row][col] != 0) {
				col--;
			}
			else {
				count = count + col + 1;
				row++;
			}
		}

		System.out.println(count);
	}
}
