package Validator;

public class EmailValidator {
    public static boolean isValidEmail(String email) {
        String regex =
                "(Email|^[A-Za-z0-9_]+(?:[.-][A-Za-z0-9_]+)*" +    // local part
                        "@" +
                        "(?!.*[_])" +                                // no underscore in domain
                        "[A-Za-z0-9]+(?:[.-][A-Za-z0-9]+)*" +       // domain
                        "\\.[a-z]{2,3}$)";                            //
        // extension (2-3 lowercase letters)

        return email.matches(regex);
    }


}

