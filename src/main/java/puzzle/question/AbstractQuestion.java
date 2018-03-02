package puzzle.question;

import java.util.ArrayList;
import java.util.List;

import puzzle.Puzzle;
import puzzle.enums.Choice;

public abstract class AbstractQuestion {

	protected List<ChoiceContent> choices;
	protected Puzzle puzzle;
	
	public AbstractQuestion(Puzzle puzzle) {
		this.puzzle = puzzle;
		choices = initChoices();
	}
	
	protected List<ChoiceContent> initChoices() {
		List<ChoiceContent> choices = new ArrayList<ChoiceContent>();
		ChoiceContent choiceA = initChoiceA();
		choices.add(choiceA);
		ChoiceContent choiceB = initChoiceB();
		choices.add(choiceB);
		ChoiceContent choiceC = initChoiceC();
		choices.add(choiceC);
		ChoiceContent choiceD = initChoiceD();
		choices.add(choiceD);
		return choices;
	}

	protected abstract ChoiceContent initChoiceA();
	protected abstract ChoiceContent initChoiceB();
	protected abstract ChoiceContent initChoiceC();
	protected abstract ChoiceContent initChoiceD();

	public boolean test(Choice answer) {
		return choices.get(answer.ordinal()).test();
	}

	protected abstract class ChoiceContent {
		
		protected Choice label;

		public ChoiceContent(Choice label) {
			this.label = label;
		}

		protected abstract boolean test();

		protected Choice getLabel() {
			return label;
		}
	}
}
