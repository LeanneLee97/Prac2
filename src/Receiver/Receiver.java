package Receiver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Receiver {
    private ArrayList<String> taskList = new ArrayList<>();
    private static final String FILE_PATH = "src/dataStore.txt";

    public Receiver() {
        this.taskList = loadFromFile();
    }

    public ArrayList<String> loadFromFile() {
        Path path = Path.of(FILE_PATH);
        try {
            Files.readAllLines(path);
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void storeToFile() {
        Path path = Path.of(FILE_PATH);
        try {
            Files.write(path, taskList, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
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

    public void addTask(int index, String removedTask) {
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

