package puzzle.question;

import java.util.Map;

import puzzle.Puzzle;
import puzzle.enums.Choice;

public class Question7 extends AbstractQuestion {

	private Map<Choice, Integer> count;
	public Question7(Puzzle puzzle) {
		super(puzzle);
		count = puzzle.getAnswerCount();
	}

	private boolean testChoice(Choice choice) {
		for (Choice c: Choice.values()) {
			if (!count.containsKey(c)) {
				count.put(c, 0);
			}
			if (c == choice) {
				continue;
			}
			if (count.get(choice) >= count.get(c)) {
				return false;
			}
		}
		return true;
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
