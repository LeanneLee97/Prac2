public class isValidEmail {
    public static boolean isValidEmail(String email) {


        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || atIndex == email.length() - 1) {
            return false; // must have non-empty local part and domain
        }

        String localPart = email.substring(0, atIndex);
        String domainPart = email.substring(atIndex + 1);

        // Local Check uppercase and lowercase Latin letters A to Z and a to z digits 0 to 9
        if (!localPart.matches("^[A-Za-z0-9._-]+$")) {
            return false;
        }

        // Domain Check uppercase and lowercase Latin letters A to Z and a to z digits 0 to 9
        if (!domainPart.matches("^[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            return false;
        }

        // printable characters ._- (dot, underscore & dash). Note that for the printable
        // characters, they must not be present as either the first or last character and also do not
        // appear consecutively. The underscore character is the exception to this rule.

        for (int i = 0; i < localPart.length(); i++) {
            char c = localPart.charAt(i);

            if ((c == '.' || c == '-') && (i == 0 || i == localPart.length() - 1)) {
                return false; // . or - at start or end
            }

            // Consecutive . or - (not _)
            if ((c == '.' || c == '-') && i > 0) {
                char prev = localPart.charAt(i - 1);
                if (prev == '.' || prev == '-') {
                    return false;
                }
            }
        }

        // printable characters .- (dot & dash). Note that for the printable characters, they must
        // not be present as either the first or last character and also do not appear consecutively
        // underscore NOT ALLOWED anywhere in Domain Part
        for (int i = 0; i < domainPart.length(); i++) {
            char c = domainPart.charAt(i);

            if ((c == '.' || c == '-') && (i == 0 || i == domainPart.length() - 1)) {
                return false; // . or - at start or end
            }

            // Consecutive . or -
            if ((c == '.' || c == '-') && i > 0) {
                char prev = domainPart.charAt(i - 1);
                if (prev == '.' || prev == '-') {
                    return false;
                }
            }
        }
        int lastDotIndex = domainPart.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == 0 || lastDotIndex == domainPart.length() - 1) {
            // No dot or dot at start/end is invalid
            return false;
        }

        String domainName = domainPart.substring(0, lastDotIndex);
        String domainExt = domainPart.substring(lastDotIndex + 1);

        // the “ .xxx ” part of the domain is allowed to have a range of minimum 2 to a maximum
        //of 3 characters. In addition, only lowercase Latin letters a to z are allowed.
        if (domainExt.length() < 2 || domainExt.length() > 3) {
            return false;
        }

        if (!domainExt.matches("[a-z]{2,3}")) {
            return false;
        }

        return true;
    }

}

