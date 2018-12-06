package hackerrank;

public class GradingStudents {
	/*
	 * https://www.hackerrank.com/challenges/grading/problem
	 */

	static int[] gradingStudents(final int[] grades) {
		int grade = 0;
		int gradeMod = 0;
		int offset = 0;

		for (int i = 0; i < grades.length; i++) {
			grade = grades[i];
			gradeMod = grade % 5;

			if (grade < 38 || gradeMod == 0) {
				continue;
			}

			offset = 5 - gradeMod;

			if (offset <= 2) {
				grades[i] = grade + offset;
			}
		}

		return grades;
	}
}
