public class AddCommand implements Command {
    private final Receiver taskList;
    private String data1;
    private String data2;
    private String data3;
    private final String payload;

    public AddCommand(Receiver taskList, String payload) {
        this.taskList = taskList;
        this.payload = payload;
    }

    @Override
    public void execute() {
        String[] splitPayload = payload.split(" ");
        if (splitPayload.length != 3) {
            throw new IllegalArgumentException("Invalid payload: Expecting 3 " +
                    "data fields");
        }

        data1 = splitPayload[0];
        data2 = splitPayload[1];
        data3 = splitPayload[2];

        //taskList.validateTask(data3);

        String task = String.join(" ", data1, data2, data3);
        taskList.addTask(task);
    }

    @Override
    public void undo() {
        String task = String.join(" ", data1, data2, data3);
        taskList.removeTask(task);
    }

    @Override
    public boolean isStackable() {
        return true;
    }
}

