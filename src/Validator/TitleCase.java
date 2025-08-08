package Validator;

public class TitleCase {
    private final String input;

    public TitleCase(String input) {
        this.input = input;
    }

    public String titleCase() {
        if (Character.isLetter(input.charAt(0))){
            return input.substring(0, 1).toUpperCase() + input.substring(1);
        }
        else{
            return input;
        }
    }
}
