public class ListCommand implements Command {
    private final Receiver receiver;

    public ListCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public boolean execute() {
        receiver.listAll();
        return true;
    }

    @Override
    public void undo() {
        // Listing doesn't modify state, so nothing to undo
    }

    @Override
    public boolean isUndoable() {
        return false;
    }
}