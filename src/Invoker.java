import java.util.Stack;

public class Invoker {
    private Command[] commands;

    public void setCommandsForExecution(Command[] commands) {
        this.commands = commands;
    }
    public void executeCommand(Stack <Command> history) {
        if (commands != null){
            for (Command commands : commands){
                commands.execute();
                if (commands.isStackable()){
                    history.push(commands);
                }
            }
        }
    }
}
