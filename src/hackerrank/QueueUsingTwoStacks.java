package hackerrank;

import java.util.Stack;

public class QueueUsingTwoStacks {

	/*
	 * https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
	 */

	public static void main(final String[] args) {

	}

	public static class MyQueue<B> {
		private final Stack<B> stack1;
		private final Stack<B> stack2;

		MyQueue() {
			stack1 = new Stack<>();
			stack2 = new Stack<>();
		}

		public void enqueue(final B data) {
			stack1.push(data);
		}

		public B dequeue() {
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}

			return stack2.pop();
		}

		public B peek() {
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}

			return stack2.peek();
		}
	}
}
