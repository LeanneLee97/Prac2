import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final Path path = Paths.get(System.getProperty("user.dir"));
    private final File data = new File(path + "/data/dataStore.txt");
    private static final int INDEXOFTASKDESCRIPTION = 4;
    public Storage() {
    }
    public ArrayList<Task> readFromFile() {

        ArrayList<Task> toReturn = new ArrayList<>();
        try {
            Scanner sc = new Scanner(data);
            while (sc.hasNextLine()) {

                String[] next = sc.nextLine().split(" | ");
                switch (next[0]) {
                    case ("add"):
                        String todoName = "";
                        for (int a = INDEXOFTASKDESCRIPTION; a < next.length; a++) {
                            todoName += next[a] + " ";
                        }
                        Task todo = new Todo(todoName);
                        toReturn.add(todo);

                        break;
                }
            }
            sc.close();

        } catch (FileNotFoundException fileExp) {
            System.out.println(fileExp);
        }
        return toReturn;
    }
}
