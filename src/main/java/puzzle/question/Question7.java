package puzzle.question;

import java.util.Map;

import puzzle.Puzzle;
import puzzle.enums.Choice;
import puzzle.enums.Question;

public class Question7 extends AbstractQuestion {

	private Map<Choice, Integer> count;
	
	Question7(Puzzle puzzle) {
		super(puzzle, Question.Q7);
	}
	
	protected void setup() {
		count = puzzle.getAnswerCount();
	}

	protected class ChoiceContentForQ7 extends ChoiceContent {

		protected Choice choiceToCompare;
		
		public ChoiceContentForQ7(Choice label, Choice choiceToCompare) {
			super(label);
			this.choiceToCompare = choiceToCompare;
		}

		@Override
		protected boolean test() {
			for (Choice c: Choice.values()) {
				if (c == choiceToCompare) {
					continue;
				}
				if (count.get(choiceToCompare) >= count.get(c)) {
					return false;
				}
			}
			return true;
		}
		
	}
	
	@Override
	protected ChoiceContent initChoiceA() {
		return new ChoiceContentForQ7(Choice.A, Choice.C);
	}

	@Override
	protected ChoiceContent initChoiceB() {
		return new ChoiceContentForQ7(Choice.B, Choice.B);
	}

	@Override
	protected ChoiceContent initChoiceC() {
		return new ChoiceContentForQ7(Choice.C, Choice.A);
	}

	@Override
	protected ChoiceContent initChoiceD() {
		return new ChoiceContentForQ7(Choice.D, Choice.D);
	}

}
