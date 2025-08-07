package Invoker;

import Commands.*;
import Exceptions.*;
import java.util.Stack;

public class Invoker {
    private Command[] cmdToExecute;

    public void setCommandsForExecution(Command[] commands) {
        this.cmdToExecute = commands;
    }

    public void executeCommand(Stack<Command> history) {
        if (cmdToExecute != null) {
            for (Command command : cmdToExecute) {
                try {
                    if (command == null) {
                        throw new CustomException("Invalid Command");
                    }
                    command.execute();
                    if (command.isStackable()) {
                        history.push(command);
                    }
                } catch (CustomException e) {
                    System.out.println("Command failed");
                }
            }
        }
    }
}
