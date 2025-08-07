package Commands;
import Exceptions.CustomException;
import Receiver.Receiver;
import Validator.EmailValidator;
import Validator.SentenceCase;

public class UpdateCommand implements Command {
    private final Receiver taskList;
    private int index;
    private String data1;
    private String data2;
    private String data3;
    private String previousTask;
    private String oldData1;
    private String oldData2;
    private String oldData3;
    private final String payload;

    public UpdateCommand(Receiver taskList, String payload) {
        this.taskList = taskList;
        this.payload = payload;
    }

    @Override
    public void execute() throws CustomException {
        String[] splitPayload = payload.split(" ");
        if(splitPayload.length <2 || splitPayload.length > 4){
            throw new CustomException("Invalid payload: Expecting " +
                    "2 to 4 data fields");
        }
        index = Integer.parseInt(splitPayload[0]) - 1 ;

        if (taskList.getTask(index) == null){
            throw new CustomException("Invalid payload: Nothing to update");
        }
        //taskList.validateTask(data3);
        previousTask = taskList.getTask(index);
        String[] splitPreviousTask = previousTask.split(" ");
        oldData1 = splitPreviousTask[0];
        oldData2 = splitPreviousTask[1];
        oldData3 = splitPreviousTask[2];

        data1 = new SentenceCase(splitPayload[1]).sentenceCase();
        String updatedTask = String.join(" ", data1, oldData2, oldData3);
        if (splitPayload.length > 2) {
            data2 = new SentenceCase(splitPayload[2]).sentenceCase();
            updatedTask = String.join(" ", data1, data2, oldData3);
            if (splitPayload.length > 3) {
                data3 = splitPayload[3];
                if (!EmailValidator.isValidEmail(data3)) {
                    throw new CustomException("Invalid email");
                }
                updatedTask = String.join(" ", data1, data2, data3);
            }
        }

        taskList.updateTask(index, updatedTask);

        //System.out.println(data1 + data2 + data3);
    }

    @Override
    public void undo() {
        taskList.updateTask(index, previousTask);
    }

    @Override
    public boolean isStackable() {
        return true;
    }
}
