package matrix;

public class Transpose {

	public int[][] getTransposeUsingExtraMemory(final int[][] matrix) {
		final int[][] transposeMatrix = new int[matrix[0].length][matrix.length];

		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				transposeMatrix[i][j] = matrix[j][i];
			}
		}

		return transposeMatrix;
	}

	// In place
	public void getTransposeWithoutExtraMemory(final int[][] matrix) {
		int temp = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
