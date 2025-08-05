public class DeleteCommand implements Command {
    private Receiver receiver;
    private int index;
    private Employee deletedEmployee;

    public DeleteCommand(Receiver receiver, int index) {
        this.receiver = receiver;
        this.index = index;
    }

    @Override
    public boolean execute() {
        deletedEmployee = receiver.delete(index);
        System.out.println("Deleted: " + deletedEmployee);
        return deletedEmployee != null;
    }

    @Override
    public void undo() {
        if (deletedEmployee != null) {
            receiver.add(deletedEmployee);
            System.out.println("Undone delete: " + deletedEmployee);
        }
    }

    @Override
    public boolean isUndoable() {
        return deletedEmployee != null;
    }
}
