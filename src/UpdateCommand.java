public class UpdateCommand implements Command {
    private final Receiver taskList;
    private int index;
    private String data1;
    private String data2;
    private String data3;
    private String previousTask;
    private String oldData1;
    private String oldData2;
    private String oldData3;
    private final String payload;

    public UpdateCommand(Receiver taskList, String payload) {
        this.taskList = taskList;
        this.payload = payload;
    }

    @Override
    public void execute() {
        String[] splitPayload = payload.split(" ");
        if(splitPayload.length <2 || splitPayload.length > 4){
            throw new IllegalArgumentException("Invalid payload: Expecting " +
                    "2 to 4 data fields");
        }
        try{
            index = Integer.parseInt(splitPayload[0]) - 1;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Invalid index");
        }
        //taskList.validateTask(data3);
        previousTask = taskList.getTask(index);
        String[] splitPreviousTask = previousTask.split(" ");
        oldData1 = splitPreviousTask[0];
        oldData2 = splitPreviousTask[1];
        oldData3 = splitPreviousTask[2];

        data1 = splitPayload[1];
        String updatedTask = String.join(" ", data1, oldData2, oldData3);
        if (splitPayload.length > 2) {
            data2 = splitPayload[2];
            updatedTask = String.join(" ", data1, data2, oldData3);
            if (splitPayload.length > 3) {
                data3 = splitPayload[3];
                updatedTask = String.join(" ", data1, data2, data3);
            }
        }

        taskList.updateTask(index, updatedTask);

        //System.out.println(data1 + data2 + data3);
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
