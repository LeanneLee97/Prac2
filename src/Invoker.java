import java.util.Stack;

public class Invoker {
    private Command[] cmdToExecute;

    public void setCommandsForExecution(Command[] commands) {
        this.cmdToExecute = commands;
    }
    public void executeCommand(Stack <Command> history) {
        if (cmdToExecute != null){
            for (Command commands : cmdToExecute){
                commands.execute();
                if (commands.isStackable()){
                    history.push(commands);
                }
            }
        }
    }
}
