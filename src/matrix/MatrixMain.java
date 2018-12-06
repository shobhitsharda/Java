package matrix;

import java.io.IOException;

public class MatrixMain {
	public static void main(final String[] args) throws IOException {
		final int[][] arr = new int[4][4];

		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[0][3] = 4;

		arr[1][0] = 5;
		arr[1][1] = 6;
		arr[1][2] = 7;
		arr[1][3] = 8;

		arr[2][0] = 9;
		arr[2][1] = 10;
		arr[2][2] = 11;
		arr[2][3] = 12;

		arr[3][0] = 13;
		arr[3][1] = 14;
		arr[3][2] = 15;
		arr[3][3] = 16;

		printMatrix(new MirrorImage().getMirrorImage(arr));
		printMatrix(new WaterImage().getWaterImage(arr));
		printMatrix(new DiagonalFlip().getDiagonalFlip(arr));
		new ZigZag().getZigZag(arr);
		printMatrix(new RotateImage90Degree().rotateImage90Clockwise(arr));
	}

	public static void printMatrix(final int[][] matrix) {
		final int n = matrix.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}

			System.out.println();
		}
	}
}
