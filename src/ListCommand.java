import java.util.ArrayList;

public class ListCommand implements Command {
    private final Receiver taskList;

    public ListCommand(Receiver tasklist) {
        this.taskList = tasklist;
    }

    @Override
    public void execute() throws CustomException {
        ArrayList<String> list = taskList.getAllTasks();

        if (list.isEmpty()) {
            throw new CustomException("No tasks available.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i+1) + ": " + list.get(i));
            }
        }
        taskList.getAllTasks();
    }

    @Override
    public void undo(){

    }

    @Override
    public boolean isStackable() {
        return false;
    }
}