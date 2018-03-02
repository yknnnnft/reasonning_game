package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import puzzle.enums.Choice;

public class AnswerFactory {

	public static Integer MAX = Integer.parseInt("3333333333", 4);
	public static Integer START = Integer.parseInt("0000000000", 4);

	public static List<List<Choice>> ALL_ANSWERS;

	static {
		System.out.println("[answer factory] initiliazation starts");
		ALL_ANSWERS = new ArrayList<List<Choice>>();
		for (int i = START; i <= MAX; i++) {
			String currAnswers = String.format("%10s", Integer.toString(i, 4)).replaceAll(" ", "0");
			Choice[] answers = new Choice[10];
			for (int j = 0; j < 10; j++) {
				char testChar = currAnswers.charAt(j);
				int currAnswer = Character.getNumericValue(testChar);
				answers[j] = Choice.values()[currAnswer];
			}
			ALL_ANSWERS.add(Arrays.asList(answers));
		}
		System.out.println("[answer factory] initialization succeeded");
	}

	public static List<Choice> getAnswer(int index) {
		return ALL_ANSWERS.get(index);
	}
	
	public static String printList(Choice[] answer) {
		StringBuilder sb = new StringBuilder("[");
		for (Choice c: answer) {
			sb.append(c);
		}
		sb.append("]");
		return sb.toString();
	}
}