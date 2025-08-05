// i added the cmdToExecute field
import java.util.Stack;
//package com.yourdomain.employeemgr;

public class Invoker {
    private Command[] cmdToExecute;

    public void setCommandsForExecution(Command[] commands) {
        this.cmdToExecute = commands;
    }

    public void executeCommand(Stack<Command> history) {
        if (cmdToExecute != null) {
            for (Command cmd : cmdToExecute) {
                if (cmd.execute() && cmd.isUndoable()) {
                    history.push(cmd);
                }
            }
        }
    }
}
