/**
 * Package containing command implementations for task operations.
 */
package Commands;
import Exceptions.CustomException;
import Receiver.Receiver;
import java.util.Stack;

/**
 * Represents a command to undo the last executed stackable command.
 * This command retrieves the most recent {@link Command} from the history stack
 * and calls its {@code undo()} method to revert its effect.
 * The {@code UndoCommand} itself is not stackable, meaning it will not be stored
 * in the command history when executed.
 */
public class UndoCommand implements Command {
    private final Stack<Command> history;
    private final Receiver taskList;

    /**
     * Creates an instance of {@code UndoCommand}.
     *
     * @param taskList the {@link Receiver} containing the task list to be manipulated
     * @param history  the stack of previously executed commands to be undone
     */
    public UndoCommand( Receiver taskList, Stack<Command> history) {
        this.taskList = taskList;
        this.history = history;
    }

    /**
     * Executes the undo operation by removing the most recent command
     * from the history stack and calling its {@code undo()} method.
     *
     * @throws CustomException if the history stack is empty and there is nothing to undo
     */
    @Override
    public void execute() throws CustomException {
        if (history.isEmpty()) {
            throw new CustomException("Nothing to Undo");
        }
        Command last = history.pop();
        last.undo();

    }

    /**
     * Undoing an {@code UndoCommand} is not supported.
     *
     * @throws CustomException always, because undoing an undo is not applicable
     */
    @Override
    public void undo()  throws CustomException {
        // Not Applicable
        throw new CustomException("Nothing to Undo");
    }

    /**
     * Indicates whether this command should be added to the command history.
     *
     * @return {@code false} because {@code UndoCommand} should not be stackable
     */
    @Override
    public boolean isStackable() {
        return false;
    }
}

