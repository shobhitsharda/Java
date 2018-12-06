package matrix;

public class ZigZag {
	// Input
	// 1 2 3 4 1 5 9 13
	// 5 6 7 8 -> 14 10 6 2
	// 9 10 11 12 3 7 11 15
	// 13 14 15 16 16 12 8 4

	public void getZigZag(final int[][] matrix) {
		final int n = matrix.length;
		// int[][] newMatrix = new int[n][n];

		for (int col = 0; col < n; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < n; row++) {
					System.out.print(matrix[row][col] + " ");
				}
			}
			else {
				for (int row = n - 1; row >= 0; row--) {
					System.out.print(matrix[row][col] + " ");
				}
			}

			System.out.println();
		}
	}
}
