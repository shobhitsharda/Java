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

		//final DiagonalFlip diagonalFlip = new DiagonalFlip();
		//diagonalFlip.flip(arr);
		//printMatrix(arr);

		//final MirrorImage mirrorImage = new MirrorImage();
		//mirrorImage.getMirrorImage(arr);
		//printMatrix(arr);

		//final WaterImage waterImage = new WaterImage();
		//waterImage.getWaterImage(arr);
		//printMatrix(arr);

		//new ZigZag().getZigZag(arr);

		//final RotateImage90Degree rotateImage90Degree = new RotateImage90Degree();
		//rotateImage90Degree.rotateImage90AntiClockwise(arr);
		//rotateImage90Degree.rotateImage90Clockwise(arr);

		//rotateImage90Degree.rotateImage90ClockwiseCleanMethod(arr);
		//rotateImage90Degree.rotateImage90AntiClockwiseCleanMethod(arr);
		//printMatrix(arr);

		//final Transpose transpose = new Transpose();
		//printMatrix(transpose.getTransposeUsingExtraMemory(arr));
		//transpose.getTransposeWithoutExtraMemory(arr);
		//printMatrix(arr);

		//final int[][] matrix = { { 10, 12, 7, 3, 12 }, { 3, 10, 6, 2, 8 }, { 18, 24, 17, 6, 10 }, { 15, 21, 10, 8, 12 }, { 1, 18, 22, 4, 15 } };
		//final SaddlePoint saddlePoint = new SaddlePoint();
		//saddlePoint.printSaddlePoint(matrix);

		//final SearchInSortedMatrix searchInSortedMatrix = new SearchInSortedMatrix();
		//System.out.println(searchInSortedMatrix.optimizedSearch(arr, 9));

		//final int[][] matrix = { { 0, 0, 1, 1 }, { 0, 1, 1, 1 }, { 0, 1, 1, 1 }, { 0, 1, 1, 1 } };
		//final CountZeroInSortedMatrix countZeroInSortedMatrix = new CountZeroInSortedMatrix();
		//countZeroInSortedMatrix.countZeros(matrix);

		//final PrintDiagonal printDiagonal = new PrintDiagonal();
		//printDiagonal.print(arr);
	}

	public static void printMatrix(final int[][] matrix) {
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}

			System.out.println();
		}
	}
}
