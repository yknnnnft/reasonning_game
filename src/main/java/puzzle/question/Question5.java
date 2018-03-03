package puzzle.question;

import puzzle.Puzzle;
import puzzle.enums.Choice;
import puzzle.enums.Question;

public class Question5 extends AbstractQuestion {

	Question5(Puzzle puzzle) {
		super(puzzle, Question.Q5);
	}

	protected class ChoiceContentForQ5 extends ChoiceContent {

		protected Question questionToCompare;
		
		public ChoiceContentForQ5(Choice label, Question questionToCompare) {
			super(label);
			this.questionToCompare = questionToCompare;
		}

		@Override
		protected boolean test() {
			return puzzle.isAnswer(questionToCompare, label);
		}
		
	}
	
	@Override
	protected ChoiceContent initChoiceA() {
		return new ChoiceContentForQ5(Choice.A, Question.Q8);
	}

	@Override
	protected ChoiceContent initChoiceB() {
		return new ChoiceContentForQ5(Choice.B, Question.Q4);
	}

	@Override
	protected ChoiceContent initChoiceC() {
		return new ChoiceContentForQ5(Choice.C, Question.Q9);
	}

	@Override
	protected ChoiceContent initChoiceD() {
		return new ChoiceContentForQ5(Choice.D, Question.Q7);
	}

}
