package Commands;
import Exceptions.CustomException;
import Receiver.Receiver;
import java.util.Stack;

public interface Command {
    void execute() throws CustomException;
    void undo() throws CustomException;
    boolean isStackable();
}
