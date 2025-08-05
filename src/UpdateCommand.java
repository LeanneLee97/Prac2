//package com.yourdomain.employeemgr;

import java.util.List;

public class UpdateCommand implements Command {
    private final Receiver receiver;
    private final int index;
    private final Employee newEmployee;
    private Employee previousEmployee;

    public UpdateCommand(Receiver receiver, int index, Employee newEmployee) {
        this.receiver = receiver;
        this.index = index;
        this.newEmployee = newEmployee;
    }

    @Override
    public boolean execute() {
        if (index < 1 || index > receiver.getEmployees().size()) {
            System.out.println("Invalid index.");
            return false;
        }

        previousEmployee = receiver.getEmployees().get(index - 1);
        receiver.update(index, newEmployee);
        return true;
    }

    @Override
    public void undo() {
        if (previousEmployee != null) {
            receiver.update(index, previousEmployee);
        } else {
            System.out.println("No previous state to revert to.");
        }
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}
