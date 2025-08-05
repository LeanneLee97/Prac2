//package com.yourdomain.employeemgr;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.io.BufferedReader;


public class Client {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: Client <state-file> <commands-file>");
            System.exit(1);
        }

        Path statePath = Paths.get(args[0]);
        Path commandsPath = Paths.get(args[1]);

        Receiver receiver = new Receiver();

        if (Files.exists(statePath)) {
            try {
                receiver.loadFromFile(statePath);
                System.out.println("Loaded stored employees.");
            } catch (IOException ex) {
                System.err.println("Error loading state: " + ex.getMessage());
                System.exit(1);
            }
        }

        TaskList registry = new TaskList(receiver);
        Invoker invoker = new Invoker();
        Stack<Command> history = new Stack<>(); // Changed from Deque to Stack

        try (BufferedReader reader = Files.newBufferedReader(commandsPath)) {
            List<Command> commands = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                Optional<Command> cmdOpt = registry.parse(line);
                if (cmdOpt.isEmpty()) {
                    System.err.println("Invalid command: " + line);
                    continue;
                }
                commands.add(cmdOpt.get());
            }
            invoker.setCommandsForExecution(commands.toArray(new Command[0]));
            invoker.executeCommand(history);
        } catch (IOException ex) {
            System.err.println("Error reading commands file: " + ex.getMessage());
            System.exit(1);
        }

        try {
            receiver.storeToFile(statePath);
            System.out.println("State saved to file.");
        } catch (IOException ex) {
            System.err.println("Error saving state: " + ex.getMessage());
        }

        System.out.println("Final Employee List:");
        receiver.listAll();

        if (!history.isEmpty()) {
            Command last = history.pop();
            last.undo();
            System.out.println("Last command undone.");
            receiver.listAll();
        }
    }
}
