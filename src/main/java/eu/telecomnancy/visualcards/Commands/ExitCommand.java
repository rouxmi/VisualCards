package eu.telecomnancy.visualcards.Commands;

public class ExitCommand extends Command {

    public ExitCommand() {
        super(null);
    }

    @Override
    public void execute() {
        System.exit(0);
    }

}
