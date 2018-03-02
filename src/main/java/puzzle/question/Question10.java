package puzzle.question;

import java.util.Arrays;
import java.util.List;

import puzzle.Puzzle;
import puzzle.enums.Choice;

public class Question10 extends AbstractQuestion {

	private List<Integer> diffs = Arrays.asList(new Integer[] {3, 2, 4, 1});
	private int diff;
	public Question10(Puzzle puzzle) {
		super(puzzle);
		diff = puzzle.getLimitCount()[1] - puzzle.getLimitCount()[0];
	}

	private boolean testChoice(Choice choice) {
		return diffs.get(choice.ordinal()) == diff;
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
