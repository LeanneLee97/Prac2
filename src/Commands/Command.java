package Commands;
import Exceptions.CustomException;
import Receiver.Receiver;
import java.util.Stack;
/**
 * The Command interface represents an operation that can be executed, undone,
 * and optionally recorded for undo functionality.
 *
 * This interface is part of the Command Design Pattern. It allows encapsulating
 * a request as an object, thereby letting us parameterise clients with queues,
 * requests, and operations.
 */
public interface Command {
    /**
     * Executes the command.
     *
     * @throws CustomException if an error occurs during execution
     */
    void execute() throws CustomException;

    /**
     * Undoes the command, reversing its effect.
     *
     * @throws CustomException if an error occurs during undo
     */
    void undo() throws CustomException;

    /**
     * Indicates whether the command should be saved to history for potential undo.
     *
     * @return true if the command is stackable and can be undone; false otherwise
     */
    boolean isStackable();
}

