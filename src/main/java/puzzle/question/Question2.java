package puzzle.question;

import puzzle.Puzzle;
import puzzle.enums.Choice;
import puzzle.enums.Question;

public class Question2 extends AbstractQuestion {

	private Choice answerOfQuestionFive;

	Question2(Puzzle puzzle) {
		super(puzzle, Question.Q2);
	}
	
	protected void setup() {
		answerOfQuestionFive = puzzle.getAnswerOfQuestion(Question.Q5);
	}

	protected class ChoiceContentForQ2 extends ChoiceContent {
		
		protected final Choice toCompare;
		
		public ChoiceContentForQ2(Choice a, Choice toCompare) {
			super(a);
			this.toCompare = toCompare;
		}

		protected boolean test() {
			return this.toCompare == answerOfQuestionFive;
		}
		
	}
	@Override
	protected ChoiceContent initChoiceA() {
		return new ChoiceContentForQ2(Choice.A, Choice.C);
	}

	@Override
	protected ChoiceContent initChoiceB() {
		return new ChoiceContentForQ2(Choice.B, Choice.D);
	}

	@Override
	protected ChoiceContent initChoiceC() {
		return new ChoiceContentForQ2(Choice.C, Choice.A);
	}

	@Override
	protected ChoiceContent initChoiceD() {
		return new ChoiceContentForQ2(Choice.D, Choice.B);
	}

}
