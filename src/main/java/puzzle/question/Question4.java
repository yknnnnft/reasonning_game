package puzzle.question;

import puzzle.Puzzle;
import puzzle.enums.Choice;
import puzzle.enums.Question;

public class Question4 extends AbstractQuestion {

	Question4(Puzzle puzzle) {
		super(puzzle, Question.Q4);
	}

	protected class ChoiceContentForQ4 extends ChoiceContent {

		protected Question q1;
		protected Question q2;
		
		public ChoiceContentForQ4(Choice label, Question q1, Question q2) {
			super(label);
			this.q1 = q1;
			this.q2 = q2;
		}

		@Override
		protected boolean test() {
			return puzzle.isSameChoice(q1, q2);
		}
		
	}
	
	@Override
	protected ChoiceContent initChoiceA() {
		return new ChoiceContentForQ4(Choice.A, Question.Q1, Question.Q5);
	}

	@Override
	protected ChoiceContent initChoiceB() {
		return new ChoiceContentForQ4(Choice.B, Question.Q2, Question.Q7);
	}

	@Override
	protected ChoiceContent initChoiceC() {
		return new ChoiceContentForQ4(Choice.C, Question.Q1, Question.Q9);
	}

	@Override
	protected ChoiceContent initChoiceD() {
		return new ChoiceContentForQ4(Choice.D, Question.Q6, Question.Q10);
	}

}
