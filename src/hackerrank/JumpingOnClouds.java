package hackerrank;

public class JumpingOnClouds {
	/*
	 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
	 */

	public static void main(final String[] args) {
		final int[] a = new int[] { 0, 1, 0, 0, 0, 0 };
		System.out.println(jumpingOnClouds(a));
	}

	static int jumpingOnClouds(final int[] a) {
		final int n = a.length;
		int jumps = 0;

		int i = 0;
		while (i < n - 3) //goes through all clouds up until the last jump
		{
			i += a[i + 2] == 0 ? 2 : 1;
			jumps++;
		}

		jumps++;//This is the last jump that will be either a 1 or 2
		return jumps;
	}
}
