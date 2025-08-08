package Receiver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * The Receiver class manages a list of tasks, a filepath, and methods
 * to load tasks from a file, store tasks to a file, and manipulate
 * the task list including add, delete, update and retrieve tasks.
 */

public class Receiver {
    private ArrayList<String> taskList = new ArrayList<>();
    private static final String FILE_PATH = "./dataStore.txt";

    /**
     * Constructs a Receiver instance and loads tasks from the data file.
     */
    
    public Receiver() {
        this.taskList = loadFromFile();
    }
    /**
     * Loads the tasks from the file specified by FILE_PATH.
     * If the file does not exist, a new one will be created.
     *
     * @return a new ArrayList containing all tasks loaded from the file,
     *         or an empty list if an error occurs.
     */
    public ArrayList<String> loadFromFile() {
        Path path = Path.of(FILE_PATH);
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            List<String> lines = Files.readAllLines(path);
            return new ArrayList<>(lines);
        } catch (IOException e) {
            System.out.println("Error reading file");
            return new ArrayList<>();
        }
    }

    /**
     * Stores the current list of tasks to the file specified by FILE_PATH.
     * Prints an error message if an IOException occurs.
     */
    
    public void storeToFile() {
        Path path = Path.of(FILE_PATH);
        try {
            Files.write(path, taskList);
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
    /**
     * Adds a task to the end of the task list.
     *
     * @param task the task string to add.
     */
    public void addTask(String task) {
        taskList.add(task);
    }
    /**
     * Removes the first occurrence of the specified task from the task list.
     *
     * @param task the task string to remove.
     */
    public void deleteTask(String task) {
        taskList.remove(task);
    }
    /**
     * Removes and returns the task at the specified index.
     *
     * @param index the position of the task to remove.
     * @return the task string that was removed.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public String deleteTask(int index){
        return taskList.remove(index);
    }

    /**
     * Inserts the specified task at the specified position in the list.
     *
     * @param index the position to insert the task.
     * @param removedTask the task string to add.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public void addTask(int index, String removedTask) {
        taskList.add(index, removedTask);
    }
    /**
     * Returns the task at the specified index.
     *
     * @param index the position of the task to return.
     * @return the task string at the given index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public String getTask(int index){
        return taskList.get(index);
    }
    /**
     * Replaces the task at the specified index with a new task.
     *
     * @param index the position of the task to update.
     * @param newTask the new task string to set.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public void updateTask(int index, String newTask) {
        taskList.set(index, newTask);
    }
    /**
     * Returns a copy of all tasks in the current task list.
     *
     * @return a new ArrayList containing all current tasks.
     */
    public ArrayList<String> getAllTasks() {
        return new ArrayList<>(taskList); // returns a copy
    }
}

