package test;

import java.util.Stack;

public class Klarna {

	public static void main(final String[] args) {
		//		final String expr = "1 2 3 4";
		//
		//		System.out.println(Character.isDigit('5'));
		System.out.println(maskify_optimized("5512103073210694"));
	}

	public double evaluate(final String expr) {
		if (expr.isEmpty()) {
			return 0;
		}

		final Stack<Double> calculatorStack = new Stack<>();

		final String[] expressionArray = expr.split(" ");

		for (final String eachExpression : expressionArray) {
			if (eachExpression.equals("+")) {
				calculatorStack.push(calculatorStack.pop() + calculatorStack.pop());
			}
			else if (eachExpression.equals("-")) {
				calculatorStack.push(subtract(calculatorStack.pop(), calculatorStack.pop()));
			}
			else if (eachExpression.equals("*")) {
				calculatorStack.push(calculatorStack.pop() * calculatorStack.pop());

			}
			else if (eachExpression.equals("/")) {
				calculatorStack.push(divide(calculatorStack.pop(), calculatorStack.pop()));
			}
			else {
				calculatorStack.push(Double.parseDouble(eachExpression));
			}
		}

		return calculatorStack.pop();
	}

	public double subtract(final double value1, final double value2) {
		return value2 - value1;
	}

	public double divide(final double value1, final double value2) {
		return value2 / value1;
	}

	public static String numberToOrdinal(final Integer number) {
		if (number == 0) {
			return "0";
		}

		int remainder = number % 100;

		if (remainder > 10 && remainder < 20) {
			return number + "th";
		}

		remainder = remainder % 10;

		if (remainder == 1) {
			return number + "st";
		}
		else if (remainder == 2) {
			return number + "nd";
		}
		else if (remainder == 3) {
			return number + "rd";
		}

		return number + "th";
	}

	public static String maskify(final String creditCardNumber) {
		final int length = creditCardNumber.length();

		if (length < 6) {
			return creditCardNumber;
		}

		final char[] maskedCreditCardNumber = new char[length];
		maskedCreditCardNumber[0] = creditCardNumber.charAt(0);
		char eachChar;
		int i = 0;

		for (i = 1; i < length - 4; i++) {
			eachChar = creditCardNumber.charAt(i);
			maskedCreditCardNumber[i] = Character.isDigit(eachChar) ? '#' : eachChar;
		}

		for (int j = i; j < length; j++) {
			maskedCreditCardNumber[j] = creditCardNumber.charAt(j);
		}

		return new String(maskedCreditCardNumber);
	}

	public static String maskify_optimized(final String creditCardNumber) {
		final int length = creditCardNumber.length();

		if (length < 6) {
			return creditCardNumber;
		}

		final String substring = creditCardNumber.substring(1, length - 4);
		return creditCardNumber.substring(0, 1) + substring.replaceAll("\\d", "#") + creditCardNumber.substring(length - 4, length);
	}

}
