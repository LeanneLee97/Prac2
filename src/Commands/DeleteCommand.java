package Commands;
import Exceptions.CustomException;
import Receiver.Receiver;

public class DeleteCommand implements Command {
    private final Receiver taskList;
    private int index;
    private final String payload;
    private String removedTask;

    public DeleteCommand(Receiver taskList, String payload) {
        this.taskList = taskList;
        this.payload = payload;
    }

    @Override
    public void execute() throws CustomException {
        this.index = Integer.parseInt(payload) - 1;
        if  (taskList.getTask(index) == null){
            throw new CustomException("Invalid payload: Nothing to delete");
        }
        removedTask = taskList.deleteTask(index);
    }

    @Override
    public void undo() {
        if (removedTask != null) {
            taskList.addTask(index, removedTask);
        }
    }

    @Override
    public boolean isStackable() {
        return true;
    }

}

