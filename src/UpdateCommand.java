public class UpdateCommand implements Command {
    private final TaskList taskList;
    private final int index;
    private final Task updatedTask;
    private Task previousTask;

    public UpdateCommand(TaskList taskList, int index, Task updatedTask) {
        this.taskList = taskList;
        this.index = index;
        this.updatedTask = updatedTask;
    }

    @Override
    public void execute() {
        //previousTask = taskList.get(index);
        //taskList.update(index, updatedTask);
    }

    @Override
    public void undo() {
        taskList.update(index, previousTask);
    }
}
