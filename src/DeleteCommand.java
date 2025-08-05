public class DeleteCommand implements Command {
    private final Receiver taskList;
    private int index;
    private final String payload;
    private String removedTask;

    public DeleteCommand(Receiver taskList, String payload) {
        this.taskList = taskList;
        this.payload = payload;
    }

    @Override
    public void execute() {
        try{
            this.index = Integer.parseInt(payload);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("Invalid index");
        }
        removedTask = taskList.deleteTask(index);
    }

    @Override
    public void undo() {
        if (removedTask != null) {
            taskList.readdTask(index, removedTask);
        }
    }
}
