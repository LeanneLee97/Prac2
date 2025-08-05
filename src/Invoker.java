// i added the cmdToExecute field
import java.util.Stack;

public class Invoker {
    private Command[] cmdToExecute;

    public void setCommandsForExecution(Command[] commands) {
        this.cmdToExecute = commands;
    }

    public void executeCommand(Stack<Command> history) {
        if (cmdToExecute != null) {
            for (Command command : cmdToExecute) {
                if (command.execute()) {
                    if (command.isUndoable()) {
                        history.push(command);
                    }
                }
            }
        }
    }
}
