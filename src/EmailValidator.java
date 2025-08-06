public class EmailValidator {
        public static boolean isValidEmail(String email) {
        String regex =
                "^[A-Za-z0-9](?:[A-Za-z0-9_]|(?<![.-])[.-](?![.-]))*[A-Za-z0-9_]" + // local part
                        "@" +
                        "(?![.-])[A-Za-z0-9.-]+(?<![.-])\\." +                            // domain name
                        "[a-z]{2,3}$";                                                    // extension (2–3 lowercase letters)

        return email.matches(regex);
    }

}

