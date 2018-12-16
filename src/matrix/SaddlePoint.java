package matrix;

public class SaddlePoint {

	/*
	 * Find a Saddle point in Matrix.
	 * What is a Saddle point? 
	 * Ans: Element is said to be a saddle point if it is both minimum of its row and
	 * maximum of its column and vice versa
	 */
	public void printSaddlePoint(int[][] matrix) {
		int minColIndex = 0;
		
		for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			int min = matrix[rowIndex][0];
			boolean isSaddlePointFound = true;
			
			for (int colIndex = 1; colIndex < matrix.length; colIndex++) {
				if (matrix[rowIndex][colIndex] < min) {
					min = matrix[rowIndex][colIndex];
					minColIndex = colIndex;
				}
			}
			
			for (int i = 0; i < matrix.length; i++) {
				if (min < matrix[i][minColIndex]) {
					isSaddlePointFound = false;
					break;
				}
			}
			
			if (isSaddlePointFound) {
				System.out.println(min);
			}
		}
	}
}
