import java.util.ArrayList;

public class Invoker {
    /**
     * Set commands for execution (replaces the queue).
     */
    private ArrayList<Command> commands = new ArrayList<>();

    public void setCommandsForExecution(ArrayList<Command> list) {
        this.commands = list;
    }

    public void executeCommand() {
        for (Command c : commands) {
            c.execute();
        }
    }
}
