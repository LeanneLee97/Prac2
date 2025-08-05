//package com.yourdomain.employeemgr;

import java.util.Stack;

public class UndoCommand implements Command {
    private final Receiver receiver;
    private final Stack<Command> history;

    public UndoCommand(Receiver receiver, Stack<Command> history) {
        this.receiver = receiver;
        this.history = history;
    }

    @Override
    public boolean execute() {
        if (history.isEmpty()) {
            System.out.println("No command to undo.");
            return false;
        }

        Command lastCommand = history.pop();
        lastCommand.undo();
        return true;
    }

    @Override
    public void undo() {
        // Undoing an undo is not typically supported.
        System.out.println("Undo of undo is not supported.");
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}
