public class Invoker {
    private Command command;

    public void setCommandsForExecution(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        if(command != null) {
            command.execute();
        }
    }
}
