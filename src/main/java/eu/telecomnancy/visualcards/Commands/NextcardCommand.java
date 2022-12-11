package eu.telecomnancy.visualcards.Commands;

import eu.telecomnancy.visualcards.games.DeckOfCards;

public class NextcardCommand extends Command {

    public NextcardCommand(DeckOfCards deck) {
        super(deck);
    }

    @Override
    public boolean execute() {
        backup();
        deck.dealTopCard();
        deck.notifyObservers();
        return true;
    }

}
