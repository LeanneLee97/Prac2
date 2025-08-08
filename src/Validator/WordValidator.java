package Validator;
/**
 * Utility class to validate a word-based input.
 *
 * This validator ensures that the input consists only of:
 * - Uppercase and lowercase Latin letters (A to Z and a to z)
 * - Digits (0 to 9)
 * - Underscores ( _ )
 *
 * No other characters such as symbols, spaces, or punctuation are allowed.
 */

public class WordValidator {
    /**
     * Validates whether the provided string is a valid word entry.
     * A valid entry contains only letters (A to Z and a to z), digits (0 to 9), or underscores.
     *
     * @param input the input string to validate
     * @return true if the input matches the valid word pattern, false otherwise
     */
    public static boolean isValidEntry(String email) {
            String regex = "^[A-Za-z0-9_]+$";
            return email.matches(regex);//
    }
}

