import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Command> history = new Stack<>();
        Receiver receiver = new Receiver();
        Invoker invoker = new Invoker();

        // ✅ Load from dataStore.txt
        ArrayList<String> loadedTasks = Storage.loadFromFile();
        for (String task : loadedTasks) {
            receiver.addTask(task);
        }

        // ✅ Hardcoded commands
        String[] inputs = {
                "add John Doe john@example.com",
                "add Alice Smith alice@example.com",
                "list",
                "update 0 Johnny Doe johnny@example.com",
                "list",
                "delete 1",
                "list",
                "undo",
                "list",
                "undo",
                "list"
        };

        for (String input : inputs) {
            System.out.println("\n> " + input);
            Command command = null;

            try {
                if (input.startsWith("add ")) {
                    String payload = input.substring(4).trim();
                    command = new AddCommand(receiver, payload);
                } else if (input.startsWith("update ")) {
                    String payload = input.substring(7).trim();
                    command = new UpdateCommand(receiver, payload);
                } else if (input.startsWith("delete ")) {
                    String payload = input.substring(7).trim();
                    command = new DeleteCommand(receiver, payload);
                } else if (input.equalsIgnoreCase("list")) {
                    command = new ListCommand(receiver);
                } else if (input.equalsIgnoreCase("undo")) {
                    command = new UndoCommand(history);
                } else {
                    System.out.println("Unknown command.");
                    continue;
                }

                invoker.setCommand(command);
                invoker.executeCommand();

                if (!(command instanceof UndoCommand || command instanceof ListCommand)) {
                    history.push(command);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // ✅ Save to dataStore.txt
        Storage.saveToFile(receiver.getAllTasks());
        System.out.println("\nTasks saved to dataStore.txt");
    }
}
