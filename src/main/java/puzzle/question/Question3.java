package puzzle.question;

import java.util.ArrayList;
import java.util.List;

import puzzle.Puzzle;
import puzzle.enums.Choice;
import puzzle.enums.Question;

public class Question3 extends AbstractQuestion {
	
	private List<Choice> allAnswersToCompare;
	
	Question3(Puzzle puzzle) {
		super(puzzle, Question.Q3);
		allAnswersToCompare = new ArrayList<Choice>();
	}

	protected class ChoiceContentForQ3 extends ChoiceContent {

		protected Question questionHeld;
		protected Choice answerToCompare;
		
		public ChoiceContentForQ3(Choice label, Question questionHeld) {
			super(label);
			this.questionHeld = questionHeld;
		}

		@Override
		protected boolean test() {
			int count = 0;
			for (Choice c : allAnswersToCompare) {
				if (answerToCompare == c) {
					count++;
				}
			}
			return count == 1;
		}

		@Override
		protected void setupContent() {
			this.answerToCompare = puzzle.getAnswerOfQuestion(questionHeld);
			allAnswersToCompare.add(answerToCompare);
		}
		
	}

	@Override
	protected ChoiceContent initChoiceA() {
		return new ChoiceContentForQ3(Choice.A, Question.Q3);
	}

	@Override
	protected ChoiceContent initChoiceB() {
		return new ChoiceContentForQ3(Choice.B, Question.Q6);
	}

	@Override
	protected ChoiceContent initChoiceC() {
		return new ChoiceContentForQ3(Choice.C, Question.Q2);
	}

	@Override
	protected ChoiceContent initChoiceD() {
		return new ChoiceContentForQ3(Choice.D, Question.Q4);
	}

}
