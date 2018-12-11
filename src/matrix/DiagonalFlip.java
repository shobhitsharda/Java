package matrix;

public class DiagonalFlip {
	public void flip(final int[][] arr) {
		int temp = 0;
		final int length = arr.length;

		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}
}
