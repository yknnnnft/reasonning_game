package puzzle.question;

import java.util.ArrayList;
import java.util.List;

import puzzle.Puzzle;

public class QuestionListFactory {

	public static List<AbstractQuestion> getQuestions(Puzzle puzzle) {
		List<AbstractQuestion> list = new ArrayList<AbstractQuestion>();
		list.add(new Question1(puzzle));
		list.add(new Question2(puzzle));
		list.add(new Question3(puzzle));
		list.add(new Question4(puzzle));
		list.add(new Question5(puzzle));
		list.add(new Question6(puzzle));
		list.add(new Question7(puzzle));
		list.add(new Question8(puzzle));
		list.add(new Question9(puzzle));
		list.add(new Question10(puzzle));
		return list;
	}
}
