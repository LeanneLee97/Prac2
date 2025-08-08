package Commands;
import Exceptions.CustomException;
import Receiver.Receiver;
import java.util.ArrayList;

/**
 * Class used to display all entries from taskList. This command does not
 * expect a payload. This command is not stackable and does not support undo
 * functionality.
 */
public class ListCommand implements Command {
    private final Receiver taskList;

    /**
     * Constructs a {@code ListCommand} with the specified receiver.
     *
     * @param tasklist the receiver that manages the task list
     */
    public ListCommand(Receiver tasklist) {
        this.taskList = tasklist;
    }

    /**
     * Executes the list command by retrieving and printing all tasks.
     *
     * @throws CustomException never thrown in this implementation
     */
    @Override
    public void execute() throws CustomException {

        ArrayList<String> list = taskList.getAllTasks();

        if (list.isEmpty()) {
            System.out.println("List");
            System.out.println("No tasks available.");
        } else {
            System.out.println("List");
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%02d. %s%n", i + 1, list.get(i));
            }
        }
        taskList.getAllTasks();
    }

    /**
     * Throws a {@code CustomException} since list commands cannot be undone.
     *
     * @throws CustomException always thrown with message "Nothing to Undo"
     */
    @Override
    public void undo()  throws CustomException {
        throw new CustomException("Nothing to Undo");
    }

    /**
     * Indicates whether this command should be stored in the undo history.
     *
     * @return {@code false} since list commands are not stackable
     */
    @Override
    public boolean isStackable() {
        return false;
    }
}

