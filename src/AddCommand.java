public class AddCommand implements Command {

    private Receiver receiver;
    private String firstName;
    private String lastName;
    private String position;

    public AddCommand(Receiver receiver, String firstName, String lastName, String position) {
        this.receiver = receiver;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    @Override
    public boolean execute() {
        Employee newEmployee = new Employee(firstName, lastName, position);
        receiver.add(newEmployee);
        System.out.println("Added: " + newEmployee);
        return true;
    }


    @Override
    public boolean isUndoable() {
        return false;
    }
}

