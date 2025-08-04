public class AddCommand implements Command {
    private final Payload payload;
    private final Receiver taskList;

    public AddCommand(Receiver taskList, Payload payload) {
        this.taskList = taskList;
        this.payload = payload;
        String[] splitPayload = payload.split(" ");
        for (int i = 0; i < splitPayload.length; i++) {
            splitPayload[i] = splitPayload[i].trim();
        }
        if (splitPayload.length < 3) {
            throw new IllegalArgumentException("Invalid payload: expecting at" +
                    " least 3 data fields");
        }
    }

    @Override
    public void execute() {
        taskList.addTask(payload);
    }

    @Override
    public void undo() {
        taskList.removeTask(payload);
    }
}

