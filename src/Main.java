//package com.yourdomain.employeemgr;

import java.nio.file.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: Main <state-file> <commands-file>");
            System.exit(1);
        }

        Path stateFile = Paths.get(args[0]);
        Path commandsFile = Paths.get(args[1]);

        EmployeeManager manager = new EmployeeManager();
        // Load persisted data if exists
        if (Files.exists(stateFile)) {
            try {
                manager.loadFromCsv(stateFile);
                System.out.println("Loaded employees from " + stateFile);
            } catch (IOException e) {
                System.err.println("Error loading state: " + e.getMessage());
                System.exit(1);
            }
        }

        CommandRegistry registry = new CommandRegistry(manager);
        Deque<Command> history = new ArrayDeque<>();

        // Process instructions
        try (BufferedReader reader = Files.newBufferedReader(commandsFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Optional<Command> opt = registry.parse(line);
                if (opt.isEmpty()) {
                    System.err.println("Invalid command: " + line);
                    continue;
                }
                Command cmd = opt.get();
                boolean executed = cmd.execute();

                if (executed && cmd.isUndoable()) {
                    history.push(cmd);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading commands: " + e.getMessage());
            System.exit(1);
        }

        // Save final state
        try {
            manager.saveToCsv(stateFile);
            System.out.println("Saved state to " + stateFile);
        } catch (IOException e) {
            System.err.println("Error saving state: " + e.getMessage());
        }

        // Print final listing
        System.out.println("Final Employee List:");
        manager.listAll();

        // Example of undoing last command (if interactive mode allowed)
        if (!history.isEmpty()) {
            Command last = history.pop();
            last.undo();
            System.out.println("Undid last command.");
            manager.listAll();
        }
    }
}
