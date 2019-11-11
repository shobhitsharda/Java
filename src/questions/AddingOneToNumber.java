package questions;

import java.util.ArrayList;

public class AddingOneToNumber {

	public static void main(final String[] args) {
		final ArrayList<Integer> arr = new ArrayList<>();
		arr.add(0);
		arr.add(3);
		arr.add(1);
		//arr.add(9);

		addOne(arr).forEach(item -> {
			System.out.println(item);
		});

	}

	public static ArrayList<Integer> addOne(final ArrayList<Integer> arr) {
		final int n = arr.size();
		int currentVal = 0;
		int carry = 0;
		boolean flag = false;

		for (int i = n - 1; i >= 0; i--) {
			currentVal = arr.get(i);
			carry = (currentVal + 1) / 10;

			if (carry == 1) {
				arr.set(i, 0);
			}
			else {
				arr.set(i, currentVal + 1);
				flag = true;
				break;
			}
		}

		if (!flag) {
			arr.add(0, 1);
		}

		while (arr.get(0) == 0) {
			arr.remove(0);
		}

		return arr;
	}
}
