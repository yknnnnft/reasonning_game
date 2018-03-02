package puzzle.question;

import java.util.Arrays;
import java.util.List;

import puzzle.Puzzle;
import puzzle.enums.Choice;

public class Question8 extends AbstractQuestion {

	private List<Integer> questions = Arrays.asList(new Integer[] {6, 4, 1, 9});
	private Choice answerOfQuestion1;

	public Question8(Puzzle puzzle) {
		super(puzzle);
		answerOfQuestion1 = puzzle.getAnswerOfQuestion(0);
	}

	private boolean testChoice(Choice choice) {
		Choice answerOfChoice = puzzle.getAnswerOfQuestion(questions.get(choice.ordinal()));
		int ordinalDiff = answerOfChoice.ordinal() - answerOfQuestion1.ordinal();
		return ordinalDiff != 1 && ordinalDiff != -1;
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
