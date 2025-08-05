import java.util.ArrayList;
import java.io.IOException;
import java.util.*;

public class Client {

    private Storage storage;
    private TaskList taskList;

    public Client() {
        try {
            storage = new Storage();
            try{
                ArrayList<Task> list = storage.readFromFile();
                this.taskList = new TaskList(list);
            } catch (ArrayIndexOutOfBoundsException e){
                //throw new Exception(Exception.Code.FILE_CONTENTS_FORMAT_ERROR);
            }
        } catch (Exception e){
            //System.out.println(e.errorDescription());
        }
    }
    private String run(String command) throws IOException {
        Parser parser = new Parser();
        Command c = parser.parse(command);
        return c.execute(taskList, storage);
    }
}
