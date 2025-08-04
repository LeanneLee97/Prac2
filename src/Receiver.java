import java.util.ArrayList;

public class Receiver {
    private static final ArrayList<Payload> taskList = new ArrayList<>();

    public void addTask(Payload payload) {
        taskList.add(payload);
    }

    public void removeTask(Payload task) {
        taskList.remove(task);
    }

    public static Payload getTask(int index) {
        return taskList.get(index);
    }

    public void changeTask(int index, Payload updatedTask) {
        taskList.set(index, updatedTask);
    }

    public void listTasks() {
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + ": " + taskList.get(i));
        }
    }

    public ArrayList<Payload> getAllTasks() {
        return null;
    }

    public void deleteTask(int index, Payload removedTask) {
    }

    public void readdTask(int index, Payload removedTask) {
    }
}

