package puzzle.question;

import java.util.ArrayList;
import java.util.List;

import puzzle.Puzzle;
import puzzle.enums.Choice;
import puzzle.enums.Question;

public abstract class AbstractQuestion {

	protected List<ChoiceContent> choices;
	protected final Question label;
	protected Puzzle puzzle;
	
	AbstractQuestion(Puzzle puzzle, Question label) {
		this.puzzle = puzzle;
		this.label = label;
	}
	
	public boolean exec(Choice answer) {
		setup();
		choices = initChoices();
		return test(answer);
	}
	
	protected void setup() {
		return;
	}

	public boolean test(Choice answer) {
		return choices.get(answer.ordinal()).execTest();
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


	protected abstract class ChoiceContent {
		
		protected Choice label;

		public ChoiceContent(Choice label) {
			this.label = label;
		}

		public boolean execTest() {
			setupContent();
			return test();
		}
		
		protected abstract boolean test();

		protected void setupContent() {
			return;
		}
		
		protected Choice getLabel() {
			return label;
		}
	}
}
