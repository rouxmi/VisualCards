package eu.telecomnancy.visualcards.Commands;

import eu.telecomnancy.visualcards.DeckOfCards;

public class DrawCardCommand extends Command {

    public DrawCardCommand(DeckOfCards deck) {
        super(deck);
    }

    @Override
    public boolean execute() {
        backup();
        deck.getTopCard();
        deck.notifyObservers();
        return true;
    }

}
