package Validator;

public class EmailValidator {
    public static boolean isValidEmail(String email) {
        if (email.equals("Email")) {
            return true;
        } // placeholder for now, we need a checking logic to look for "@" in the email vs word
        else{
            String regex =
                    "(^[A-Za-z0-9_]+(?:[.-][A-Za-z0-9_]+)*" +    // local part
                            "@" +
                            "(?!.*[_])" +                                // no underscore in domain
                            "[A-Za-z0-9]+(?:[.-][A-Za-z0-9]+)*" +       // domain
                            "\\.[a-z]{2,3}$)";
            return email.matches(regex);//
        }
        // extension (2-3 lowercase letters)
    }
}

