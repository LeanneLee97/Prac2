import java.util.Stack;

public class Client {
    public static void main(String[] args) {
        Stack<Command> history = new Stack<>();
        Receiver receiver = new Receiver();
        Invoker invoker = new Invoker();

        String[] inputs = {
                "add John Doe john@gmail.com",
                "add Alice Smith alice@gmail.com",
                "list",
                "add Tommy Lee tommy@gmail.com",
                "update 0 Johnny Doe johnny@gmail.com",
                "list",
                "delete 2",
                "list"
        };

        for (String input : inputs) {
            System.out.println(input);
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

                invoker.setCommandsForExecution(new Command[] { command });
                invoker.executeCommand(history);

                if (!(command instanceof UndoCommand || command instanceof ListCommand)) {
                    history.push(command);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // ✅ Save to dataStore.txt
        receiver.saveToFile();
    }
}
