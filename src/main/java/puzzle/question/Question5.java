package puzzle.question;

import java.util.Arrays;
import java.util.List;

import puzzle.Puzzle;
import puzzle.enums.Choice;

public class Question5 extends AbstractQuestion {

	private List<Integer> questions = Arrays.asList(new Integer[] {7, 3, 8, 6});

	public Question5(Puzzle puzzle) {
		super(puzzle);
	}

	private boolean testChoice(Choice choice) {
		return puzzle.isAnswer(questions.get(choice.ordinal()), choice);
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
