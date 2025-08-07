package Validator;

public class SentenceCase {
    private final String input;

    public SentenceCase(String input) {
        this.input = input;
    }

    public String sentenceCase() {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
