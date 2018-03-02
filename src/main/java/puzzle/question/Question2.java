package puzzle.question;

import puzzle.Puzzle;
import puzzle.enums.Choice;

public class Question2 extends AbstractQuestion {

	private Choice answerOfQuestionFive;

	public Question2(Puzzle puzzle) {
		super(puzzle);
		answerOfQuestionFive = puzzle.getAnswerOfQuestion(4);
	}

	@Override
	protected ChoiceContent initChoiceA() {
		return new ChoiceContent(Choice.A) {
			@Override
			protected boolean test() {
				return answerOfQuestionFive == Choice.C;
			}
		};
	}

	@Override
	protected ChoiceContent initChoiceB() {
		return new ChoiceContent(Choice.B) {
			@Override
			protected boolean test() {
				return answerOfQuestionFive == Choice.D;
			}
			
		};
	}

	@Override
	protected ChoiceContent initChoiceC() {
		return new ChoiceContent(Choice.C) {
			@Override
			protected boolean test() {
				return answerOfQuestionFive == Choice.A;
			}
			
		};
	}

	@Override
	protected ChoiceContent initChoiceD() {
		return new ChoiceContent(Choice.D) {
			@Override
			protected boolean test() {
				return answerOfQuestionFive == Choice.B;
			}
			
		};
	}

}
