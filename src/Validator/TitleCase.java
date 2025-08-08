package Validator;

public class TitleCase {
    private final String input;

    public TitleCase(String input) {
        this.input = input;
    }

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
