public class AddCommand implements Command {

    private Receiver receiver;
    private String firstName;
    private String lastName;
    private String email;
    private Employee addedEmployee; // keep track of the employee added

    public AddCommand(Receiver receiver, String firstName, String lastName, String email) {
        this.receiver = receiver;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public boolean execute() {
        addedEmployee = new Employee(firstName, lastName, email);
        receiver.add(addedEmployee);
        System.out.println("Added: " + addedEmployee);
        return true;
    }

    @Override
    public boolean isUndoable() {
        return true;
    }

    @Override
    public void undo() {
        if (addedEmployee != null) {
            receiver.remove(addedEmployee);
            System.out.println("Undo add: Removed " + addedEmployee);
        }
    }
}
