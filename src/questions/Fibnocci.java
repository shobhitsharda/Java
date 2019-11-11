package questions;

import java.util.HashMap;

public class Fibnocci {

	//using dynamic programming

	public static void main(final String[] args) {
		final HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		map.put(1, 1);

		int i = 0;

		while (i <= 6) {
			System.out.println(getFibnocci(i, map));
			i++;
		}
	}

	public static int getFibnocci(final int num, final HashMap<Integer, Integer> map) {
		if (map.containsKey(num)) {
			return map.get(num);
		}

		final int val = getFibnocci(num - 1, map) + getFibnocci(num - 2, map);
		map.put(num, val);

		return val;
	}
}
