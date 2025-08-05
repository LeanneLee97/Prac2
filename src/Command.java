
public interface Command {
    boolean execute();
    void undo();
    boolean isUndoable();
}