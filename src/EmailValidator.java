public class EmailValidator {
    public static boolean isValidEmail(String email) {
        String regex =
            "^[A-Za-z0-9_](?:[A-Za-z0-9_]|(?<![.-])[.-](?![.-]))*[A-Za-z0-9_]@" +  // Local part
            "(?![.-])[A-Za-z0-9.-]+(?<![.-])\\." +                                 // Domain
            "[a-z]{2,3}$";                                                         // Extension

        return email.matches(regex);
    }

}

