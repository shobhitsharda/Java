package matrix;

public class SearchInSortedMatrix {

	public boolean optimizedSearch(final int matrix[][], final int num) {
		final int n = matrix.length;
		int i = 0;
		final int j = n - 1;
		int count = 0;

		while (i < n) {
			count++;
			if (matrix[i][j] == num) {
				System.out.println("count: " + count);
				return true;
			}
			else if (matrix[i][j] < num) {
				i++;
			}
			else {
				for (int k = j - 1; k >= 0; k--) {
					count++;
					if (matrix[i][k] == num) {
						System.out.println("count: " + count);
						return true;
					}
				}

				System.out.println("count: " + count);
				return false;
			}
		}

		System.out.println("count: " + count);
		return false;
	}
}
