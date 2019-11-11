package questions;

import java.util.ArrayList;
import java.util.HashSet;

public class IntegerMultiplicationToANumber {

	public static void main(final String[] args) {
		final int[] arr = { 1, 2, 4, 5, 20, 12, 10, 8, 8, -8, -2 };

		final ArrayList<Pair<Integer>> pairs = findPairs(arr, 16);
		pairs.forEach(pair -> {
			System.out.println(pair.getFirst() + " " + pair.getSecond());
		});
	}

	public static ArrayList<Pair<Integer>> findPairs(final int[] arr, final int number) {
		final ArrayList<Pair<Integer>> pairs = new ArrayList<>();
		final HashSet<Integer> map = new HashSet<>();
		final HashSet<Integer> visitedMap = new HashSet<>();

		int iCompliment;

		for (final int i : arr) {
			if (visitedMap.contains(i)) {
				continue;
			}
			else {
				visitedMap.add(i);
			}

			iCompliment = number / i;

			if (number % i == 0 && map.contains(iCompliment)) {
				pairs.add(new Pair<>(i, iCompliment));
			}
			else {
				map.add(i);
			}
		}

		return pairs;
	}

	public static class Pair<B> {
		private final B first;
		private final B second;

		Pair(final B first, final B second) {
			this.first = first;
			this.second = second;
		}

		public B getFirst() {
			return first;
		}

		public B getSecond() {
			return second;
		}
	}
}