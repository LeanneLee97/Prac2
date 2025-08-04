public class AddCommand implements Command {
    private final Todo receiver;
    private final Storage record;

    public AddCommand(Todo receiver, Storage record) {
        this.receiver = receiver;
        this.record = record;
    }

    @Override
    public void execute() {
        receiver.add(record);
    }
}
