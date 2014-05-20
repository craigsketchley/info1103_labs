package lab11;

import java.util.ArrayList;

public class Wordscore {
	protected ArrayList<String> words;

	public Wordscore() {
		words = new ArrayList<String>();
	}

	public Wordscore(String... inWords) {
		for (String s : inWords) {
			words.add(s);
		}
	}

	public int getMaxScore() {
		int maxScore = 0;
		for (String s : words) {
			if (getScore(s) > maxScore) {
				maxScore = getScore(s);
			}
		}
		return maxScore;
	}

	public double getAverageScore() {
		double averageScore = 0;
		for (String s : words) {
			averageScore += getScore(s);
		}
		averageScore /= words.size();
		return averageScore;
	}

	/*
	 * This method returns the score for a word.
	 * The score of a word is the sum of the scores of each letter, and
	 * the score of a letter is 1 for A or a, 2 for B or b, 3 for C or c,
	 * up to 26 for Z or z.
	 */
	public static int getScore(String w) {
		int sum = 0;
		String word = w.toLowerCase();
		for (int i = 0; i < word.length(); ++i) {
			sum += (int) word.charAt(i) - 'a' + 1;
		}
		return sum;
	}

	public static void main(String[] args) {
		Wordscore ws = new Wordscore("Hello", "World", "how", "are", "you");
		System.out.println(ws.getAverageScore());
		System.out.println(ws.getMaxScore());
	}

}