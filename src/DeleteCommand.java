public class DeleteCommand implements Command {
    private final TaskList taskList;
    private final int index;
    private Task removedTask;

    public DeleteCommand(TaskList taskList, int index) {
        this.taskList = taskList;
        this.index = index;
    }

    @Override
    public void execute() {
        removedTask = taskList.get(index);
        taskList.delete(index);
    }

    @Override
    public void undo() {
        if (removedTask != null) {
            taskList.insert(index, removedTask);
        }
    }
}
