package puzzle.question;

import puzzle.Puzzle;
import puzzle.enums.Choice;
import puzzle.enums.Question;

public class Question9 extends AbstractQuestion {

	protected Choice answerForQ5;
	private boolean isQuestion1And6Same;

	Question9(Puzzle puzzle) {
		super(puzzle, Question.Q9);
	}
	
	protected void setup() {
		isQuestion1And6Same = puzzle.isSameChoice(Question.Q1, Question.Q6);
		answerForQ5 = puzzle.getAnswerOfQuestion(Question.Q5);
	}
	
	protected class ChoiceContentForQ9 extends ChoiceContent {

		protected boolean isQuestionXSame;
		protected Question questionX;
		
		public ChoiceContentForQ9(Choice label, Question questionX) {
			super(label);
			this.questionX = questionX;
		}
		@Override
		protected boolean test() {
			return isQuestionXSame == !isQuestion1And6Same;
		}
		
		@Override
		protected void setupContent() {
			this.isQuestionXSame = puzzle.isAnswer(questionX, answerForQ5);
		}
	}
	
	@Override
	protected ChoiceContent initChoiceA() {
		return new ChoiceContentForQ9(Choice.A, Question.Q6);
	}

	@Override
	protected ChoiceContent initChoiceB() {
		return new ChoiceContentForQ9(Choice.B, Question.Q10);
	}

	@Override
	protected ChoiceContent initChoiceC() {
		return new ChoiceContentForQ9(Choice.C, Question.Q2);
	}

	@Override
	protected ChoiceContent initChoiceD() {
		return new ChoiceContentForQ9(Choice.D, Question.Q9);
	}

}
