import java.util.*;
import java.io.*;

public class SpellCheckerTester {

	public static void main(String[] args) throws IOException {

		SpellChecker checker = new SpellChecker("words.txt");
		List<String> incorrectWords = checker.getIncorrectWords("test.txt");

		for(String word : incorrectWords) {
			List<String> suggestions = checker.getSuggestions(word);
			System.out.print(word + " - ");
			for (String suggestion : suggestions) {
				System.out.print(suggestion + " ");
			}
			System.out.println();
		}
	}
}
