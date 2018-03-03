package puzzle.question;

import puzzle.Puzzle;
import puzzle.enums.Choice;
import puzzle.enums.Question;

public class Question8 extends AbstractQuestion {

	private Choice answerOfQuestion1;

	Question8(Puzzle puzzle) {
		super(puzzle, Question.Q8);
	}
	
	protected void setup() {
		answerOfQuestion1 = puzzle.getAnswerOfQuestion(Question.Q1);
	}

	protected class ChoiceContentForQ8 extends ChoiceContent {

		protected Question questionToCompare;
		protected Choice choiceToCompare;
		
		public ChoiceContentForQ8(Choice label, Question questionToCompare) {
			super(label);
			this.questionToCompare = questionToCompare;
		}

		@Override
		protected boolean test() {
			int ordinalDiff = choiceToCompare.ordinal() - answerOfQuestion1.ordinal();
			return ordinalDiff != 1 && ordinalDiff != -1;
		}
		
		@Override
		protected void setupContent() {
			this.choiceToCompare = puzzle.getAnswerOfQuestion(questionToCompare);
		}
	}
	
	@Override
	protected ChoiceContent initChoiceA() {
		return new ChoiceContentForQ8(Choice.A, Question.Q7);
	}

	@Override
	protected ChoiceContent initChoiceB() {
		return new ChoiceContentForQ8(Choice.B, Question.Q5);
	}

	@Override
	protected ChoiceContent initChoiceC() {
		return new ChoiceContentForQ8(Choice.C, Question.Q2);
	}

	@Override
	protected ChoiceContent initChoiceD() {
		return new ChoiceContentForQ8(Choice.D, Question.Q10);
	}

}
