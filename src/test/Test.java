package test;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(final String[] args) {
		final int[] A = { 20, 50, 90 };

		System.out.println(solution(A));
	}

	public static int solution(final int[] A) {
		final int lenght = A.length;

		final Set<Integer> set = new HashSet<>();

		for (final int aValue : A) {
			if (aValue > 0) {
				set.add(aValue);
			}
		}

		for (int i = 1; i <= lenght + 1; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return lenght + 1;
	}
}
