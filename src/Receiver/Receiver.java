package Receiver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Receiver {
    private ArrayList<String> taskList = new ArrayList<>();
    private static final String FILE_PATH = "./dataStore.txt";

    public Receiver() {
        this.taskList = loadFromFile();
    }

    public ArrayList<String> loadFromFile() {
        Path path = Path.of(FILE_PATH);
        try {
            List<String> lines = Files.readAllLines(path);
            return new ArrayList<>(lines);
        } catch (IOException e) {
            System.out.println("Error reading file");
            return new ArrayList<>();
        }
    }

    public void storeToFile() {
        Path path = Path.of(FILE_PATH);
        try {
            Files.write(path, taskList);
        } catch (IOException e) {
            System.out.println("Error writing file");
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

