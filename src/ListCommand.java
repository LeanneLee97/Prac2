public class ListCommand implements Command {
    private final Receiver taskList;

    public ListCommand(Receiver taskList) {
        this.taskList = taskList;
    }

    @Override
    public void execute() {
        taskList.listTasks();
    }

    @Override
    public void undo() {
        // Not applicable
    }
}
