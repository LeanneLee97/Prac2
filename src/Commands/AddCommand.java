package Commands;
import Receiver.Receiver;
import Exceptions.CustomException;
import EmailValidator.EmailValidator;

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

        data1 = splitPayload[0];
        data2 = splitPayload[1];
        data3 = splitPayload[2];

        if (!EmailValidator.isValidEmail(data3)) {
            throw new CustomException("Invalid email");
        }

        //taskList.validateTask(data3);

        String task = String.join(" ", data1, data2, data3);
        taskList.addTask(task);
    }

    @Override
    public void undo() {
        String task = String.join(" ", data1, data2, data3);
        taskList.removeTask(task);
    }

    @Override
    public boolean isStackable() {
        return true;
    }
}

