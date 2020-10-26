/* Following the specification in the README.md file, provide your
 * SpellChecker class.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class SpellChecker {

    private HashSet<String> dictionary;
    private List<String> incorrect;
    private File inFile;

    public SpellChecker(String file) throws FileNotFoundException {
        //   suggestions = new ArrayList<String>();
        incorrect = new ArrayList<>();
        dictionary = new HashSet<>();
        inFile = new File(file);
        Scanner input = new Scanner(inFile);

        //adds words from file into dictionary
        while (input.hasNext()) {
            String word = input.nextLine();
            dictionary.add(word.toLowerCase());
        }

    }

    public List<String> getIncorrectWords(String filename) throws
            FileNotFoundException {

        inFile = new File(filename);
        Scanner input = new Scanner(inFile);

        //splits lines into string array words
        while (input.hasNext()) {
            String line = input.nextLine().toLowerCase();
            String[] words = line.split("\\s+");

            for (String word : words) {
                //checks if first index is alphanumeric
                if (word.length() > 0) {
                    if (!Character.isLetterOrDigit(word.charAt(0))) {
                        word = word.substring(1, word.length());
                    }
                }
                //checks if last index is alphnumeric
                if (word.length() > 0 && !Character.isLetterOrDigit(word
                        .charAt(word.length() - 1))) {
                    word = word.substring(0, word.length() - 1);
                }
                
                //adds incorrect words to incorrect
                if (!dictionary.contains(word) && word.length() > 0) {
                    incorrect.add(word);
                }
            }
        }
        return incorrect;
    }


    public List<String> getSuggestions(String word) {
        
        List<String> suggestions = new ArrayList<>();

        //ADD character
        for (char j = 'a'; j <= 'z'; j++) {
            for (int i = 0; i < word.length() + 1; i++) {
                String tmp = word.substring(0, i) + j + word.substring(i,
                        word.length());
                if (dictionary.contains(tmp) && !suggestions.contains(tmp)) {
                    suggestions.add(tmp);
                }
            }
        }
       
        //REMOVE character
        for (int i = 0; i < word.length(); i++) {
            String tmp = word.substring(0, i) + word.substring(i + 1, word
                    .length());
            if (dictionary.contains(tmp) && !suggestions.contains(tmp)) {
                suggestions.add(tmp);
            }
        }

        //SWAP character
        for (int i = 0; i < word.length() - 1; i++) {
            String tmp = word.substring(0, i) + word.substring(i + 1, i + 2)
                    + word.substring(i, i + 1);
            
            if (i < word.length() - 2) {
                tmp = tmp + word.substring(i + 2, word.length());
            }
            if (dictionary.contains(tmp) && !suggestions.contains(tmp)) {
                suggestions.add(tmp);
            }
        }
        
        return suggestions;
    }
}