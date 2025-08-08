package Exceptions;
/**
 * A custom exception to help narrow down application specific errors.
 * This exception can be thrown in cases where a specific error message
 * needs to be conveyed to users, since scenarios with built-in
 * exceptions are too generic.
 *
 */
public class CustomException extends Exception {
    /**
     * Constructs a new CustomException with the specified detail message.
     *
     */
    public CustomException(String message) {
        super(message);
    }
}

