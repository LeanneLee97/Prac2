public class Employee {
    private String firstName;
    private String lastName;
    private String email;

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Parse from a line like: "FirstName LastName Email"
    public static Employee fromString(String line) {
        String[] parts = line.trim().split("\\s+"); // split by any whitespace
        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid employee line: " + line);
        }
        return new Employee(parts[0], parts[1], parts[2]);
    }

    // Serialize employee to line
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + email;
    }

    // Optionally, getters/setters here
}
