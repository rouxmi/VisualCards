package eu.telecomnancy.visualcards.Commands;

import eu.telecomnancy.visualcards.games.DeckOfCards;

public class NextcardCommand extends Command {

    public NextcardCommand(DeckOfCards deck) {
        super(deck);
    }

    @Override
    public void execute() {
        backup();
        deck.dealTopCard();
        deck.notifyObservers();
    }

}
