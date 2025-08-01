import java.util.ArrayList;

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
}
