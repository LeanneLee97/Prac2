import Commands.*;
import Exceptions.*;
import Invoker.Invoker;
import Receiver.Receiver;

import java.util.Stack;

public class Client {
    public static void main(String[] args) {
    Stack<Command> history = new Stack<>();
    Receiver receiver = new Receiver();
    Invoker invoker = new Invoker();

    String[] inputs = {
            "add firstname lastname -",

    };

    for (String input : inputs) {
        System.out.println(input);
        Command command = null;

        if (input.startsWith("add ")) {
            String payload = input.substring(4).trim();
            command = new AddCommand(receiver, payload);
        }  if (input.startsWith("update ")) {
            String payload = input.substring(7).trim();
            command = new UpdateCommand(receiver, payload);
        }  if (input.startsWith("delete ")) {
            String payload = input.substring(7).trim();
            command = new DeleteCommand(receiver, payload);
        }  if (input.equalsIgnoreCase("list")) {
            command = new ListCommand(receiver);
        }  if (input.equalsIgnoreCase("undo")) {
            command = new UndoCommand(receiver, history);
        }

        invoker.setCommandsForExecution(new Command[]{command});
        invoker.executeCommand(history);


    }

    // Save to dataStore.txt
    receiver.storeToFile();
}
}

