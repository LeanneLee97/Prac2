import java.util.ArrayList;

/**
 * Receiver class that performs business logic on tasks.
 * Acts on the Payload objects as part of the Command Design Pattern.
 */
public class Receiver {
    private static final ArrayList<String> taskList = new ArrayList<>();

    /**
     * Adds a new task to the task list.
     */
    public static void addTask(String payload) {
        taskList.add(payload);
    }

    /**
     * Removes a task by object.
     */
    public void removeTask(Payload payload) {
        taskList.remove(payload);
    }

    /**
     * Removes a task by index and returns the removed Payload.
     */
    public void deleteTask(int index) {
        taskList.remove(index);
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
    public static String getTask(int index) {
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
    public static ArrayList getAllTasks() {
        return new ArrayList(taskList);
    }
}
