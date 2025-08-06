public class DeleteCommand implements Command {
    private final Receiver taskList;
    private int index;
    private final String payload;
    private String removedTask;

    public DeleteCommand(Receiver taskList, String payload){
        this.taskList = taskList;
        this.payload = payload;
    }

    @Override
    public void execute() throws CustomException {
        this.index = Integer.parseInt(payload);
        if  (index == 0){
            throw new CustomException("Invalid payload: Nothing to delete");
        }
        removedTask = taskList.deleteTask(index);
    }

    @Override
    public void undo() {
        if (removedTask != null) {
            taskList.reAddTask(index, removedTask);
        }
    }

    @Override
    public boolean isStackable() {
        return true;
    }

}