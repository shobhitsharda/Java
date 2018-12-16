package matrix;

public class PrintDiagonal {

	public void print(final int[][] matrix) {
		final int n = matrix.length;

		for (int row = 0; row < n; row++) {
			int r = row;
			int c = 0;

			while (r >= 0 && c <= row) {
				System.out.println(matrix[r][c]);
				r--;
				c++;
			}
		}

		for (int col = 1; col < n; col++) {
			int r = n - 1;
			int c = col;

			while (r >= col && c < n) {
				System.out.println(matrix[r][c]);
				r--;
				c++;
			}
		}
	}
}
