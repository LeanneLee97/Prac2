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
            "Add First_name Last_name Email",
//            "add john Doe simple@example.com",
//            "aDd Hanna moon tetter.tots@potatoesarelife.com",
//            "ADD Ah Boon
//            Gr..een-tea@teaforlife.com",
//            "list",
//            "update 3 Adam Sun Adamisbest@email.com",
            "list",
//            "undo",
//            "update 3 Adam Sun",
//            "list",
//            "undo",
//            "update 3 Adam",
//            "list",
//            "update 1 Blue Bell ice-cream@alaskaFields.org",
//            "list",
            "Delete a",
//            "list",
//            "undo",
//            "list",
//            "delete 1",
              "list",
//            "delete 7",
//            "update 12 Steven",
//            "hello",
    };

    for (String input : inputs) {
        Command command = null;
        String lowerCase = input.toLowerCase();

        if (lowerCase.startsWith("add")) {
            String payload = input.substring(4).trim();
            command = new AddCommand(receiver, payload);
        }  if (lowerCase.startsWith("update")) {
            String payload = input.substring(7).trim();
            command = new UpdateCommand(receiver, payload);
        }  if (lowerCase.startsWith("delete")) {
            String payload = input.substring(7).trim();
            command = new DeleteCommand(receiver, payload);
        }  if (lowerCase.equalsIgnoreCase("list")) {
            command = new ListCommand(receiver);
        }  if (lowerCase.equalsIgnoreCase("undo")) {
            command = new UndoCommand(receiver, history);
        }


        invoker.setCommandsForExecution(new Command[]{command});
        invoker.executeCommand(history);


    }

    // Save to dataStore.txt
    receiver.storeToFile();
}
}

