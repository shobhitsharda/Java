package array;

public class FindCommon {

	/*
	 * Find common elements in three sorted arrays
	 */

	public static void main(final String[] args) {
		final int[] a1 = new int[] { 1, 5, 10, 20, 40, 80 };
		final int[] a2 = new int[] { 6, 7, 20, 80, 100 };
		final int[] a3 = new int[] { 3, 4, 15, 20, 30, 70, 80, 120 };

		findCommon(a1, a2, a3);
	}

	public static void findCommon(final int[] a1, final int[] a2, final int[] a3) {
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < a1.length && j < a2.length && k < a3.length) {
			if (a1[i] == a2[j] && a2[j] == a3[k]) {
				System.out.println(a1[i]);
				i++;
				j++;
				k++;
			}
			else if (a1[i] < a2[j]) {
				i++;
			}
			else if (a2[j] < a3[k]) {
				j++;
			}
			else {
				k++;
			}
		}
	}
}
