public class DeleteCommand implements Command {
    private final Receiver taskList;
    private final int index;
    private Payload removedTask;

    public DeleteCommand(Receiver taskList, Payload payload) {
        this.taskList = taskList;
        this.index = Integer.parseInt(payload.getIndex());
    }

    @Override
    public void execute() {
        removedTask = Receiver.getTask(index);
        taskList.deleteTask(index, removedTask);
    }

    @Override
    public void undo() {
        if (removedTask != null) {
            taskList.readdTask(index, removedTask);
        }
    }
}
