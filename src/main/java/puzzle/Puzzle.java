package puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import puzzle.enums.Choice;
import puzzle.question.*;

public class Puzzle {

	private List<AbstractQuestion> questions;
	private List<Choice> answers;
	private Map<Choice, Integer> answerCount;
	
	public Puzzle() {
		questions = new ArrayList<AbstractQuestion>();
		answers = new ArrayList<Choice>();
		answerCount = new HashMap<Choice, Integer>();
		for (Choice c: Choice.values()) {
			answerCount.put(c, 0);
		}
	}
	
	public void initQuestions() {
		questions.add(new Question1(this));
		questions.add(new Question2(this));
		questions.add(new Question3(this));
		questions.add(new Question4(this));
		questions.add(new Question5(this));
		questions.add(new Question6(this));
		questions.add(new Question7(this));
		questions.add(new Question8(this));
		questions.add(new Question9(this));
		questions.add(new Question10(this));
	}

	public void fillInAnswer(List<Choice> answers) {
		this.answers = answers;
		countAnswers();
	}

	public Choice getAnswerOfQuestion(int i) {
		return answers.get(i);
	}
	
	public boolean test() {
		boolean result = true;
		int questionIdx = 1;
		while (result && questionIdx < questions.size()) {
			result = questions.get(questionIdx).test(answers.get(questionIdx));
			questionIdx++;
		}
//		if (!result) {
//			System.out.println(printCurrAnswer() + 
//					" failed at question[" + 
//					(questionIdx) + 
//					"]: " + answers.get(questionIdx - 1));
//		}
		return result;
	}
	
	public int countOptions(Choice option) {
		int count = 0;
		for (Choice o : answers) {
			if (o == option) {
				count++;
			}
		}
		return count;
	}
	
	public boolean isAnswer(int i, Choice choice) {
		return getAnswerOfQuestion(i) == choice;
	}

	public boolean isSameChoice(int i, int j) {
		return getAnswerOfQuestion(i) == getAnswerOfQuestion(j);
	}
	
	public void countAnswers() {
		for (Choice c: answers) {
			answerCount.put(c, answerCount.get(c) + 1);
		}
	}

	public Map<Choice, Integer> getAnswerCount() {
		return answerCount;
	}

	public Integer[] getLimitCount() {
		int smallest = 10;
		int largest = 0;
		for (Map.Entry<Choice, Integer> count: answerCount.entrySet()) {
			int c = count.getValue();
			if (c < smallest) {
				smallest = c;
			}
			if (c > largest) {
				largest = c;
			}
		}
		return new Integer[] {smallest, largest};
	}
	
	public String printCurrAnswer() {
		StringBuilder sb = new StringBuilder("[ ");
		int idx = 1;
		for (Choice c : answers) {
			sb.append(idx++).append(".").append(c).append(" ");
		}
		sb.append("]");
		return sb.toString();
	}
}
