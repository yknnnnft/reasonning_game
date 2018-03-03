package puzzle.question;

import puzzle.Puzzle;
import puzzle.enums.Choice;
import puzzle.enums.Question;

public class Question1 extends AbstractQuestion {

	Question1(Puzzle puzzle) {
		super(puzzle, Question.Q1);
	}

	protected class ChoiceContentForQ1 extends ChoiceContent {

		public ChoiceContentForQ1(Choice label) {
			super(label);
		}

		@Override
		protected boolean test() {
			return true;
		}
		
	}
	
	@Override
	protected ChoiceContent initChoiceA() {
		return new ChoiceContentForQ1(Choice.A);
	}

	@Override
	protected ChoiceContent initChoiceB() {
		return new ChoiceContentForQ1(Choice.B);
	}

	@Override
	protected ChoiceContent initChoiceC() {
		return new ChoiceContentForQ1(Choice.C);
	}

	@Override
	protected ChoiceContent initChoiceD() {
		return new ChoiceContentForQ1(Choice.D);
	}

}
