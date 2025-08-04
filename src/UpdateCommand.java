public class UpdateCommand implements Command {
    private final Receiver taskList;
    private final int index;
    private final String data1;
    private final String data2;
    private final String data3;
    private String previousTask;

    public UpdateCommand(Receiver taskList, String payload) {
        this.taskList = taskList;

        String[] splitPayload = payload.split(" ");
        if(splitPayload.length != 4){
            throw new IllegalArgumentException("Invalid payload: Expecting 4 " +
                    "data fields");
        }
        try{
            this.index = Integer.parseInt(splitPayload[0]);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Invalid index");
        }
        this.data1 = splitPayload[1];
        this.data2 = splitPayload[2];
        this.data3 = splitPayload[3];

        Receiver.validateTask(data3);
    }

    @Override
    public void execute() {
        previousTask = tasklist.getTask(index);
        String updatedTask = String.join(" ", data1, data2, data3);
        taskList.changeTask(index, updatedTask);
    }

    @Override
    public void undo() {
        taskList.changeTask(index, previousTask);
    }
}
