package Commands;
import java.util.Stack;

public class UndoCommand implements Command {
    private final Stack<Command> history;
    private final Receiver taskList;

    public UndoCommand(Stack<Command> history) {
        this.taskList = taskList;
        this.history = history;
    }

    @Override
    public void execute() throws CustomException {
        if (history.isEmpty()) {
            throw new CustomException("Nothing to Undo");
        }
        Command last = history.pop();
        last.undo();

    }

    @Override
    public void undo() {
        // Not Applicable
    }

    @Override
    public boolean isStackable() {
        return false;
    }
}
