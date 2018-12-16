package matrix;

public class RotateImage90Degree {

	public void rotateImage90AntiClockwiseCleanMethod(final int[][] matrix) {
		final int n = matrix.length - 1;

		for (int i = 0; i <= n / 2; i++) {
			for (int j = i; j < n - i; j++) {
				final int p1 = matrix[j][i];
				final int p2 = matrix[n - i][j];
				final int p3 = matrix[n - j][n - i];
				final int p4 = matrix[i][n - j];

				matrix[n - i][j] = p1;
				matrix[n - j][n - i] = p2;
				matrix[i][n - j] = p3;
				matrix[j][i] = p4;
			}
		}
	}

	public void rotateImage90ClockwiseCleanMethod(final int[][] matrix) {
		final int n = matrix.length - 1;

		for (int i = 0; i <= n / 2; i++) {
			for (int j = i; j < n - i; j++) {
				final int p1 = matrix[i][j];
				final int p2 = matrix[j][n - i];
				final int p3 = matrix[n - i][n - j];
				final int p4 = matrix[n - j][i];

				matrix[j][n - i] = p1;
				matrix[n - i][n - j] = p2;
				matrix[n - j][i] = p3;
				matrix[i][j] = p4;
			}
		}
	}

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
