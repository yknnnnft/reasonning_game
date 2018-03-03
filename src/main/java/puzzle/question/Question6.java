package puzzle.question;

import puzzle.Puzzle;
import puzzle.enums.Choice;
import puzzle.enums.Question;

public class Question6 extends AbstractQuestion {

	private Choice answerOfQuestion8;
	
	Question6(Puzzle puzzle) {
		super(puzzle, Question.Q6);
	}
	
	protected void setup() {
		answerOfQuestion8 = puzzle.getAnswerOfQuestion(Question.Q8);
	}

	protected class ChoiceContentForQ6 extends ChoiceContent {

		protected Question[] questions;
		
		public ChoiceContentForQ6(Choice label, Question[] questions) {
			super(label);
			this.questions = questions;
		}

		@Override
		protected boolean test() {
			return answerOfQuestion8 == puzzle.getAnswerOfQuestion(questions[0]) &&
					answerOfQuestion8 == puzzle.getAnswerOfQuestion(questions[1]);
		}
		
	}
	
	@Override
	protected ChoiceContent initChoiceA() {
		return new ChoiceContentForQ6(Choice.A, new Question[] {Question.Q2, Question.Q4});
	}

	@Override
	protected ChoiceContent initChoiceB() {
		return new ChoiceContentForQ6(Choice.B, new Question[] {Question.Q1, Question.Q6});
	}

	@Override
	protected ChoiceContent initChoiceC() {
		return new ChoiceContentForQ6(Choice.C, new Question[] {Question.Q3, Question.Q10});
	}

	@Override
	protected ChoiceContent initChoiceD() {
		return new ChoiceContentForQ6(Choice.D, new Question[] {Question.Q5, Question.Q9});
	}

}
