public class AddCommand implements Command {
    private final Receiver taskList;
    private final String data1;
    private final String data2;
    private final String data3;

    public AddCommand(Receiver taskList, String payload) {
        this.taskList = taskList;

        String[] splitPayload = payload.split(" ");
        if (splitPayload.length != 3) {
            throw new IllegalArgumentException("Invalid payload: Expecting 3 " +
                    "data fields");
        }

        this.data1 = splitPayload[0];
        this.data2 = splitPayload[1];
        this.data3 = splitPayload[2];

        Receiver.validateTask(data3);
    }

    @Override
    public void execute() {
        String task = String.join(" ", data1, data2, data3);
        Receiver.addTask(task);
    }

    @Override
    public void undo() {
        String task = String.join(" ", data1, data2, data3);
        Receiver.removeTask(task);
    }
}

