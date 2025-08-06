import java.io.*;
import java.util.ArrayList;

public class Receiver {
    private ArrayList<String> taskList = new ArrayList<>();
    private static final String FILE_PATH = "src/dataStore.txt";

    public Receiver() {
        this.taskList = loadFromFile();
    }

    public ArrayList<String> loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File does not exist");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                taskList.add(line);
            }
            //System.out.println("Loaded " + taskList.size() + " tasks");
        } catch (IOException e) {
            System.out.println("Error while reading file" + e.getMessage());
        }
        return new ArrayList<>();
    }

    public void storeToFile() {
        File file = new File(FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for (String task : taskList) {
                writer.write(task);
                writer.newLine();
            }
            //System.out.println("Saved " + taskList.size() + " tasks");
        } catch(IOException e){
            System.out.println("Error while writing to file" + e.getMessage());
        }
    }

    public void addTask(String task) {
        taskList.add(task);
    }

    public void removeTask(String task) {
        taskList.remove(task);
    }

    public String deleteTask(int index){
        return taskList.remove(index);
    }

    public void reAddTask(int index, String removedTask) {
        taskList.add(index, removedTask);
    }

    public String getTask(int index){
        return taskList.get(index);
    }

    public void updateTask(int index, String newTask) {
        taskList.set(index, newTask);
    }

    public ArrayList<String> getAllTasks() {
        return new ArrayList<>(taskList); // returns a copy
    }
}
