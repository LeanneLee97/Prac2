//package com.yourdomain.employeemgr;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Receiver receiver = new Receiver();
        TaskList taskList = new TaskList(receiver);
        Invoker invoker = new Invoker();
        Stack<Command> history = new Stack<>();

        Path commandsPath = Paths.get(args[1]);
        try (BufferedReader reader = Files.newBufferedReader(commandsPath)) {
            String line;
            List<Command> cmds = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                Optional<Command> opt = taskList.parse(line);
                opt.ifPresent(cmds::add);
            }
            invoker.setCommandsForExecution(cmds.toArray(new Command[0]));
            invoker.executeCommand(history);
        }

        System.out.println("Final:");
        receiver.listAll();

        if (!history.isEmpty()) {
            Command last = history.pop();
            last.undo();
            System.out.println("After undo:");
            receiver.listAll();
        }
    }
}
