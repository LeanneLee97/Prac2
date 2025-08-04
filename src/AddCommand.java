public class AddCommand implements Command {
    private final Task task;
    private final TaskList taskList;

    public AddCommand(Task task, TaskList taskList) {
        this.task = task;
        this.taskList = taskList;
    }

    @Override
    public void execute() {
        taskList.add(task);
    }

    @Override
    public void undo() {
        taskList.remove(task);
    }
}

