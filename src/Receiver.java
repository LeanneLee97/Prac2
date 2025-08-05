import java.util.ArrayList;
import java.io.*;

/**
 * Receiver class that performs business logic on tasks.
 * Acts on the Payload objects as part of the Command Design Pattern.
 */
public class Receiver {
    private ArrayList<String> taskList = new ArrayList<>();
    private static final String FILE_PATH = "src/dataStore.txt";

    public Receiver() {
        this.taskList = loadFromFile();

    }
    /**
     * Adds a new task to the task list.
     */
    public void addTask(String task) {
        taskList.add(task);
    }

    /**
     * Removes a task by object.
     */
    public void removeTask(String task) {
        taskList.remove(task);
    }

    /**
     * Removes a task by index and returns the removed Payload.
     */
    public String deleteTask(int index) {
        return taskList.remove(index);
    }

    /**
     * Re-inserts a previously removed task at the given index.
     */
    public void readdTask(int index, String removedTask) {
        taskList.add(index, removedTask);
    }

    /**
     * Returns the task at the given index.
     */
    public String getTask(int index) {
        return taskList.get(index);
    }

    /**
     * Replaces the task at the given index with the updated task.
     */
    public void changeTask(int index, String updatedTask) {
        taskList.set(index, updatedTask);
    }

    /**
     * Lists all tasks currently in the task list.
     */
    public void listTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println(i + ": " + taskList.get(i));
            }
        }
    }

    /**
     * Returns all tasks (used for file storage).
     */
    public ArrayList <String> getAllTasks() {
        return new ArrayList<>(taskList);
    }

    public ArrayList<String> loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("dataStore.txt doesn't exist.");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null){
                taskList.add(line);
            }
            System.out.println("Loaded " + taskList.size() + " tasks.");
        } catch (IOException e){
            System.out.println("Error reading file." + e.getMessage());
        }
        return new  ArrayList<>();
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))){
            for (String task : taskList) {
                writer.write(task);
                writer.newLine();
            }
            System.out.println("Saved " + taskList.size() + " tasks.");
        } catch (IOException e){
            System.out.println("Error writing to file." + e.getMessage());
        }
    }

    public boolean validateTask(String task) {
        if (taskList.contains(task)) {
            return true;
        } else {
            return false;
        }
    }
}
