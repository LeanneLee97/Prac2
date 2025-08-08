package Validator;
/**
 * Utility class for validating email addresses.
 */
public class EmailValidator {
    /**
     * Validates whether the provided email string is a valid email address
     * according to a specific regex pattern.
     * 
     * The validation rules include:
     * - The local part must contain only letters, digits, and underscores,
     *   and can contain dots or hyphens between valid characters.
     * - The domain part (2 parts) must follow the format yyyy.xxx:
     *   * Contains uppercase and lowercase Latin letters A to Z and a to z.
     *   * Contains digits 0 to 9.
     *   * Contains printable characters dot (.) and dash (-) only.
     *   * Dot and dash must not be present as the first or last character.
     *   * Dot and dash must not appear consecutively.
     *   * The ".xxx" part (top-level domain) must be 2 to 3 characters long.
     *   * The top-level domain characters can only be lowercase Latin letters a to z.
     * - The domain part must not contain underscores.
     * - The top-level domain (extension) must be 2 or 3 lowercase letters.
     * 
     * @param email the email string to validate
     * @return true if the email matches the pattern; false otherwise
     */


    public static boolean isValidEntry(String email) {

// placeholder for now, we need a checking logic to look for "@" in the email vs word
            String regex =
                    "(^[A-Za-z0-9_]+(?:[.-][A-Za-z0-9_]+)*" +    // local part
                            "@" +
                            "(?!.*[_])" +                                // no underscore in domain
                            "[A-Za-z0-9]+(?:[.-][A-Za-z0-9]+)*" +       // domain
                            "\\.[a-z]{2,3}$)";
            // extension (2-3 lowercase letters)
            return email.matches(regex);//

    }
}

