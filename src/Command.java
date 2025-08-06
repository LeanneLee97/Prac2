public interface Command {
    void execute();
    void undo();
    boolean isStackable();
}
