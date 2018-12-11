package matrix;

public class WaterImage {
	public void getWaterImage(final int[][] arr) {
		final int n = arr.length;
		int temp = 0;

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[n - 1 - i][j];
				arr[n - 1 - i][j] = temp;
			}
		}
	}
}
