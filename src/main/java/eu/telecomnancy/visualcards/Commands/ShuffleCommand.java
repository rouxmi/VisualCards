package eu.telecomnancy.visualcards.Commands;

import eu.telecomnancy.visualcards.DeckOfCards;

public class ShuffleCommand extends Command {

    public ShuffleCommand(DeckOfCards deck) {
        super(deck);
    }

    @Override
    public boolean execute() {
        backup();
        deck.shuffle();
        deck.notifyObservers();
        return true;
    }

}
