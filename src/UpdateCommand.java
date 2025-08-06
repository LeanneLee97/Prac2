public class UpdateCommand implements Command {
    private final Receiver taskList;
    private int index;
    private String data1;
    private String data2;
    private String data3;
    private String previousTask;
    private final String payload;

    public UpdateCommand(Receiver taskList, String payload) {
        this.taskList = taskList;
        this.payload = payload;
    }

    @Override
    public void execute() {
        String[] splitPayload = payload.split(" ");
        if(splitPayload.length != 4){
            throw new IllegalArgumentException("Invalid payload: Expecting 4 " +
                    "data fields");
        }
        try{
            index = Integer.parseInt(splitPayload[0]) - 1;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Invalid index");
        }
        data1 = splitPayload[1];
        data2 = splitPayload[2];
        data3 = splitPayload[3];

        //taskList.validateTask(data3);
        previousTask = taskList.getTask(index);
        String updatedTask = String.join(" ", data1, data2, data3);
        taskList.updateTask(index, updatedTask);
    }

    @Override
    public void undo() {
        taskList.updateTask(index, previousTask);
    }

    @Override
    public boolean isStackable() {
        return true;
    }
}
