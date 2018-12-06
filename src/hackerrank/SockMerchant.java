package hackerrank;

import java.util.HashSet;

/*
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 */
public class SockMerchant {

	public static void main(final String[] args) {
		System.out.println(sockMerchant(6, new int[] { 1, 2, 3, 4, 2, 1 }));
	}

	static int sockMerchant(final int n, final int[] ar) {
		final HashSet<Integer> tempSet = new HashSet<>();
		int pairCount = 0;

		for (int i = 0; i < n; i++) {
			if (tempSet.contains(ar[i])) {
				pairCount++;
				tempSet.remove(ar[i]);
			}
			else {
				tempSet.add(ar[i]);
			}
		}

		return pairCount;
	}
}
