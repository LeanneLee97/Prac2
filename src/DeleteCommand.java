public class DeleteCommand implements Command {
    private final Receiver taskList;
    private final int index;
    private String removedTask;

    public DeleteCommand(Receiver taskList, String payload) {
        this.taskList = taskList;
        try{
            this.index = Integer.parseInt(payload);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("Invalid index");
        }
    }

    @Override
    public void execute() {
        removedTask = taskList.deleteTask(index);
    }

    @Override
    public void undo() {
        if (removedTask != null) {
            taskList.readdTask(index, removedTask);
        }
    }
}
