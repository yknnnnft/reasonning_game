package puzzle.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import puzzle.Puzzle;
import puzzle.enums.Choice;

public class Question3 extends AbstractQuestion {

	private List<Integer> questionIndices;
	private List<Choice> choices;

	public Question3(Puzzle puzzle) {
		super(puzzle);
		choices = new ArrayList<Choice>();
		questionIndices = Arrays.asList(new Integer[] { 2, 5, 1, 3 });
		setupAnswer();
	}

	private void setupAnswer() {
		Choice answerForA = puzzle.getAnswerOfQuestion(questionIndices.get(Choice.A.ordinal()));
		Choice answerForB = puzzle.getAnswerOfQuestion(questionIndices.get(Choice.B.ordinal()));
		Choice answerForC = puzzle.getAnswerOfQuestion(questionIndices.get(Choice.C.ordinal()));
		Choice answerForD = puzzle.getAnswerOfQuestion(questionIndices.get(Choice.D.ordinal()));
		choices.add(answerForA);
		choices.add(answerForB);
		choices.add(answerForC);
		choices.add(answerForD);
	}

	private int sameCount(Choice answer) {
		int count = 0;
		for (Choice c : choices) {
			if (answer == c) {
				count++;
			}
		}
		return count;
	}

	private boolean testChoice(Choice c) {
		return sameCount(choices.get(c.ordinal())) == 1;
	}

	@Override
	protected ChoiceContent initChoiceA() {
		return new ChoiceContent(Choice.A) {
			@Override
			protected boolean test() {
				return testChoice(label);
			}
		};
	}

	@Override
	protected ChoiceContent initChoiceB() {
		return new ChoiceContent(Choice.B) {
			@Override
			protected boolean test() {
				return testChoice(label);
			}
			
		};
	}

	@Override
	protected ChoiceContent initChoiceC() {
		return new ChoiceContent(Choice.C) {
			@Override
			protected boolean test() {
				return testChoice(label);
			}
			
		};
	}

	@Override
	protected ChoiceContent initChoiceD() {
		return new ChoiceContent(Choice.D) {
			@Override
			protected boolean test() {
				return testChoice(label);
			}
			
		};
	}

}
