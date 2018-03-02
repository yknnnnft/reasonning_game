package puzzle.question;

import puzzle.Puzzle;
import puzzle.enums.Choice;

public class Question4 extends AbstractQuestion {

	public Question4(Puzzle puzzle) {
		super(puzzle);
	}

	@Override
	protected ChoiceContent initChoiceA() {
		return new ChoiceContent(Choice.A) {
			@Override
			protected boolean test() {
				return puzzle.isSameChoice(0, 4);
			}
			
		};
	}

	@Override
	protected ChoiceContent initChoiceB() {
		return new ChoiceContent(Choice.B) {
			@Override
			protected boolean test() {
				return puzzle.isSameChoice(1, 6);
			}
			
		};
	}

	@Override
	protected ChoiceContent initChoiceC() {
		return new ChoiceContent(Choice.C) {
			@Override
			protected boolean test() {
				return puzzle.isSameChoice(0, 8);
			}
			
		};
	}

	@Override
	protected ChoiceContent initChoiceD() {
		return new ChoiceContent(Choice.D) {
			@Override
			protected boolean test() {
				return puzzle.isSameChoice(5, 9);
			}
			
		};
	}

}
