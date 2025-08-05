import java.util.Stack;

public class UndoCommand implements Command {
    private final Stack<Command> history;

    public UndoCommand(Stack<Command> history) {
        this.history = history;
    }

    @Override
    public void execute() {
        if (!history.isEmpty()) {
            Command last = history.pop();
            last.undo();
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    @Override
    public void undo() {
        // Not Applicable
    }
}
