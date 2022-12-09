package eu.telecomnancy.visualcards.Commands;

import eu.telecomnancy.visualcards.DeckOfCards;

public class SortCommand extends Command {

    public SortCommand(DeckOfCards deck) {
        super(deck);
    }

    @Override
    public boolean execute() {
        backup();
        deck.sort();
        deck.notifyObservers();
        return true;
    }

}
