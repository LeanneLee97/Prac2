//package newDuke.main;
//import newDuke.DukeTasks.Task;
import java.util.ArrayList;

public class TaskList {

    ArrayList<Task> list;

    public TaskList() {
        list = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    public Task getTask(int i) {
        return this.list.get(i);
    }

    public void updateTaskList(ArrayList<Task> list) {
        this.list = list;
    }

    public ArrayList<Task> getTaskList() {
        return this.list;
    }

    public void addTaskList(Task task) {
        this.list.add(task);
    }


    public int getSize() {
        return list.size();
    }

    public int indexOf(Task t) {
        return list.indexOf(t);
    }

    public void changeTask(int index, Task t) {
        list.set(index, t);
    }

    public void add(Task task) {
    }

    public void remove(Task task) {
    }

//    public Task get(int index) {
//        return index; // to be edited
//    }

    public void update(int index, Task updatedTask) {
    }

    public void delete(int index) {
    }

    public void insert(int index, Task removedTask) {
    }

    public void list() {
    }
}