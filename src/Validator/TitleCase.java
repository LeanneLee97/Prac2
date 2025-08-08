package Validator;
/**
 * Utility class to convert a given input string into title case format.
 * 
 * Title case means the first letter of each word is capitalized (if it is a letter),
 * and the rest of the letters in the word are converted to lowercase.
 * Words starting with non-letter characters retain their first character as is,
 * while the remaining characters are converted to lowercase.
 * 
 * Words are assumed to be separated by spaces. Consecutive spaces are ignored.
 * 
 * Example usage:
 * TitleCase tc = new TitleCase("jOhn DOE");
 * String formatted = tc.titleCase(); // returns "John Doe"
 */

public class TitleCase {
    private final String input;
    /**
     * Constructs a TitleCase formatter for the given input string.
     * 
     * @param input the input string to be converted to title case
     */

    public TitleCase(String input) {
        this.input = input;
    }
    /**
     * Converts the input string to title case.
     * Each word's first character is capitalized if it is a letter, otherwise kept as is.
     * The rest of the characters in each word are converted to lowercase.
     * Words are separated by spaces.
     * 
     * @return the title-cased string, or the original input if null or empty
     */
    public String titleCase() {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (word.isEmpty()) {
                continue;
            }

            String formatted;
            char firstChar = word.charAt(0);

            if (Character.isLetter(firstChar)) {
                formatted = Character.toUpperCase(firstChar) + word.substring(1).toLowerCase();
            } else {
                formatted = firstChar + word.substring(1).toLowerCase();
            }

            result.append(formatted);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
