public class ListCommand implements Command {
    private final TaskList taskList;

    public ListCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void execute() {
        taskList.list();
    }

    @Override
    public void undo() {
        // Not applicable
    }
}
