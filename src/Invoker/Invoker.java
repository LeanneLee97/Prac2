package Invoker;

import Commands.*;
import Exceptions.*;
import java.util.Stack;

/**
 * The Invoker class is responsible for executing commands.
 * It holds an array of commands to execute and triggers their execution.
 * It also manages a history stack to support undo operations for commands
 * that are stackable.
 */

public class Invoker {
    private Command[] cmdToExecute;
    /**
     * Sets the array of commands to be executed.
     *
     * @param commands an array of Command objects to be executed
     */

    public void setCommandsForExecution(Command[] commands) {
        this.cmdToExecute = commands;
    }
    /**
     * Executes all the commands set in this invoker.
     * For each command, this method calls {@code execute()}. If a command
     * is stackable (e.g supports undo), it is pushed on to the history stack.
     * If any command is invalid or fails, a CustomException is caught and
     * a message is printed.
     *
     * @param history a stack to store executed commands that support undo
     */
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

                    System.out.println("Command failed: " + e.getMessage());

                }
            }
        }
    }
}
