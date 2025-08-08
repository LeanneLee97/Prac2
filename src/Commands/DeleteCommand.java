package Commands;
import Exceptions.CustomException;
import Receiver.Receiver;

import java.util.ArrayList;

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
        String[] splitPayload = payload.split(" ");
        if (splitPayload.length != 1) {
            throw new CustomException("Invalid payload: Expecting only index");
        }

        try {
            this.index = Integer.parseInt(payload.trim()) - 1;
            if (index <= 0){
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

