package puzzle.question;

import java.util.ArrayList;
import java.util.List;

import puzzle.Puzzle;
import puzzle.enums.Choice;

public class Question6 extends AbstractQuestion {

	private List<Integer[]> questions;
	private Choice answerOfQuestion8;
	public Question6(Puzzle puzzle) {
		super(puzzle);
		questions = new ArrayList<Integer[]>();
		questions.add(new Integer[] {1, 3});
		questions.add(new Integer[] {0, 5});
		questions.add(new Integer[] {2, 9});
		questions.add(new Integer[] {4, 8});
		answerOfQuestion8 = puzzle.getAnswerOfQuestion(7);
	}

	private boolean testChoice(Choice choice) {
		Integer[] q = questions.get(choice.ordinal());
		return answerOfQuestion8 == puzzle.getAnswerOfQuestion(q[0]) &&
				answerOfQuestion8 == puzzle.getAnswerOfQuestion(q[1]);
	}

	@Override
	protected ChoiceContent initChoiceA() {
		return new ChoiceContent(Choice.A) {
			@Override
			protected boolean test() {
				return testChoice(label);
			}
			
		};
	}

	@Override
	protected ChoiceContent initChoiceB() {
		return new ChoiceContent(Choice.B) {
			@Override
			protected boolean test() {
				return testChoice(label);
			}
			
		};
	}

	@Override
	protected ChoiceContent initChoiceC() {
		return new ChoiceContent(Choice.C) {
			@Override
			protected boolean test() {
				return testChoice(label);
			}
			
		};
	}

	@Override
	protected ChoiceContent initChoiceD() {
		return new ChoiceContent(Choice.D) {
			@Override
			protected boolean test() {
				return testChoice(label);
			}
			
		};
	}

}
