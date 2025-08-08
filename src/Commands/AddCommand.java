package Commands;
import Receiver.Receiver;
import Exceptions.CustomException;
import Validator.*;

/**
 * Class used to add new entries into taskList. This command expects a
 * payload consisting of {@code data1},  {@code data2} and {@code data3}. 
 * {@code data1} and {@code data2} should be formatted to be Titlecase. 
 * {@code data3} only able to accept a single email address or Latin letters 
 * (case-insensitive), digits 0 to 9 and underscores.
 */
public class AddCommand implements Command {
    private final Receiver taskList;
    private String data1;
    private String data2;
    private String data3;
    private final String payload;

    /**
     * Constructs an {@code AddCommand} with the specified receiver and input payload.
     *
     * @param taskList the receiver that manages the task list
     * @param payload the input string containing three fields separated by whitespace
     */
    public AddCommand(Receiver taskList, String payload) {
        this.taskList = taskList;
        this.payload = payload;
    }

    /**
     * @code execute Executes the add command by validating and formatting the
     * input,
     * then adding the resulting task to the receiver's task list.
     *
     * @throws CustomException if the payload is invalid or fails validation
     */
    @Override
    public void execute() throws CustomException{
        // Split the payload into the 3 data fields
        String[] splitPayload = payload.split("\\s+");
        //Check if there are exactly 3 data fields
        if (splitPayload.length != 3) {
            throw new CustomException("Invalid payload: Expecting 3 " +
                    "data fields");
        }

        data1 = new TitleCase(splitPayload[0]).titleCase();
        data2 = new TitleCase(splitPayload[1]).titleCase();
        if (splitPayload[2].contains("@")){ // check email
            data3 = splitPayload[2];
            if (!EmailValidator.isValidEntry(data3)) {
                throw new CustomException("Invalid email");
            }
        }
        else { // check word
            data3 = new TitleCase(splitPayload[2]).titleCase();
            if (!WordValidator.isValidEntry(data3)) {
                throw new CustomException("Invalid word.");
            }
        }
            String task = String.join(" ", data1, data2, data3);
            taskList.addTask(task);
            System.out.println("add");
    }

    /**
     * Undoes the add command by removing the previously added task from the receiver.
     */
    @Override
    public void undo() {
        String task = String.join(" ", data1, data2, data3);
        taskList.deleteTask(task);
        System.out.println("Undo");
    }
    /**
     * Indicates whether this command should be stored in the undo history.
     *
     * @return {@code true} since add commands are stackable
     */

    @Override
    public boolean isStackable() {
        return true;
    }
}



