package puzzle;

import java.util.List;

import puzzle.enums.Choice;

public class Tester {

	private static final double PROGRESS_INTERVAL = 0.1;

	public void exec() {
		List<Choice> oneAnswers = null;
		System.out.println("[tester] test starts...");
		double breakPoint = PROGRESS_INTERVAL;
		for (int idx = 0; idx < AnswerFactory.MAX; idx++) {
			double progress = (double) idx / AnswerFactory.MAX;
			if (progress >= breakPoint){
				System.out.println(String.format("[tester] %.0f%%(%d/%d) completed...",
						breakPoint * 100, idx, AnswerFactory.MAX));
				breakPoint += PROGRESS_INTERVAL;
			}
			oneAnswers = AnswerFactory.getAnswer(idx);
			Puzzle puzzle = new Puzzle();
			puzzle.fillInAnswer(oneAnswers);
			puzzle.initQuestions();
			if (puzzle.test()) {
				System.out.println("===========================");
				System.out.println(String.format("[tester] succeeded at: %dth time try. \nAnswer: %s",
						idx, puzzle.printCurrAnswer()));
				System.out.println("===========================");
			}	
		}
		System.out.println("[tester] test is over.");
	}
}
