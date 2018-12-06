package matrix;

public class DiagonalFlip {
	public int[][] getDiagonalFlip(final int[][] matrix) {
		final int n = matrix.length;
		int temp = 0;

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		return matrix;
	}
}
