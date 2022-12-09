package eu.telecomnancy.visualcards.Commands;

public class NewGameCommand extends Command {

    public NewGameCommand() {
        super(null);
    }

    @Override
    public boolean execute() {
        deck.newGame();
        return true;
    }

}

