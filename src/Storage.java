import java.io.*;
import java.util.ArrayList;

/**
 * Handles saving and loading tasks from a text file.
 */
public class Storage {
    private static final String FILE_PATH = "src/dataStore.txt";

    /**
     * Saves the task list to a file.
     * @param tasks List of Payload tasks to write
     */
    public static void saveToFile(ArrayList<Payload> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Payload task : tasks) {
                writer.write(serialize(task));
                writer.newLine();
            }
            System.out.println("✅ Data saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Loads the task list from the file.
     * @return List of Payloads read from the file
     */
    public static ArrayList<Payload> loadFromFile() {
        ArrayList<Payload> tasks = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("No existing data found. Starting fresh.");
            return tasks;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Payload p = deserialize(line);
                if (p != null) {
                    tasks.add(p);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        return tasks;
    }

    /**
     * Converts a Payload to a string format.
     */
    private static String serialize(Payload p) {
        return String.join(" | ",
                p.getData1(),
                p.getData2(),
                p.getData3());
    }

    /**
     * Converts a saved line back into a Payload.
     */
    private static Payload deserialize(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length != 3) return null;

        Payload payload = new Payload("");
        payload.split(parts[0] + " " + parts[1] + " " + parts[2]);
        return payload;
    }
}
