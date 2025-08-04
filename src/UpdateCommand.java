public class UpdateCommand implements Command {
    private final Receiver taskList;
    private final int index;
    private final Payload updatedTask;
    private Payload previousTask;

    public UpdateCommand(Receiver taskList, Payload payload) {
        this.taskList = taskList;
        this.index = Integer.parseInt(payload.getIndex());
        this.updatedTask = payload;
    }

    @Override
    public void execute() {
        previousTask = Receiver.getTask(index);
        taskList.changeTask(index, updatedTask);
    }

    @Override
    public void undo() {
        taskList.changeTask(index, previousTask);
    }
}
