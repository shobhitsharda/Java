package matrix;

public class RotateImage90Degree {
	public void rotateImage90Clockwise(final int[][] matrix) {
		final int n = matrix.length;
		int temp = 0;
		int last = 0;
		int offset = 0;

		for (int layer = 0; layer < n / 2; layer++) {
			last = n - 1 - layer;

			for (int i = layer; i < last; i++) {
				offset = i - layer;
				temp = matrix[layer][i];

				matrix[layer][i] = matrix[last - offset][layer];
				matrix[last - offset][layer] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = temp;
			}
		}
	}

	public void rotateImage90AntiClockwise(final int[][] matrix) {
		final int n = matrix.length;
		int temp = 0;
		int last = 0;
		int offset = 0;

		for (int layer = 0; layer < n / 2; layer++) {
			last = n - 1 - layer;

			for (int i = layer; i < last; i++) {
				offset = i - layer;

				temp = matrix[i][layer];

				matrix[i][layer] = matrix[layer][last - offset];
				matrix[layer][last - offset] = matrix[last - offset][last];
				matrix[last - offset][last] = matrix[last][i];
				matrix[last][i] = temp;
			}
		}
	}
}
