package puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import puzzle.enums.Choice;
import puzzle.enums.Question;
import puzzle.question.AbstractQuestion;
import puzzle.question.QuestionListFactory;

public class Puzzle {
	
	private List<AbstractQuestion> questions;
	private List<Choice> answers;
	private Map<Choice, Integer> answerCount;
	
	public Puzzle() {
		answers = new ArrayList<Choice>();
		answerCount = new HashMap<Choice, Integer>();
		for (Choice c: Choice.values()) {
			answerCount.put(c, 0);
		}
	}
	
	public void initQuestions() {
		questions = QuestionListFactory.getQuestions(this);
	}

	public void fillInAnswer(List<Choice> answers) {
		this.answers = answers;
		countAnswers();
	}

	public Choice getAnswerOfQuestion(Question q) {
		return answers.get(q.ordinal());
	}
	
	public boolean test() {
		boolean result = true;
		int questionIdx = 1;
		while (result && questionIdx < questions.size()) {
			result = questions.get(questionIdx).exec(answers.get(questionIdx));
			questionIdx++;
		}
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
	
	public boolean isAnswer(Question q, Choice choice) {
		return getAnswerOfQuestion(q) == choice;
	}

	public boolean isSameChoice(Question q1, Question q2) {
		return getAnswerOfQuestion(q1) == getAnswerOfQuestion(q2);
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
