package Commands;
import Receiver.Receiver;
import Exceptions.CustomException;
import Validator.*;

public class AddCommand implements Command {
    private final Receiver taskList;
    private String data1;
    private String data2;
    private String data3;
    private final String payload;

    public AddCommand(Receiver taskList, String payload) {
        this.taskList = taskList;
        this.payload = payload;
    }

    @Override
    public void execute() throws CustomException{
        String[] splitPayload = payload.split(" ");
        if (splitPayload.length != 3) {
            throw new CustomException("Invalid payload: Expecting 3 " +
                    "data fields");
        }

        data1 = new TitleCase(splitPayload[0]).titleCase();
        data2 = new TitleCase(splitPayload[1]).titleCase();
        if (splitPayload[2].contains("@")){ // check email
            data3 = splitPayload[2];
            if (!EmailValidator.isValidEntry(data3)) {
                throw new CustomException("Invalid email");
            }
        }
        else { // check word
            data3 = new TitleCase(splitPayload[2]).titleCase();
            if (!WordValidator.isValidEntry(data3)) {
                throw new CustomException("Invalid word.");
            }
        }



            //taskList.validateTask(data3);

            String task = String.join(" ", data1, data2, data3);
            taskList.addTask(task);
            System.out.println("add");
    }

    @Override
    public void undo() {
        String task = String.join(" ", data1, data2, data3);
        taskList.deleteTask(task);
        System.out.println("Undo");
    }

    @Override
    public boolean isStackable() {
        return true;
    }
}


