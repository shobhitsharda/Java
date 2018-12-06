package matrix;

public class WaterImage {
	public int[][] getWaterImage(final int[][] matrix) {
		final int n = matrix.length; // n is the length of the matrix, assumption matrix is nxn
		int temp = 0;

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - i][j];
				matrix[n - 1 - i][j] = temp;
			}
		}

		return matrix;
	}
}
