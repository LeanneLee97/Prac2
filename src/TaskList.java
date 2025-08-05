//package com.yourdomain.employeemgr;

import java.util.Optional;

public class TaskList {

    private final Receiver receiver;

    public TaskList(Receiver receiver) {
        this.receiver = receiver;
    }

    public Optional<Command> parse(String line) {
        String[] parts = line.split(",");
        if (parts.length < 2) {
            return Optional.empty();
        }

        String commandType = parts[0].trim();
        String[] params = new String[parts.length - 1];
        System.arraycopy(parts, 1, params, 0, params.length);

        switch (commandType.toLowerCase()) {
            case "add":
                return Optional.of(new AddCommand(receiver, params[0], params[1], params[2]));
//            case "delete":
//                return Optional.of(new DeleteCommand(receiver, Integer.parseInt(params[0])));
//            case "update":
//                return Optional.of(new UpdateCommand(receiver, Integer.parseInt(params[0]), params[1], params[2], params[3]));
//            case "list":
//                return Optional.of(new ListCommand(receiver));
//            case "undo":
//                return Optional.of(new UndoCommand(receiver));
            default:
                return Optional.empty();
        }

    }
}
