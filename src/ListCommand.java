public class ListCommand implements Command {
    private final Receiver taskList;

    public ListCommand(Receiver taskList) {
        this.taskList = taskList;
    }

    @Override
    public void execute() {
        taskList.getAllTasks();
    }

    @Override
    public void undo() {
        // Not applicable
    }
}
