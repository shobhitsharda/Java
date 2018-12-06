package matrix;

public class MirrorImage {
	public int[][] getMirrorImage(final int[][] matrix) {
		System.out.println();
		final int n = matrix.length; // length of the matrix, assumption is nxn matrix
		int temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = temp;
			}
		}

		return matrix;
	}
}
