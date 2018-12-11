package matrix;

public class MirrorImage {
	public void getMirrorImage(final int[][] arr) {
		final int length = arr.length;
		int temp = 0;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length / 2; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[i][length - 1 - j];
				arr[i][length - 1 - j] = temp;
			}
		}
	}
}