package Commands;
import Exceptions.CustomException;
import Receiver.Receiver;

import java.util.ArrayList;

/**
 * Class used to delete entries from taskList. This command expects a
 * payload consisting of <index>. <index></> should be an integer value.
 */
public class DeleteCommand implements Command {
    private final Receiver taskList;
    private int index;
    private final String payload;
    private String removedTask;

    /**
     * Constructs a {@code DeleteCommand} with the specified receiver and input payload.
     *
     * @param taskList the receiver that manages the task list
     * @param payload the input string containing the index of the task to delete
     */
    public DeleteCommand(Receiver taskList, String payload) {
        this.taskList = taskList;
        this.payload = payload;
    }

    /**
     * Executes the delete command by validating the index and removing the corresponding task.
     *
     * @throws CustomException if the payload is invalid, the index is out of bounds,
     *                         or the task list is empty
     */
    @Override
    public void execute() throws CustomException {
        String[] splitPayload = payload.split("\\s+");
        if (splitPayload.length != 1) {
            throw new CustomException("Invalid payload: Expecting only index");
        }

        try {
            this.index = Integer.parseInt(payload) - 1;
            if (index < 0){
                throw new CustomException("Index should be positive number");
            }
        } catch (NumberFormatException e) {
            throw new CustomException("Invalid index: not a number");
        }

        ArrayList<String> list = taskList.getAllTasks();
        if(list.isEmpty()){
            throw new CustomException("No tasks available.");
        }
        if(list.size() <= index){
            throw new CustomException("No entry to delete");
        }
        if  (taskList.getTask(index) == null){
            throw new CustomException("No entry to delete");
        }
        removedTask = taskList.deleteTask(index);
        System.out.println("Delete");
    }

    @Override
    public void undo() {
        if (removedTask != null) {
            taskList.addTask(index, removedTask);
            System.out.println("undo");
        }
    }

    @Override
    public boolean isStackable() {
        return true;
    }
}
