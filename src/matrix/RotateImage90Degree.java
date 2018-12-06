package matrix;

public class RotateImage90Degree {
	public int[][] rotateImage90Clockwise(final int[][] matrix) {
		final int n = matrix.length;
		int temp = 0;
		int last = 0;
		int offset = 0;

		for (int layer = 0; layer < n / 2; layer++) {
			last = n - 1 - layer;

			for (int i = layer; i < last; i++) {

				temp = matrix[layer][i];
				offset = i - layer;

				matrix[layer][i] = matrix[last - offset][layer];
				matrix[last - offset][layer] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = temp;
			}
		}

		return matrix;
	}
}
