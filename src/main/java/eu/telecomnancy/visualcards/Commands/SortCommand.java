package eu.telecomnancy.visualcards.Commands;

import eu.telecomnancy.visualcards.games.DeckOfCards;

public class SortCommand extends Command {

    public SortCommand(DeckOfCards deck) {
        super(deck);
    }

    @Override
    public void execute() {
        backup();
        deck.sort();
        deck.notifyObservers();
    }

}
