package puzzle.question;

import puzzle.Puzzle;
import puzzle.enums.Choice;
import puzzle.enums.Question;

public class Question10 extends AbstractQuestion {

	private int diff;
	
	Question10(Puzzle puzzle) {
		super(puzzle, Question.Q10);
	}
	
	protected void setup() {
		diff = puzzle.getLimitCount()[1] - puzzle.getLimitCount()[0];
	}
	
	protected class ChoiceContentForQ10 extends ChoiceContent {

		protected int diffContent;
		
		public ChoiceContentForQ10(Choice label, int diffContent) {
			super(label);
			this.diffContent = diffContent;
		}

		@Override
		protected boolean test() {
			return diffContent == diff;
		}
	}
	
	@Override
	protected ChoiceContent initChoiceA() {
		return new ChoiceContentForQ10(Choice.A, 3);
	}

	@Override
	protected ChoiceContent initChoiceB() {
		return new ChoiceContentForQ10(Choice.B, 2);
	}

	@Override
	protected ChoiceContent initChoiceC() {
		return new ChoiceContentForQ10(Choice.C, 4);
	}

	@Override
	protected ChoiceContent initChoiceD() {
		return new ChoiceContentForQ10(Choice.D, 1);
	}

}
