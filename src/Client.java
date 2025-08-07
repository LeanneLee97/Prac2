import Commands.*;
import Exceptions.*;
import Invoker.Invoker;
import Receiver.Receiver;

import java.util.Stack;

/**
 * For testing purposes only
 */

public static void main(String[] args) throws CustomException {
    Stack<Command> history = new Stack<>();
    Receiver receiver = new Receiver();
    Invoker invoker = new Invoker();

    String[] inputs = {
            "add First_name Last_name Email",
            "add John Doe simple@example.com",
            "add Hanna Moon tetter.tots@potatoesarelife.com",
            "add Ah Boon green-tea@teaforlife.com",
            "list",
            "update 2 Adam",
            "list",
            "undo",
            "list",
            "update 2 Adam Sun",
            "list",
            "undo",
            "list",
            "update 2 Adam Sun adamisbest@umail.com",
            "list",
            "undo",
            "list",
            "update 2 Adam",
            "list",
            "update 1 blue bell ice-cream@alaskaFields.org",
            "list",
            "delete 1",
            "list",
            "undo",
            "list"
    };

    for (String input : inputs) {
        System.out.println(input);
        Command command = null;

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
            command = new UndoCommand(receiver, history);
        } else {
            System.out.println("Unknown command.");
            continue;
        }

        invoker.setCommandsForExecution(new Command[]{command});
        invoker.executeCommand(history);


    }

    // Save to dataStore.txt
    receiver.storeToFile();
}

