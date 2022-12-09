package eu.telecomnancy.visualcards.Commands;

public class ExitCommand extends Command {

    public ExitCommand() {
        super(null);
    }

    @Override
    public boolean execute() {
        System.exit(0);
        return true;
    }

}
