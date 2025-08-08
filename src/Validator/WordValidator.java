package Validator;

public class WordValidator {
    public static boolean isValidEntry(String email) {
            String regex = "^[A-Za-z0-9_]+$";
            return email.matches(regex);//
    }
}

