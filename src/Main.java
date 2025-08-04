import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut
// actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private Storage storage;
    private Receiver taskList;

    public static void main(String[] args) {
        // Load from file at program start
        ArrayList<Payload> loaded = Storage.loadFromFile();
        for (Payload p : loaded) {
            Receiver.addTask("first samuel sam@gmail.com");
        }

// Save to file before exit
        Storage.saveToFile(Receiver.getAllTasks());


    }
}