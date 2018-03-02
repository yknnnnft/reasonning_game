package puzzle.question;

import java.util.Arrays;
import java.util.List;

import puzzle.Puzzle;
import puzzle.enums.Choice;

public class Question9 extends AbstractQuestion {

	private List<Integer> questions = Arrays.asList(new Integer[] {5, 9, 1, 8});
	private boolean isQuestion1And6Same;

	public Question9(Puzzle puzzle) {
		super(puzzle);
		isQuestion1And6Same = puzzle.isSameChoice(0, 5);
	}

	private boolean testChoice(Choice choice) {
		boolean isXAnd5Same = puzzle.isSameChoice(4, questions.get(choice.ordinal()));
		return isQuestion1And6Same == isXAnd5Same;
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
